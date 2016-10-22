package com.troy.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by zhangyongyu on 2016/10/21.
 *
 * @parse com.troy.dao
 */
public class SelectTable {
    public static void masin(String[] args){
        try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("成功加载MySQL驱动！");

            String url="jdbc:mysql://localhost:3306/vcg_community";    //JDBC的URL
            Connection conn;

            conn = DriverManager.getConnection(url,"root","");
            Statement stmt = conn.createStatement(); //创建Statement对象
            System.out.println("成功连接到数据库！");


            String path = "/Users/zhangyongyu/Desktop/123.xls";
            FileInputStream excelFileInputStream = new FileInputStream(path);
            // XSSFWorkbook 就代表一个 Excel 文件
            // 创建其对象，就打开这个 Excel 文件
            HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);
            // 输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！
            excelFileInputStream.close();
            System.out.println("关闭流对象...");


//            for (int i = 1; i <= 50 ;i++) {
//                HSSFRow bRow = sheet.createRow(i);
//                HSSFCell nCell = bRow.createCell(0);
//                HSSFCell cell = bRow.createCell(1);
//                nCell.setCellValue(i);
//                cell.setCellValue(0);
//            }
            int xCell = 1;

            for (int weekStr = 1; weekStr <=6; weekStr++){
                String sql = "SELECT B.rCount resourceCounts , count(userId) peoples FROM( SELECT A.uploaderId AS userId , A.pcount AS rCount FROM( SELECT COUNT(DISTINCT uploader_id) AS uploaderId , COUNT(id) pcount FROM troy_temp WHERE week_str = '"+weekStr+"' AND( resource_type = '0' OR resource_type = '2') GROUP BY uploader_id) AS A WHERE(A.pcount BETWEEN 1 AND 1000)) AS B GROUP BY rCount";    //要执行的SQL
                ResultSet rs = stmt.executeQuery(sql);//创建数据对象

                // XSSFSheet 代表 Excel 文件中的一张表格
                // 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
                // 注意表格索引从 0 开始！
                HSSFSheet sheet = workbook.getSheetAt(0);

                HSSFRow bRowLast = sheet.getRow(50);
                HSSFCell nCellLast = bRowLast.getCell(xCell);
                int count = 0;

                while (rs.next()){
                    int resourceCounts = rs.getInt(1);
                    int peopleCounts = rs.getInt(2);

//                    System.out.println(resourceCounts+"======="+peopleCounts);

                    if (resourceCounts < 50 && resourceCounts > 0){
                        HSSFRow bRow = sheet.getRow(resourceCounts);
                        bRow.getCell(xCell).setCellValue(peopleCounts);
                    }else {
                        count+=peopleCounts;
                    }
                    nCellLast.setCellValue(count);
                }

                xCell+=2;

                System.out.println(xCell);

                rs.close();
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

            stmt.close();
            conn.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        //调用Class.forName()方法加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("成功加载MySQL驱动！");

        String url="jdbc:mysql://localhost:3306/vcg_community";    //JDBC的URL
        Connection conn;

        conn = DriverManager.getConnection(url,"root","");
        Statement stmt = conn.createStatement(); //创建Statement对象
        System.out.println("成功连接到数据库！");

        String path = "/Users/zhangyongyu/Desktop/123.xls";
        FileInputStream excelFileInputStream = new FileInputStream(path);
        // XSSFWorkbook 就代表一个 Excel 文件
        // 创建其对象，就打开这个 Excel 文件
        HSSFWorkbook workbook = new HSSFWorkbook(excelFileInputStream);
        // 输入流使用后，及时关闭！这是文件流操作中极好的一个习惯！
        excelFileInputStream.close();
        System.out.println("关闭流对象...");


//            for (int i = 1; i <= 50 ;i++) {
//                HSSFRow bRow = sheet.createRow(i);
//                HSSFCell nCell = bRow.createCell(0);
//                HSSFCell cell = bRow.createCell(1);
//                nCell.setCellValue(i);
//                cell.setCellValue(0);
//            }


        int xCell2 = 2;

        for (int weekStr = 1; weekStr <=6; weekStr++){

            String sql2 = "SELECT A.like_count likeCount , count(A.id) rCount FROM( SELECT id , like_count FROM troy_temp WHERE week_str = '"+weekStr+"' GROUP BY id) AS A GROUP BY like_count;"; //要执行的SQL
            ResultSet rs2 = stmt.executeQuery(sql2);//创建数据对象

            // XSSFSheet 代表 Excel 文件中的一张表格
            // 我们通过 getSheetAt(0) 指定表格索引来获取对应表格
            // 注意表格索引从 0 开始！
            HSSFSheet sheet = workbook.getSheetAt(0);

            HSSFRow bRowLast = sheet.getRow(50);
            HSSFCell nCellLast2 = bRowLast.getCell(xCell2);
            int count2 = 0;


            while (rs2.next()){
                int likeCount = rs2.getInt(1);
                int rCount = rs2.getInt(2);

                System.out.println(likeCount+"======="+rCount);

                if (likeCount < 50 && likeCount >= 0){
                    HSSFRow bRow = sheet.getRow(likeCount);
                    bRow.getCell(xCell2).setCellValue(rCount);
                }else {
                    count2+=rCount;
                }
                nCellLast2.setCellValue(count2);
            }

            xCell2+=2;

            rs2.close();
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

        stmt.close();
        conn.close();
    }
}
