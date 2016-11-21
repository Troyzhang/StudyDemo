package com.troy.xml2;

import com.troy.xml2.bean.ItemBean;
import com.troy.xml2.bean.JingpinBean;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml2
 */
public class Java2Xml {
    public static void main(String[] args) {
        JingpinBean jingpinBean = new JingpinBean();
        ItemBean itemBean = new ItemBean();

        itemBean.setOriPicSrc("oripicsrc");
        itemBean.setPageUrl("pageUrl");
        itemBean.setPicTitle("picTitle");
        itemBean.setSurr1("surr1");
        itemBean.setSurr2("surr2");
        itemBean.setTag("tag");
        itemBean.setCategory("category");
        itemBean.setCreateTime("createTime");

//        itemsBean.setItem(new String[]);

        jingpinBean.setPublishTime("publishtime");
        jingpinBean.setItem(itemBean);


        JAXBContext context;
        try {
            context = JAXBContext.newInstance(JingpinBean.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();

            mar.marshal(jingpinBean, writer);

            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
