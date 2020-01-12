package com.poll.parser.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader implements FileReadable {

    private File file;
    private String path;
    private FileInputStream fis;

    public FileReader(String path) {
        this.file = new File(path);
    }

    public File getFile() {
        return file;
    }

    public FileInputStream getFileInputStream() throws FileNotFoundException {
        fis = new FileInputStream(getFile());
        return fis;
    }

    public void close() throws IOException {
        fis.close();
    }
}
