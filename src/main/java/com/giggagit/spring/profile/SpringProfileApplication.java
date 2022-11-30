package com.giggagit.spring.profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringProfileApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringProfileApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringProfileApplication.class, args);
		
		logger.trace("Trace level log message");
		logger.info("Info level log message");
		logger.debug("Debug level log message");
		logger.warn("Warn level log message");
		logger.error("Error level log message");
	}

}
