package com.eumji.zblog.controller;

import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Category;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping("/category/load/{categoryId}")
    public String loadArticleByCategory(Model model,Pager pager, @PathVariable Integer categoryId){
        List<ArticleCustom> articleList = categoryService.loadArticleByCategory(pager,categoryId);
        if (!articleList.isEmpty()){
            model.addAttribute("articleList",articleList);
            model.addAttribute("categoryName",articleList.get(0).getCategoryName());
        }
        return "/blog/part/categorySummary";
    }

}
