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
        Path fileName = path.getFileName();
        if(fileName.toString().lastIndexOf(".") < 0  ){
            return;
        }
        String extension = path.getFileName().toString().substring(fileName.toString().lastIndexOf("."));
        switch (extension) {
            case ".txt":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/txt"));
                break;
            case ".png":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/png"));
                break;
            case ".gif":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/gif"));
                break;
            case ".jpg":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/jpg"));
                break;
            case ".csv":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/csv"));
                break;
            case ".exe":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/exe"));
                break;
            case ".pdf":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/pdf"));
                break;
            case ".json":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/json"));
                break;
            case ".wma":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/wma"));
                break;
            case ".gitignore":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/gitignore"));
                break;
            case ".zip":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/zip"));
                break;
            case ".sqlite3":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/sqlite3"));
                break;
            case ".py":
                createDirectory(path, Paths.get("C:/assignment/file_io/sorted/py"));
                break;
            default:
                System.out.println("Error " + extension);
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

    private static void moveContentOfMagazine(){
        Path path = Paths.get("C:/Users/uzair/Downloads/unsorted/unsorted/magazine's");
        Path directoryPath = Paths.get("C:/assignment/file_io/sorted/png/magazine's");
       // Files.createDirectories();
    }

    }

