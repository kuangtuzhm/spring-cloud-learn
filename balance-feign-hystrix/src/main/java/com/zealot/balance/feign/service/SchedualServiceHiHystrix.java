package com.zealot.balance.feign.service;

import org.springframework.stereotype.Service;

@Service
public class SchedualServiceHiHystrix implements SchedualServiceHi {

	@Override
	public String sayHiFromClientOne(String name) {

		return "sorry" + name;
	}

}
