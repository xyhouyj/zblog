package com.eumji.zblog.controller;

import com.eumji.zblog.service.TagService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Do
 * @package com.eumji.zblog.controller.admin
 * @name TagController
 * @date 2017/4/13
 * @time 18:54
 */
@Controller
@RequestMapping("/tag")
public class TagController {

   @Resource
    private TagService tagService;

   @RequestMapping("/load/{tagId}")
    public String loadArticleByTag(Pager pager, @PathVariable Integer tagId, Model model){
       List<ArticleCustom> articleList = tagService.loadArticleByTag(pager,tagId);
       if (!articleList.isEmpty()){
           model.addAttribute("articleList",articleList);
           model.addAttribute("pager",pager);
           model.addAttribute("tagName",articleList.get(0).getTagList().get(0).getTagName());
       }

       return "blog/part/tagSummary";
   }

   @RequestMapping("/pager/{tagId}")
   public Pager initPage(Pager pager,@PathVariable int tagId){
        tagService.ArticleTagPage(pager,tagId);
        return pager;
   }
}

