package com.eumji.zblog.controller;

import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Category;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by GeneratorFx on 2017-04-11.
 */
@Controller
public class CategoryController {

    @Resource
    CategoryService categoryService;

    @RequestMapping("/article/category/{categoryId}")
    public String loadArticleByCategory(Pager pager, @PathVariable Integer categoryId){
        List<ArticleCustom> articleCustomList = categoryService.loadArticleByCategory(pager,categoryId);
        return "/blog/part/categorySummary";
    }

}
