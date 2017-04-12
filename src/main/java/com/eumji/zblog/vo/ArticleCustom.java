package com.eumji.zblog.vo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Do
 * @package com.eumji.zblog.vo
 * @name ArticleCustom
 * @date 2017/4/12
 * @time 12:34
 */
@Alias("articleCutsom")
public class ArticleCustom implements Serializable {

    private Integer id;
    private Integer categoryId; //分类id
    private String categoryName; //分类名称
    private String categoryAliasName; //分类别名
    private String title;
    private String content;
    private String description;
    private Integer status;
    private String author;
    private Date createTime;
    private Date updateTime;
    private Integer showCount;
    private List<ArticleTag> tagList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryAliasName() {
        return categoryAliasName;
    }

    public void setCategoryAliasName(String categoryAliasName) {
        this.categoryAliasName = categoryAliasName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getShowCount() {
        return showCount;
    }

    public void setShowCount(Integer showCount) {
        this.showCount = showCount;
    }

    public List<ArticleTag> getTagList() {
        return tagList;
    }

    public void setTagList(List<ArticleTag> tagList) {
        this.tagList = tagList;
    }

    @Override
    public String toString() {
        return "ArticleCustom{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryAliasName='" + categoryAliasName + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", author='" + author + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", showCount=" + showCount +
                ", tagList=" + tagList +
                '}';
    }
}
