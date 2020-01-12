package com.poll.runner;

import com.poll.parser.Parser;
import com.poll.parser.file.FileReadable;
import com.poll.parser.file.FileReader;
import com.poll.parser.xls.XlsParser;

public class Runner {

    public static void main(String[] args) {
        FileReadable fileReader = new FileReader("holidays.xls");
        Parser holidayParser = new Parser(new XlsParser(fileReader));

        holidayParser.extract();
    }
}
