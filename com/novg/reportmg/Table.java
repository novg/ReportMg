package com.novg.reportmg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NovgorodskiyAK on 12.01.2016.
 */
public class Table {
    private int separator;
    private List<List<String>> table;

    public Table() {
        table = new ArrayList<>();
        separator = 0;
    }


    public void setSeparator(int separator) {
        this.separator = separator;
    }

    public int getSeparator() {
        return separator;
    }

    public void setTable(List<List<String>> table) {
        this.table = table;
    }

    public List<List<String>> getTable() {
        return table;
    }

    public void addLine(List<String> line) {
        table.add(line);
    }
}
