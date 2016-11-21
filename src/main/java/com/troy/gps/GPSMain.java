package com.troy.gps;


/**
 * Created by zhiwei.deng on 16/11/14.
 */
public class GPSMain {
    public static void main(String[] arg){
        SimpleCoodinates simpleCoodinates = WgsGcjConverter.wgs84ToGcj02(43.21085,-79.06495555555556);
        System.out.println(simpleCoodinates.getLat());
        System.out.println(simpleCoodinates.getLon());
//        31.707842059806396
//        119.85685052895354
//        31.7078502433,119.8568633800
//
//        31.709933,119.852075
    }
}
