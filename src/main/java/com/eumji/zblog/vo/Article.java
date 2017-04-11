package com.eumji.zblog.vo;

import java.io.Serializable;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public class Article implements Serializable {

private Integer id;
private Integer categoryId;
private String title;
private Byte[] content;
private String description;
private Integer status;
private String author;
private Long createTime;
private Long updateTime;
private Integer showCount;
public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public Integer getCategoryid() {
return categoryId;
}

public void setCategoryid(Integer categoryId) {
this.categoryId = categoryId;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public Byte[] getContent() {
return content;
}

public void setContent(Byte[] content) {
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

public Long getCreatetime() {
return createTime;
}

public void setCreatetime(Long createTime) {
this.createTime = createTime;
}

public Long getUpdatetime() {
return updateTime;
}

public void setUpdatetime(Long updateTime) {
this.updateTime = updateTime;
}

public Integer getShowcount() {
return showCount;
}

public void setShowcount(Integer showCount) {
this.showCount = showCount;
}

}
