package com.troy.action;

import com.troy.demo.*;
import org.json.JSONObject;

import java.io.File;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.action
 */
public class demoAction {

    public static void main(String[] args){

        demo8 d8 = new demo8();

        String idurl = "500px145692245.jpg";

        File file = new File("/Users/zhangyongyu/Desktop/Exif/pic/" + idurl);

        JSONObject jsonObject = d8.exifRead(file);

        System.out.println(jsonObject);

    }
}
