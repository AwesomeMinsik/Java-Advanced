package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain4 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp/hello.dat");
        byte[] input = {65,66,67,68};
        fos.write(input);
        fos.close();

        FileInputStream fis = new FileInputStream("temp/hello.dat");
        byte[] readAllBytes = fis.readAllBytes();
        System.out.println(Arrays.toString(readAllBytes));

        /*readAllbyte() 저장된 byte를 한번 호출로 모두 읽을 수 있음 / 용량이 적은 파일,메모리에 모든 내용을 처리할때 편리함
           ** 저장된 용량이 예측이안되거나, 클 경우 자바 메모리 부족 예외가 발생할 수 있음 */

        fis.close();
    }
}
