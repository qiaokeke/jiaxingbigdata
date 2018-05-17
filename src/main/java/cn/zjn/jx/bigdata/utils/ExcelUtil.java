package cn.zjn.jx.bigdata.utils;

import cn.zjn.jx.bigdata.domain.xls.PowerAllView;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author: qiaokk
 * @Description:
 * @Date: Created in 2018-05-15 20:11
 * @Modified By:
 * @Email: qiaokekeshu@163.com
 */
public class ExcelUtil {

    //添加id
    public static void addIdtoPowerAllViews(List<PowerAllView> views){
        int id =1;
        for (PowerAllView view:views){
            view.setId(id++);
        }
    }

    public static Workbook getPowerAllViewsXls(List<PowerAllView> views){
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("1");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("序号");
        row.createCell(1).setCellValue("企业名称");
        row.createCell(2).setCellValue("电表号");
        row.createCell(3).setCellValue("A相电压");
        row.createCell(4).setCellValue("B相电压");
        row.createCell(5).setCellValue("C相电压");
        row.createCell(6).setCellValue("总电能");
        row.createCell(7).setCellValue("尖电能");
        row.createCell(8).setCellValue("峰电能");
        row.createCell(9).setCellValue("谷电能");
        row.createCell(10).setCellValue("倍率");
        row.createCell(11).setCellValue("采集时间");

        int rowNum=1;
        for (PowerAllView view:views){
           Row row2 = sheet.createRow(rowNum);
            row2.createCell(0).setCellValue(view.getId());
            row2.createCell(1).setCellValue(view.getCompanyName());
            row2.createCell(2).setCellValue(view.getpCode());
            row2.createCell(3).setCellValue(view.getaDianYa());
            row2.createCell(4).setCellValue(view.getbDianYa());
            row2.createCell(5).setCellValue(view.getcDianYa());
            row2.createCell(6).setCellValue(view.getZxygdnZ());
            row2.createCell(7).setCellValue(view.getZxygdnJ());
            row2.createCell(8).setCellValue(view.getZxygdnF());
            row2.createCell(9).setCellValue(view.getZxygdnG());
            row2.createCell(10).setCellValue(view.getBeiLv());
            row2.createCell(11).setCellValue(view.getTime());
            rowNum++;
        }

        return workbook;
    }

}
