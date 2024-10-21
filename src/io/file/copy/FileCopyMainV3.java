package io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        Path source = Path.of("temp/copy.dat");
        Path target = Path.of("temp/copy_new.dat");

        Files.copy(source,target, StandardCopyOption.REPLACE_EXISTING);//Files 에서 제공하는 경로지정으로 파일 복사하기
        //StandardCopyOption.REPLACE_EXISTING = 카피옵션 설정 = REPLACE_EXISTING (기존저장내역을 source 에있는 내용으로 전부 교체)
        long endTime = System.currentTimeMillis();
        //I/O stream 보다 훨씬 빠름 = 자바에서 제공하는 Stream 을 사용하지않고 운영체제의 복사기능을 사용하기때문.
        //Files.copy 호출로 파일 복사는 자바 메모리 예외발생이 없을 것 같다.
        System.out.println("time taken = " + (endTime-startTime)+"ms");
    }
}
