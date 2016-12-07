package com.troy.xml.xmlTest;

import java.util.Date;
import java.text.SimpleDateFormat;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by zhangyongyu on 2016/11/24.
 *
 * @parse com.troy.xml.xmlTest
 */
public class DateAdapter extends XmlAdapter<String, Date> {
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat fmt = new SimpleDateFormat(pattern);

    @Override
    public Date unmarshal(String dateStr) throws Exception {
        return fmt.parse(dateStr);
    }

    @Override
    public String marshal(Date date) throws Exception {

        return fmt.format(date);
    }

}
