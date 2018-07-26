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

package com.zealot.module.admin.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.zealot.module.admin.es.dao.ServerInfoRepository;
import com.zealot.module.admin.pojo.ServerInfo;
import com.zealot.module.admin.service.ServerInfoService;

/**
 * @FileName ServerInfoServiceImpl.java
 * @Description: 
 *
 * @Date 2018年7月26日 下午2:11:18
 * @author Zhao Haiming
 * @version 1.0
 */
@Service
public class ServerInfoServiceImpl implements ServerInfoService{
    
    private static final Logger logger = LoggerFactory.getLogger(ServerInfoServiceImpl.class);

    // ES 操作类
    @Autowired
    ServerInfoRepository serverInfoRepository;

    @Override
    public void save(ServerInfo info) {
        
        serverInfoRepository.save(info);
        logger.info("存储服务器信息info="+JSON.toJSONString(info));
    }

    @Override
    public List<ServerInfo> findAll() {
        List<ServerInfo> list = new ArrayList<>();
        Iterator<ServerInfo> iter = serverInfoRepository.findAll().iterator();
        while(iter.hasNext())
        {
            list.add(iter.next());
        }
        return list;
    }

    @Override
    public void delete(String id) {
        serverInfoRepository.deleteById(id);
    }

    
}
