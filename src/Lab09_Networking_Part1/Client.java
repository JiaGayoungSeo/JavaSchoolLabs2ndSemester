package Lab09_Networking_Part1;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static String messageIn;
    static String messageOut;
    static Scanner keyboardInput;

    //Declare socket to maintain connection
    static Socket client;
    //Declare IO pathways
    static ObjectOutputStream output;
    static ObjectInputStream input;
    static String choice;

    public static void main(String[] args){
        try{
            /*
1.	The client will continue to send until either the string <OVER> or <OUT> is sent.
2.	The server will continue to receive until either the string <OVER> or <OUT> is received
3.	When the client sends the string <OVER> it will then continue to receive until it Receives <OVER> or <OUT> from the server.
4.	When the server receives <OVER> it will continue to send until <OVER> or <OUT> is sent.
5.	If the server sends <OVER> return to step 1
6.	If the server sends <OUT> it terminates and the connection is lost
7.	If the client sends <OUT> terminate the client.  The server should still be running and awaiting more connections.
 */
            client = new Socket ( InetAddress.getByName ( "127.0.0.1"),77);

            //1. Establish IO paths between client and server
            ObjectOutputStream output = new ObjectOutputStream ( client.getOutputStream () );
            output.flush ();
            ObjectInputStream input = new ObjectInputStream ( client.getInputStream () );

            while(true){
                System.out.println ( "Please type your message: " );

                do{
                    keyboardInput = new Scanner ( System.in );
                    messageOut = keyboardInput.nextLine ();
                }while(!messageOut.equals ( "Over" )&&!messageOut.equals ( "Out" ));{
                    messageOut += keyboardInput.nextLine ();
                }
                output.writeObject ( messageOut );
                output.flush ();

                messageIn = (String)input.readObject ();

                if(messageIn.equals ( "Over" )){
                    continue;
                }
                else if(messageIn.equals ( "Out" )){
                    break;
                }
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
