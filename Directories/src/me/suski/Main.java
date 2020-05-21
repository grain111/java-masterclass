package me.suski;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//
//            @Override
//            public boolean accept(Path entry) throws IOException {
//                return Files.isRegularFile(entry);
//            }
//        };

        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        Path directory = FileSystems.getDefault()
                .getPath("FileTree" + File.separator + "Dir2");
        try (DirectoryStream<Path> content = Files
                .newDirectoryStream(directory, filter)) {

            for (Path file :
                    content) {
                System.out.println(file.getFileName());
            }
            
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }

        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try {

            Path tempFile = Files.createTempFile("myapp", ".appext");
            System.out.println("Temp file path: " + tempFile.toAbsolutePath());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();

        for (FileStore store :
                stores) {
            System.out.println(store);
            System.out.println(store.name());
        }

        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path :
                rootPaths) {
            System.out.println(path);
        }

        System.out.println("------ Walking tree for Dir2");
        Path dir2Path = FileSystems.getDefault()
                .getPath("FileTree", "Dir2");

        try {
            Files.walkFileTree(dir2Path, new PrintNames());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("------ Copy Dir2 to Dir4\\Dir2Copy");

        Path targetPath = FileSystems.getDefault()
                .getPath("FileTree", "Dir4", "Dir2Copy");

        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, targetPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        File file = new File("C:\\Users\\Bartek\\Documents\\Coding\\java-masterclass\\Directories\\Examples");
        Path convertedPath = file.toPath();
        System.out.println("convertedPath = " + convertedPath);

        File parent = new File("C:\\Example");
        File resolvedFile = new File(parent, "dir\\file.txt");
        System.out.println("resolvedFile = " + resolvedFile.toPath());

        resolvedFile = new File("C:\\Example", "dir\\file.txt");
        System.out.println("resolvedFile = " + resolvedFile.toPath());

        Path parentPath = Paths.get("C:\\Example");
        Path childRelativePath = Paths.get("dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("workingDirectory = " + workingDirectory.getAbsolutePath());

        System.out.println("---- print Dir2 contents");

        File dir2File = new File(workingDirectory, "FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();

        for (int i = 0; i < dir2Contents.length; i++) {
            System.out.println("i=" + i + ": " + dir2Contents[i]);
        }

        System.out.println("---- print Dir2 contents / listFiles");

        File[] dir2Files = dir2File.listFiles();

        for (int i = 0; i < dir2Files.length; i++) {
            System.out.println("i=" + i + ": " + dir2Files[i].getName());
        }


    }
}
