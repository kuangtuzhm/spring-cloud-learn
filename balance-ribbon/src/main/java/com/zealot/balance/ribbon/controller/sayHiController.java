package com.zealot.balance.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zealot.balance.ribbon.service.HelloService;

@RestController
public class sayHiController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/hi")
	public String sayHi(String name)
	{
		return helloService.hiService(name);
	}
}
