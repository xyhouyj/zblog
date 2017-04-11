package com.eumji.zblog.controller;

import com.eumji.zblog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by GeneratorFx on 2017-04-11.
*/
@Controller
@RequestMapping("/user")
public class UserController {

@Resource
UserService userService;


}
