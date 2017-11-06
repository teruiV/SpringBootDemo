package com.frank.chapter412.codegen;

import com.frank.chapter412.utils.CamelUnderlineTransformUtils;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import org.jooq.util.JavaGenerator;
import org.jooq.util.JavaWriter;
import org.jooq.util.SchemaDefinition;
import org.jooq.util.TableDefinition;
import org.jooq.util.mysql.MySQLTableDefinition;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by HYL on 2016/11/11.
 */

@Slf4j
public class SimpleJavaGenerator extends JavaGenerator {

    private SchemaDefinition schema;

    private Map<String, TableDefinition> oldTables = new HashMap<>();

    private String getNewTablePattern() {
        return GenerationCodeUtil.includeTables;
    }

    private void initOldTables() {
        String fullClassName = this.getStrategy().getJavaPackageName(schema) + "." + this.getStrategy().getJavaClassName(schema);
        String schemaId = schema.getName().toUpperCase();

        try {
            Class clz = Class.forName(fullClassName);
            SchemaImpl oldSchema = (SchemaImpl) clz.getField(schemaId).get(clz);
            List tables = oldSchema.getTables();
            for (Object item : tables) {
                Table t = (Table) item;
                MySQLTableDefinition table = new MySQLTableDefinition(schema, t.getName(), t.getComment());
                oldTables.put(table.getName(), table);
            }
        } catch (Exception e) {
            log.warn("have not old tables in database " + schemaId);
        }
    }

    @Override
    protected void generateDao(TableDefinition table) {
        // super.generateDao(table);
        log.info("generator my dao and service .....");
        GenerationRepo.generator(schema.getName(), table.getName());
        GenerationService.generator(schema.getName(), table.getName());
    }

    @Override
    protected void empty(File file, String suffix, Set<File> keep) {
        //super.empty(file, suffix, keep);

        if (file != null) {
            if (file.isDirectory()) {
                File[] children = file.listFiles();
                if (children != null) {
                    File[] var5 = children;
                    int var6 = children.length;

                    for (int var7 = 0; var7 < var6; ++var7) {
                        File child = var5[var7];
                        this.empty(child, suffix, keep);
                    }
                }
            } else if (file.getName().endsWith(suffix)) {
                String className = file.getName().replaceAll("\\.java", "");
                className = className.replaceAll("Record$", "");
                String dbName = schema.getName().replaceAll("_", "").toLowerCase();

                if (!keep.contains(file)) {
                    file.delete();
                    log.info("delete file => " + file.getAbsolutePath());
                    // 删除 repo, service
                    GenerationRepo.deleteRepo(dbName, className);
                    GenerationService.deleteService(dbName, className);
                } else {
                    if (dbName.equals(file.getParentFile().getName())) {
                        // 父级目录是数据库名
                        log.info(" no checkout => " + file.getAbsolutePath());
                    } else {
                        className = CamelUnderlineTransformUtils.camelToUnderline(className).replaceFirst("_", "");
                        if (!className.matches(getNewTablePattern())) {
                            // git checkout
                            log.info("checkout => " + file.getAbsolutePath());
                            try {
                                Process process = Runtime.getRuntime().exec("git checkout " + file.getAbsolutePath());
                                process.waitFor();
                            } catch (IOException | InterruptedException e) {
                                log.error("git checkout error : " + e.getMessage());
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void generateSchema(SchemaDefinition schema, JavaWriter out) {
        this.schema = schema;
        this.initOldTables();
        super.generateSchema(schema, out);
    }

}
