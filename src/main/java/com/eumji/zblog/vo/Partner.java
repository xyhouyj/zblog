package com.eumji.zblog.vo;

import org.apache.ibatis.type.Alias;
import java.io.Serializable;

/**
 * Created by GeneratorFx on 2017-04-10.
 */
@Alias("partner")
public class Partner implements Serializable {


    private Integer id;

    private String siteName;

    private String siteUrl;

    private String siteDesc;

    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }

    public String getSiteDesc() {
        return siteDesc;
    }

    public void setSiteDesc(String siteDesc) {
        this.siteDesc = siteDesc;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", siteName='" + siteName + '\'' +
                ", siteUrl='" + siteUrl + '\'' +
                ", siteDesc='" + siteDesc + '\'' +
                ", sort=" + sort +
                '}';
    }
}
