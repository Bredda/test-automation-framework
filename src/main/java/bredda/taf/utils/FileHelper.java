package bredda.taf.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {

    public static InputStream getInputStreamFromClasspath(String filename) {
        ClassLoader classLoader = FileHelper.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream(filename);
        return is;
    }

    public static void createDirectory(Path directoryPath) {
        try {
            Files.createDirectories(directoryPath);
        } catch (IOException e) {
            throw new IllegalArgumentException(String.format("Could not create directory: %s", directoryPath.toString()));
        }
    }

    public static void purgeDirectory(File dir) {
        for (File file: dir.listFiles()) {
            if (file.isDirectory())
                purgeDirectory(file);
            file.delete();
        }
    }

}
