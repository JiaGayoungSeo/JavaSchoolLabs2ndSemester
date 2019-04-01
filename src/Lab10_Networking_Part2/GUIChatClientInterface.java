package Lab10_Networking_Part2;
import javax.swing.*;


public class GUIChatClientInterface extends JFrame {
    public GUIChatClientInterface(){
        //set the title bar
        super("Chatter");
        //set dimensions
        setSize(500,500);
        //tell it to appear
        setVisible(true);
    }

    public static void main(String[] args){
        GUIChatClientInterface chatter = new GUIChatClientInterface();
    }
}
