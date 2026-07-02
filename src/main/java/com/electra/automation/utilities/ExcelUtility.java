package com.electra.automation.utilities;

import com.electra.automation.constants.FrameworkConstants;
import com.electra.automation.exceptions.FrameworkException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtility {
    public static List<Map<String, String>> readSheet(String sheetName) {
        List<Map<String, String>> data = new ArrayList<>();
        try (FileInputStream fis = new FileInputStream(FrameworkConstants.EXCEL_PATH);
             Workbook workbook = new XSSFWorkbook(fis)) {
            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new FrameworkException("Sheet not found: " + sheetName);
            }
            Row headerRow = sheet.getRow(0);
            for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
                Row row = sheet.getRow(rowIndex);
                if (row == null) continue;
                Map<String, String> rowMap = new HashMap<>();
                for (int colIndex = 0; colIndex < headerRow.getLastCellNum(); colIndex++) {
                    Cell cell = row.getCell(colIndex, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                    rowMap.put(headerRow.getCell(colIndex).getStringCellValue(), cell == null ? "" : cell.toString());
                }
                data.add(rowMap);
            }
        } catch (IOException e) {
            throw new FrameworkException("Unable to read Excel file", e);
        }
        return data;
    }
}
