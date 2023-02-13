package ua.goit.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFile {
    public String readUsingFiles(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
