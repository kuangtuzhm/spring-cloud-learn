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
 * 2018年7月25日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.module.admin.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.zealot.module.admin.pojo.ServerInfo;
import com.zealot.module.admin.service.ServerInfoService;
import com.zealot.module.admin.utils.httpclient.HttpAPIService;

/**
 * @FileName ScheduledTasks.java
 * @Description: 
 *
 * @Date 2018年7月25日 下午6:14:45
 * @author Zhao Haiming
 * @version 1.0
 */
@Component
public class ScheduledTasks {

    private final static Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    
    ExecutorService executorService = Executors.newFixedThreadPool(20);
    
    @Autowired
    private ServerInfoService serverInfoService;
    
    @Resource
    private HttpAPIService httpAPIService;

    @Scheduled(fixedRate = 30000)
    public void reportCurrentTime() {
        logger.info("打印当前时间: {}.", dateFormat.format(new Date()));
        
        List<ServerInfo> allServerList = serverInfoService.findAll();
        logger.info("查找到需要监控的服务器数量="+allServerList.size());
        for(final ServerInfo server : allServerList)
        {
            logger.info("server="+JSON.toJSONString(server));
            //检测服务器状态
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        String url = "http://"+server.getId()+"/actuator/health";
                        String str = httpAPIService.doGet(url);
                        logger.info(server.getId()+"采集数据:"+str);
                    } catch (Exception e) {
                        logger.warn("采集"+server.getId()+"出错。。。。。。。");
                    }
                }
            });
        }
        


    }
}
