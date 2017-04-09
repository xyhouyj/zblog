package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * FILE: com.eumji.zblog.mapper.UserMapper.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 10:20
 */
@Mapper
public interface UserMapper {
    /**
     * 获取用户凭证
     * @param username 账号
     * @return
     */
    User getUser(@Param("username") String username);

    List<User> allUser();
}
