package com.zealot.eureka.client.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaController {

	@Value("${server.port}")
    String port;
	
    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi "+name+",i am from port:" +port;
    }
    
    @RequestMapping("/mytest")
    public String home() {
        return "mytest==" +port;
    }
    
    @RequestMapping("/getList")
    public List<String> getList() {
    	List<String> list = new ArrayList<>();
    	list.add("test1");
    	list.add("test2");
    	list.add("test3");
        return list;
    }
}
