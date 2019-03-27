package Lab09_Networking_Part1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo2 {
    static String messageIn ="";
    static String messageOut ="";

    public static void main(String[] args) throws IOException {

        int port = 12345;


        while(true){
            ServerSocket server = new ServerSocket ( port );
            System.out.println ( "Waiting for client to connect...." );
            //server 소켓으로 들어오는 클라이언트 소켓을 받음
            Socket client = server.accept ();

            //데이터를 가져오고 보낼 스트림을 연결
            InputStream input = client.getInputStream ();
            OutputStream output = client.getOutputStream ();

            //문자통신만 하기 때문에 그리고 속도 향상을 위해 보조스트림연결

            BufferedReader br = new BufferedReader ( new InputStreamReader ( input ) );
            PrintWriter pw = new PrintWriter ( output );

            //메세지를 보내고 받는 기능 구현하기
            while(true){
                Scanner sc = new Scanner ( System.in );

                do{
                    messageIn = br.readLine();
                    System.out.println ("Client Says "+messageIn );
                } while(!messageIn.equals("OVER")&&!messageIn.equals("OUT"));

                if(messageIn.equals("OUT")){
                    port++;
                    break;
                }

                do{
                    System.out.println("Response: ");
                    messageOut = sc.nextLine();
                    pw.println(messageOut);
                    pw.flush();
                }while(!messageOut.equals("OVER")&&!messageOut.equals("OUT"));

                if(messageOut.equals("OUT")){
                    System.exit(0);
                }
            }
        }
    }
}
