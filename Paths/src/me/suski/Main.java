package me.suski;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
        printFile(path);

        System.out.println("-------------------");
        Path filePath = Paths
                .get(".", "files", "SubdirectoryFile.txt");
        printFile(filePath);

        System.out.println("-------------------");
        filePath = Paths
                .get("C:\\Users\\Bartek\\Documents\\Coding\\java-masterclass\\OutThere.txt");
        printFile(filePath);

        System.out.println("-------------------");
        filePath = Paths.get(".");
        System.out.println(filePath.toAbsolutePath());

        System.out.println("-------------------");
        Path path2 = FileSystems.getDefault()
                .getPath(".", "files", "..", "files", "SubdirectoryFile.txt");
        System.out.println(path2.normalize().toAbsolutePath());
        printFile(path2);

        System.out.println("-------------------");
        Path path3 = FileSystems.getDefault().getPath("thisFile.txt");
        System.out.println(path3.toAbsolutePath());

        System.out.println("-------------------");
        Path path4 = Paths.get("X:\\Users\\Bartek\\Documents\\tests\\ING", "absc", "f.j");
        System.out.println(path4.toAbsolutePath());

        System.out.println("-------------------");
        filePath = FileSystems.getDefault().getPath("files");
        System.out.println(filePath.toAbsolutePath());
        System.out.println("Exists = " + Files.exists(filePath));

        System.out.println("-------------------");
        System.out.println(path4.toAbsolutePath());
        System.out.println("Exists = " + Files.exists(path4));

        System.out.println("-------------------");
        System.out.println("-------------------");

        try {
//            Path sourcFile = FileSystems.getDefault()
//                    .getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault()
//                    .getPath("Examples", "file1copy.txt");
//            Files.copy(sourcFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            sourcFile = FileSystems.getDefault()
//                    .getPath("Examples", "Dir1");
//            copyFile = FileSystems.getDefault()
//                    .getPath("Examples", "Dir4");
//            Files.copy(sourcFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

//            Path fileToMove = FileSystems.getDefault()
//                    .getPath("Examples", "file1copy.txt");
//            Path destination = FileSystems.getDefault()
//                    .getPath("Examples", "Dir1", "file1copy.txt");
//            Files.move(fileToMove, destination);

//            Path fileToRename = FileSystems.getDefault()
//                    .getPath("Examples", "file1.txt");
//            Path newFile = FileSystems.getDefault()
//                    .getPath("Examples", "file2.txt");
//            Files.move(fileToRename, newFile);

//            Path fileToDelete = FileSystems.getDefault()
//                    .getPath("Examples", "Dir1", "file1copy.txt");
//            Files.delete(fileToDelete);


//            Path fileToCreate = FileSystems.getDefault()
//                    .getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

//            Path dirToCreate = FileSystems.getDefault()
//                    .getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

//            Path dirToCreate = FileSystems.getDefault()
//                    .getPath("Examples", "Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Files.createDirectories(dirToCreate);

            filePath = FileSystems.getDefault()
                    .getPath("Examples", "Dir1\\file1.txt");
            long size = Files.size(filePath);
            System.out.println(size);
            System.out.println(Files.getLastModifiedTime(filePath));

            BasicFileAttributes fileAttributes = Files
                    .readAttributes(filePath, BasicFileAttributes.class);
            System.out.println(fileAttributes.size());
            System.out.println(fileAttributes.lastModifiedTime());
            System.out.println(fileAttributes.creationTime());
            System.out.println(fileAttributes.isDirectory());
            System.out.println(fileAttributes.isRegularFile());


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printFile(Path path) {
        try (BufferedReader fileReader = Files.newBufferedReader(path)) {

            String line;
            while ((line = fileReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
