package com.troy.xml;

import com.troy.xml.bean.Item;
import com.troy.xml.bean.Jingpin;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangyongyu on 2016/11/14.
 *
 * @parse com.troy.xml
 */
public class Java2Xml {
    public static void main() throws JAXBException, IOException {
        Set<Item> items = new HashSet<Item>();

        Item item1 = new Item("1","2","3","4","5","6","7",new Date());
        Item item2 = new Item("1","2","3","4","5","6","7",new Date());

        items.add(item1);
        items.add(item2);

        Jingpin jingpin = new Jingpin(new Date());
        jingpin.setItems(items);

        FileWriter writer =null;
        JAXBContext context = JAXBContext.newInstance(Jingpin.class);
        try{
            Marshaller marshal = context.createMarshaller();
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshal.marshal(jingpin, System.out);

            writer =new FileWriter("搜狗.xml");
            marshal.marshal(jingpin, writer);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }



}
