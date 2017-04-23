package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.service.TagService;
import com.eumji.zblog.vo.Category;
import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Partner;
import com.eumji.zblog.vo.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @Resource
    private TagService tagService;

    @Resource
    private PartnerService partnerService;
    /**
     * 后台首页
     * @return
     */
    @RequestMapping("/home")
    public String homePage(){
        return "redirect:/admin/article/list";
    }

    /**
     * 跳转到文章列表页面
     * @return
     */
    @RequestMapping("/article/list")
    public String articlePage(Model model){
        List<Tag> tagList = tagService.getTagList();
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("tagList",tagList);
        model.addAttribute("categoryList",categoryList);
        return "admin/article/articleList";
    }


    @RequestMapping("/tag/list")
    public String labelPage(){
        return "admin/label/labelList";
    }
    /**
     * 加载友链分页
     * @param pager
     * @param model
     * @return
     */
    @RequestMapping("/partner/load")
    public String loadPartner(Pager pager, Model model,String param){
        pager.setStart((pager.getPage()-1)*pager.getLimit());
        List<Partner> partnerList =partnerService.loadPartner(pager,param);
        model.addAttribute("partnerList",partnerList);
        return "admin/partner/partnerTable";
    }

    /**
     * 跳转添加友链页面
     * @return
     */
    @RequestMapping("/partner/addJump")
    public String partnerAddPage(){
        return "admin/partner/partnerAdd";
    }

    @RequestMapping("/partner/editJump")
    public String partnerEditPage(Integer id,Model model){
        Partner partner = partnerService.getPartnerById(id);
        model.addAttribute("partner",partner);
        return "admin/partner/partnerEdit";
    }

    /**跳转到友链展示页面
     * @return
     */
    @RequestMapping("/partner/list")
    public String partnerPage(){
        return "admin/partner/partnerList";
    }
}
