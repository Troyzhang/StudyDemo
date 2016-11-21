package com.troy.demo;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by zhangyongyu on 2016/11/17.
 *
 * @parse com.troy.demo
 */
public class deom17 {
    public static void main(String []args){

//        String sql="1' or '1'='1";
//        System.out.println("防SQL注入:"+ StringEscapeUtils.escapeCsv(sql)); //防SQL注入

//        System.out.println("转义HTML,注意汉字:"+StringEscapeUtils.escapeHtml4(""));    //转义HTML,注意汉字
        System.out.println("反转义HTML:"+StringEscapeUtils.unescapeHtml4("&lt;p&gt;requiem 安魂曲&lt;/p&gt;争执、各自的正义。勇敢的心天使的旋律"));  //反转义HTML
        System.out.println("转义HTML,注意汉字:"+StringEscapeUtils.escapeHtml4("<p>requiem 安魂曲</p>"));
//        System.out.println("转成Unicode编码："+StringEscapeUtils.escapeJava("陈磊兴"));     //转义成Unicode编码
//
//        System.out.println("转义XML："+StringEscapeUtils.escapeXml("<name>陈磊兴</name>"));   //转义xml
//        System.out.println("反转义XML："+StringEscapeUtils.unescapeXml("<name>陈磊兴</name>"));    //转义xml

    }
}
