package com.eumji.zblog.vo;

import java.io.Serializable;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public class Category implements Serializable {

private Integer id;
private String categoryName;
private String aliasName;
private Integer sort;
public Integer getId() {
return id;
}

public void setId(Integer id) {
this.id = id;
}

public String getCategoryname() {
return categoryName;
}

public void setCategoryname(String categoryName) {
this.categoryName = categoryName;
}

public String getAliasname() {
return aliasName;
}

public void setAliasname(String aliasName) {
this.aliasName = aliasName;
}

public Integer getSort() {
return sort;
}

public void setSort(Integer sort) {
this.sort = sort;
}

}
