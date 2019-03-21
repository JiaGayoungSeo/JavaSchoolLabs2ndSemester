package Lab09_Networking_Part1;


import java.io.*;
import java.net.*;
import java.util.Scanner;



//One shot server. It will listen for an incoming message, respond, and then shut down.
public class Server {

    static String messageIn; // hold the incoming message
    static String messageOut; // hold the outgoing message
    static Scanner keyboardInput;

    // creates what is called a "handshake point" for other programs(on other computers) to connect to this one
    static ServerSocket server;

    static Socket connection;

    static ObjectOutputStream outputStream; //out to client
    static ObjectInputStream inputStream; //in from client


    public static void main(String[] args){
        try{

            //open socket
            server = new ServerSocket ( 77,100 );
            //wait for client to connect
            System.out.println ( "Waiting for client to connect...." );
            connection = server.accept ();
            System.out.println ( "Client Connected !" );

            /*
1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
2.	The server will continue to receive until either the string <OVER> or <OUT> is received
3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
5.	If the server sends <OVER> return to step 1
6.	If the server sends <OUT> it terminates and the connection is lost
7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
 */


            outputStream = new ObjectOutputStream ( connection.getOutputStream () );
            outputStream.flush ();

            inputStream = new ObjectInputStream ( connection.getInputStream () );

            while(true){
                messageIn = (String)inputStream.readObject ();
                System.out.println ( "Client says: "+messageIn );
                System.out.println ( "Response! " );
                keyboardInput = new Scanner ( System.in );
                messageOut = keyboardInput.nextLine ();
                outputStream.writeObject ( messageOut );
                outputStream.flush ();

            }


        } catch (IOException ioe){
            System.out.println ( ioe.toString () );
        } catch (ClassNotFoundException cnfe){
            System.out.println ( cnfe.toString () );
        }

    }


}
