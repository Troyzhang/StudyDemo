//package com.troy.demo;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by zhangyongyu on 16/9/2.
// *
// * @parse com.troy.demo
// */
//public class demo2 {
//    public demo2() {
//    }
//
//    public static void masadin(String[] args) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
//        Date date = new Date();
//        System.out.println(sdf.format(date));
//        Long time = Long.valueOf(System.currentTimeMillis());
//        System.out.println(sdf.format(new Date(Long.parseLong(String.valueOf(time)))));
//    }
//
//    public static void main(String[] args){
//        JSONArray jsonArray =
//        int sum = 0;
//        while (jsonArray.size()>0){
//            for (int i = 0; i<jsonArray.size();i++){
//                JSONObject json = jsonArray.getJSONObject(i);
//
//                String photos = json.getString("photos");
//
//                JSONArray photosArray = JSONArray.parseArray(photos);
//
//                int photosSize = photosArray.size();
//
//                sum+=photosSize;
//
//            }
//            msg.put("total",sum);
//        }
//    }
//}
