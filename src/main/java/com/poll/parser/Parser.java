package com.poll.parser;

public class Parser {
    private Parsable parser;
    private String pathToOutput;
    private String pathToInput;

    public Parser(Parsable parser) {
        this.parser = parser;
    }

    public void extract(){
        parser.outputToJSON();
    }

    public String getPathToOutput() {
        return pathToOutput;
    }

    public void setPathToOutput(String pathToOutput) {
        this.pathToOutput = pathToOutput;
    }

    public String getPathToInput() {
        return pathToInput;
    }

    public void setPathToInput(String pathToInput) {
        this.pathToInput = pathToInput;
    }
}
