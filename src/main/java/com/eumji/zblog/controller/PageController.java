package com.eumji.zblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页入口controller
 * FILE: com.eumji.zblog.controller.IndexController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/8
 * TIME: 15:19
 */
@Controller
public class PageController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/archives")
    public String archivesPage(){
        return "archives";
    }

    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/articleList")
    public String articleList(){
        return "/admin/article/articleList";
    }

    @RequestMapping("/admin/friend/list")
    public String partnerList(){
        return "/admin/partner/partnerList";
    }

    @RequestMapping("/admin/friend/addJump")
    public String addPage(){
        return "/admin/partner/partnerAdd";
    }
}
