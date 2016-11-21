package com.troy.xml;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml
 */
public class Main {

    public static void main(String args[]){
        XmlImpl dd=new XmlImpl();
        String str="/Users/zhangyongyu/Desktop/xml/1.xml";
        dd.init();
        dd.createXml(str);    //创建xml
//        dd.parserXml(str);    //读取xml
    }

}
