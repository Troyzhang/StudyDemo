package com.troy.demo;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyongyu on 2016/9/28.
 *
 * @parse com.troy.demo
 */
public class demo11 {
    public static void main(String []args){
        String resId = "fe391e7ef0cb4b048863b8ed67fdc8cb_d";
        JSONObject jsonObject = new com.alibaba.fastjson.JSONObject();
        jsonObject.put("status" , "200");
        jsonObject.put("message", "sucess");
        try {
            LineIterator in = FileUtils.lineIterator(new File("/Users/zhangyongyu/Desktop/datong.txt"), "UTF-8");
            List<String> list = new ArrayList<String>();
            while (in.hasNext()) {
                String ids = in.nextLine();
                list.add(ids);
            }
            in.close();

            boolean temp = false;
            for (String rid : list){
                if (!resId.contains(rid)) {
                    continue;
                }else {
                    temp = true;
                    break;
                }
            }
            if (temp == false) throw new Exception(resId + " 不是大通作品id!");

            jsonObject.put("Data", "success");

        } catch (Exception e){
            e.printStackTrace();
            jsonObject.put("status" , "500");
            jsonObject.put("message", e.getMessage());
        }
        System.out.println(jsonObject.toJSONString());
    }
}
