package com.delta;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableAutoConfiguration
public class DeltaApplication {
	
	private static Logger logger = Logger.getLogger(DeltaApplication.class);
	
	public static void main(String[] args) {
//		SpringApplication app = new SpringApplication(DeltaApplication.class);
//		app.setBannerMode(org.springframework.boot.Banner.Mode.OFF);
//		app.run(args);
		SpringApplication.run(DeltaApplication.class, args);
		logger.info("service start success !");
	}

}
