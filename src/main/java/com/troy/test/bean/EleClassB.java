package com.troy.test.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * Created by zhangyongyu on 2016/11/15.
 *
 * @parse com.troy.test.bean
 */
public class EleClassB {
    private String attrUserName;
    private String attrPassword;

    private String eleCode;

    @XmlAttribute
    public String getAttrUserName() {
        return attrUserName;
    }
    public void setAttrUserName(String attrUserName) {
        this.attrUserName = attrUserName;
    }
    @XmlAttribute(name="password")
    public String getAttrPassword() {
        return attrPassword;
    }
    public void setAttrPassword(String attrPassword) {
        this.attrPassword = attrPassword;
    }
    @XmlElement
    public String getEleCode() {
        return eleCode;
    }
    public void setEleCode(String eleCode) {
        this.eleCode = eleCode;
    }
}