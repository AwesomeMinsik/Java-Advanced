package io.start;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.*;

public class FileWriterMain {
    public static void main(String[] args) throws IOException {
        String input = "ABC";
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, UTF_8));
        bw.write(input);
        bw.write(input);
        bw.write(input);
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(FILE_NAME, UTF_8));

        String line;

        while ((line = br.readLine()) != null){
        System.out.println(line);
        }

        br.close();
    }
}
