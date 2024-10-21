package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV1 {
    public static final int PORT = 12345;
    public static void main(String[] args) throws IOException {

        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 " + PORT);

        Socket socket = serverSocket.accept();

        log("소켓 연결 :" + socket);

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());


        //클라이언트 로부터 문자 받기
        String received = input.readUTF();
        log("client -> server: " + received);

        //클라이언트 에게 문자 보내기
        String toSend = received + "반갑노!";
        output.writeUTF(toSend);
        log("client <- server: " + toSend);
        
        //자원 정리
        log("연결 종료: " + socket);
        input.close();
        output.close();
        socket.close();
        serverSocket.close();
    }
}
