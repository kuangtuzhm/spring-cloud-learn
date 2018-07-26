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
 * 2018年7月26日    Zhao Haiming         Create the class
 * http://www.jimilab.com/
*/

package com.zealot.module.admin.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zealot.module.admin.pojo.ServerInfo;
import com.zealot.module.admin.service.ServerInfoService;

/**
 * @FileName CityRestController.java
 * @Description: 
 *
 * @Date 2018年7月26日 上午9:58:26
 * @author Zhao Haiming
 * @version 1.0
 */
@RestController
public class ServerInfoController {

    @Autowired
    private ServerInfoService serverInfoService;

    /**
     * 插入 ES 新城市
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/server_info/save")
    public String createCity(ServerInfo info) {
        info.setId("172.16.5.22:8838");
        info.setIp("172.16.5.22");
        info.setPort(8838);
        info.setDescription("balance-ribbon本机测试");
        info.setCreateTime(new Date());
        serverInfoService.save(info);
        
        info.setId("172.16.10.111:8833");
        info.setIp("172.16.10.111");
        info.setPort(8833);
        info.setDescription("eureka-client测试1");
        info.setCreateTime(new Date());
        serverInfoService.save(info);
        
        info.setId("172.16.10.111:8832");
        info.setIp("172.16.10.111");
        info.setPort(8832);
        info.setDescription("eureka-client测试2");
        info.setCreateTime(new Date());
        serverInfoService.save(info);
        
        serverInfoService.delete("172.16.10.111:8834");
        return "done";
    }

}