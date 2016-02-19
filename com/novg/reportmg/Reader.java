package com.novg.reportmg;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by NovgorodskiyAK on 11.01.2016.
 */
public class Reader {
    private List<String> parse(List<String> list) {
        List<String> parsedList = new ArrayList<>();
        parsedList.add(list.get(1).split(" ")[0]);
        parsedList.add(list.get(1).split(" ")[1]);
        parsedList.add(list.get(2));
        parsedList.add(list.get(0).replace("39042", ""));
        parsedList.add(list.get(5));
//        parsedList.add(list.get(6).replace(".", ","));
        parsedList.add(list.get(6));
        parsedList.add(list.get(4));
        parsedList.add(list.get(4));
        parsedList.add("");
        parsedList.add("");

        return parsedList;
    }

    Table readFile(String fileName) {
        Table table = new Table();
        try {
            Workbook workbook = WorkbookFactory.create(new File(fileName));
            Sheet sheet = workbook.getSheetAt(0);
            Pattern pattern = Pattern.compile("\\D+");
            boolean rtk = false;
            int rowStart = sheet.getFirstRowNum();
            int rowEnd = sheet.getLastRowNum();
            int correction = 0;
            int separator = 0;

            for (int num = rowStart; num < rowEnd; num++) {
                List<String> list = new ArrayList<>();
                Row currentRow = sheet.getRow(num);
                int lastCol = currentRow.getLastCellNum();

                for (int col = 0; col < lastCol; col++) {
                    Cell cell = currentRow.getCell(col);
                    if (!rtk && cell.getStringCellValue().contains("Всего по поставщику")) {
                        rtk = true;
                        separator = num;
                    }

                    Matcher matcher = pattern.matcher(cell.getStringCellValue());
                    if (col == 0 && matcher.find()) {
                        if (!rtk) correction++;
                        break;
                    }

                    list.add(cell.getStringCellValue());
                }

                if (list.size() > 0)
                    table.addLine(parse(list));
            }

            separator -= correction;
            table.setSeparator(separator);
            return table;
        } catch (IOException e) {
            System.out.println("Error reading file: " + fileName);
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            System.out.println("Invalid format file: " + fileName);
            e.printStackTrace();
        }

        return table;
    }
}
