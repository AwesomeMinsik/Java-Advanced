package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class ReaderWriterMainV3 {
    public static void main(String[] args) throws IOException {
        /*      FileWriter , FileReader
           OutputStream , InoutStream 이 byte 를 다루는 I/O 클래스라면
           FileWriter , FileReader 는 문자(char,String) 를 다루는 I/O 클래스이다.
        * */
        String writeString = "V3ABCD";
        System.out.println("write = " + writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        fw.write(writeString);
        fw.close();

        /*FileWriter 는 내부에서 스스로 FileOutputStream 을 하나 생성해서 사용한다.
          어떤 데이터라도 컴퓨터에는 byte 단위로 저장되야 하기 때문에 byte 를 다루는 클래스가 필요하기 때문이다.*/

        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        int ch;
        while ((ch = fr.read()) != -1){
            content.append((char)ch);
        }

        fr.close();

        String string = content.toString();
        System.out.println("string = " + string);
    }
}
