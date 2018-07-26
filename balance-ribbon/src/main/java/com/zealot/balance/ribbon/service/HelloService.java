package com.zealot.balance.ribbon.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

	@Autowired
	RestTemplate restTemplate;

	public String hiService(String name) {
		return restTemplate.getForObject("http://EUREKA-CLIENT/hi?name=" + name,
				String.class);
	}
	
	public String myTestService()
	{
		return restTemplate.getForObject("http://EUREKA-CLIENT/mytest",
				String.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getList()
	{
		List<String> list = new ArrayList<>();
		return restTemplate.getForObject("http://EUREKA-CLIENT/getList",
				list.getClass());
	}

	public String hiError(String name) {
		return "hi," + name + ",sorry,error!";
	}
}
