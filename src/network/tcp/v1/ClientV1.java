package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV1 {
    public static final int PORT = 12345; 
    /* 위의 12345 포트가 이미 다른 프로세스에서 실행중이거나 12345 포트로 서버를 실행한 상태로 종료하지 않는다면  BindException 이 발생한다.
     포트값을 변경하던가, 예제의 서버는 꼭 종료하자 IntelliJ 에서 해당 서버가 실행중에 종료하면 안내 팝업이 뜨는데,
     이때 반드시 Terminate 로 종료해야한다. Disconnect 로 종료할시 서버 프로세스가 죽지않고 계속 유지되어 포트를 사용할 수없다.*/
    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");
        Socket socket = new Socket("localhost", PORT);
//        socket.getInputStream();외부에 데이터 보낼때
//        socket.getOutputStream();외부 데이터 받을때
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        log("소캣 연결 : "+ socket);

        //서버에게 문자보내기
        Scanner scanner = new Scanner(System.in);
        String toSend = scanner.nextLine();
        output.writeUTF(toSend);

        log("client -> server: " + toSend);

        //서버로부터 문자 받기

        String received = input.readUTF();
        log("client <- server: " + received);

        //자원 정리
        log("연결 종료"+ socket);
        input.close();
        output.close();
        socket.close();

    }
}
