package Lab10_Networking_Part2;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;

public class MusicDemo3 extends Thread {
    public MusicDemo3(String filepath){
        try{

            //File file = new File("C:\\Users\\seo8556\\Downloads\\bgm.wav");
            File file = new File(filepath);

            FileInputStream fis = new FileInputStream(file);
            AudioStream as = new AudioStream(fis);
            AudioPlayer.player.start(as);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
