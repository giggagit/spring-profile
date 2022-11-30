package com.giggagit.spring.profile.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DevService implements IService {

	@Override
	public String getService() {
		return "Call DevService";
	}

}
