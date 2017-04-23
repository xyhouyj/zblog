package com.eumji.zblog.mapper;

import com.eumji.zblog.vo.Pager;
import com.eumji.zblog.vo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Do
 * @package com.eumji.zblog.mapper
 * @name TagMapper
 * @date 2017/4/13
 * @time 18:55
 */
@Mapper
public interface TagMapper {

    int getTagCount();

    Tag getTagById(Integer id);

    List<Tag> loadTagList(@Param("pager") Pager pager, @Param("tagName") String tagName);

    void saveTag(Tag tag);

    int checkExist(Tag tag);

    void updateTag(Tag tag);

    int initPage(Pager pager);

    List<Tag> getTagList();

    /**
     * 加载此tag下的所有文章
     * @return
     * @param tagId
     */
    int articleTagPage(int tagId);
}
