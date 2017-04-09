package com.eumji.zblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * FILE: com.eumji.zblog.controller.admin.AdminPageController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/9
 * TIME: 21:55
 */
@Controller
@RequestMapping("/admin")
public class AdminPageController {
    @RequestMapping("/home")
    public String homePage(){
        return "redirect:/admin/article/articleList";
    }

    @RequestMapping("/article/articleList")
    public String articlePage(){
        return "/admin/article/articleList";
    }
}
