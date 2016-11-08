package com.troy.demo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by zhangyongyu on 2016/11/8.
 *
 * @parse com.troy.demo
 */
public class demo13 {

    public static void main(String[] args){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gpsLatitude","37° 54' 58.91\"");
        jsonObject.put("gpsLongitude","-37° 54' 58.91\"");

        exifTools(jsonObject);

        System.out.println(jsonObject);
    }


    public static Double convertToDecimalByString(String latlng) {
        try {
            latlng = latlng.replace(" ", "");
            double du = Double.parseDouble(latlng.substring(0, latlng.indexOf("°")));
            double fen = Double.parseDouble(latlng.substring(latlng.indexOf("°") + 1, latlng.indexOf("'")));
            double miao = Double.parseDouble(latlng.substring(latlng.indexOf("'") + 1, latlng.indexOf("\"")));
            if (du < 0)
                return -(Math.abs(du) + (fen + (miao / 60)) / 60);
            return du + (fen + (miao / 60)) / 60;

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void exifTools(JSONObject json0bj) {
        /*
        gps度分秒处理
         */
        if (json0bj.containsKey("gpsLatitude")) {
            String gpsLatitude = json0bj.getString("gpsLatitude");

            if (gpsLatitude != null){
                Double gpsLe = convertToDecimalByString(gpsLatitude);
                if (gpsLe == null){
                    json0bj.put("gpsLatitude", gpsLatitude);
                }else {
                    json0bj.put("gpsLatitude", convertToDecimalByString(gpsLatitude));
                }
            }
        }
        if (json0bj.containsKey("gpsLongitude")) {
            String gpsLongitude = json0bj.getString("gpsLongitude");

            if (gpsLongitude != null){
                Double gpsLg = convertToDecimalByString(gpsLongitude);
                if (gpsLg == null){
                    json0bj.put("gpsLongitude", gpsLongitude);
                }else {
                    json0bj.put("gpsLongitude", gpsLg);
                }
            }
        }
    }
}
