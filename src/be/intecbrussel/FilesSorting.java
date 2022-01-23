package be.intecbrussel;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FilesSorting {
    public static final String TARGET_DIR = "C:/assignment/file_io/sorted/";
    public static final String SOURCE_DIR = "C:/Users/uzair/Downloads/unsorted/unsorted";
    public static Map<String, List<String>> summaryMap = new HashMap<>();


    public static void main(String[] args) {

        createDirectoryForFiles(Paths.get(SOURCE_DIR));

        createSummaryFile();

    }

    private static void createSummaryFile() {
        Path path = Paths.get("C:/assignment/file_io/summary.txt");
        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
            writeSummaryFile(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeSummaryFile(Path path) {
        try (BufferedWriter summaryFile = Files.newBufferedWriter(path)) {
            summaryFile.write("FileName\t\t");
            summaryFile.write("Readable\t\t");
            summaryFile.write("Writable\t\t\n");

            summaryMap.forEach((key, value) -> {
                try {
                    summaryFile.write("\n\n\n======\n");
                    summaryFile.write(key + "\n");
                    summaryFile.write("======\n");
                    for (String v : value) {
                        summaryFile.write(v + "\n");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void createDirectoryForFiles(Path path) {
        try (Stream<Path> walk = Files.walk(path, 3)) {
            walk.filter(Files::isRegularFile)
                    .forEach(FilesSorting::move);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void move(Path path) {

        String extension = path.getFileName().toString().substring(path.getFileName().toString()
                .lastIndexOf(".")).replace(".", "");
        createDirectory(path, Paths.get(TARGET_DIR + extension), extension);

    }

    private static void prepare(Path path, String key) {
        List<String> list;
        if (summaryMap.containsKey(key)) {
            list = summaryMap.get(key);
        } else {
            list = new ArrayList<>();
        }
        String readable = Files.isReadable(path) ? "x" : "\\";
        String writable = Files.isWritable(path) ? "x" : "\\";
        list.add(path.getFileName().toString() + "\t|\t" + readable + "\t|\t" + writable);
        summaryMap.put(key, list);
    }


    private static void createDirectory(Path path, Path directoryPath, String extension) {
        try {
            Files.createDirectories(directoryPath);
            Path newPath = directoryPath.resolve(path.getFileName());
            Files.move(path, newPath, StandardCopyOption.REPLACE_EXISTING);
            if (Files.isHidden(newPath)) {
                prepare(newPath, "hidden");
            }
                prepare(newPath, extension);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}

