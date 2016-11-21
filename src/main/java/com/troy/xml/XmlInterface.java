package com.troy.xml;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml
 */

public interface XmlInterface {

    /**
     * 建立XML文档
     * @param fileName 文件全路径名称
     */
    public void createXml(String fileName);
    /**
     * 解析XML文档
     * @param fileName 文件全路径名称
     */
    public void parserXml(String fileName);
}
