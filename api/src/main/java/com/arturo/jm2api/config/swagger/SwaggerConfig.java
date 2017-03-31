package com.arturo.jm2api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import com.arturo.jm2api.common.Profiles;

import springfox.documentation.builders.LoginEndpointBuilder;
import springfox.documentation.service.LoginEndpoint;
import springfox.documentation.spring.web.plugins.DocumentationPluginsManager;
import springfox.documentation.spring.web.scanners.ApiDescriptionReader;
import springfox.documentation.spring.web.scanners.ApiListingScanner;
import springfox.documentation.spring.web.scanners.ApiModelReader;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@Profile(Profiles.SWAGGER)
public class SwaggerConfig {
    
    @Primary
    @Bean
    public ApiListingScanner addExtraOperations(
        ApiDescriptionReader apiDescriptionReader, 
        ApiModelReader apiModelReader, 
        DocumentationPluginsManager pluginsManager) {
        return new LoginOperation(
            apiDescriptionReader, apiModelReader, pluginsManager);
    }
   
    @Bean
    public LoginEndpoint loginEndpoint() {
        return new LoginEndpointBuilder()
            .url("/user/login")
            .build();
    }
    
}
