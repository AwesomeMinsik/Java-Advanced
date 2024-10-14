package io.text;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV2 {
    public static void main(String[] args) throws IOException {
        String writeString = "ABCD";
        System.out.println("write = " + writeString);
        
        //파일에 쓰기
        FileOutputStream fos = new FileOutputStream(FILE_NAME);
        OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);

        osw.write(writeString);
        osw.close();

        //파일에 읽기

        FileInputStream fis = new FileInputStream(FILE_NAME);
        InputStreamReader isr = new InputStreamReader(fis, UTF_8);
        //문자 바이트로 인코딩, 바이트 문자로 디코딩을 자동으로해주는 reader, writer

        StringBuilder sb = new StringBuilder();
        int ch;// -1 을 담을수없는 char 형식을 대신해 int 로 받기위함
        while ((ch = isr.read()) != -1){
            sb.append((char) ch);
        }
        isr.close();
        System.out.println("read String = " + sb);


    }
}
