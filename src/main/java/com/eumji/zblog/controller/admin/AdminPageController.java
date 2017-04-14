package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.PartnerService;
import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Partner;
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
    private PartnerService partnerService;
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

    @RequestMapping("/partner/load")
    public String loadPartner(Pager pager, Model model){
        pager.setStart((pager.getPage()-1)*pager.getLimit());
        List<Partner> partnerList =partnerService.loadPartner(pager);
        model.addAttribute("partnerList",partnerList);
        return "/admin/partner/partnerTable";
    }
}
