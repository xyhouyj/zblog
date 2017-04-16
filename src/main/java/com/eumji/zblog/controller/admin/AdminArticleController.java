package com.eumji.zblog.controller.admin;

import com.eumji.zblog.service.ArticleService;
import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.service.TagService;
import com.eumji.zblog.util.ResultInfo;
import com.eumji.zblog.util.ResultInfoFactory;
import com.eumji.zblog.vo.Article;
import com.eumji.zblog.vo.Category;
import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger log = LoggerFactory.getLogger(AdminArticleController.class);
    @Resource
    private ArticleService articleService;

    @Resource
    private TagService tagService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/initPage")
    @ResponseBody
    public Pager initPage(Pager pager) {
        articleService.InitPager(pager);
        return pager;
    }

    @RequestMapping("/addPage")
    public String addPage() {
        return "/admin/article/articleAdd";
    }

    @RequestMapping("/load")
    public String loadArticle(Pager pager, Integer categoryId, int[] tagIds, String title, Model model) {

        pager.setStart(pager.getStart());
        Map<String, Object> param = new HashMap<>();
        param.put("tags", tagIds);
        param.put("categoryId", categoryId);
        param.put("title",title);
        param.put("pager", pager);
        List<Article> articleList = articleService.loadArticle(param);
        model.addAttribute("articleList", articleList);
        return "/admin/article/articleTable";
    }

    @RequestMapping("/updateStatue")
    @ResponseBody
    public ResultInfo updateStatue(Integer id, int status) {
        try {

            articleService.updateStatue(id, status);
        } catch (Exception e) {
            log.error(e.toString());
            return ResultInfoFactory.getErrorResultInfo("更新状态失败,请稍后再尝试");
        }
        return ResultInfoFactory.getSuccessResultInfo();
    }

    @RequestMapping("/term")
    public String articleTerm(Model model) {
        List<Tag> tagList = tagService.getTagList();
        List<Category> categoryList = categoryService.getCategoryList();
        model.addAttribute("tagList", tagList);
        model.addAttribute("categoryList", categoryList);
        return "/admin/article/articleInfo";
    }


    @RequestMapping("/save")
    @ResponseBody
    public ResultInfo SaveArticle(Article article,int[] tags){
        try {
//            article.setContent(URLDecoder.decode(article.getContent(), "UTF-8"));
//            article.setDescription(URLDecoder.decode(article.getDescription(),"UTF-8"));
            articleService.saveArticle(article, tags);
        }catch (Exception e){
            log.error(e.toString());
            return ResultInfoFactory.getErrorResultInfo("添加失败,请稍后再尝试");
        }
        return ResultInfoFactory.getSuccessResultInfo();

    }

    @RequestMapping("/editJump")
    public String updatePage(Integer id,Model model){
        Article article = articleService.getArticleById(id);
        model.addAttribute("article",article);
        return"/admin/article/articleEdit";
    }

    @RequestMapping("/updateInfo")
    public String updateInfo(Integer articleId,Model model){
        Article article = articleService.getArticleById(articleId);
        List<Category> categoryList = categoryService.getCategoryList();
        List<Tag> tagList = tagService.getTagList();
        model.addAttribute("article",article);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("tagList",tagList);
        return "/admin/article/articleEditInfo";
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResultInfo updateArticle(Article article,int[] tags){
        try {
            articleService.updateArticle(article,tags);
        }catch (Exception e){
            log.error(e.toString());
            ResultInfoFactory.getErrorResultInfo("修改失败,请稍后再试!");
        }
        return ResultInfoFactory.getSuccessResultInfo();
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResultInfo deleteArticle(Integer id){
        try {

            articleService.deleteArticle(id);
        }catch (Exception e){
            log.error(e.toString());
            return ResultInfoFactory.getErrorResultInfo("删除失败!");
        }
        return ResultInfoFactory.getSuccessResultInfo();
    }
}