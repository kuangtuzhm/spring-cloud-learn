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
 * @FileName Module.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午4:05:12
 * @author Zhao Haiming
 * @version 1.0
 */
public enum ResultCode {

    SUCCESS(0), FAIL(1); 
    
    private final Integer result; 
    
    private ResultCode(Integer result) { 
        this.result = result; 
    } 
    
    public Integer getResultCode() { 
        return result; 
     }
}
