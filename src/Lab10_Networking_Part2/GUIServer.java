package Lab10_Networking_Part2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class GUIServer {
    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;

    //declare object to create port for incoming requests
    static ServerSocket server;
    //declare object to maintain the connection
    static Socket connection;

    static ObjectOutputStream output;
    static ObjectInputStream input;


    public static void main(String[] args){
        try{
            server = new ServerSocket ( 12345,100 );
            System.out.println ( "Waiting for client to connect...." );
            connection = server.accept ();
            System.out.println ( "Client Connected !" );

            //1. Establish IO paths between client and server
            output = new ObjectOutputStream ( connection.getOutputStream () );
            output.flush ();

            input = new ObjectInputStream ( connection.getInputStream () );

            //2. wait for incoming String object
            messageIn = (String)input.readObject ();

            System.out.println ( "Client Says: "+ messageIn );

            //4. Wait for our server administrator (that's us) to type a response
            System.out.println ( "Response! " );
            keyboardInput = new Scanner ( System.in );
            messageOut = keyboardInput.nextLine ();

            //5. Send that response back to the client
            output.writeObject ( messageOut );
            output.flush ();


        } catch (IOException ioe){
            System.out.println ( ioe.toString () );
        } catch (ClassNotFoundException cnfe){
            System.out.println ( cnfe.toString () );
        }

    }
}
