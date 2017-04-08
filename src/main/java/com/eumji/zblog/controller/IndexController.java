package com.eumji.zblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 首页入口controller
 * FILE: com.eumji.zblog.controller.IndexController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/8
 * TIME: 15:19
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }
    @RequestMapping("/archives")
    public String archivesPage(){
        return "archives";
    }

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("userName","zhangsan");
        return "hello";
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
