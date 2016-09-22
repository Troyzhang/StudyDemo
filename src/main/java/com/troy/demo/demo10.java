package com.troy.demo;

import com.troy.fdcp.ImageUtil;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * Created by zhangyongyu on 2016/9/22.
 *
 * @parse com.troy.demo
 */
public class demo10 {
    public static void main(String[] args){

        int[] a = new int[ 3 * 2 ];

        BufferedImage wImage = ImageUtil.getImage("/Users/zhangyongyu/Desktop/121.jpg");
        WritableRaster wRaster = wImage.getRaster();
        int wWidth = wRaster.getWidth();
        int wHeight = wRaster.getHeight();
        int[] wPixels = new int[wWidth * wHeight];
        wRaster.getPixels(0, 0, wWidth, wHeight, wPixels);

        System.out.println(wPixels);
    }
}
