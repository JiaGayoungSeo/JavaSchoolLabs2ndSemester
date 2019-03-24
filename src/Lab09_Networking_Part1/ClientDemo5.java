package Lab09_Networking_Part1;
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class ClientDemo5 {
    static String messageIn;
    static String messageOut;
    static Scanner keyboradInput = new Scanner(System.in);

    //declare object to maintain connection
    static Socket client;
    static ObjectOutputStream output;
    static ObjectInputStream input;
    /*
    1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
    2.	The server will continue to receive until either the string <OVER> or <OUT> is received
    3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
    4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
    5.	Idf the server sends <OVER> return to step 1
    6.	If the server sends <OUT> it terminates and the connection is lost
    7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
    */


    public static void main(String[] args) {
        try {
            messageIn = "";
            client = new Socket(InetAddress.getByName("10.52.32.13"), 12345);

            //1 establish IO path between client and server
            messageOut = "";
            ObjectOutputStream output = new ObjectOutputStream(client.getOutputStream());
            output.flush();
            ObjectInputStream input = new ObjectInputStream(client.getInputStream());
            while (!messageOut.equals("OUT") && !messageIn.equals("OUT")) {
                messageOut = "";
                while (!messageOut.equals("OUT") && !messageOut.equals("OVER") && !messageIn.equals("OUT")) {
                    //2 wait for the out client user yupe a message
                    System.out.println("Please type your message: ");
                    keyboradInput = new Scanner(System.in);
                    messageOut = keyboradInput.nextLine();
                    //3 send the message out
                    output.writeObject(messageOut);
                    output.flush();
                }
                messageIn = "";
                while (!messageIn.equals("OVER") && !messageIn.equals("OUT") && !messageOut.equals("OUT")) {
                    //4 wait for an incoming string object
                    messageIn = (String) input.readObject();

                    //5 print it to the screen
                    System.out.println("Server says: " + messageIn);
                }

            }
            client.close();

        } catch (SocketException s) {
            System.out.println(s.toString());
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (ClassNotFoundException cnfe) {
            cnfe.toString();
        }

    }
}
