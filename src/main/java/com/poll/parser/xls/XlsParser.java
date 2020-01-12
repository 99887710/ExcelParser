package com.poll.parser.xls;

import com.poll.json.Json;
import com.poll.json.JsonArray;
import com.poll.parser.Parsable;
import com.poll.parser.file.FileReadable;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.util.Iterator;

public class XlsParser implements Parsable {

    private FileReadable fileReader;
    private HSSFSheet sheet;

    public XlsParser(FileReadable fileReader) {
        this.fileReader = fileReader;
    }


    public HSSFWorkbook getWorkBook(){
        try (HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileReader.getFileInputStream())){
            return hssfWorkbook;
        }  catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


    public HSSFSheet getSheet(int num){
        HSSFWorkbook workbook = getWorkBook();
        if (workbook == null)
            throw new IllegalArgumentException("The workbook is null");
        return workbook.getSheetAt(num);
    }

    public Row getRow(int numOfSheet, int numOfRow) {
        try {
            sheet = getSheet(numOfSheet);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("The sheet is null");
        }
        return sheet.getRow(numOfRow);
    }

    public void printRow(int numOfSheet, int numOfRow){
        Row row;
        try {
            row = getRow(numOfSheet, numOfRow);

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("The row is null");
        }
        Iterator<Cell> cellIt = row.cellIterator();
        while (cellIt.hasNext()){
            Cell cell = cellIt.next();
            System.out.println(cell.toString() + ";");
        }
    }

    private Iterator<Row> getRows(int numOfSheet){
        try {
            sheet = getSheet(numOfSheet);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException("The sheet is null");
        }
        return sheet.rowIterator();
    }

    public String outputToJSON() {
        return parse();
    }

    private void skipPrevRows(Iterator iterator, int num) {
        for (int i=0; i<num; i++)
            iterator.next();
    }

    private String parse() {
        System.out.println("Parsing XLS file...");

        Iterator<Row> rowIt = getRows(0);
        skipPrevRows(rowIt, 6);
        JsonArray array = new JsonArray();

        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            Json rowObj = new Json();
            Iterator<Cell> cellItr = row.cellIterator();

            while (cellItr.hasNext()) {
                Cell cell = cellItr.next();
                switch (cell.getColumnIndex()) {
                    case 0:
                        rowObj.put("County", String.valueOf(cell.getStringCellValue()));
                        break;
                    case 1:
                        rowObj.put("Votes1", String.valueOf(cell.getNumericCellValue()));
                        break;
                    case 2:
                        rowObj.put("Votes2", String.valueOf(cell.getNumericCellValue()));
                        break;
                    case 3:
                        rowObj.put("Votes3", String.valueOf(cell.getNumericCellValue()));
                        break;
                }
            }
            array.add(rowObj);
        }
        return array.toJson();
    }

}
