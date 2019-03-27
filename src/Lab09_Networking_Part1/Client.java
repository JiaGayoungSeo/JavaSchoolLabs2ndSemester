package Lab09_Networking_Part1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static String messageIn;
    static String messageOut;
    //static Scanner keyboardInput;

    //Declare socket to maintain connection
    //static Socket client;
    //Declare IO pathways
    //static ObjectOutputStream output;
    //static ObjectInputStream input;

    public Client(String ip){
        int port = 12345;

        //create streams to input and output data 서버와 데이터 입출력을 위한 스트림 생성
        BufferedReader br = null;
        PrintWriter pw = null;
        //create Socket object for client 클라이언트용 소켓 객체 생성
        Socket socket = null;

        try{
            System.out.println ( InetAddress.getLocalHost ().getHostAddress () );
            String serverIp = ip;

            //c서버 연결 소켓
            socket = new Socket ( serverIp,port );
            //입출력 스트림 생성(데이터를 가져오고 보낼수 있도록)
            InputStream input = socket.getInputStream ();
            OutputStream output = socket.getOutputStream ();
            //보조 스트림 붙이기(성능개선)
            br = new BufferedReader ( new InputStreamReader ( input ) );
            pw = new PrintWriter ( output );

            //Scanner 생성
            Scanner sc = new Scanner ( System.in );

            while(true){

                do{
                    System.out.print( "Message:" );
                    messageOut = sc.nextLine ();

                    //client가 입력한 메세지를 서버에 보냄
                    pw.println (messageOut);
                    //버퍼 비워주기
                    pw.flush ();
                }while(!messageOut.equals("OUT")&&!messageOut.equals("OVER"));

                if(messageOut.equals ( "OUT" )){
                    break;
                }

                do{
                    messageIn = br.readLine();
                    System.out.println ( "Server says: "+messageIn );

                }while(!messageIn.equals("OVER")&&!messageIn.equals("OUT"));

            }


        } catch (IOException e){
            e.printStackTrace ();
        }finally {
            try{
                br.close ();
                pw.close ();
                socket.close ();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args){
        Client walkieTalkie = new Client("10.52.7.167");
    }
}
