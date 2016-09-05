package com.troy.demo;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangyongyu on 16/9/5.
 *
 * @parse com.troy.demo
 */
public class demo7 {

    /*
       *
       * 下划线 和 驼峰 转换
       *
       */
    public static final char UNDERLINE='_';
    public static String camelToUnderline(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (Character.isUpperCase(c)){
                sb.append(UNDERLINE);
                sb.append(Character.toLowerCase(c));
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String underlineToCamel(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        int len=param.length();
        StringBuilder sb=new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c=param.charAt(i);
            if (c==UNDERLINE){
                if (++i<len){
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static String underlineToCamel2(String param){
        if (param==null||"".equals(param.trim())){
            return "";
        }
        StringBuilder sb=new StringBuilder(param);
        Matcher mc= Pattern.compile("_").matcher(param);
        int i=0;
        while (mc.find()){
            int position=mc.end()-(i++);
            //String.valueOf(Character.toUpperCase(sb.charAt(position)));
            sb.replace(position-1,position+1,sb.substring(position,position+1).toUpperCase());
        }
        return sb.toString();
    }

    /*
       *
       * Date 和 String 转换
       *
       */
    private static Date changeString(String inputDate){
        Date outputDate = null;
        if (inputDate == null){
            return null;
        }

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
            outputDate = simpleDateFormat.parse(inputDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return outputDate;
    }


    private static Date changeString2(String inputDate){
        Date outputDate = null;
        if (inputDate == null){
            return null;
        }

        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd");
            outputDate = simpleDateFormat.parse(inputDate);
        }catch (Exception e){
            e.printStackTrace();
        }
        return outputDate;
    }


    /*
    *
    * exif读取
    *
    */
    public static JSONObject exifRead(File file){
        JSONObject jsonObject = new JSONObject();

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            for (Directory directory : metadata.getDirectories()){
                for (Tag tag : directory.getTags()){
                    jsonObject.put(tag.getTagName(), tag.getDescription());
                }
                if (directory.hasErrors()){
                    for (String error : directory.getErrors()){
                        jsonObject.put("error", error);
                    }
                }
            }

        } catch (ImageProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

}
