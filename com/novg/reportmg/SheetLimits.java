package com.novg.reportmg;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NovgorodskiyAK on 14.01.2016.
 * Class creates Sheet of Limits
 */
public class SheetLimits {
    private Sheet sheet;
    private String date;
    private List<Integer> summedCells;
    private int totalRow;
    private CellStyle styleInnerHeading;
    private CellStyle styleHeading;
    private CellStyle styleHeadline;
    private CellStyle styleTable;
    private CellStyle styleDouble;
    private CellStyle styleDoubleBold;
    private CellStyle styleCorpColor;
    private CellStyle styleLimitsDoubleSum;
    private CellStyle styleResultHeadline;

    public SheetLimits(XSSFWorkbook workbook, String date) {
        this.date = date;
        sheet = workbook.createSheet(date + "-Лимиты");
        summedCells = new ArrayList<>();
        CellStyles cellStyles = new CellStyles(workbook);
        styleInnerHeading = cellStyles.innerHeadLine();
        styleHeading = cellStyles.heading();
        styleHeadline = cellStyles.headline();
        styleTable = cellStyles.limitsTable();
        styleDouble = cellStyles.limitsDouble();
        styleDoubleBold = cellStyles.limitsDoubleBold();
        styleCorpColor = cellStyles.corpColor();
        styleLimitsDoubleSum = cellStyles.limitsDoubleSum();
        styleResultHeadline = cellStyles.resultHeadline();
    }

    public void create() {
        Row rowHeadline = sheet.createRow(0);
        Cell cellHeadline = rowHeadline.createCell(0);
        cellHeadline.setCellValue("Затраты на междугородние переговоры за " + date);
        cellHeadline.setCellStyle(styleHeadline);
        int row = 2;

        int rowMerge = row + 3;
        String[][] table = LimitsInitializer.MANAGEMENT_SAZ;
        row = createTableLimits("РУКОВОДСТВО  АО \"РУСАЛ Саяногорск\"", table, row, false);
        mergeCells(rowMerge, row - 1, 0);

        rowMerge = row + 3;
        table = LimitsInitializer.OTB;
        row = createTableLimits("ОТДЕЛ ОХРАНЫ ТРУДА И ПРОМЫШЛЕННОЙ БЕЗОПАСНОСТИ", table, row, true);
        mergeCells(rowMerge, row - 1, 200);

        rowMerge = row + 3;
        table = LimitsInitializer.PDO;
        row = createTableLimits("ПРОИЗВОДСТВЕННО-ДИСПЕТЧЕРСКИЙ ОТДЕЛ", table, row, true);
        mergeCells(rowMerge, row - 1, 450);

        rowMerge = row + 3;
        table = LimitsInitializer.LAWYERS;
        row = createTableLimits("ЮРИДИЧЕСКИЙ ОТДЕЛ", table, row, true);
        mergeCells(rowMerge, row - 1, 600);

        rowMerge = row + 3;
        table = LimitsInitializer.ELECTROLYSE;
        row = createTableLimits("ДИРЕКЦИЯ ПО ЭЛЕКТРОЛИЗНОМУ ПРОИЗВОДСТВУ", table, row, true);
        mergeCells(rowMerge, rowMerge + 1, 250);
        rowMerge += 2;
        mergeCells(rowMerge, rowMerge, 250);

        rowMerge = row + 3;
        table = LimitsInitializer.FOUNDRY;
        row = createTableLimits("ДИРЕКЦИЯ ПО ЛИТЕЙНОМУ ПРОИЗВОДСТВУ", table, row, true);
        mergeCells(rowMerge, row - 1, 500);

        rowMerge = row + 3;
        table = LimitsInitializer.ELECTRODE;
        row = createTableLimits("ДИРЕКЦИЯ ПО ПРОИЗВОДСТВУ ЭЛЕКТРОДОВ", table, row, true);
        mergeCells(rowMerge, row - 1, 500);

        rowMerge = row + 3;
        table = LimitsInitializer.ENERGY;
        row = createTableLimits("СЛУЖБА ГЛАВНОГО ЭНЕРГЕТИКА", table, row, true);
        mergeCells(rowMerge, row - 1, 600);

        rowMerge = row + 3;
        table = LimitsInitializer.ECOLOGY;
        row = createTableLimits("ДИРЕКЦИЯ ПО ЭКОЛОГИИ И АНАЛИТИЧЕСКОМУ КОНТРОЛЮ ПРОИЗВОДСТВА", table, row, true);
        mergeCells(rowMerge, row - 1, 200);

        rowMerge = row + 3;
        table = LimitsInitializer.COMMERCE;
        row = createTableLimits("КОММЕРЧЕСКАЯ ДИРЕКЦИЯ", table, row, true);
        mergeCells(rowMerge, rowMerge + 3, 1000);
        rowMerge += 4;
        mergeCells(rowMerge, rowMerge + 1, 500);
        rowMerge += 2;
        mergeCells(rowMerge, rowMerge + 10, 2850);
        rowMerge += 11;
        mergeCells(rowMerge, rowMerge + 3, 400);
        rowMerge += 4;
        mergeCells(rowMerge, rowMerge + 2, 50);

        rowMerge = row + 3;
        table = LimitsInitializer.PERSONNEL;
        row = createTableLimits("ДИРЕКЦИЯ ПО ПЕРСОНАЛУ", table, row, true);
        mergeCells(rowMerge, rowMerge + 7, 850);
        rowMerge += 9;
        mergeCells(rowMerge, rowMerge, 400);

        rowMerge = row + 3;
        table = LimitsInitializer.FINANCE;
        row = createTableLimits("ФИНАНСОВАЯ ДИРЕКЦИЯ", table, row, true);
        mergeCells(rowMerge, row - 1, 1000);

        rowMerge = row + 3;
        table = LimitsInitializer.SECURITY;
        row = createTableLimits("ДИРЕКЦИЯ ПО ЗАЩИТЕ РЕСУРСОВ", table, row, true);
        mergeCells(rowMerge, row - 1, 1000);

        rowMerge = row + 3;
        table = LimitsInitializer.TRADE_UNION;
        row = createTableLimits("ПРОФКОМ  ЗАВОДА", table, row, true);
        mergeCells(rowMerge, row - 1, 500);

        rowMerge = row + 3;
        table = LimitsInitializer.PRESS_SERVICE;
        row = createTableLimits("ПРЕСС-СЛУЖБА", table, row, true);
        mergeCells(rowMerge, row - 1, 100);

        rowMerge = row + 3;
        table = LimitsInitializer.VETERAN_UNION;
        row = createTableLimits("Союз ветеранов", table, row, true);
        mergeCells(rowMerge, row - 1, 100);

        row = resultTable(row);

        rowMerge = row + 3;
        table = LimitsInitializer.DIS;
        row = createTableLimits("ДИС", table, row, false);
        mergeCells(rowMerge, row - 1, 0);

        rowMerge = row + 3;
        table = LimitsInitializer.OTHER;
        row = createTableLimits("ПРОЧИЕ", table, row, false);
        mergeCells(rowMerge, row - 1, 0);

        totalTable(row);

        sheet.setColumnWidth(0, 256 * 80);
        sheet.setColumnWidth(1, 256 * 12);
        sheet.setColumnWidth(2, 256 * 10);
        sheet.setColumnWidth(3, 256 * 10);
        sheet.setColumnWidth(4, 256 * 10);
        sheet.setColumnWidth(5, 256 * 10);
        sheet.setColumnWidth(6, 256 * 10);
        sheet.setColumnWidth(7, 256 * 10);
    }

    private void totalTable(int row) {
        int r = row + 1;
        Row currentRow = sheet.createRow(++r);
        Cell currentCell = currentRow.createCell(5);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(String.format("РТК!F%d+ГТС!F%d",
                Report.listSumRtsGtk.get(1), Report.listSumRtsGtk.get(0)));

        currentRow = sheet.createRow(++r);
        currentCell = currentRow.createCell(5);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(String.format("D%d+D%d+D%d",
                summedCells.get(summedCells.size() - 2), summedCells.get(summedCells.size() - 1), totalRow));

        currentRow = sheet.createRow(++r);
        currentCell = currentRow.createCell(5);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(String.format("F%d-F%d", r - 1, r));
    }

    private int resultTable(int row) {
        int r = row + 2;
        Row headingRow = sheet.createRow(r);
        String[] caption = LimitsInitializer.CAPTION;
        for (int col = 1; col < caption.length; col++) {
            Cell cell = headingRow.createCell(col + 2);
            cell.setCellValue(caption[col]);
            cell.setCellStyle(styleHeading);
        }

        Row currentRow = sheet.createRow(++r);
        Cell currentCell = currentRow.createCell(2);
        currentCell.setCellStyle(styleResultHeadline);
        currentCell.setCellValue("ИТОГО ПО ЛИМИТИРУЕМЫМ НОМЕРАМ:");

        StringBuilder sumsBuilder = new StringBuilder();
        StringBuilder limitsBuilder = new StringBuilder();
        for (Integer summedCell : summedCells.subList(1, summedCells.size())) {
            sumsBuilder.append("D");
            sumsBuilder.append(summedCell);
            sumsBuilder.append("+");

            limitsBuilder.append("E");
            limitsBuilder.append(summedCell);
            limitsBuilder.append("+");
        }

        sumsBuilder.delete(sumsBuilder.length() - 1, sumsBuilder.length());
        currentCell = currentRow.createCell(3);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(sumsBuilder.toString());

        limitsBuilder.delete(limitsBuilder.length() - 1, limitsBuilder.length());
        currentCell = currentRow.createCell(4);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(limitsBuilder.toString());

        currentCell = currentRow.createCell(5);
        currentCell.setCellFormula(String.format("IF(D%1$d>E%1$d,D%1$d-E%1$d,\"\")", r + 1));
        currentCell.setCellStyle(styleLimitsDoubleSum);

        currentCell = currentRow.createCell(6);
        currentCell.setCellFormula(String.format("IF(D%1$d<E%1$d,E%1$d-D%1$d,\"\")", r + 1));
        currentCell.setCellStyle(styleLimitsDoubleSum);

        currentRow = sheet.createRow(++r);
        currentCell = currentRow.createCell(2);
        currentCell.setCellStyle(styleResultHeadline);
        currentCell.setCellValue("ИТОГО ПО ЗАВОДУ:");

        currentCell = currentRow.createCell(3);
        currentCell.setCellStyle(styleLimitsDoubleSum);
        currentCell.setCellFormula(String.format("D%d+D%d", summedCells.get(0), r));
        totalRow = r + 1;

        return r;
    }

    private void mergeCells(int rowBegin, int rowEnd, int limit) {
        sheet.addMergedRegion(new CellRangeAddress(rowBegin, rowEnd, 4, 4));
        sheet.addMergedRegion(new CellRangeAddress(rowBegin, rowEnd, 5, 5));
        sheet.addMergedRegion(new CellRangeAddress(rowBegin, rowEnd, 6, 6));

        Row currentRow = sheet.getRow(rowBegin);
        Cell cell = currentRow.createCell(4);

        if (limit > 0) {
            cell.setCellValue(limit);
            cell.setCellStyle(styleHeading);

            cell = currentRow.createCell(5);
            cell.setCellFormula(String.format("IF(SUM(D%1$d:D%2$d)>E%1$d,SUM(D%1$d:D%2$d)-E%1$d,\"\")",
                    rowBegin + 1, rowEnd + 1));
            cell.setCellStyle(styleDoubleBold);

            cell = currentRow.createCell(6);
            cell.setCellFormula(String.format("IF(SUM(D%1$d:D%2$d)<E%1$d,E%1$d-SUM(D%1$d:D%2$d),\"\")",
                    rowBegin + 1, rowEnd + 1));
            cell.setCellStyle(styleDoubleBold);
        } else {
            cell.setCellValue("");
            cell.setCellStyle(styleHeading);

            cell = currentRow.createCell(5);
            cell.setCellValue("");
            cell.setCellStyle(styleDoubleBold);

            cell = currentRow.createCell(6);
            cell.setCellValue("");
            cell.setCellStyle(styleDoubleBold);
        }

        for (int i = rowBegin + 1; i <= rowEnd; i++) {
            currentRow = sheet.getRow(i);
            for (int j = 4; j < 7; j++) {
                cell = currentRow.createCell(j);
                cell.setCellStyle(styleHeading);
            }
        }
    }

    private int createTableLimits(String name, String[][] table, int row, boolean limit) {
        int r = row;
        Row currentRow = sheet.createRow(++r);
        Cell currentCell = currentRow.createCell(0);
        currentCell.setCellValue(name);
        currentCell.setCellStyle(styleHeadline);
        r = fillTable(table, r, limit);
        return r;
    }

    private int fillTable(String[][] table, int row, boolean limit) {
        int r = row;
        Row headingRow = sheet.createRow(++r);
        String[] caption = LimitsInitializer.CAPTION;
        for (int col = 0; col < caption.length; col++) {
            Cell cell = headingRow.createCell(col + 2);
            cell.setCellValue(caption[col]);
            cell.setCellStyle(styleHeading);
        }

        int rowStart = ++r;
        for (String[] line : table) {
            Row currentRow = sheet.createRow(r);
            Cell cell = currentRow.createCell(0);
            cell.setCellValue(line[0]);
            if (line[2].equals("")) {
                cell.setCellStyle(styleInnerHeading);
            } else {
                cell.setCellStyle(styleTable);
                cell = currentRow.createCell(1);
                cell.setCellStyle(styleTable);
                if (!line[1].equals(""))
                    cell.setCellValue(Double.parseDouble(line[1]));

                cell = currentRow.createCell(2);
                cell.setCellStyle(styleTable);
                cell.setCellValue(Double.parseDouble(line[2]));

                cell = currentRow.createCell(3);
                cell.setCellStyle(styleDouble);
                cell.setCellFormula(String.format("SUMIF('%1$s'!D:F,C%2$d,'%1$s'!F:F)", "3счет", r + 1));

                if (Initializer.getCorporateMap().containsKey(line[2])) {
                    cell = currentRow.createCell(7);
                    cell.setCellStyle(styleCorpColor);
                    cell.setCellValue("корп");
                }
            }
            r++;
        }

        summedCells.add(r + 1);
        headingRow = sheet.createRow(r);
        Cell cellSum = headingRow.createCell(2);
        cellSum.setCellValue("ВСЕГО:");
        cellSum.setCellStyle(styleLimitsDoubleSum);

        cellSum = headingRow.createCell(3);
        cellSum.setCellFormula(String.format("SUM(D%d:D%d)", rowStart + 1, r));
        cellSum.setCellStyle(styleLimitsDoubleSum);

        if (limit) {
            cellSum = headingRow.createCell(4);
            cellSum.setCellFormula(String.format("SUM(E%d:E%d)", rowStart + 1, r));
            cellSum.setCellStyle(styleLimitsDoubleSum);

            cellSum = headingRow.createCell(5);
            cellSum.setCellFormula(String.format("IF(D%1$d>E%1$d,D%1$d-E%1$d,\"\")", r + 1));
            cellSum.setCellStyle(styleLimitsDoubleSum);

            cellSum = headingRow.createCell(6);
            cellSum.setCellFormula(String.format("IF(D%1$d<E%1$d,E%1$d-D%1$d,\"\")", r + 1));
            cellSum.setCellStyle(styleLimitsDoubleSum);
        } else {
            cellSum = headingRow.createCell(4);
            cellSum.setCellStyle(styleLimitsDoubleSum);
            cellSum = headingRow.createCell(5);
            cellSum.setCellStyle(styleLimitsDoubleSum);
            cellSum = headingRow.createCell(6);
            cellSum.setCellStyle(styleLimitsDoubleSum);
        }

        return r;
    }
}
