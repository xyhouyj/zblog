package com.eumji.zblog.mapper;


import com.eumji.zblog.vo.Category;
import com.eumji.zblog.vo.CategoryCustom;
import com.eumji.zblog.vo.Pager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* Created by GeneratorFx on 2017-04-11.
*/
@Mapper
public interface CategoryMapper {

    /**
     * 初始化分类信息
     * @return
     */
    List<CategoryCustom> initCategoryList();

    Category getCategoryById(Integer id);

    List<Category> loadCategory(@Param("pager") Pager pager, @Param("categoryName") String categoryName);

    int checkExist(Category category);

    void saveCategory(Category category);

    void updateCategory(Category category);

    int initPage(Pager pager);
}
