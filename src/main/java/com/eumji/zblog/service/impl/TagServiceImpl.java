package com.eumji.zblog.service.impl;

import com.eumji.zblog.mapper.ArticleMapper;
import com.eumji.zblog.mapper.TagMapper;
import com.eumji.zblog.service.TagService;
import com.eumji.zblog.vo.ArticleCustom;
import com.eumji.zblog.vo.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Do
 * @package com.eumji.zblog.service.impl
 * @name TagServiceImpl
 * @date 2017/4/13
 * @time 18:56
 */
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private TagMapper tagMapper;
    @Override
    public List<ArticleCustom> loadArticleByTag(Pager pager, Integer tagId) {
        return articleMapper.loadArticleByTag(pager,tagId);
    }

    @Override
    public int getTagCount() {
        return tagMapper.getTagCount();
    }
}
