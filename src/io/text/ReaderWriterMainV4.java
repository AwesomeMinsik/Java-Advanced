package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE =8192;
    public static void main(String[] args) throws IOException {

        String writeString = "V3ABCD\n가나다";
        System.out.println("==write string==");
        System.out.println("write = " + writeString);

        FileWriter fw = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bw = new BufferedWriter(fw,BUFFER_SIZE);
        bw.write(writeString);
        bw.close();

        StringBuilder content = new StringBuilder();
        FileReader fr = new FileReader(FILE_NAME, UTF_8);
        BufferedReader br = new BufferedReader(fr, BUFFER_SIZE);

        String line;

        while ((line =br.readLine()) != null){
            content.append(line).append("\n");
        }
        br.close();
//
//        int ch;
//        while ((ch = fr.read()) != -1){
//            content.append((char)ch);
//        }
//
//        fr.close();
        System.out.println("==read string==");
        System.out.println(content);
    }
}