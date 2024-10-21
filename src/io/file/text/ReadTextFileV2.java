package io.file.text;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class ReadTextFileV2 {

    public static final String PATH = "temp/hello2.txt";
    public static void main(String[] args) throws IOException {
        String writeString = "abc\n가나다";
        System.out.println("writeString = " + writeString);

        Path path = Path.of(PATH);

        //파일에서 쓰기
        Files.writeString(path,writeString, UTF_8);

        //파일에서 읽기
        List<String> readAllLines = Files.readAllLines(path, UTF_8);
        for (int i = 0; i <readAllLines.size(); i++) {
            System.out.println((i+1) + " : " + readAllLines.get(i));
        }


        //Files 를 사용하면 파일에 읽기 쓰기를 편리하게 사용할 수있다
    }
}
