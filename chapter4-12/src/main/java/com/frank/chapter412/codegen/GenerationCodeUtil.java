package com.frank.chapter412.codegen;

import com.frank.chapter412.utils.CamelUnderlineTransformUtils;
import lombok.extern.slf4j.Slf4j;
import org.jooq.impl.SchemaImpl;
import org.jooq.util.GenerationTool;
import org.jooq.util.jaxb.*;

import java.util.List;

/**
 * Created by HYL on 2016/11/3.
 */
@Slf4j
public class GenerationCodeUtil {
    private static String database = "test";

    // 正则表达式
    public static String includeTables = "user";
    public static String excludeTables = "";

    public static String entityBasePackage = "com.frank.chapter412.entity.";
    public static String entityDir = "src/main/java";

    private static Jdbc getDevDbJdbc() {
        return new Jdbc()
                .withDriver("com.mysql.jdbc.Driver")
                .withUrl("jdbc:mysql://localhost:3306")
                .withUser("root")
                .withPassword("root");
    }

    private static void generator(String database, String includesTableName, String excludeTableName) throws Exception {

        String targetPackage = entityBasePackage + database.replaceAll("_", "");

        includesTableName = getIncludeTables(database, includesTableName);

        Database db = new Database()
                .withName("org.jooq.util.mysql.MySQLDatabase")
                .withIncludes(includesTableName)
                .withExcludes(excludeTableName)
                .withInputSchema(database);

        Target target = new Target()
                .withPackageName(targetPackage)
                .withDirectory(entityDir);

        Generate generate = new Generate()
                .withGlobalCatalogReferences(false)
                .withDaos(true)
                .withPojos(true)
                .withRecords(true);


        Configuration configuration = new Configuration()
                .withJdbc(getDevDbJdbc())
                .withGenerator(new SimpleConfGenerator()
                        .withDatabase(db)
                        .withTarget(target)
                        .withGenerate(generate)
                );

        GenerationTool.generate(configuration);
    }

    private static String getIncludeTables(String database, String includeTables) {

        String pkg = entityBasePackage + database.replaceAll("_", "");
        String fieldName = database.toUpperCase();
        String className = CamelUnderlineTransformUtils.underlineToCamel(database);
        className = pkg + "." + className.replaceFirst(className.substring(0, 1), className.substring(0, 1).toUpperCase());

        String result = includeTables;

        try {
            // 加上已经生成过得表
            Class clz = Class.forName(className);
            SchemaImpl schema = (SchemaImpl) clz.getField(fieldName).get(clz);
            List tables = schema.getTables();
            for (Object table : tables) {
                result += "|" + table.toString().replaceAll("\"", "");
            }
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
            log.warn("not exist database => " + database);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        generator(database, includeTables, excludeTables);
    }

}
