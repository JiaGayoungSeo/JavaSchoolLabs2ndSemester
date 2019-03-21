package Lab09_Networking_Part1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {

        int port = 12;

                   /*
1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
2.	The server will continue to receive until either the string <OVER> or <OUT> is received
3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
5.	If the server sends <OVER> return to step 1
6.	If the server sends <OUT> it terminates and the connection is lost
7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
 */

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
                //클라이언트가 보낸 메세지를 받음
                String message = br.readLine ();

                Scanner sc = new Scanner ( System.in );

                if(!message.equals ( "Over" )&&!message.equals ( "Out" )){
                    System.out.println ( client.getInetAddress ()+" Says "+message );

                    String response = sc.nextLine ();
                    pw.println (response);
                    //버퍼 비워주기
                    pw.flush ();
                }
                else if(message.equals ( "Over" )){

                    System.out.println ( "Send the client Over or Out" );
                    String newMessage = sc.nextLine ();


                    if(newMessage.equals ( "Over" )){
                        continue;
                    }
                    if(newMessage.equals ( "Out" )){
                        System.out.println ( "It terminates and the connection is lost" );
                        System.exit ( 0 );
                    }
                    pw.println (newMessage);

                }
                if(message.equals ( "Out" )){
                    break;
                }
            }
            port++;
            continue;
        }
    }
}
