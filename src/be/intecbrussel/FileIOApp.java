package be.intecbrussel;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class FileIOApp {
    public static void main(String[] args) {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("C:/Users/uzair/Downloads/unsorted/unsorted"))) {
            for (Path file : stream) {
                createDirectory(file);
                // System.out.println("folder is created");
                // Path path = Paths.get("C:/Users");

                System.out.println(file.getFileName());

            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
    }

    private static void createDirectory(Path path) {
        if (path.toString().endsWith(".txt")) {
            // String stringPath = path.toString();
            //  int indexOfTxt = stringPath.indexOf("txt");
            try {
                Path directoryPath = Paths.get("C:/Users/uzair/Downloads/sorted");
                if (Files.notExists(directoryPath)) {
                    Files.createDirectories(directoryPath);
                }

                Files.move(path, directoryPath, StandardCopyOption.ATOMIC_MOVE);
                System.out.println("file is added to this folder");

            } catch (IOException | DirectoryIteratorException ex) {
                ex.printStackTrace();
            }
        }

    }
}
