package com.troy.gps;

import java.math.BigDecimal;

/**
 * Created by zhangyongyu on 2016/11/21.
 *
 * @parse com.troy.gps
 */
public class ConvertLatlng {


    // 经纬度度分秒转换为小数
    public static double convertToDecimal(double du, double fen, double miao) {
        if (du < 0)
            return -(Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60);
        return Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60;
    }



    public static double convertTodecimal(String sdu, String sfen, String smiao) {
        double du = Double.parseDouble(sdu);
        double fen = Double.parseDouble(sfen);
        double miao = Double.parseDouble(smiao);
        if (du < 0)
            return -(Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60);
        return Math.abs(du) + (Math.abs(fen) + (Math.abs(miao) / 60)) / 60;
    }



    // 以字符串形式输入经纬度的转换
//    public static double convertToDecimalByString(String latlng) {
//        double du = 0;
//        double fen = 0;
//        double miao = 0;
//        if (latlng.indexOf("°") != -1) {
//            du = Double.parseDouble(latlng.substring(0, latlng.indexOf("°")));
//            if (latlng.indexOf("′") != -1) {
//                fen = Double.parseDouble(latlng.substring(
//                        latlng.indexOf("°") + 1, latlng.indexOf("′")));
//                if (latlng.indexOf("″") != -1) {
//                    miao = Double.parseDouble(latlng.substring(
//                            latlng.indexOf("′") + 1, latlng.indexOf("″")));
//                }
//            }
//        }
//        if (du < 0)
//            return -(Math.abs(du) + (fen + (miao / 60)) / 60);
//        return du + (fen + (miao / 60)) / 60;
//
//    }

    public static double convertToDecimalByString(String latlng) {
        latlng = latlng.replace(" ", "");
        double du = Double.parseDouble(latlng.substring(0, latlng.indexOf("°")));
        double fen = Double.parseDouble(latlng.substring(latlng.indexOf("°") + 1, latlng.indexOf("'")));
        double miao = Double.parseDouble(latlng.substring(latlng.indexOf("'") + 1, latlng.indexOf("\"")));
        if (du < 0)
            return -(Math.abs(du) + (fen + (miao / 60)) / 60);
        return du + (fen + (miao / 60)) / 60;

    }

    // 将小数转换为度分秒
    public static String convertToSexagesimal(double num) {
        int du = (int) Math.floor(Math.abs(num)); // 获取整数部分
        double temp = getdPoint(Math.abs(num)) * 60;
        int fen = (int) Math.floor(temp); // 获取整数部分
        double miao = getdPoint(temp) * 60;
        BigDecimal b = new BigDecimal(miao);
        double newMiao = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        if (num < 0)
            return "-" + du + "°" +" "+ fen + "'" +" "+ newMiao + "\"";

        return du + "°" +" "+ fen + "'" +" "+ newMiao + "\"";

    }

    // 获取小数部分
    public static double getdPoint(double num) {
        double d = num;
        int fInt = (int) d;
        BigDecimal b1 = new BigDecimal(Double.toString(d));
        BigDecimal b2 = new BigDecimal(Integer.toString(fInt));
        double dPoint = b1.subtract(b2).floatValue();
        return dPoint;
    }

}