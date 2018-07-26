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

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @FileName IPUtil.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午4:47:11
 * @author Zhao Haiming
 * @version 1.0
 */
public class IPUtil {

    public static String ip;
    
    public static String getIp()
    {
        if(null == ip)
        {
            try {
                InetAddress address = InetAddress.getLocalHost();//获取的是本地的IP地址 //PC-20140317PXKX/192.168.0.121
                ip = address.getHostAddress();//192.168.0.121    
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return ip;
    }
}
