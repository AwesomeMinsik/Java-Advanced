package io.start;

import java.io.*;

public class Buffered {
    public static void main(String[] args) throws IOException {
        /*FileOutputStream fos = new FileOutputStream("temp/bufferd.dat");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10 * 1024 * 1024; i++){
            fos.write(1);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start); 96초*/
/*
        FileInputStream fis = new FileInputStream("temp/bufferd.dat");
        int data;
        int fileSize = 0;
        long start = System.currentTimeMillis();
        while((data = fis.read()) != -1) {
            fileSize++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(fileSize);*/

//        FileOutputStream fis = new FileOutputStream("temp/bufferd.dat");
//        BufferedOutputStream bos = new BufferedOutputStream(fis);
//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 10 * 1024 * 1024; i++){
//            bos.write(1);
//        }
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//

        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("temp/bufferd.dat"));
        int fileSize = 0;
        int data;
        long start = System.currentTimeMillis();

        while ((data = bufferedInputStream.read())!= -1){
            fileSize++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
