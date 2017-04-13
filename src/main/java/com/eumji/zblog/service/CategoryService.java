package com.eumji.zblog.service;


import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.CategoryCustom;
import com.eumji.zblog.vo.Pager;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public interface CategoryService {



    List<ArticleCustom> loadArticleByCategory(Pager pager, Integer categoryId);

    /**
     * 初始化分类信息
     * @return
     */
    List<CategoryCustom> initCategoryList();
}
