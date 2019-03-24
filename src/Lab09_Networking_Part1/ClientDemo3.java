package Lab09_Networking_Part1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo3 {
    public static void main(String[] args){

        try{



            // 1. 서버의 IP와 서버의 동작 포트 값(10001)을 인자로 넣어 socket 생성

            Socket sock = new Socket("127.0.0.1", 10001);

            BufferedReader keyboard =

                    new BufferedReader(new InputStreamReader(System.in));



            // 2. 생성된 Socket으로부터 InputStream과 OutputStream을 구함

            OutputStream out = sock.getOutputStream();

            InputStream in = sock.getInputStream();



            // 3. InputStream은 BufferedReader 형식으로 변환

            //    OutputStream은 PrintWriter 형식으로 변환

            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));


            // 4. 키보드로부터 한 줄씩 입력받는 BufferedReader 객체 생성

            BufferedReader br = new BufferedReader(new InputStreamReader(in));


            String line = "";
            // 5. 키보드로부터 한 줄을 입력받음
            try {
                while(!line.equals ( "OVER" )){
                    line = keyboard.readLine ();

                    if(line.equals("OUT")) break;

                    // 6. PrintWriter에 있는 println() 메소드를 이용해 서버에게 전송

                    pw.println(line);

                    pw.flush();

                }


                String serverMessage = br.readLine ();
                while(serverMessage!=null){
                    System.out.println (serverMessage);

                }

            } catch (NullPointerException npe){
                npe.printStackTrace ();
            }



            pw.close();

            br.close();

            sock.close();

        }catch(Exception e){

            System.out.println(e);

        }

    }


}
