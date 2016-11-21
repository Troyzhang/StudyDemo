package com.troy.test.bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by zhangyongyu on 2016/11/15.
 *
 * @parse com.troy.test
 */
@XmlRootElement(name="RootClass")
public class RootClass {
    private EleClassA a;
    private EleClassB b;
    private String root;
    private String rootA;

    @XmlElement(name="A")
    public EleClassA getA() {
        return a;
    }
    public void setA(EleClassA a) {
        this.a = a;
    }
    @XmlElement(name="B")
    public EleClassB getB() {
        return b;
    }
    public void setB(EleClassB b) {
        this.b = b;
    }
    public String getRoot() {
        return root;
    }
    public void setRoot(String root) {
        this.root = root;
    }
    public String getRootA() {
        return rootA;
    }
    public void setRootA(String rootA) {
        this.rootA = rootA;
    }
}
