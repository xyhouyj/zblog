package com.eumji.zblog.service;


import com.eumji.zblog.vo.User;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public interface UserService {


    User loadUserByUsername(String username);
}
