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
    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/home")
    public String homePage(){
        return "redirect:/admin/article/articleList";
    }

    /**
     * 跳转到文章列表页面
     * @return
     */
    @RequestMapping("/article/articleList")
    public String articlePage(){
        return "/admin/article/articleList";
    }


    /**
     * 跳转到添加文章页面
     * @return
     */
    @RequestMapping("/article/addPage")
    public String articleAddPage(){
        return "/admin/article/articleAdd";
    }
}
