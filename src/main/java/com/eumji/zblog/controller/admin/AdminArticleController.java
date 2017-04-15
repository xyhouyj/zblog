package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.util.ResultInfoFactory;
import com.eumji.zblog.vo.Article;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * FILE: com.eumji.zblog.controller.admin.AdminArticleController.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/15
 * TIME: 22:00
 */
@Controller
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/initPage")
    @ResponseBody
    public Pager initPage(Pager pager){
        articleService.InitPager(pager);
        return pager;
    }

    @RequestMapping("/load")
    public String loadArticle(Pager pager, Integer categoryId, Integer tagId, String title, Model model){
        pager.setStart(pager.getStart());
        Map<String,Object> param = new HashMap<>();
        param.put("tagId",tagId);
        param.put("categoryId",tagId);
        param.put("pager",pager);
        List<Article> articleList = articleService.loadArticle(param);
        model.addAttribute("articleList",articleList);
        return "/admin/article/articleTable";
    }

    @RequestMapping("/updateStatue")
    @ResponseBody
    public ResultInfo updateStatue(Integer id,int status){
        try {

            articleService.updateStatue(id,status);
        }catch (Exception e){
            return ResultInfoFactory.getErrorResultInfo("更新状态失败,请稍后再尝试");
        }
        return ResultInfoFactory.getSuccessResultInfo();


    }
}
