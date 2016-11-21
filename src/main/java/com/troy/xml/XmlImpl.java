package com.troy.xml;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml
 */
public class XmlImpl implements XmlInterface {
    private Document document;

    public void init() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            this.document = builder.newDocument();
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createXml(String fileName) {

        Element root = this.document.createElement("JingpinBean");
        this.document.appendChild(root);

        Element publishTime = this.document.createElement("publishTime");
        publishTime.appendChild(this.document.createTextNode("publishTime"));
        root.appendChild(publishTime);

        Element items = this.document.createElement("ItemBean");
        root.appendChild(items);

        Element employee = this.document.createElement("item");
        items.appendChild(employee);

        Element oriPicSrc = this.document.createElement("oriPicSrc");
        oriPicSrc.appendChild(this.document.createTextNode("oriPicSrc"));
        employee.appendChild(oriPicSrc);
        Element pageUrl = this.document.createElement("pageUrl");
        pageUrl.appendChild(this.document.createTextNode("pageUrl"));
        employee.appendChild(pageUrl);
        Element picTitle = this.document.createElement("picTitle");
        picTitle.appendChild(this.document.createTextNode("picTitle"));
        employee.appendChild(picTitle);
        Element surr1 = this.document.createElement("surr1");
        surr1.appendChild(this.document.createTextNode("surr1"));
        employee.appendChild(surr1);
        Element surr2 = this.document.createElement("surr2");
        surr2.appendChild(this.document.createTextNode("surr2"));
        employee.appendChild(surr2);
        Element tag = this.document.createElement("tag");
        tag.appendChild(this.document.createTextNode("tag"));
        employee.appendChild(tag);
        Element category = this.document.createElement("category");
        category.appendChild(this.document.createTextNode("category"));
        employee.appendChild(category);
        Element createTime = this.document.createElement("createTime");
        createTime.appendChild(this.document.createTextNode("createTime"));
        employee.appendChild(createTime);

//        root.appendChild(ItemBean);

        TransformerFactory tf = TransformerFactory.newInstance();
        try {
            Transformer transformer = tf.newTransformer();
            DOMSource source = new DOMSource(document);
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            PrintWriter pw = new PrintWriter(new FileOutputStream(fileName));
            StreamResult result = new StreamResult(pw);
            transformer.transform(source, result);
            System.out.println("生成XML文件成功!");
        } catch (TransformerConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (TransformerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void parserXml(String fileName) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(fileName);

            NodeList employees = document.getChildNodes();
            for (int i = 0; i < employees.getLength(); i++) {
                Node employee = employees.item(i);
                NodeList employeeInfo = employee.getChildNodes();
                for (int j = 0; j < employeeInfo.getLength(); j++) {
                    Node node = employeeInfo.item(j);
                    NodeList employeeMeta = node.getChildNodes();
                    for (int k = 0; k < employeeMeta.getLength(); k++) {
                        System.out.println(employeeMeta.item(k).getNodeName()
                                + ":" + employeeMeta.item(k).getTextContent());
                    }
                }
            }
            System.out.println("解析完毕");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (ParserConfigurationException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
