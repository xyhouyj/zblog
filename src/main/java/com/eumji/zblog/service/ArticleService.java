package com.eumji.zblog.service;

import com.eumji.zblog.vo.Article;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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

    /**
     * 初始化后台管理的article分页信息
     * @param pager 分页对象
     */
    void InitPager(Pager pager);

    List<Article> loadArticle(Map<String, Object> param);

    void updateStatue(Integer id, int status);

    void saveArticle(Article article, int[] tags) throws IOException;

    Article getArticleById(Integer id);

    void updateArticle(Article article, int[] tags);

    void deleteArticle(Integer id);

    ArticleCustom getArticleCustomById(Integer articleId);

    /**
     * 获取上一篇文章信息
     * @param articleId
     * @return
     */
    Article getLastArticle(Integer articleId);

    /**
     * 获取下一篇文章信息
     * @param articleId
     * @return
     */
    Article getNextArticle(Integer articleId);

    /**
     * 增加文章阅读数量
     * @param articleId
     */
    void addArticleCount(Integer articleId);

    List<ArticleCustom> popularArticle();

    String[] getArticleId();

    List<Article> getArticleListByKeywords(String keyword);

    List<Map> articleArchiveList();
}
