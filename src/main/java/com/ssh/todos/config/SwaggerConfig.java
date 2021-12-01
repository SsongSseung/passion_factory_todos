package com.ssh.todos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
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

@Configuration
@EnableSwagger2
//@Profile("!prd")
//@EnableWebMvc
public class SwaggerConfig {
	private ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("todos api")
				.description("열정 팩토리 코딩테스트")
				.version("v1.0")
				.build();
	}
	
	@Bean
	public Docket api() {

        List<Parameter> customHeaders = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(customHeaders)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/todos/**"))
				.build()
				.apiInfo(metadata());
	}
}
