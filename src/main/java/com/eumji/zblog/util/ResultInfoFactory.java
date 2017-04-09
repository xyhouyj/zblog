package com.eumji.zblog.util;

/**
 * 获取错误信息的工具类
 * FILE: com.eumji.zblog.util.UserInfoUtil.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 15:39
 */
public class ResultInfoFactory {
    public static ResultInfo ERROR_RESULT;

    /**
     * 带错误信息错误信息相应体
     * @param errorInfo
     * @return
     */
    public static ResultInfo getErrorRestInfo(String errorInfo){
        if (ERROR_RESULT == null){
            ERROR_RESULT = new ResultInfo("fail",errorInfo);
        }else{
            ERROR_RESULT.setErrorInfo(errorInfo);
        }
        return ERROR_RESULT;
    }

    /**
     * 不带参数错误信息相应体
     * 默认为错误信息为操作失败
     * @return
     */
    public static ResultInfo getErrorResultInfo(){
        return getErrorRestInfo("操作失败！！！");
    }


}
