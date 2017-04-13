package com.eumji.zblog.vo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * @author Do
 * @package com.eumji.zblog.vo
 * @name CategoryCustom
 * @date 2017/4/13
 * @time 12:30
 */
@Alias("categoryCustom")
public class CategoryCustom implements Serializable {
    private Integer id;
    private String categoryName;
    private String aliasName;
    private Integer sort;
    private Integer articleCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    @Override
    public String toString() {
        return "CategoryCustom{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                ", sort=" + sort +
                ", articleCount=" + articleCount +
                '}';
    }
}
