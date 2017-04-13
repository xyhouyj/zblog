package com.eumji.zblog.service;

import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;

import java.util.List;

/**
 * @author Do
 * @package com.eumji.zblog.service
 * @name TagService
 * @date 2017/4/13
 * @time 18:55
 */
public interface TagService {
    /**
     * 获取当前tag下的文章列表
     * @param pager
     * @param tagId
     * @return
     */
    List<ArticleCustom> loadArticleByTag(Pager pager, Integer tagId);

    int getTagCount();
}
