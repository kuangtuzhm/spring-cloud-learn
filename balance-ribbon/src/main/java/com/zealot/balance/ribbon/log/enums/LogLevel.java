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

package com.zealot.balance.ribbon.log.enums;

/**
 * @FileName LogLevel.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午4:05:12
 * @author Zhao Haiming
 * @version 1.0
 */
public enum LogLevel {

    ERROR("error"), WARN("warn"), INFO("info"), DEBUG("debug"); 
    
    private final String level; 
    
    private LogLevel(String level) { 
        this.level = level; 
    } 
    
    public String getLevel() { 
        return level; 
     }
}
