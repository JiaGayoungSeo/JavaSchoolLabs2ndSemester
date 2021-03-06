package Lab10_Networking_Part2;

import javax.annotation.processing.SupportedSourceVersion;
import javax.swing.*;
import java.io.ObjectInputStream;

public class ChatListener implements Runnable {
    private ObjectInputStream input;
    private JTextArea chatOutput;
    final static String newline = "\n";

    public ChatListener(ObjectInputStream input, JTextArea chatOutput){
        this.input = input;
        this.chatOutput = chatOutput;
    }

    public void run(){
        try{
            while(true){
                String messageIn = (String)(input.readObject ());
                chatOutput.append ( messageIn+newline );
            }
        }catch (Exception e){
            System.out.println ( e.toString () );
        }
    }
}
