package Lab09_Networking_Part1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ServerDemo4 {

    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;

    //declare object to create port for incoming requests
    //declare object to maintain the connection
    static Socket connection;
    static ServerSocket server;
    static ObjectOutputStream output;
    static ObjectInputStream input;

    public static void main(String[] args){
        try{
            messageOut = "";
            server = new ServerSocket ( 22222,100 );
            while(!messageOut.equals ( "out" )){
                System.out.println ( "Waiting for the client to connect" );

                connection = server.accept ();
                System.out.println ( "Client connected!" );
                messageIn = "";

                output = new ObjectOutputStream ( connection.getOutputStream () );
                output.flush ();
                input = new ObjectInputStream ( connection.getInputStream () );

                while(!messageIn.equals ( "out" )&&!messageOut.equals ( "out" )){
                    messageIn = (String)input.readObject ();
                    System.out.println ( "Client says: " +messageIn);
                }
                if(!messageIn.equals ( "out" )){
                    messageOut = "";
                    while(!messageOut.equals ( "over" )&&!messageOut.equals ( "out" )){
                        System.out.println ( "Response: "+messageIn );
                        keyboardInput = new Scanner ( System.in );
                        messageOut = keyboardInput.nextLine ();
                        output.writeObject ( messageOut );
                        output.flush ();
                    }
                }
            }

        } catch (SocketException s){
            s.printStackTrace ();
        } catch (IOException ie){
            ie.printStackTrace ();
        } catch (ClassNotFoundException cnfe){
            cnfe.printStackTrace ();
        }

    }


}
