package io.text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV1 {
    public static void main(String[] args) throws IOException {
        //인코딩
        String writeString ="ABC";
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println("writeBytes = " + Arrays.toString(writeBytes));

        //파일에서 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        fos.write(writeBytes);
        fos.close();

        //파일에서 읽기
        FileInputStream fis = new FileInputStream(FILE_NAME);
        byte[] readAllBytes = fis.readAllBytes();
        System.out.println("readAllBytes = " + Arrays.toString(readAllBytes));
        fis.close();

        //byte -> String UTF-8 디코딩


        String readString = new String(readAllBytes, UTF_8);
        System.out.println("readAllBytes = " + Arrays.toString(readAllBytes));
        System.out.println("readString = " + readString);
    }
}
