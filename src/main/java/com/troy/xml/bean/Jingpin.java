package com.troy.xml.bean;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml.bean
 */
@XmlType(name="jingpin",propOrder={"publishTime","items"})
@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name="jingpin")
public class Jingpin {

    @XmlJavaTypeAdapter(value=DateAdapter.class)
    private Date publishTime;

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private Set<Item> items;

    public Jingpin(){
    }

    public Jingpin(Date publishTime){
        this.publishTime = publishTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
