package com.novg.reportmg;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CellStyles {
    private XSSFWorkbook workbook;

    public CellStyles(XSSFWorkbook workbook) {
        this.workbook = workbook;
    }

    XSSFCellStyle headline() {
        XSSFCellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 10);
        font.setBold(true);
        style.setFont(font);
        return style;
    }

    XSSFCellStyle resultHeadline() {
        XSSFCellStyle style = headline();
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.getFont().setItalic(true);
        return style;
    }

    XSSFCellStyle innerHeadLine() {
        XSSFCellStyle style = headline();
        style.getFont().setFontHeightInPoints((short) 8);
        return style;
    }

    XSSFCellStyle corpColor() {
        XSSFCellStyle style = workbook.createCellStyle();
        Font font = heading().getFont();
        font.setColor(IndexedColors.GREEN.index);
        style.setFont(font);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    XSSFCellStyle heading() {
        XSSFCellStyle style = workbook.createCellStyle();
        Font font = headline().getFont();
        font.setFontHeightInPoints((short) 8);
        style.setBorderBottom(BorderStyle.MEDIUM);
        style.setBottomBorderColor(IndexedColors.BLACK.index);
        style.setBorderLeft(BorderStyle.MEDIUM);
        style.setLeftBorderColor(IndexedColors.BLACK.index);
        style.setBorderRight(BorderStyle.MEDIUM);
        style.setRightBorderColor(IndexedColors.BLACK.index);
        style.setBorderTop(BorderStyle.MEDIUM);
        style.setTopBorderColor(IndexedColors.BLACK.index);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        style.setDataFormat(workbook.createDataFormat().getFormat("0"));
        style.setFont(font);
        return style;
    }

    XSSFCellStyle limitsDoubleBold() {
        XSSFCellStyle style = heading();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
        style.getFont().setBoldweight(Font.BOLDWEIGHT_BOLD);
        return style;
    }

    XSSFCellStyle limitsDoubleSum() {
        XSSFCellStyle style = limitsDoubleBold();
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.getFont().setItalic(true);
        return style;
    }

    XSSFCellStyle table() {
        XSSFCellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 8);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.index);
        style.setBorderLeft(BorderStyle.THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.index);
        style.setBorderRight(BorderStyle.THIN);
        style.setRightBorderColor(IndexedColors.BLACK.index);
        style.setBorderTop(BorderStyle.THIN);
        style.setTopBorderColor(IndexedColors.BLACK.index);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setDataFormat(workbook.createDataFormat().getFormat("0"));
        style.setFont(font);
        return style;
    }

    XSSFCellStyle limitsTable() {
        XSSFCellStyle style = table();
        style.setAlignment(HorizontalAlignment.LEFT);
        style.getFont().setFontName("Times New Roman");
        return style;
    }

    XSSFCellStyle doubleStyle() {
        XSSFCellStyle style = table();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
        return style;
    }

    XSSFCellStyle limitsDouble() {
        Font font = limitsTable().getFont();
        XSSFCellStyle style = doubleStyle();
        style.setAlignment(HorizontalAlignment.RIGHT);
        style.setFont(font);
        return style;
    }

    XSSFCellStyle caption() {
        XSSFCellStyle style = table();
        style.getFont().setBoldweight(Font.BOLDWEIGHT_BOLD);
        return style;
    }

    XSSFCellStyle gts() {
        XSSFCellStyle style = table();
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    XSSFCellStyle doubleGts() {
        XSSFCellStyle style = gts();
        style.setDataFormat(doubleStyle().getDataFormat());
        return style;
    }

    XSSFCellStyle rtk() {
        XSSFCellStyle style = table();
        style.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        return style;
    }

    XSSFCellStyle doubleRtk() {
        XSSFCellStyle style = rtk();
        style.setDataFormat(doubleStyle().getDataFormat());
        return style;
    }

    XSSFCellStyle doubleBold() {
        XSSFCellStyle style = caption();
        style.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
        return style;
    }
}
