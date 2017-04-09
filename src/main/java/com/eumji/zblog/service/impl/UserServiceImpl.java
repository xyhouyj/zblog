package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.UserMapper;
import com.eumji.zblog.service.UserService;
import com.eumji.zblog.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * FILE: com.eumji.zblog.service.impl.UserServiceImpl.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 10:10
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 通过userName查找User
     *
     * @param username
     * @return
     */
    @Override
    public User loadUserByUsername(String username) {
        return userMapper.getUser(username);
    }
}
