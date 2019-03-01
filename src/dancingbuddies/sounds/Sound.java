/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingbuddies.sounds;

import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;

/**
 *
 * @author Dell
 */
public class Sound {
    
    public Sound()
    {
        music();
    }
    public void music()
    {
        AudioPlayer BGP= AudioPlayer.player;
        AudioStream BGM;
        AudioData AD;
        ContinuousAudioDataStream loop=null;
         
        try
        {
            InputStream test=new FileInputStream("sunflower.wav");
         BGM= new AudioStream(test);
         
         //Loop required!!!
         
         
         //AD=BGM.getData();
         //loop= new ContinuousAudioDataStream(AD);
          AudioPlayer.player.start(BGM);
        }
        catch(Exception e)
        {
           e.printStackTrace();
        }
        //BGP.start(loop);
    }
}
