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
    public static void mfaain(String[] args) throws Exception {
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
            if (make != null  && model != null) {

                String[] makeArray = make.split(" ");
                String[] modelArray = model.split(" ");

                if (!model.contains(makeArray[0].toString())){
                    if (model.contains("PENTAX")){
                        result = model;
                    }else {
                        result = makeArray[0] + " " + model;
                    }
                }
                if (model.contains(makeArray[0].toString())) {
                    result = model;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        // 创建 Excel 文件的输入流对象
        System.out.println("输入流对象...");
        String path = "/Users/zhangyongyu/Desktop/Exif/model/apple model.xls";
        FileInputStream excelFileInputStream = new FileInputStream(path);
        // XSSFWorkbook 就代表一个 Excel 文件
        // 创建其对象，就打开这个 Excel 文件
        HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);
        // 输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！
        excelFileInputStream.close();
        System.out.println("关闭流对象...");
        // XSSFSheet 代表 Excel 文件中的一张表格
        // 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
        // 注意表格索引从 0 开始！
        HSSFSheet sheet = workbook.getSheetAt(0);

        // 开始循环表格数据,表格的行索引从 0 开始
        // employees.xlsx 第一行是标题行，我们从第二行开始, 对应的行索引是 1
        // sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            // XSSFRow 代表一行数据
            HSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                continue;
            }
            HSSFCell nCell1 = row.getCell(0); // 第一列
            HSSFCell nCell2 = row.getCell(1); // 第二列

            //mix
//			String mix_make = mix(nCell1.getStringCellValue(), nCell2.getStringCellValue());
            //altitude
//            String altitude = altitude(nCell1.getStringCellValue(), nCell2.getStringCellValue());
            //makeModel
//			String makeModel = modelVcg(nCell1.getStringCellValue(), nCell2.getStringCellValue());
            //exposure
//			String exposure = exposureTimeVcg(nCell1.getStringCellValue());
            //huaWeiVcg
//            String huaWei = huaWeiVcg(nCell1.getStringCellValue());
            //appleVcg

            String apple = appleVcg(nCell2.getStringCellValue());


            HSSFCell nCell4 = row.createCell(3);
//			HSSFCell nCell2 = row.createCell(1);

//			nCell3.setCellValue(mix_make);
//            nCell3.setCellValue(huaWei);
//			nCell3.setCellValue(makeModel);
//			nCell2.setCellValue(exposure);
            nCell4.setCellValue(apple);

            StringBuilder employeeInfoBuilder = new StringBuilder();
            employeeInfoBuilder.append("exif信息 --> ").append("Cell1 : ").append(nCell1.getStringCellValue());
//                    .append(" , Cell2 : ").append(nCell2.getStringCellValue());
            System.out.println(employeeInfoBuilder.toString()+"  ,  Cell4 : "+nCell4);
        }

//		// ------ 创建一行新的数据 ----------//
//		// 指定行索引，创建一行数据, 行索引为当前最后一行的行索引 + 1
//		int currentLastRowIndex = sheet.getLastRowNum();
//		int newRowIndex = currentLastRowIndex + 1;
//		HSSFRow newRow = sheet.createRow(newRowIndex);
//		// 开始创建并设置该行每一单元格的信息，该行单元格的索引从 0 开始
//		int cellIndex = 0;
//		// 创建一个单元格，设置其内的数据格式为字符串，并填充内容，其余单元格类同
//		HSSFCell newNameCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
//		newNameCell.setCellValue("钱七");
//		HSSFCell newGenderCell = newRow.createCell(cellIndex++, Cell.CELL_TYPE_STRING);
//		newGenderCell.setCellValue("女");



        // 将最新的 Excel 数据写回到原始 Excel 文件中
        // 首先要创建一个原始Excel文件的输出流对象！
        System.out.println("开始写入...");
        FileOutputStream excelFileOutPutStream = new FileOutputStream(path);
        // 将最新的 Excel 文件写入到文件输出流中，更新文件信息！
        workbook.write(excelFileOutPutStream);
        // 执行 flush 操作， 将缓存区内的信息更新到文件上
        excelFileOutPutStream.flush();
        // 使用后，及时关闭这个输出流对象， 好习惯，再强调一遍！
        excelFileOutPutStream.close();
        System.out.println("写入完成...");
    }


    public static String huaWeiVcg(String model){
        String result = null;
        try {
            if (model != null){
                if (model.contains("HUAWEI ")){
                    if (model.contains("MLA-AL10")) result = "麦芒5";
                    else if (model.contains("RIO-AL00")) result = "麦芒4";
                    else if (model.contains("TAG-AL00")) result = "畅想5S";
                    else if (model.contains("TIT-AL00")) result = "畅想5";
                    else if (model.contains("SCL-L21")) result = "Y6";
                    else if (model.contains("Y560-L01")) result = "Y560";
                    else if (model.contains("Y530-U00")) result = "Y530";
                    else if (model.contains("Y511-U10")) result = "Y511";
                    else if (model.contains("Y330-U05")) result = "Y330";
                    else if (model.contains("T8833") || model.contains("Y300-0100")) result = "Y300";
                    else if (model.contains("W1")) result = "W1";
                    else if (model.contains("GRA-")) result = "P8";
                    else if (model.contains("P7-")) result = "P7";
                    else if (model.contains("P6-")) result = "P6";
                    else if (model.contains("CRR-")) result = "MateS";
                    else if (model.contains("NXT-")) result = "Mate8";
                    else if (model.contains("MT7-")) result = "Mate7";
                    else if (model.contains("MT2-")) result = "Mate2";
                    else if (model.contains("MT1-")) result = "Mate1";
                    else if (model.contains("VNS-")) result = "G9";
                    else if (model.contains("G750-")) result = "G750";
                    else if (model.contains("G700-")) result = "G700";
                    else if (model.contains("RIO-TL00") || model.contains("RIO-UL00")) result = "G7 Plus";
                    else if (model.contains("G7-TL00") || model.contains("G7-UL20")) result = "G7";
                    else if (model.contains("G6-")) result = "G6";
                    else if (model.contains("HN3-")) result = "Honor3";
                    else {
                        String[] tempArray = model.split(" ");
                        result = tempArray[1];
                    }

                }else {
                    if (model.contains("ALE-") || model.contains("M100-UL10")) result = "P8";
                    else if (model.contains("P6-")) result = "P6";
                    else if (model.contains("VIE-")) result = "P9 Plus";
                    else if (model.contains("EVA-")) result = "P9";
                    else if (model.contains("GL07S")) result = "p2";
                    else if (model.contains("GEM-")) result = "HonorX2";
                    else if (model.contains("KNT-")) result = "HonorV8";
                    else if (model.contains("FRD-")) result = "Honor8";
                    else if (model.contains("ATH-")) result = "Honor7i";
                    else if (model.contains("PLK-")) result = "Honor7";
                    else if (model.contains("PE-")) result = "Honor6 Plus";
                    else if (model.contains("H60-")) result = "Honor6";
                    else if (model.contains("KIW-")) result = "Honor5X";
                    else if (model.contains("NEM-")) result = "Honor5C";
                    else if (model.contains("Che1-") || model.contains("Che2-") || model.contains("CHE-")) result = "Honor4X";
                    else if (model.contains("CHM-")) result = "Honor4C";
                    else if (model.contains("SCL-")) result = "Honor4A";
                    else if (model.contains("C8817D") || model.contains("G620S-L01") || model.contains("G621-TL00") || model.contains("G630-U251")) result = "Honor4";
                    else if (model.contains("H30-") || model.contains("Hol-U10")) result = "Honor3C";
                    else if (model.contains("G7-L01")) result = "G7";
                    else if (model.contains("CHC-U01")) result = "G play mini";
                    else result = model;

                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }


    public static String appleVcg(String model) {
        String result = null;
        try {
            if (model != null) {
                if (!model.contains("iPhone ")) {
                    if (model.contains("iPhone3,")) result = "iPhone 4";
                    else if (model.contains("iPhone4,")) result = "iPhone 4S";
                    else if (model.contains("iPhone5,1")) result = "iPhone 5 GSM";
                    else if (model.contains("iPhone5,2")) result = "iPhone 5 CDMA";
                    else if (model.contains("iPhone5,3")) result = "iPhone 5C";
                    else if (model.contains("iPhone6,1")) result = "iPhone 5S CDMA";
                    else if (model.contains("iPhone6,2")) result = "iPhone 5S GSM";
                    else if (model.contains("iPhone7,2")) result = "iPhone 6";
                    else if (model.contains("iPhone7,1")) result = "iPhone 6 Plus";
                    else if (model.contains("iPhone8,1")) result = "iPhone 6S";
                    else if (model.contains("iPhone8,2")) result = "iPhone 6S Plus";
                    else result = model;
                }else {
                    result = model;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
