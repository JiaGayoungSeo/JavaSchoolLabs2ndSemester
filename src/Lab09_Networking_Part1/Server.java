package Lab09_Networking_Part1;


import java.io.*;
import java.net.*;
import java.util.Scanner;



//One shot server. It will listen for an incoming message, respond, and then shut down.
public class Server {

    static String messageIn ="";
    static String messageOut ="";

    public Server(){
        int port = 12345;

        try {
            ServerSocket server = new ServerSocket ( port );
            while(true){


                System.out.println ( "Waiting for client to connect...." );

                //server 소켓으로 들어오는 클라이언트 소켓을 받음
                Socket client = server.accept ();

                //데이터를 가져오고 보낼 스트림을 연결
                InputStream input = client.getInputStream ();
                OutputStream output = client.getOutputStream ();

                //문자통신만 하기 때문에 그리고 속도 향상을 위해 보조스트림연결

                BufferedReader br = new BufferedReader ( new InputStreamReader ( input ) );
                PrintWriter pw = new PrintWriter ( output );

                //function to send and receive messages 메세지를 보내고 받는 기능 구현하기
                while(true){
                    Scanner sc = new Scanner ( System.in );
                    //receive messages from client until client sends "OVER" or "OUT"
                    do{
                        messageIn = br.readLine();
                        System.out.println ("Client says "+messageIn );
                    } while(!messageIn.equals("OVER")&&!messageIn.equals("OUT"));
                    //if message from server is "OUT", break the loop and change port number
                    if(messageIn.equals("OUT")){
                        break;
                    }
                    //send client side messages until server sends "OVER" or "OUT"
                    do{
                        System.out.println("Response: ");
                        messageOut = sc.nextLine();
                        pw.println(messageOut);
                        pw.flush();
                    }while(!messageOut.equals("OVER")&&!messageOut.equals("OUT"));

                    if(messageOut.equals("OUT")){
                        System.out.println("Connection is lost");
                        pw.close();
                        br.close();
                        client.close();
                        server.close();
                        System.exit(0);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args){
        Server walkieTalkie = new Server();
    }
}
