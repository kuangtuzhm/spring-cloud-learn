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

package com.zealot.balance.ribbon.log.bean;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @FileName ServiceLogBean.java
 * @Description: 
 *
 * @Date 2018年7月23日 下午3:34:26
 * @author Zhao Haiming
 * @version 1.0
 */
public class ServiceLogBean {

    /**
     * 项目标识
     */
    private String projectId;
    
    /**
     * 服务器ip
     */
    private String serverIp;  
    
    private Integer userId;
    
    private String module;
    
    private String level;
    
    private String params;
    
    private String operObj;
    
    private String operObjInfo;
    
    /**
     * 0:默认 比如登录等 2：用户操作 3：菜单操作 4：角色 等等，需要开发人员定义。业务根据项目情况定义为静态变量或者enum,禁止在代码中各自写
     */
    //由module字段代替。
    //private Integer operType = 0;
    
    /**
     * 操作日志类型 1-->登陆 2-->添加 3-->修改 4-->删除(除软删除)   业务根据项目情况定义为静态变量或者enum,禁止在代码中各自写
     */
    private Integer operAction;
    
    private String operatorDesc;
    
    /**
     * 响应成功，失败(1成功 0失败)
     */
    private Integer resultCode = 1;
    
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getOperObj() {
        return operObj;
    }

    public void setOperObj(String operObj) {
        this.operObj = operObj;
    }

    public String getOperObjInfo() {
        return operObjInfo;
    }

    public void setOperObjInfo(String operObjInfo) {
        this.operObjInfo = operObjInfo;
    }

//    public Integer getOperType() {
//        return operType;
//    }
//
//    public void setOperType(Integer operType) {
//        this.operType = operType;
//    }

    public Integer getOperAction() {
        return operAction;
    }

    public void setOperAction(Integer operAction) {
        this.operAction = operAction;
    }

    public String getOperatorDesc() {
        return operatorDesc;
    }

    public void setOperatorDesc(String operatorDesc) {
        this.operatorDesc = operatorDesc;
    }

    public Integer getResultCode() {
        return resultCode;
    }

    public void setResultCode(Integer resultCode) {
        this.resultCode = resultCode;
    }
    
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    
}
