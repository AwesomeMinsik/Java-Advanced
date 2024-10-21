package io.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NewFilesMain {
    public static void main(String[] args) throws IOException {
        Path file = Path.of("temp/example.txt");
        Path dir = Path.of("temp/exampleDir");

        System.out.println("file exists = " + Files.exists(file));
        try {
            Files.createFile(file);
            System.out.println("file created");
        } catch (FileAlreadyExistsException e) {
            System.out.println(file+"file already exists");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            Files.createDirectories(dir);
        } catch (FileAlreadyExistsException e) {
            System.out.println(dir+"directory already exitst");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        Files.delete(file);
        System.out.println("file deleted");


        Files.isRegularFile(file);
        System.out.println("is file : " + Files.isRegularFile(file));
        Files.isDirectory(dir);
        System.out.println("is dir : " + Files.isDirectory(dir));

        System.out.println(file.getFileName());

        System.out.println(Files.size(file));

    }
}
