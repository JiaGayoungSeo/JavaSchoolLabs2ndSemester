package Lab10_Networking_Part2;
//import com.sun.corba.se.impl.io.OutputStreamHook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class GUIChatClientInterface extends JFrame {

    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JButton chatSend;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Socket connection;



    public GUIChatClientInterface(){
        //set the title bar
        super("Client Chatter");
        //set dimensions
        setSize(500,500);
        //tell it to appear
        setVisible(true);


        ////determines the layout
        BorderLayout layout = new BorderLayout();
        setLayout( layout );

        //create a font object
        Font font = new Font("Helvetica",Font.PLAIN,15);

        //add some controls
        chatOutput = new JTextArea();
        chatInput = new JTextArea(3,20);
        chatSend = new JButton("Send");

        add(chatOutput, BorderLayout.CENTER);
        add(chatInput, BorderLayout.SOUTH);
        add(chatSend, BorderLayout.SOUTH);

        //set background color
        chatInput.setBackground(new Color(208,236,231));
        chatOutput.setBackground(new Color(249,231,159));

        //set font
        chatOutput.setFont(font);

        chatOutput.append("Client side! Let's get it started!"+"\n");

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

    public void connectToServer(){

        try{
            String targetIP =
                    JOptionPane.showInputDialog("Enter Server IP Address");
            connection = new Socket(targetIP,12345);
            output = new ObjectOutputStream(connection.getOutputStream());
            input = new ObjectInputStream(connection.getInputStream());
            output.flush();
        }
        catch( Exception e){
            System.out.println("Oops! : "+e.toString() );

        }
    }


    public static void main(String[] args){

        GUIChatClientInterface chatter = new GUIChatClientInterface();
        chatter.connectToServer();
        ChatListener chatListener = new ChatListener ( chatter.input, chatter.chatOutput );

        ExecutorService listen = Executors.newFixedThreadPool(1);
        listen.execute ( chatListener );

    }
}


