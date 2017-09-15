package com.zealot.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zealot.ribbon.service.HelloService;

@RestController
public class RibbonController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/hi")
	public String hi(String name)
	{
		return helloService.hiService(name);
	}
}
