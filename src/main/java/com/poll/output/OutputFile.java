package com.poll.output;

import java.io.*;

public class OutputFile {

    public static void export(String file, String data) {
        try (OutputStream os = new FileOutputStream(file);
            Writer writer = new OutputStreamWriter(os, "UTF-8")) {
            writer.write(data);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
