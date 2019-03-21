package Lab09_Networking_Part1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientDemo {
    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;


    //Declare socket to maintain connection
    static Socket client;
    //Declare IO pathways
    static ObjectOutputStream output;
    static ObjectInputStream input;


    public static void main(String[] args){
        try{
            while(true){
                client = new Socket ( InetAddress.getByName ( "127.0.0.1"),8080);

                //1. Establish IO paths between client and server
                ObjectOutputStream output = new ObjectOutputStream ( client.getOutputStream () );
                output.flush ();

                ObjectInputStream input = new ObjectInputStream ( client.getInputStream () );

                //2. Wait for out client user ti type a message
                System.out.println ( "Please type your message: " );
                keyboardInput = new Scanner ( System.in );
                messageOut = keyboardInput.nextLine ();

                //3. Send that messages to the server
                output.writeObject ( messageOut );
                output.flush ();

                //4. Wait for an incoming String object.
                messageIn = (String)input.readObject ();

                //5. Print it to the screen.
                System.out.println ( "SERVER SAYS: "+messageIn );
                messageOut = keyboardInput.nextLine ();
            }

        } catch (IOException ioe){
            System.out.println ( ioe.toString () );
        } catch (ClassNotFoundException cnfe){
            System.out.println ( cnfe.toString () );
        }

    }
}
