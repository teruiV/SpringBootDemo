package com.frank.chapter35.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jianweilin on 2017/10/11.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {


    @Bean
    public Docket createRestApi() {
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(getPublicParams("User-Id","用户编号","jianwl","String","header"));
        parameters.add(getPublicParams("User-Token","用户令牌","jianwl","String","header"));
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.frank.chapter35.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameters);
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("记录点滴成长")
                .description("swaggeri 教程")
                .termsOfServiceUrl("http://jianwl.com")
                .version("1.0")
                .build();
    }

    private Parameter getPublicParams(String name,String desc,String defaultVal,String dataType,String paramType) {
        return new Parameter(name,desc,defaultVal,true,false,new ModelRef(dataType),null,null,paramType,"");
    }
}
