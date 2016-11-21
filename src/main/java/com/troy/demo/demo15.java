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

    public static void masssin(String[] args){
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
