package com.troy.xml2.bean;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml2.bean
 */
public class ItemBean {

    public String oriPicSrc;
    public String pageUrl;
    public String picTitle;
    public String surr1;
    public String surr2;
    public String tag;
    public String category;
    public String createTime;

    @XmlElement(name = "oriPicSrc")
    public String getOriPicSrc() {
        return oriPicSrc;
    }

    public void setOriPicSrc(String oriPicSrc) {
        this.oriPicSrc = oriPicSrc;
    }

    @XmlElement(name = "pageUrl")
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    @XmlElement(name = "picTitle")
    public String getPicTitle() {
        return picTitle;
    }

    public void setPicTitle(String picTitle) {
        this.picTitle = picTitle;
    }

    @XmlElement(name = "surr1")
    public String getSurr1() {
        return surr1;
    }

    public void setSurr1(String surr1) {
        this.surr1 = surr1;
    }

    @XmlElement(name = "surr2")
    public String getSurr2() {
        return surr2;
    }

    public void setSurr2(String surr2) {
        this.surr2 = surr2;
    }

    @XmlElement(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @XmlElement(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @XmlElement(name = "createTime")
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

}
