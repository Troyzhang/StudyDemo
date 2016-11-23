package com.troy.gps;

/**
 * Created by zhiwei.deng on 16/11/14.
 */
public class GPSMain {
    public static void main(String[] arg){
//        SimpleCoodinates simpleCoodinates = WgsGcjConverter.wgs84ToGcj02(43.21085,119.06495555555556);
//        System.out.println(simpleCoodinates.getLat());
//        System.out.println(simpleCoodinates.getLon());
//        31.707842059806396
//        119.85685052895354
//        31.7078502433,119.8568633800
//
//        31.709933,119.852075
        String a = "39° 56' 9.36\"";
        String b = "116° 28' 35.21\"";

        Double ad = ConvertLatlng.convertToDecimalByString(a);
        Double bd = ConvertLatlng.convertToDecimalByString(b);

        System.out.println(ad+"==="+bd);

        String aa = ConvertLatlng.convertToSexagesimal(ad);
        String bb = ConvertLatlng.convertToSexagesimal(bd);
        System.out.println(a+"==="+b);
        System.out.println(aa+"==="+bb);

        SimpleCoodinates simpleCoodinates = WgsGcjConverter.wgs84ToGcj02(ad,bd);
        System.out.println("84转02：");
        System.out.println(simpleCoodinates.getLat()+"==="+simpleCoodinates.getLon());

        String aaa = ConvertLatlng.convertToSexagesimal(simpleCoodinates.getLat());
        String bbb = ConvertLatlng.convertToSexagesimal(simpleCoodinates.getLon());
        System.out.println(aaa+"==="+bbb);

    }
}
