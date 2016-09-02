package com.troy.demo;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo4 {
    public static void main(String[] args) {
        String aString = "11136/8915933 sec";
        String bString = "iphone";
        String[] tempArray = aString.replace(" sec", "").split("/");
        aString.contains(bString);
        Double as1 = Double.valueOf(Double.parseDouble(tempArray[1]) / Double.parseDouble(tempArray[0]));
        int as = (int)Math.rint(as1.doubleValue());
        String re = "1/" + as + " sec";
        System.out.println(aString);
        System.out.println(aString.replace(" sec", ""));
        System.out.println(tempArray[0] + "....." + tempArray[1]);
        System.out.println(as);
        System.out.println(re);
    }
}
