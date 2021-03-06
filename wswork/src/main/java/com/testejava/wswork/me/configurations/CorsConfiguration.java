package com.testejava.wswork.me.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");

        // liberando app cliente exemplo:
        // registry.addMapping("/**")
        // .allowedOrigins("OutroEndereco")
        // .allowedMethods("GET", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}
