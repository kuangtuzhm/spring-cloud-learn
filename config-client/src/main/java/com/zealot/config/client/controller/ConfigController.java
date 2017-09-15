package com.zealot.config.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

	@Value("${my-config.appName}")
	private String appName;
	
	@RequestMapping(value="/getAppName")
	public String getAppName()
	{
		return appName;
	}
}
