package Lab09_Networking_Part1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo2 {
    public static void main(String[] args){

        int port = 12;

        //서버와 데이터 입출력을 위한 스트림 생성
        BufferedReader br = null;
        PrintWriter pw = null;
        //클라이언트용 소켓 객체 생성
        Socket socket = null;

                   /*
1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
2.	The server will continue to receive until either the string <OVER> or <OUT> is received
3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
5.	If the server sends <OVER> return to step 1
6.	If the server sends <OUT> it terminates and the connection is lost
7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
 */

        try{
            System.out.println ( InetAddress.getLocalHost ().getHostAddress () );
            String serverIp = "127.0.0.1";

            //서버 연결 소켓
            socket = new Socket ( serverIp,port );

            if(socket!=null)//소켓 객체가 생성되었다면
            {
                //입출력 스트림 생성(데이터를 가져오고 보낼수 있도록)
                InputStream input = socket.getInputStream ();
                OutputStream output = socket.getOutputStream ();
                //보조 스트림 붙이기(성능개선)
                br = new BufferedReader ( new InputStreamReader ( input ) );
                pw = new PrintWriter ( output );

                //Scanner 생성
                Scanner sc = new Scanner ( System.in );

                while(true){
                    System.out.print( "Message:" );
                    String message = sc.nextLine ();

                    //client가 입력한 메세지를 서버에 보냄
                    pw.println (message);
                    //버퍼 비워주기
                    pw.flush ();
                    if(message.equals ( "OVER" )){
                        break;
                    }

                    //서버가 보낸 메세지 확인
                    String receiveMessage = br.readLine ();
                    if(!receiveMessage.equals ( "OVER" )&&!receiveMessage.equals ( "OUT" )){
                        System.out.println ( receiveMessage );
                    }
                    if(receiveMessage.equals ( "OVER" )){
                        continue;
                    }
                    if(receiveMessage.equals ( "OVER" )){
                        System.out.println ( "The connection is lost" );
                    }
                }

            }
        } catch (IOException e){
            e.printStackTrace ();
        }finally {
            try{
                br.close ();
                pw.close ();
                socket.close ();
            }catch (Exception e){

            }
        }


    }
}
