package com.zealot.balance.feign.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zealot.balance.feign.service.RibbonService;
import com.zealot.balance.feign.service.SchedualServiceHi;

@RestController
public class HiController {

	@Autowired
	SchedualServiceHi schedualServiceHi;
	
	@Autowired
	RibbonService ribbonService;
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String sayHi(@RequestParam String name)
	{
		//return schedualServiceHi.hi(name);
		return ribbonService.hi(name);
	}
	
	@RequestMapping(value="/mytest", method=RequestMethod.GET)
	public String myTest()
	{
		//return schedualServiceHi.myTest();
		return ribbonService.myTest();
	}
	
	@RequestMapping(value="/getList", method=RequestMethod.GET)
	public List<String> getList()
	{
		//return schedualServiceHi.getList();
		return ribbonService.getList();
	}
}
