package Lab10_Networking_Part2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIChatClientInterface extends JFrame {

    private JTextArea chatInput;
    private JTextArea chatOutput;
    private JButton chatSend;

    public GUIChatClientInterface(){
        //set the title bar
        super("Chatter");
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
        chatSend = new JButton("Out");


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

                            System.out.println( out.getText() );

                        }

                        catch( Exception e){

                            System.out.println("Oops! : "+e.toString() );

                        }

                    }


                }
        );


    }

    public static void main(String[] args){
        GUIChatClientInterface chatter = new GUIChatClientInterface();
    }
}
