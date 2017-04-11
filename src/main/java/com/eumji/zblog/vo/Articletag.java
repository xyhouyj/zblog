package com.eumji.zblog.vo;

import java.io.Serializable;

/**
* Created by GeneratorFx on 2017-04-11.
*/
public class Articletag implements Serializable {

private Integer articleId;
private Integer tagId;
public Integer getArticleid() {
return articleId;
}

public void setArticleid(Integer articleId) {
this.articleId = articleId;
}

public Integer getTagid() {
return tagId;
}

public void setTagid(Integer tagId) {
this.tagId = tagId;
}

}
