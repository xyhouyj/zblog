package com.eumji.zblog.controller;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.service.TagService;
import com.eumji.zblog.vo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class  PageController {

    @Resource
    private PartnerService partnerService;

    @Resource
    private ArticleService articleService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private TagService tagService;
    @RequestMapping("/")
    public String home(Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        int tagCount = tagService.getTagCount();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        return "indexs";
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

    @RequestMapping("/category/details/{categoryId}")
    public String categoryPage(Model model,@PathVariable Integer categoryId){
        List<Partner> partnerList = partnerService.findAll();
        model.addAttribute("partnerList",partnerList);
        model.addAttribute("categoryId",categoryId);
        return "/category";
    }
    /**
     * 加载文章
     * @return
     */
    @RequestMapping("/article/details/{articleId}")
    public String loadArticle(Integer articleId,Model model){
        List<Partner> partnerList = partnerService.findAll();
        List<CategoryCustom> categoryList = categoryService.initCategoryList();
        int articleCount = articleService.getArticleCount();
        int tagCount = tagService.getTagCount();
        model.addAttribute("categoryCount",categoryList.size());
        model.addAttribute("articleCount",articleCount);
        model.addAttribute("tagCount",tagCount);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("partnerList",partnerList);
        return "/article";
    }
}
