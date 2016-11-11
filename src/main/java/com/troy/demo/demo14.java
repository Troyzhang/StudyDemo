package com.troy.demo;

/**
 * Created by zhangyongyu on 2016/11/8.
 *
 * @parse com.troy.demo
 */
public class demo14 {
    public static void main(String[] args){


        String contestTags = "69330 c53546845df95f53647fa238864 , 69330 c53546845df95f53647fa238864 - contestCategory - 000 , setlibrarya9f5a5f3106444ab8c495b69b24e46d8_d , 745 a9016f4454ff1979579307c9c58e3 - attachment.rar , 745 a9016f4454ff1979579307c9c58e3 - attachment - NAME - 元素.rar";
        String[] ct = contestTags.split(", ");
        for (String a : ct){

            if (a.contains("setlibrary")){
                System.out.print(a);
            }

        }

    }
}
