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

package com.zealot.module.admin.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.zealot.module.admin.pojo.ServerInfo;

/**
 * @FileName CityRepository.java
 * @Description: ES操作实体类
 *
 * @Date 2018年7月26日 上午9:38:03
 * @author Zhao Haiming
 * @version 1.0
 */
public interface ServerInfoRepository extends ElasticsearchRepository<ServerInfo, String> {
}
