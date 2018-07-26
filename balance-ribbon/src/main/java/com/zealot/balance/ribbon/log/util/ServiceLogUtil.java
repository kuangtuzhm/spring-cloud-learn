/*
 * COPYRIGHT. ShenZhen JiMi Technology Co., Ltd. 2018.
 * ALL RIGHTS RESERVED.
 *
 * No part of this publication may be reproduced, stored in a retrieval system, or transmitted,
 * on any form or by any means, electronic, mechanical, photocopying, recording, 
 * or otherwise, without the prior written permission of ShenZhen JiMi Network Technology Co., Ltd.
 *
 * Amendment History:
 * 
 * Date                   By              Description
 * -------------------    -----------     -------------------------------------------
 * 2018年7月23日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.balance.ribbon.log.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.zealot.balance.ribbon.consts.Constant;
import com.zealot.balance.ribbon.log.bean.ServiceLogBean;
import com.zealot.balance.ribbon.log.enums.LogLevel;
import com.zealot.balance.ribbon.log.enums.Module;
import com.zealot.balance.ribbon.log.enums.OperAction;
import com.zealot.balance.ribbon.log.enums.ResultCode;

/**
 * @FileName ServiceLogUtil.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午3:54:39
 * @author Zhao Haiming
 * @version 1.0
 */
public class ServiceLogUtil {

    private final static Logger flumeLog = LoggerFactory.getLogger("flumelog");
    
    public static void saveServiceLog(ServiceLogBean log,Object... params)
    {
        String logStr = JSON.toJSONString(log);
        switch(log.getLevel())
        {
            case "debug":
                flumeLog.debug(logStr,params);
                break;
            case "info":
                flumeLog.info(logStr,params);
                break;
            case "warn":
                flumeLog.warn(logStr,params);
                break;
            case "error":
                flumeLog.error(logStr,params);
                break;
        }
    }
    
    /**
     * @Title: error 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void error(Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        error(null, module,operAction,operatorDesc,params);
    }
    
    /**
     * @Title: error 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operObj:具体被操作对象的id(比如用户id,设备imei等) operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void error(String operObj, Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        ServiceLogBean log = getServiceLogBean(LogLevel.ERROR,module,operAction,operObj, operatorDesc);
        saveServiceLog(log, params);
    }
    
    /**
     * @Title: warn 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void warn(Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        warn(null, module,operAction,operatorDesc,params);
    }
    
    /**
     * @Title: warn 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operObj:具体被操作对象的id(比如用户id,设备imei等) operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void warn(String operObj, Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        ServiceLogBean log = getServiceLogBean(LogLevel.WARN,module,operAction,operObj, operatorDesc);
        saveServiceLog(log, params);
    }
    
    /**
     * @Title: info 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void info(Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        info(null, module,operAction,operatorDesc,params);
    }
    
    public static void info(String operObj, Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        ServiceLogBean log = getServiceLogBean(LogLevel.INFO,module,operAction, operObj, operatorDesc);
        saveServiceLog(log, params);
    }
    
    /**
     * @Title: debug 
     * @Description:保存基本的操作信息的日志
     * @param module
     * @param operAction
     * @param operatorDesc
     * @param module:模块  operAction:操作 operatorDesc:具体的日志描述 params:如果operatorDesc(日志描述)参数中有通配符，则params替换
     * @author Zhao Haiming
     * @date 2018年7月24日 上午8:54:35
     */
    public static void debug(Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        debug(null, module,operAction,operatorDesc,params);
    }
    
    public static void debug(String operObj, Module module, OperAction operAction, String operatorDesc, Object... params)
    {
        ServiceLogBean log = getServiceLogBean(LogLevel.DEBUG,module,operAction,operObj, operatorDesc);
        saveServiceLog(log, params);
    }
    
    public static ServiceLogBean getServiceLogBean(LogLevel logLevel, Module module, OperAction operAction, String operatorDesc)
    {
        return getServiceLogBean(logLevel, module, operAction, null, operatorDesc);
    }
    
    public static ServiceLogBean getServiceLogBean(LogLevel logLevel, Module module, OperAction operAction, String operObj, String operatorDesc)
    {
        ServiceLogBean log = new ServiceLogBean();
        
        log.setLevel(logLevel.getLevel());
        log.setModule(module.getModule());
        log.setOperAction(operAction.getOperAction());
        log.setOperatorDesc(operatorDesc);
        
        log.setOperObj(operObj);
//        log.setOperObjInfo(operObjInfo);
        //log.setOperType(operType);
//        log.setParams(params);
        log.setProjectId(Constant.projectId);
        log.setServerIp(IPUtil.getIp());
//        log.setUserId(userId);
        log.setResultCode(ResultCode.SUCCESS.getResultCode());
        
        log.setCreateTime(new Date());
        
        return log;
    }
    
    public static String getExceptionStr(Throwable e)
    {
        StringWriter sw = new StringWriter();    
        PrintWriter pw = new PrintWriter(sw);    
        e.printStackTrace(pw);    
        String msg=sw.toString();
        return msg;
//        String exStr = null;
//        StackTraceElement[] ses = e.getStackTrace();
//        if(ses.length > 0)
//        {
//            for(StackTraceElement se : ses)
//            {
//                exStr+=(se.toString()+"\n");
//            }
//        }
//        return exStr;
    }
    
    public static void main(String [] args)
    {
        String s = String.format("id{},名字{}", "123456","张三");
        System.out.println(s);
    }
}
