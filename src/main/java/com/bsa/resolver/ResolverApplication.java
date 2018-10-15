package com.bsa.resolver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

@SpringBootApplication
public class ResolverApplication {

	public static void main(String[] args) {
		SpringApplication.run(FleetoInfoServerApplication.class, args);
	}
	
    @Bean
    public ViewResolver getViewResolver(){
        MarkdownViewResolver resolver = new MarkdownViewResolver();
        resolver.setSuffix(".md");
        return resolver;
    }
}
