package com.troy.demo;

import java.io.File;
import com.troy.it.sauronsoftware.jave.Encoder;
import com.troy.it.sauronsoftware.jave.MultimediaInfo;


/**
 * Created by zhangyongyu on 2016/11/11.
 *
 * @parse com.troy.demo
 */
public class demo15 {

    public static void main(String[] args){
        File source = new File("/Users/zhangyongyu/Desktop/1.mkv");
        Encoder encoder = new Encoder();
        try {
            MultimediaInfo m = encoder.getInfo(source);
            long ls = m.getDuration();
            System.out.println(ls/1000+"秒!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
