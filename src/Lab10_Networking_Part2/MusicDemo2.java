package Lab10_Networking_Part2;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;

public class MusicDemo2 extends Thread {

    public MusicDemo2(String file_url)
    {
        try{

            File file = new File(file_url);
            FileInputStream fis = new FileInputStream(file);
            AudioStream as = new AudioStream(fis);
            AudioPlayer.player.start(as);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("sound exception");
        }
    }
}

