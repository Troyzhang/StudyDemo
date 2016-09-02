package com.troy.demo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by zhangyongyu on 16/9/2.
 *
 * @parse com.troy.demo
 */
public class demo5 {
    public static void main(String[] args) throws Exception {
        System.out.println("输入流对象...");
        String path = "/Users/zhangyongyu/Desktop/altitude.xls";
        FileInputStream excelFileInputStream = new FileInputStream(path);
        HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);
        excelFileInputStream.close();
        System.out.println("关闭流对象...");
        HSSFSheet sheet = workbook.getSheetAt(0);

        for(int excelFileOutPutStream = 1; excelFileOutPutStream <= sheet.getLastRowNum(); ++excelFileOutPutStream) {
            HSSFRow row = sheet.getRow(excelFileOutPutStream);
            if(row != null) {
                HSSFCell nCell1 = row.getCell(0);
                HSSFCell nCell2 = row.getCell(1);
                String altitude = altitude(nCell1.getStringCellValue(), nCell2.getStringCellValue());
                HSSFCell nCell3 = row.createCell(2);
                nCell3.setCellValue(altitude);
                StringBuilder employeeInfoBuilder = new StringBuilder();
                employeeInfoBuilder.append("exif信息 --> ").append("Cell1 : ").append(nCell1.getStringCellValue()).append(" , Cell2 : ").append(nCell2.getStringCellValue());
                System.out.println(employeeInfoBuilder.toString() + "  ,  Cell3 : " + nCell3);
            }
        }

        System.out.println("开始写入...");
        FileOutputStream var12 = new FileOutputStream(path);
        workbook.write(var12);
        var12.flush();
        var12.close();
        System.out.println("写入完成...");
    }

    public static String exposureTimeVcg(String exposureTime) {
        String result = null;

        try {
            String[] e;
            if(exposureTime.contains("/")) {
                e = exposureTime.replace(" sec", "").split("/");
                if(exposureTime.length() <= 14 && e[0].toString() == "1") {
                    result = exposureTime.replace(" sec", "");
                } else {
                    Double reString = Double.valueOf(Double.parseDouble(e[1]) / Double.parseDouble(e[0]));
                    int etInt = (int)Math.rint(reString.doubleValue());
                    result = "1/" + etInt;
                }
            } else if(exposureTime.contains(".")) {
                e = exposureTime.replace(" sec", "").split("\\.");
                String reString1 = e[1].replaceAll("(0)*$", "");
                if(reString1.length() > 0) {
                    result = e[0] + "." + e[1].replaceAll("(0)*$", "");
                } else {
                    result = e[0];
                }
            } else {
                result = exposureTime.replace(" sec", "");
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }

    public static String mix(String make, String model) {
        String result = null;

        try {
            if(make.equals("MIX") && model != null) {
                if(model.contains("iP") || model.contains("ip")) {
                    result = "Apple";
                }

                if(model.contains("Canon")) {
                    result = "Canon";
                }

                if(model.contains("DSC-") || model.contains("ILCE-") || model.contains("NEX-")) {
                    result = "Sony";
                }

                if(model.contains("E-P5")) {
                    result = "OLYMPUS";
                }

                if(model.contains("FinePix J150W")) {
                    result = "FUJIFILM";
                }

                if(model.contains("HUAWEI")) {
                    result = "HUAWEI";
                }

                if(model.contains("NIKON")) {
                    result = "NIKON";
                }

                if(model.contains("PENTAX")) {
                    result = "PENTAX";
                }

                if(model.contains("MK260")) {
                    result = "Meitu";
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static String altitude(String GPSAltitude, String GPSAltitudeRef) {
        String result = null;

        try {
            if(GPSAltitudeRef != null && GPSAltitude != null) {
                if(GPSAltitudeRef.contains("Below")) {
                    result = "-" + GPSAltitude.replace(" metres", "");
                } else {
                    result = GPSAltitude.replace(" metres", "");
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return result;
    }

    public static String modelVcg(String make, String model) {
        String result = null;

        try {
            if(make != null && model != null) {
                String[] e = make.split(" ");
                String[] modelArray = model.split(" ");
                if(!model.contains(e[0].toString())) {
                    result = e[0] + " " + model;
                }

                if(model.contains(e[0].toString())) {
                    result = model;
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }

        return result;
    }
}
