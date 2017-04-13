package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.ArticleMapper;
import com.eumji.zblog.mapper.CategoryMapper;
import com.eumji.zblog.service.CategoryService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.CategoryCustom;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
* Created by GeneratorFx on 2017-04-11.
*/
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private ArticleMapper articleMapper;



    @Override
    public List<ArticleCustom> loadArticleByCategory(Pager pager, Integer categoryId) {
        return articleMapper.loadArticleByCategory(pager,categoryId);
    }

    @Override
    public List<CategoryCustom> initCategoryList() {
        return categoryMapper.initCategoryList();
    }
}
