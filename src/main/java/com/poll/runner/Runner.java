package com.poll.runner;

import com.poll.output.OutputFile;
import com.poll.parser.Parser;
import com.poll.parser.file.FileReadable;
import com.poll.parser.file.FileReader;
import com.poll.parser.xls.XlsParser;

public class Runner {

    public static void main(String[] args) {
        FileReadable fileReader = new FileReader("taiwan_presidential_election.xls");
        Parser electionParser = new Parser(new XlsParser(fileReader));

        OutputFile.export("election-result.json", electionParser.extract());
    }
}
