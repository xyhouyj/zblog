package com.eumji.zblog.vo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Do
 * @package com.eumji.zblog.vo
 * @name LogInfo
 * @date 2017/4/10
 * @time 18:14
 */
@Alias("log")
public class LogInfo implements Serializable {

    private String id;

    private String userId;

    private String url;

    private String ip;

    private String method;

    private String args;

    private String classMethod;

    private String exception;

    private Date operateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getClassMethod() {
        return classMethod;
    }

    public void setClassMethod(String classMethod) {
        this.classMethod = classMethod;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", url='" + url + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                ", args='" + args + '\'' +
                ", classMethod='" + classMethod + '\'' +
                ", exception='" + exception + '\'' +
                ", operateTime=" + operateTime +
                '}';
    }
}
