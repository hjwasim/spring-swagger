package com.hjwasim.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket config() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    public static final Contact DEFAULT_CONTACT = new Contact(
            "Hjwasim", "http://github.com/hjwasim", "hjwasim001@gmail.com");

    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo(
            "Product Service", "Product Service API Description", "1.0",
            "urn:tos", DEFAULT_CONTACT,
            "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", Arrays.asList());

    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json"));


}
