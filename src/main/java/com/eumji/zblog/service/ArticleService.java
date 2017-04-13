package com.eumji.zblog.service;

import com.eumji.zblog.vo.Article;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public interface ArticleService {


    List<ArticleCustom> articleList(Pager pager);

    /**
     * 获取分页信息
     * @return
     */
    Pager<Article> InitPager();

    int getArticleCount();
}
