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

package com.zealot.balance.ribbon.consts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @FileName Constant.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午4:37:34
 * @author Zhao Haiming
 * @version 1.0
 */
@Component
public class Constant {

    
    public static String projectId;

    @Value("${project.code}")
    public void setProjectId(String projectId) {
        Constant.projectId = projectId;
    }  
}
