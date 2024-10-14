package io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {
    public static void main(String[] args) throws IOException {
        System.out.println();

        PrintStream printStream = System.out;

        byte[] bytes = "hello\n".getBytes(UTF_8);
        printStream.write(bytes);
        printStream.println("print!");

        /*ByteStream , PrintStream 모두
        I/O(InputStream, OutputStream)를 상속받는다.
        I/O Stream 은 추상클래스로 여러 입출력에 대한 작업에 필요한
        기능의 추상화하여 표준을 잡아 두었기 때문에
        다양한 환경에서 Stream 의 기능을 변경없이 동일하게 사용할 수있다.
        */
    }
}
