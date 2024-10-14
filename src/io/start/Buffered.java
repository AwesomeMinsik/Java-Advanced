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
        //버퍼 스트림은 버퍼에 대한 기능만 제공하기 때문에 대상 Stream 객체가 있어야한다.
        int fileSize = 0;
        int data;
        long start = System.currentTimeMillis();

        while ((data = bufferedInputStream.read())!= -1){
            fileSize++;
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);

        /*버퍼를 직접 구해서 읽기,쓰기 했을 때 보다 BufferedStream 사용했을때 조금 더 느린이유 예상해보기

        bufferedStream 은 읽기, 쓰기에서 lock 을 걸어두어 메서드호출이나 연산이 추가로 작동하는 것 같다.
        이는 멀티스레드 환경에서의 동시성 문제를 피하기위함이며, 버퍼를 직접구현 했을때는 로컬환경에서만 작동하므로 이에대한
        추가 메서드 구현이나, 연산이 필요없기 때문에 메서드 호출 자체로 1byte 라도 쓰이는 순간 bufferedStream 이 조금더 느릴 수 밖에없는 것 같다.

        */
    }
}
