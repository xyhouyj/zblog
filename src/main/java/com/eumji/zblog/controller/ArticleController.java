package com.eumji.zblog.controller;

import com.eumji.zblog.vo.Article;
import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;

import java.util.List;

/**
 * Created by GeneratorFx on 2017-04-11.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @RequestMapping("/list/{id}")
    @ResponseBody
    public ResultInfo articleList(Pager pager){

        return null;
    }

    @RequestMapping("/load")
    public String loadArticle(Pager<Article> pager, Model model){
        List<ArticleCustom> articleList = articleService.articleList(pager);
        System.out.println(articleList);
        model.addAttribute("articleList",articleList);
        return "blog/part/articleSummary";
    }


}
