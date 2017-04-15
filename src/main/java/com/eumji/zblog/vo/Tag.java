package com.eumji.zblog.vo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

/**
 * FILE: com.eumji.zblog.vo.Tag.java
 * MOTTO:  不积跬步无以至千里,不积小流无以至千里
 * AUTHOR: EumJi
 * DATE: 2017/4/15
 * TIME: 11:36
 */
@Alias("tag")
public class Tag implements Serializable {

    private Integer id;
    private String tagName;
    private String aliasName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", aliasName='" + aliasName + '\'' +
                '}';
    }
}
