package com.eumji.zblog.controller;

import com.eumji.zblog.service.ArticletagService;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
* Created by GeneratorFx on 2017-04-11.
*/
@Controller
public class ArticletagController {

    @Resource
    ArticletagService articletagService;

    @RequestMapping("/pager/tag/load/{id}")
    public Pager loadTagPage(@PathVariable int id,Pager pager){
        return pager;
    }
}
