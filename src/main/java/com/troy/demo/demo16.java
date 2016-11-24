package com.troy.demo;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.demo
 */
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import java.awt.print.Book;
import java.io.FileOutputStream;
import java.io.IOException;


public class demo16 {

    Book[] books = new Book[]{};

    public void BuildXMLDoc() throws IOException, JDOMException {
        // 创建根节点 并设置它的属性 ;
        Element root = new Element("Jingpin").setAttribute("count", "4");
        // 将根节点添加到文档中；
        Document Doc = new Document(root);

        for (int i = 0; i < books.length; i++) {
            // 创建节点 book;
            Element elements = new Element("publishTime");
            // 给 book 节点添加子节点并赋值；
            elements.addContent(new Element("id").setText("id"));
            elements.addContent(new Element("name").setText("name"));
            //
            root.addContent(elements);
        }
        // 输出 books.xml 文件；
        // 使xml文件 缩进效果
        Format format = Format.getPrettyFormat();
        XMLOutputter XMLOut = new XMLOutputter(format);
        XMLOut.output(Doc, new FileOutputStream("/Users/zhangyongyu/Desktop/xml/111.xml"));
    }
    public static void main(String[] args) {
        try {
            demo16 j2x = new demo16();
            System.out.println("正在生成 books.xml 文件...");
            j2x.BuildXMLDoc();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("文件已生成");
    }
}