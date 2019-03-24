package Lab09_Networking_Part1;

import java.io.*;
import java.util.Scanner;
import java.net.*;

public class ServerDemo5 {

    static String messageIn;
    static String messageOut;
    static Scanner keyboradInput = new Scanner(System.in);
    static ServerSocket server;
    static Socket connection;
    static ObjectOutputStream output;
    static ObjectInputStream input;
    /*
    1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
    2.	The server will continue to receive until either the string <OVER> or <OUT> is received
    3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
    4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
    5.	If the server sends <OVER> return to step 1
    6.	If the server sends <OUT> it terminates and the connection is lost
    7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
    */

    public static void main(String[] args) {
        try {
            messageOut = "";
            server = new ServerSocket(12345, 100);
            while (!messageOut.equals("OUT")) {
                System.out.println("Waiting for the client to connect...");
                connection = server.accept();
                System.out.println("Client connected!");
                messageIn = "";

                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());

                while (!messageIn.equals("OUT") && !messageOut.equals("OUT")) {


                    while (!messageIn.equals("OUT") && !messageIn.equals("OVER")) {

                        messageIn = (String) input.readObject();
                        System.out.println("Client says: " + messageIn);

                    }

                    if (!messageIn.equals("OUT")) {
                        messageOut = "";
                        while (!messageOut.equals("OVER") && !messageOut.equals("OUT")) {

                            System.out.println("Response: ");
                            keyboradInput = new Scanner(System.in);
                            messageOut = keyboradInput.nextLine();
                            output.writeObject(messageOut);
                            output.flush();
                        }
                    }
                }
            }
        } catch (SocketException s) {
            System.out.println(s.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException cntf) {
            System.out.println(cntf.toString());
        }
    }
}
