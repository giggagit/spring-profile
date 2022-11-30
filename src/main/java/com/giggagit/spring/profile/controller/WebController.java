package com.giggagit.spring.profile.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giggagit.spring.profile.service.IService;

@RestController
public class WebController {

	private static final Logger logger1 = LoggerFactory.getLogger("com.giggagit.rest.api1");
	private static final Logger logger2 = LoggerFactory.getLogger("com.giggagit.rest.api2");
	
	private final IService service;
	
	public WebController(IService service) {
		this.service = service;
	}

	@Value("${web.msg}")
	private String msg;
	
	@GetMapping("/msg")
	public ResponseEntity<String> testMsg(HttpServletRequest request) {
		logger1.debug("logger1: testMsg.LocalAddr="+request.getLocalAddr());
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/service")
	public ResponseEntity<String> callService(HttpServletRequest request) {
		Map<String, String[]> map = request.getParameterMap();
		String str = map.keySet().stream()
				.map(key -> key + "=" + Arrays.toString(map.get(key)))
				.collect(Collectors.joining(", ", "{", "}"));
		logger2.debug("logger2: callService.ParameterMap="+str);
		return ResponseEntity.ok(service.getService());
	}
	
	@GetMapping("/loop")
	public ResponseEntity<?> loop() throws Exception {
		for (int i = 0; i < 5; i++) {
			logger2.debug("loop: "+i);
			Thread.sleep(1000);
			
		}
		return ResponseEntity.noContent().build();
	}

	
}
