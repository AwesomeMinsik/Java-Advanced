package io.file;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OldFileMain {
    public static void main(String[] args) throws IOException {
        File file = new File("temp/example.txt");
        File directory = new File("temp/exampleDir");

        System.out.println("file exists : " + file.exists());
        
        boolean created = file.createNewFile();
        System.out.println("file created : " + created);

        boolean dirCreated = directory.mkdir();
        System.out.println(" directory Created : " + dirCreated);
//        boolean deleted = file.delete();
//        System.out.println("file deleted = " + deleted);
        System.out.println("is file :"+file.isFile());
        System.out.println("is dir :"+directory.isDirectory());
        System.out.println("file name :" + file.getName());
        System.out.println("file size" + file.length()+"byte");// 파일의 byte 크기반환


        File newFile = new File("temp/newExample.txt");
        boolean renamed = file.renameTo(newFile);
        System.out.println("file renamed : " + renamed);

        long lastModified = newFile.lastModified();
        System.out.println("file lastModified : " +new Date(lastModified));
    }

}
