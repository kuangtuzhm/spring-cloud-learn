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

package com.zealot.module.admin.service;

import java.util.List;

import com.zealot.module.admin.pojo.ServerInfo;

/**
 * @FileName ServerInfoService.java
 * @Description: 
 *
 * @Date 2018年7月26日 下午2:10:33
 * @author Zhao Haiming
 * @version 1.0
 */
public interface ServerInfoService {
    
    public void save(ServerInfo info);

    public List<ServerInfo> findAll();
    
    public void delete(String id);
}
