package com.troy.demo;

import com.troy.fdcp.ImageUtil;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangyongyu on 2016/9/22.
 *
 * @parse com.troy.demo
 */
public class demo10 {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        Date date = simpleDateFormat.parse("2016-09-18 15:00:00");


        System.out.println(date.getTime());
    }
}