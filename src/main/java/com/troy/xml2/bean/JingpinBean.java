package com.troy.xml2.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml2.bean
 */
@XmlRootElement(name="jingpin")
public class JingpinBean {
    private String publishTime;
    private ItemBean i;

    @XmlElement(name = "publishTime")
    public String getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

//    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public ItemBean getItem() {
        return i;
    }

    public void setItem(ItemBean i) {
        this.i = i;
    }
}
