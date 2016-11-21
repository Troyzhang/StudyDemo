package com.troy.test;

import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.troy.test.bean.RootClass;
import com.troy.test.bean.EleClassA;
import com.troy.test.bean.EleClassB;
/**
 * Created by zhangyongyu on 2016/11/15.
 *
 * @parse com.troy.test
 */
public class Test1 {
    public static void main(String[] args) {
        RootClass rc = new RootClass();
        EleClassA a = new EleClassA();
        EleClassB b = new EleClassB();

//        a.setAttrC("");
        a.setEleA("eleA");
        a.setEleB("eleB");

//        b.setAttrPassword("");
//        b.setAttrUserName("");
        b.setEleCode("");

        rc.setB(b);
        rc.setA(a);

//        rc.setRoot("root");
//        rc.setRootA("rootA");


        JAXBContext context;
        try {
            context = JAXBContext.newInstance(RootClass.class);
            Marshaller mar = context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            mar.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");

            StringWriter writer = new StringWriter();

            mar.marshal(rc, writer);

            System.out.println(writer.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
