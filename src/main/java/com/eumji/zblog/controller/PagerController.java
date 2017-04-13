package com.eumji.zblog.controller;

import com.eumji.zblog.service.PagerService;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Do
 * @package com.eumji.zblog.controller.admin
 * @name PagerController
 * @date 2017/4/11
 * @time 21:44
 */
@RestController
public class PagerController {

    @Resource
    private PagerService pagerService;
    /**
     * 初始化分页信息
     * @return
     */
    @RequestMapping("/pager/article/load")
    public Pager loadArticlePager(Pager pager){
        pagerService.initPage(pager);
        return pager;
    }

    @RequestMapping("/pager/category/load")
    public Pager loadCategoryPager(Pager pager,Integer categoryId){
        pagerService.loadCategoryPager(pager,categoryId);
        return pager;
    }
}
