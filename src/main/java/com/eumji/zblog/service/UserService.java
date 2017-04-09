package com.eumji.zblog.service;

import com.eumji.zblog.vo.User;

/**
 * FILE: com.eumji.zblog.service.UserService.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 10:09
 */
public interface UserService {
    /**
     * 通过userName查找User
     * @param username
     * @return
     */
    User loadUserByUsername(String username);
}
