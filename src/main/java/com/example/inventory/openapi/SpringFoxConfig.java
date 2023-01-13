package com.example.inventory.openapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

    @Bean
    public Docket apiDocket() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.example.inventory.controller"))
                    .build()
                .apiInfo(apiInfo())
                .tags(new Tag("Estoque", "Gerencia o Estoque"));
    }

    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("Inventory API")
                .description("API aberta para Dealers.")
                .version("1.1")
                .contact(new Contact(
                        "NGTechnology", "https://www.ngtechnology.com","contato@ngtechnology.com"))
                .build();
    }

}
