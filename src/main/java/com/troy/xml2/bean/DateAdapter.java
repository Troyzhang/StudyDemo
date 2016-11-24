package com.troy.xml2.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangyongyu on 2016/11/24.
 *
 * @parse com.troy.xml2.bean
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