package com.eumji.zblog.controller;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.vo.Article;
import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Partner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private PartnerService partnerService;

    @Resource
    private ArticleService articleService;
    @RequestMapping("/")
    public String home(Model model){
        List<Partner> partnerList = partnerService.findAll();
        Pager<Article> pager = articleService.InitPager();
        model.addAttribute("partnerList",partnerList);
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
