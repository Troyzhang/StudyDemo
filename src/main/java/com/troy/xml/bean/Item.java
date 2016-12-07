package com.troy.xml.bean;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml.bean
 */
@XmlType(name="item",propOrder={"oriPicSrc","pageUrl","picTitle","surr1","surr2","tag","category","createTime"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Item {

//    @XmlElement
    private String oriPicSrc;

//    @XmlElement
    private String pageUrl;

//    @XmlElement
    private String picTitle;

//    @XmlElement
    private String surr1;

//    @XmlElement
    private String surr2;

//    @XmlElement
    private String tag;

//    @XmlElement
    private String category;

//    @XmlElement
    private Date createTime;

    public Item(){}

    public Item(String oriPicSrc, String pageUrl, String picTitle, String surr1,
                     String surr2,String tag,String category, Date createTime){
        this.oriPicSrc = oriPicSrc;
        this.pageUrl = pageUrl;
        this.picTitle = picTitle;
        this.surr1 = surr1;
        this.surr2 = surr2;
        this.tag = tag;
        this.category = category;
        this.createTime = createTime;
    }

    public String getOriPicSrc() {
        return oriPicSrc;
    }

    public void setOriPicSrc(String oriPicSrc) {
        this.oriPicSrc = oriPicSrc;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getPicTitle() {
        return picTitle;
    }

    public void setPicTitle(String picTitle) {
        this.picTitle = picTitle;
    }

    public String getSurr1() {
        return surr1;
    }

    public void setSurr1(String surr1) {
        this.surr1 = surr1;
    }

    public String getSurr2() {
        return surr2;
    }

    public void setSurr2(String surr2) {
        this.surr2 = surr2;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
