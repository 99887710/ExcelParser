package com.poll.parser.xls;

import com.poll.json.Json;
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
    private HSSFWorkbook hssfWorkbook;
    private HSSFSheet sheet;

    public XlsParser(FileReadable fileReader) {
        this.fileReader = fileReader;
    }


    public HSSFWorkbook getWorkBook(){
        try {
            hssfWorkbook = new HSSFWorkbook(fileReader.getFileInputStream());
        }  catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return hssfWorkbook;
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
        close();
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

    public void outputToJSON() {
        System.out.println("Parsing XLS file...");

        Iterator<Row> rowIt = getRows(0);
        while (rowIt.hasNext()) {
            Row row = rowIt.next();
            Json json = new Json();
            //store json node in array

        }
    }

    public void close(){
        try {
            hssfWorkbook.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
