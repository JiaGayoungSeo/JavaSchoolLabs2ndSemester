package Lab10_Networking_Part2;

import com.sun.media.jfxmedia.Media;
import com.sun.media.jfxmedia.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIServerDemo1 extends JFrame {

    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JButton chatSend;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ServerSocket server;
    private Socket connection;

    public GUIServerDemo1(){
        //set the title bar
        super("Server Chatter");
        //set dimensions
        setSize(500,500);
        //tell it to appear
        setVisible(true);

        ////determines the layout
        BorderLayout layout = new BorderLayout();
        setLayout( layout );


        //add some controls
        chatOutput = new JTextArea();
        chatInput = new JTextArea(3,20);
        chatInput.setLineWrap(true);
        chatSend = new JButton("Send");


        add(chatOutput, BorderLayout.CENTER);
        add(chatInput, BorderLayout.SOUTH);
        add(chatSend, BorderLayout.SOUTH);

        Panel chatInputContainer = new Panel();

        chatInputContainer.add(chatInput);
        chatInputContainer.add(chatSend);

        add( chatInputContainer,BorderLayout.SOUTH);

        chatSend.addActionListener(

                new ActionListener(){

                    public void actionPerformed( ActionEvent ae){
                        sendData(chatInput);
                    }

                    private void sendData(JTextArea out){

                        try{
                            output.writeObject(out.getText());
                            out.setText("");
                        }
                        catch( Exception e){
                            System.out.println("Oops! : "+e.toString() );
                        }
                    }
                }
        );
    }

    public void connectToClient(int port){

        try{
            server = new ServerSocket(port,100);
            connection = server.accept();
            output = new ObjectOutputStream(connection.getOutputStream());
            input = new ObjectInputStream(connection.getInputStream());
            output.flush();

        }
        catch( Exception e){
            System.out.println("Oops! : "+e.toString() );

        }
    }

    public static void main(String[] args){
        GUIServerDemo1 demo1 = new GUIServerDemo1();
        demo1.connectToClient(12345);
        ChatListener chatListener = new ChatListener(demo1.input,demo1.chatOutput);


        ExecutorService listen = Executors.newFixedThreadPool(2);
        MusicDemo3 introMusic = new MusicDemo3("D:\\COMP233 JAVA\\BarbieGirl.wav");
        listen.execute(chatListener);
        listen.execute(introMusic);

    }
}
