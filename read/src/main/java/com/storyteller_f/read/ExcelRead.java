package com.storyteller_f.read;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelRead extends Read {
    public ExcelRead(String path) {
        super(path);
    }

    public static Workbook get(String path) throws Exception {
        int i = path.lastIndexOf(".");
        if (i > 0) {
            String substring = path.substring(i);
            switch (substring) {
                case ".xlsx":
                    return new XSSFWorkbook(path);
                case ".xls":
                    return new HSSFWorkbook(new BufferedInputStream(new FileInputStream(path)));
                case ".ods":
                    return new ODFWorkbook(path);
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public HashMap<String, List<String>> read(int row, int col, int sheetIndex) throws Exception {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        Workbook workbook = get(path);
        if (workbook == null) return null;
        Sheet sheetAt = workbook.getSheetAt(sheetIndex);
        for (int i = 1; i < row; i++) {
            List<String> list = new ArrayList<>();
            Row rowByIndex = sheetAt.getRow(i);
            for (int i1 = 1; i1 < col; i1++) {
                org.apache.poi.ss.usermodel.Cell cellByIndex = rowByIndex.getCell(i1);
                list.add(cellByIndex.getStringCellValue());
            }
            Cell cellByIndex = rowByIndex.getCell(0);
            String key = cellByIndex.getStringCellValue();
            System.out.println(key);
            hashMap.put(key, list);
        }
        return hashMap;
    }

    @Override
    public List<String> allSheets() throws Exception {
        ArrayList<String> strings = new ArrayList<>();
        Workbook workbook = get(path);
        if (workbook==null) {
            return strings;
        }
        int numberOfSheets = workbook.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            strings.add(workbook.getSheetName(i));
        }
        return strings;
    }

}
