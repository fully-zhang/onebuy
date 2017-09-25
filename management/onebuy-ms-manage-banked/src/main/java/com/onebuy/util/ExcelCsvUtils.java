package com.onebuy.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExcelCsvUtils {
    private static final Logger LOG = LoggerFactory
            .getLogger(ExcelCsvUtils.class);

    public static File toCSV(InputStream inputStream){
        int maxRowWidth = 0;
        List<List<String>> data = new ArrayList<List<String>>();
        Workbook workbook;
        int rowNum = 0;
        try {
            workbook = new HSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(0);
            if(sheet.getPhysicalNumberOfRows()>0){
                rowNum = sheet.getLastRowNum();
            }
            for (int i = 0; i <= rowNum; i++) {
                Row row = sheet.getRow(i);
                maxRowWidth = Math.max(row.getLastCellNum(),maxRowWidth);
                data.add(rowToCsv(sheet.getRow(i)));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            LOG.info(data.toString());
            return writeCSV(data,maxRowWidth,rowNum);
        } catch (IOException e) {
            LOG.error("IOE",e);
        }
        return null;
    }

    private static File writeCSV(List<List<String>> data, int maxRowWidth, int rowNum) throws IOException {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        List<String> line = null;
        StringBuffer buffer = null;
        String csvLineElement = null;
        try {

            File file = new File("/csv/临时csv.csv");
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
            for(int i = 0; i <= rowNum; i++) {
                buffer = new StringBuffer();
                line = data.get(i);
                for(int j = 0; j < maxRowWidth; j++) {
                    if(line.size() > j) {
                        csvLineElement = line.get(j);
                        if(csvLineElement != null) {
                            buffer.append(csvLineElement);
                        }
                    }
                    if(j < (maxRowWidth - 1)) {
                        buffer.append(',');
                    }
                }
                LOG.info(buffer.toString());
                osw.write(buffer.toString().trim());
                if(i < ( data.size() - 1)) {
                    osw.write("\r\n");
                }
            }
            return file;
        } finally {
            if(osw != null) {
                osw.flush();
                osw.close();
            }
        }
    }

    private static List<String> rowToCsv(Row row){
        List<String> list = new ArrayList<String>();
        if(row == null)return list;
        int cellNum = row.getLastCellNum();
        DataFormatter formatter = new DataFormatter();
        for (int i = 0; i <= cellNum; i++) {
            list.add(formatter.formatCellValue(row.getCell(i)));
        }
        return list;
    }

    public static List<Map<String,Object>> toExcelData(List beans){
        List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i < beans.size(); i++) {
            maps.add(mapper.convertValue(beans.get(i), Map.class));
        }
        return maps;
    }
}
