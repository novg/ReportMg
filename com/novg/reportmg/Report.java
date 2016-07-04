package com.novg.reportmg;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Report {
    private enum SheetName {
        Corporate, MvzOrder, MvzPhone
    }

    private enum Region {
        Rtk, Gts, All
    }

    static List<Integer> listSumRtsGtk;
    private Table table;
    private XSSFWorkbook workbook;
    private String fileName;
    private XSSFCellStyle styleDouble;
    private XSSFCellStyle styleDoubleBold;
    private XSSFCellStyle styleTable;
    private XSSFCellStyle styleCaption;
    private XSSFCellStyle styleDoubleGts;
    private XSSFCellStyle styleGts;
    private XSSFCellStyle styleDoubleRtk;
    private XSSFCellStyle styleRtk;

    public Report(String fileName) {
        this.fileName = fileName;
        listSumRtsGtk = new ArrayList<>();
        workbook = new XSSFWorkbook();
        CellStyles cellStyles = new CellStyles(workbook);
        styleDouble = cellStyles.doubleStyle();
        styleDoubleBold = cellStyles.doubleBold();
        styleTable = cellStyles.table();
        styleCaption = cellStyles.caption();
        styleDoubleGts = cellStyles.doubleGts();
        styleGts = cellStyles.gts();
        styleDoubleRtk = cellStyles.doubleRtk();
        styleRtk = cellStyles.rtk();
    }

    public void create() {
        Reader reader = new Reader();
        table = reader.readFile(fileName);
        createSheetBasic(SheetName.Corporate);
        createSheetBasic(SheetName.MvzOrder);
        createSheetBasic(SheetName.MvzPhone);
        createSheetStatistic(Region.All);
        createSheetStatistic(Region.Gts);
        createSheetStatistic(Region.Rtk);
        createSheetMvz(Region.Gts);
        createSheetMvz(Region.Rtk);
        new SheetLimits(workbook, dateString()).create();

        saveFile();
    }

    private void createSheetMvz(Region region) {
        Sheet sheet = null;
        int[] mvz = null;
        String regionName = null;

        switch (region) {
            case Rtk:
                sheet = workbook.createSheet("МВЗ РТК");
                mvz = Initializer.getMvzRtk();
                regionName = "РТК";
                break;
            case Gts:
                sheet = workbook.createSheet("МВЗ ГТС");
                mvz = Initializer.getMvzGts();
                regionName = "ГТС";
                break;
        }

        String[] caption = Initializer.getMvzCaption();
        createCaption(caption, sheet, styleTable);

        for (int row = 0; row < mvz.length; row++) {
            Row currentRow = sheet.createRow(row + 1);
            Cell cell = currentRow.createCell(0);
            cell.setCellValue(mvz[row]);
            cell.setCellStyle(styleTable);

            cell = currentRow.createCell(1);
            cell.setCellFormula(String.format("VLOOKUP(A%d,'МВЗ=ЗАКАЗ'!A:B,2,(FALSE))", row + 2));
            cell.setCellStyle(styleTable);

            cell = currentRow.createCell(2);
            cell.setCellFormula(String.format("SUMIF(%s!I:I,A%d,%s!F:F)", regionName, row + 2, regionName));
            cell.setCellStyle(styleDouble);
        }

        Row rowSum = sheet.createRow(mvz.length + 1);
        Cell cellSum = rowSum.createCell(0);
        cellSum.setCellValue("Итого:");
        cellSum.setCellStyle(styleCaption);

        cellSum = rowSum.createCell(1);
        cellSum.setCellStyle(styleCaption);

        cellSum = rowSum.createCell(2);
        cellSum.setCellFormula(String.format("SUM(C2:C%d)", mvz.length + 1));
        cellSum.setCellStyle(styleDoubleBold);

        sheet.setColumnWidth(0, 256 * 12);
        sheet.setColumnWidth(1, 256 * 12);
        sheet.setColumnWidth(2, 256 * 12);
    }

    private void createSheetStatistic(Region region) {
        Sheet sheet = null;
        int rowStart = 0;
        int rowEnd = 0;
        CellStyle style = null;
        CellStyle styleDouble = null;

        switch (region) {
            case Rtk:
                sheet = workbook.createSheet("РТК");
                style = styleRtk;
                styleDouble = styleDoubleRtk;
                rowStart = table.getSeparator();
                rowEnd = table.getTable().size();
                break;
            case Gts:
                sheet = workbook.createSheet("ГТС");
                style = styleGts;
                styleDouble = styleDoubleGts;
                rowStart = 0;
                rowEnd = table.getSeparator();
                break;
            case All:
                sheet = workbook.createSheet("3счет");
                rowStart = 0;
                rowEnd = table.getTable().size();
                break;
        }

        String[] caption = Initializer.getStatisticCaption();
        createCaption(caption, sheet, styleCaption);

        int row = 1;
        for (int line = rowStart; line < rowEnd; line++) {
            Row currentRow = sheet.createRow(row++);
            List<String> list = table.getTable().get(line);
            for (int col = 0; col < list.size(); col++) {
                Cell cell = currentRow.createCell(col);
                String s = list.get(col);

                if (2 < col && col < 8)
                    cell.setCellValue(Double.parseDouble(s));
                else if (col == 8)
                    cell.setCellFormula(String.format("VLOOKUP(D%d,'МВЗ=Телефон'!A:B,2,(FALSE))", row));
                else if (col == 9)
                    cell.setCellFormula(String.format("VLOOKUP(I%d,'МВЗ=ЗАКАЗ'!A:B,2,(FALSE))", row));
                else
                    cell.setCellValue(s);

                if (region == Region.All) {
                    if (line < table.getSeparator()) {
                        style = styleGts;
                        styleDouble = styleDoubleGts;
                    } else {
                        style = styleRtk;
                        styleDouble = styleDoubleRtk;
                    }
                }

                cell.setCellStyle(style);
                if (col == 5)
                    cell.setCellStyle(styleDouble);
            }
        }

        if (region == Region.All) {
            Cell cellTable = sheet.getRow(1).createCell(10);
            cellTable.setCellValue("местн");
            cellTable.setCellStyle(styleGts);
            cellTable = sheet.getRow(1).createCell(11);
            cellTable.setCellFormula(String.format("SUM(F2:F%d)", table.getSeparator() + 1));
            cellTable.setCellStyle(styleDoubleGts);

            cellTable = sheet.getRow(2).createCell(10);
            cellTable.setCellValue("мг мн");
            cellTable.setCellStyle(styleRtk);
            cellTable = sheet.getRow(2).createCell(11);
            cellTable.setCellFormula(String.format("SUM(F%d:F%d)", table.getSeparator() + 2, row));
            cellTable.setCellStyle(styleDoubleRtk);

            cellTable = sheet.getRow(3).createCell(10);
            cellTable.setCellValue("итого");
            cellTable.setCellStyle(styleCaption);
            cellTable = sheet.getRow(3).createCell(11);
            cellTable.setCellFormula(String.format("SUM(F%d:F%d)", 2, row));
            cellTable.setCellStyle(styleDoubleBold);
        } else {
            Row sumRow = sheet.createRow(row++);
            Cell sumCell = sumRow.createCell(5);
            sumCell.setCellStyle(styleDoubleBold);
            sumCell.setCellFormula(String.format("SUM(F%d:F%d)", 2, row - 1));
            listSumRtsGtk.add(row);
        }

        sheet.setColumnWidth(0, 256 * 9);
        sheet.setColumnWidth(1, 256 * 9);
        sheet.setColumnWidth(2, 256 * 21);
        sheet.setColumnWidth(3, 256 * 8);
        sheet.setColumnWidth(4, 256 * 8);
        sheet.setColumnWidth(5, 256 * 8);
        sheet.setColumnWidth(6, 256 * 13);
        sheet.setColumnWidth(7, 256 * 13);
        sheet.setColumnWidth(8, 256 * 13);
        sheet.setColumnWidth(9, 256 * 13);
    }

    private void createSheetBasic(SheetName sheetName) {
        Map<String, String> map = null;
        String[] caption = null;
        Sheet sheet = null;

        switch (sheetName) {
            case Corporate: {
                sheet = workbook.createSheet("Корпоративка");
                map = Initializer.getCorporateMap();
                caption = Initializer.getCorporateCaption();
                break;
            }
            case MvzOrder:
                sheet = workbook.createSheet("МВЗ=ЗАКАЗ");
                map = Initializer.getMvzOrderMap();
                caption = Initializer.getMvzOrderCaption();
                break;
            case MvzPhone:
                sheet = workbook.createSheet("МВЗ=Телефон");
                map = Initializer.getMvzPhoneMap();
                caption = Initializer.getMvzPhoneCaption();
                break;
        }

        createCaption(caption, sheet, styleTable);

        int row = 1;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            Row currentRow = sheet.createRow(row++);
            Cell cellKey = currentRow.createCell(0);
            cellKey.setCellValue(Integer.parseInt(entry.getKey()));
            cellKey.setCellStyle(styleTable);
            Cell cellValue = currentRow.createCell(1);
            if (!entry.getValue().isEmpty())
                cellValue.setCellValue(Double.parseDouble(entry.getValue()));
            else
                cellValue.setCellValue(entry.getValue());
            cellValue.setCellStyle(styleTable);
        }

        sheet.setColumnWidth(0, 256 * 21);
        sheet.setColumnWidth(1, 256 * 21);
    }

    private void createCaption(String[] caption, Sheet sheet, XSSFCellStyle styleTable) {
        Row row = sheet.createRow(0);
        for (int col = 0; col < caption.length; col++) {
            Cell cell = row.createCell(col);
            cell.setCellStyle(styleTable);
            cell.setCellValue(caption[col]);
        }
    }

    private void saveFile() {
        String outFile = dateString() + "-saz.xlsx";
        try (FileOutputStream outputStream = new FileOutputStream(outFile)) {
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private String dateString() {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, -1);
        Date date = calendar.getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        return dateFormat.format(date);
    }
}
