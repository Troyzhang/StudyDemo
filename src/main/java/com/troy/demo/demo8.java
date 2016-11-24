package com.troy.demo;

import com.alibaba.fastjson.JSONObject;
import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.*;

/**
 * Created by zhangyongyu on 16/9/9.
 * @param
 * @parse com.troy.demo
 *
 * exif读取
 */
public class demo8 {

    public static void main(String[] args) {


        String idurl = "IMG_0104.JPG.jpeg";

        File file = new File("/Users/zhangyongyu/Desktop/Exif/pic/" + idurl);

        JSONObject jsonObject = exifRead(file);

        System.out.println(jsonObject);
        System.out.println("-----");


    }

    public static JSONObject exifRead(File file){
        JSONObject jsonObject = new JSONObject();

        try {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
//            GpsDirectory gpsDirectory =

            for (Directory directory : metadata.getDirectories()){
                for (Tag tag : directory.getTags()){
                    if (tag.getDescription().toString().length()<64) {
                        jsonObject.put(tag.getTagName(), tag.getDescription());
                    }
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


//    public static JSONObject exifWrite(File file){
//        JSONObject jsonObject = new JSONObject();
//
//        try {
//
//            JpegHeaders jpegHeaders = new JpegHeaders(file.toString());
//
//            // EXIF
//            App1Header exifHeader = jpegHeaders.getApp1Header();
//
//            // 遍历显示EXIF
////            Map.Entry entry;
////            entry.getKey()
////            SortedMap tags = exifHeader.getTags();
////            for (Map.Entry entry : tags.entrySet()) {
////                System.out.println(entry.getKey() + "[" + entry.getKey().name
////                        + "]:" + entry.getValue());
////            }
//
//            // 修改EXIF的拍照日期
////            exifHeader.setValue(App1Header.Tag.GPSINFO,"as");
//            exifHeader.setValue(App1Header.Tag.DATETIMEORIGINAL, "2007:11:04 07:42:56");
//            // 保存
//            jpegHeaders.save(true);
//
//
//            jsonObject.put("message","successful");
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonObject.put("message","error");
//        }
//        return jsonObject;
//    }




//    public static JSONObject exifWrite(File file){
//        JSONObject jsonObject = new JSONObject();
//
//        try {
//            InputStream fip = new BufferedInputStream(new FileInputStream(file)); // No need to buffer
//            LLJTran llj = new LLJTran(fip);
//            try {
//                llj.read(LLJTran.READ_INFO, true);
//            } catch (LLJTranException e) {
//                e.printStackTrace();
//            }
//
//            Exif exif = (Exif) llj.getImageInfo();
//
//            /* Set some values directly to gps IFD */
//
//            Entry e;
//
//            // Set Latitude 纬度
//            e = new Entry(Exif.ASCII);
//            e.setValue(0, 'N');
//            exif.setTagValue(Exif.GPSINFO,-1, e, true);
//
//            //设置具体的纬度
//            e = new Entry(Exif.RATIONAL);
//            e.setValue(0, new Rational(31, 1));
//            e.setValue(1, new Rational(21, 1));
//            e.setValue(2, new Rational(323, 1));
//            exif.setTagValue(Exif.GPSINFO,-1, e, true);
//
//            // Set Longitude 经度
//            e = new Entry(Exif.ASCII);
//            e.setValue(0, 'E');
//            exif.setTagValue(Exif.GPSINFO,-1, e, true);
//
//            //设置具体的经度
//            e = new Entry(Exif.RATIONAL);
//            e.setValue(0, new Rational(120, 1));
//            e.setValue(1, new Rational(58, 1));
//            e.setValue(2, new Rational(531, 1));
//            exif.setTagValue(Exif.GPSINFO,-1, e, true);
//
//            llj.refreshAppx(); // Recreate Marker Data for changes done
//
//            //改写后的文件，文件必须存在
//            OutputStream out = new BufferedOutputStream(new FileOutputStream(file));
//
//            // Transfer remaining of image to output with new header.
//            try {
//                llj.xferInfo(null, out, LLJTran.REPLACE, LLJTran.REPLACE);
//            } catch (LLJTranException e1) {
//                e1.printStackTrace();
//            }
//
//            fip.close();
//            out.close();
//
//            llj.freeMemory();
//
//            jsonObject.put("message","successful");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            jsonObject.put("message","error");
//        }
//        return jsonObject;
//    }

}
