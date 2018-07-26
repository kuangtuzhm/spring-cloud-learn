package com.zealot.balance.ribbon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zealot.balance.ribbon.log.bean.ServiceLogBean;
import com.zealot.balance.ribbon.log.enums.LogLevel;
import com.zealot.balance.ribbon.log.enums.Module;
import com.zealot.balance.ribbon.log.enums.OperAction;
import com.zealot.balance.ribbon.log.util.ServiceLogUtil;
import com.zealot.balance.ribbon.service.HelloService;

@RestController
public class sayHiController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value="/hi")
	public String sayHi(String name)
	{
	    //不带具体操作对象id
	    ServiceLogUtil.info(Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    //带具体操作对象id
	    ServiceLogUtil.info("987654321",Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    
	    //不带具体操作对象id
	    ServiceLogUtil.debug(Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    //带具体操作对象id
	    ServiceLogUtil.debug("7777777", Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    
	    //不带具体操作对象id
	    ServiceLogUtil.warn(Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    //带具体操作对象id
        ServiceLogUtil.warn("1111123", Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    
	    //不带具体操作对象id
	    ServiceLogUtil.error(Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
	    //带具体操作对象id
        ServiceLogUtil.error("44444444", Module.USER, OperAction.ADD, "id{},名字{},地址{}","123456","张三","深圳市南山区");
        
		return helloService.hiService(name);
	}
	
	@RequestMapping(value="/mytest")
	public String mytest()
	{
	    //不带具体操作对象id
	    ServiceLogBean log = ServiceLogUtil.getServiceLogBean(LogLevel.INFO, Module.USER, OperAction.UPDATE ,"进行了一个更新用户的操作.用户id={}");
	    //带具体操作对象id
	    log = ServiceLogUtil.getServiceLogBean(LogLevel.INFO, Module.USER, OperAction.UPDATE, "123456" ,"进行了一个更新用户的操作.用户id={}");
	    log.setOperObjInfo("{'id':'123456','name':'测试用户'}");
	    ServiceLogUtil.saveServiceLog(log,"123456");
	    
		return helloService.myTestService();
	}
	
	@RequestMapping(value="/getList")
	public List<String> getList()
	{
	    List<String> list = null;
		try {
            list = helloService.getList();
        } catch (Exception e) {
            //不带具体操作对象id
            ServiceLogBean log = ServiceLogUtil.getServiceLogBean(LogLevel.INFO, Module.USER, OperAction.UPDATE, ServiceLogUtil.getExceptionStr(e));
            log.setParams("参数123456");
            ServiceLogUtil.saveServiceLog(log);
        }
		return list;
	}
}
