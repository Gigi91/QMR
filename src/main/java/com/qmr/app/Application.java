package com.qmr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("/WEB-INF/classes/spring.xml")//non il percorso attuale, ma quello che si ottiene dal build di maven
//@ImportResource("spring.xml")//non il percorso attuale, ma quello che si ottiene dal build di maven
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(Application.class);
	}

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    	
    }
}