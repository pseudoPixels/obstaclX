/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.io.*;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayerBuilder;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Admin
 */
public class MainMenuAudio {
    
    MediaPlayer menu;
    MediaPlayerBuilder builder;
    AudioClip CLICK_AUDIOCLIP,BACKGROUND_CLIP;
    Media BACKGROUND_MEDIA;
    
    
    String s;
    public MainMenuAudio() {
        String g1=new String();
        String j=new String();
        s=new String("");
        s="";
        s=this.getClass().getResource(g1).toString();
        
        
        int v=s.indexOf("Obstacle");
        for(int i=0;i<v;i++)
        {
            char ch;
            ch=s.charAt(i);
            j+=ch;
            
        }
        s=j;
        s+="Obstacle/src/Audio/";
        
    }
    
    
    public void click()
    {
        String j=new String();
        j=s;
        j+="click.wav";
        
        CLICK_AUDIOCLIP = new AudioClip(j);
        CLICK_AUDIOCLIP.setCycleCount(1);
        CLICK_AUDIOCLIP.play(1);
        
    }
    public void menuStart()
    {
        String j=new String();
        j=s;
        j+="startingMusic.mp3";
        BACKGROUND_CLIP= new AudioClip(j);
        BACKGROUND_CLIP.setCycleCount(Timeline.INDEFINITE);
        BACKGROUND_CLIP.play();
    }
    public void menuStop()
    {
      BACKGROUND_CLIP.stop();
    }
    
}
