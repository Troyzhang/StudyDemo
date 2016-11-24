package com.troy.demo;

import java.io.File;


/**
 * Created by zhangyongyu on 2016/11/11.
 *
 * @parse com.troy.demo
 */
public class demo15 {

    public static void main(String[] args){
        String gpsLongitude = "116° 28' 35.21\"";
        String gpsLatitude = "39° 56' 9.36\"";

        double a = convertToDecimalByString(gpsLatitude);
        double b = convertToDecimalByString(gpsLongitude);

        System.out.print(a+"==="+b);

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

}
