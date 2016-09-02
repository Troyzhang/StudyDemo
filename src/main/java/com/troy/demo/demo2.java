package com.troy.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo2 {
    public demo2() {
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
        Date date = new Date();
        System.out.println(sdf.format(date));
        Long time = Long.valueOf(System.currentTimeMillis());
        System.out.println(sdf.format(new Date(Long.parseLong(String.valueOf(time)))));
    }
}
