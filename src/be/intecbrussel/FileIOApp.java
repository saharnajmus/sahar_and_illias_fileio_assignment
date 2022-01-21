package be.intecbrussel;

import java.io.IOException;
import java.nio.file.*;

public class FileIOApp {
    public static void main(String[] args) {

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("C:/Users/uzair/Downloads/unsorted/unsorted"))) {
            for (Path file : stream) {
                createDirectoryForTextFiles(file);
                // System.out.println("folder is created");
                // Path path = Paths.get("C:/Users");

                System.out.println(file.getFileName());

            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
    }

    private static void createDirectoryForTextFiles(Path path) {
        if (path.toString().endsWith(".txt")) {
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/txt");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".png")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/png");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".gif")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/gif");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".jpg")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/jpg");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".csv")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/csv");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".exe")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/exe");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".pdf")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/pdf");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".json")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/json");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".wma")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/wma");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".gitignore")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/gitignore");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".zip")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/zip");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".sqlite3")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/sqlite3");
            createDirectory(path,directoryPath);
        }
        else if(path.toString().endsWith(".py")){
            Path directoryPath = Paths.get("C:/assignment/file_io/sorted/py");
            createDirectory(path,directoryPath);
        }



    }
    private static void createDirectory(Path path, Path directoryPath){
        try {
            // if (Files.notExists(directoryPath)) {
            Files.createDirectories(directoryPath);
            // }

            Path newPath = directoryPath.resolve(path.getFileName());
            Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
           // System.out.println("file is added to this folder");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    }

