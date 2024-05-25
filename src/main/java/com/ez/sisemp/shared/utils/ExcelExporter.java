package com.ez.sisemp.shared.utils;

import com.ez.sisemp.shared.exception.ExcelExportException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelExporter {

    private ExcelExporter() {
        throw new IllegalStateException("Clase de utilidad ExcelExporter");
    }

    public static<T> void createExcelFile(List<String> headers, List<T> data, String sheetName, HttpServletResponse response) throws IOException {
        if(data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Datos a exportar no pueden ser nulos o vacíos");
        }
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);
        Row headerRow = sheet.createRow(0);
        headers.forEach(header -> {
            int i = headers.indexOf(header);
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header);
            cell.setCellStyle(createHeaderCellStyle(workbook));
        });

        AtomicInteger rowCount = new AtomicInteger(1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        data.forEach(rowData -> {
            Row row = sheet.createRow(rowCount.getAndIncrement());
            Field[] fields = rowData.getClass().getDeclaredFields();
            int i = 0;
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = field.get(rowData);
                    Cell cell = row.createCell(i);
                    if (value == null) {
                        continue;
                    }
                    if (value instanceof String) {
                        cell.setCellValue((String) value);
                    } else if (value instanceof Integer) {
                        cell.setCellValue((Integer) value);
                    } else if (value instanceof Double) {
                        cell.setCellValue((Double) value);
                    } else if (value instanceof java.util.Date) {
                        cell.setCellValue(dateFormat.format((java.util.Date) value));
                    } else if (value == null) {
                        cell.setBlank();
                    }
                    i++;
                } catch (IllegalAccessException e) {
                    throw new ExcelExportException(String.format("Error al convertir datos a Excel : %s", e.getMessage()));
                }
            }
        });
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename="+sheetName+".xlsx");

        headers.forEach(header -> {
            int i = headers.indexOf(header);
            sheet.autoSizeColumn(i);
        });

        try (OutputStream outputStream = response.getOutputStream()) {
            workbook.write(outputStream);
        } catch (IOException e) {
            throw new ExcelExportException(String.format("Error al exportar excel : %s", e.getMessage()));
        } finally {
            workbook.close();
        }
    }

    private static CellStyle createHeaderCellStyle(Workbook workbook) {
        CellStyle cellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        cellStyle.setFont(headerFont);
        cellStyle.setFillForegroundColor(IndexedColors.BLUE.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return cellStyle;
    }
}
