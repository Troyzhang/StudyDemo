package com.troy.demo;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo6 {
    public static void main(String[] args) {
        String s = "0.000120340000";
        s = s.replaceAll("(0)*$", "");
        System.out.println(s);
        String exposureTime = "20 sec";
        String result = null;

        try {
            if(exposureTime.contains("sec")) {
                String[] e;
                if(exposureTime.length() > 10 && exposureTime.contains("/")) {
                    e = exposureTime.replace(" sec", "").split("/");
                    Double etDouble = Double.valueOf(Double.parseDouble(e[1]) / Double.parseDouble(e[0]));
                    int etInt = (int)Math.rint(etDouble.doubleValue());
                    result = "1/" + etInt + " sec";
                } else if(exposureTime.length() > 10 && exposureTime.contains(".")) {
                    e = exposureTime.replace(" sec", "").split("\\.");
                    result = e[0] + "." + e[1].replaceAll("(0)*$", "") + " sec";
                } else {
                    result = exposureTime;
                }
            } else {
                result = exposureTime;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println(result);
    }
}
