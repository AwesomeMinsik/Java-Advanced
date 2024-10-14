package io.start;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        //디렉토리를 못찾으면 fileNotFoundException 발생, 파일은 없으면 자동생성해줌
        fos.write(65);
        fos.write(66);
        fos.write(67);
        fos.close();
        //텍스트 편집기, IDE 에서는 byte 단위 데이터를 문자로 인코딩해줌
        FileInputStream fis = new FileInputStream("temp/hello.dat");
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());

        fis.close();
    }
}
