package com.app.messagebroker.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(info());
    }

    private Info info() {
        return new Info()
                .title("Implement message broker")
                .version("1.0.0")
                .contact(contact())
                .description("")
                .license(license());
    }

    private Contact contact() {
        return new Contact()
                .email("rafik.myhost@gmail.com")
                .name("Arafik");
    }

    private License license() {
        return new License()
                .name("MIT License")
                .url("https://choosealicense.com/licenses/mit/");
    }
}
