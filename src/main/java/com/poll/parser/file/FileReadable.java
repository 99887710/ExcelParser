package com.poll.parser.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileReadable {

    File getFile();
    FileInputStream getFileInputStream() throws FileNotFoundException;
    void close() throws IOException;
}
