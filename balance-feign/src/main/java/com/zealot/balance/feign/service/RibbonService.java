package com.zealot.balance.feign.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="BALANCE-RIBBON")
public interface RibbonService {

	@RequestMapping(value = "/hi",method = RequestMethod.GET)
	String hi(@RequestParam(value = "name") String name);
	
	@RequestMapping(value = "/mytest",method = RequestMethod.GET)
	String myTest();
	
	@RequestMapping(value = "/getList",method = RequestMethod.GET)
	List<String> getList();
}
