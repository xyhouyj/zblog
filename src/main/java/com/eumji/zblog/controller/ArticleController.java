package com.eumji.zblog.controller;

import com.eumji.zblog.vo.Article;
import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
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

    @RequestMapping("/artice/list/{id}")
    @ResponseBody
    public ResultInfo articleList(Pager pager){
        List<Article> articleList = articleService.articleList(pager);
        return null;
    }


}
