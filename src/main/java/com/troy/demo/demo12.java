package com.troy.demo;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by zhangyongyu on 2016/9/30.
 *
 * @parse com.troy.demo
 */
public class demo12 {
    public static void masain(String[] args) throws Exception {
        // 创建 Excel 文件的输入流对象
        System.out.println("输入流对象...");
        String path = "/Users/zhangyongyu/Desktop/1.xls";
        String path2 = "/Users/zhangyongyu/Desktop/2.xls";
        FileInputStream excelFileInputStream = new FileInputStream(path);
        FileInputStream excelFileInputStream2 = new FileInputStream(path2);
        // XSSFWorkbook 就代表一个 Excel 文件
        // 创建其对象，就打开这个 Excel 文件
        HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);
        HSSFWorkbook workbook2 = new HSSFWorkbook(excelFileInputStream2);
        // 输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！
        excelFileInputStream.close();
        excelFileInputStream2.close();
        System.out.println("关闭流对象...");
        // XSSFSheet 代表 Excel 文件中的一张表格
        // 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
        // 注意表格索引从 0 开始！
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFSheet sheet2 = workbook2.getSheetAt(0);

        // 开始循环表格数据,表格的行索引从 0 开始
        // employees.xlsx 第一行是标题行，我们从第二行开始, 对应的行索引是 1
        // sheet.getLastRowNum() : 获取当前表格中最后一行数据对应的行索引
        for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            // XSSFRow 代表一行数据
            HSSFRow row = sheet.getRow(rowIndex);
            if (row == null) {
                continue;
            }
            HSSFCell nCell01 = row.getCell(0);
            String upId = nCell01.getStringCellValue();

            HSSFCell nCell02 = row.createCell(1);
            HSSFCell nCell03 = row.createCell(2);
            HSSFCell nCell04 = row.createCell(3);
            HSSFCell nCell05 = row.createCell(4);
            HSSFCell nCell06 = row.createCell(5);
            HSSFCell nCell07 = row.createCell(6);
            HSSFCell nCell08 = row.createCell(7);


            for (int rowIndex2 = 1; rowIndex2 <= sheet2.getLastRowNum(); rowIndex2++) {
                // XSSFRow 代表一行数据
                HSSFRow row2 = sheet2.getRow(rowIndex2);
                if (row2 == null) {
                    continue;
                }

                String nCell1 = null; // 第一列
                try {
                    nCell1 = row2.getCell(0).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell2 = null; // 第二列
                try {
                    nCell2 = row2.getCell(1).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell3 = null; // 第二列
                try {
                    nCell3 = row2.getCell(2).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell4 = null; // 第二列
                try {
                    nCell4 = row2.getCell(3).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell5 = null; // 第二列
                try {
                    nCell5 = row2.getCell(4).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell6 = null; // 第二列
                try {
                    nCell6 = row2.getCell(5).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String nCell7 = null; // 第二列
                try {
                    nCell7 = row2.getCell(6).getStringCellValue();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (upId == nCell1) {
                    nCell02.setCellValue(nCell1);
                    nCell03.setCellValue(nCell2);
                    nCell04.setCellValue(nCell3);
                    nCell05.setCellValue(nCell4);
                    nCell06.setCellValue(nCell5);
                    nCell07.setCellValue(nCell6);
                    nCell08.setCellValue(nCell7);
                }

                System.out.println(nCell01 + " " + nCell02 + " " + nCell03 + " " + nCell04 + " " + nCell05 + " " + nCell06 + " " + nCell07 + " " + nCell08);
            }

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
    }


    public  static  void  main(String[] args) throws Exception {
        String path = "/Users/zhangyongyu/Desktop/123.xls";
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

        for (int i = 1; i <= 50 ;i++) {
            HSSFRow bRow = sheet.createRow(i);
            HSSFCell nCell = bRow.createCell(0);

            nCell.setCellValue(i);
        }



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


}
