/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.util.Random;
import javafx.animation.Timeline;
import javafx.scene.media.AudioClip;

/**
 *
 * @author Admin
 */
public class GameAudio {
    String s;
    AudioClip GAMEBACKGROUND_CLIP,PLAYERJUMP_CLIP,PLAYERFOOTSTEPS_CLIP,PLAYERHIT_CLIP;
    AudioClip PLAYERFALLINTOWATER_CLIP,CLICK_AUDIOCLIP,Gulp_AUDIOCLIP;
    AudioClip PLATFORM_HIT,angryGuy;
    AudioClip WATER,HAMMER,FIRE,WALK;
    public GameAudio() {
        SetLocation();
        
    }
    public void SetLocation() {
        String g1=new String();
        String j=new String();
        s=new String();
        s=this.getClass().getResource(g1).toString();
        
        
        int v=s.indexOf("Obstacle");
        for(int i=0;i<v;i++)
        {
            char ch;
            ch=s.charAt(i);
            j+=ch;
            
        }
        s=j;
        
        
    }
    
    public void gameBackGroundMusicStart()
    {
        Integer num=Math.abs((new Random().nextInt()%4))+1;
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/gamebackground1.mp3";
        
        GAMEBACKGROUND_CLIP = new AudioClip(j);
        GAMEBACKGROUND_CLIP.setCycleCount(1);
        GAMEBACKGROUND_CLIP.play();
        
    }
    public void gameBackGroundMusicStop()
    {
        GAMEBACKGROUND_CLIP.stop();
    }
    
    public void platformGotHitStart(){
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/hit1.wav";
        PLATFORM_HIT = new AudioClip(j);
        PLATFORM_HIT.setCycleCount(1);
        PLATFORM_HIT.play();
        
    }
    
    public void playerInWater(){
       String j=new String();
        j=s;
        j+="Obstacle/src/Audio/water6.wav";
        WATER = new AudioClip(j);
        WATER.setCycleCount(1);
        WATER.play(); 
    }
    public void playerInFire(){
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/Fire.mp3";
        FIRE = new AudioClip(j);
        FIRE.setCycleCount(1);
        FIRE.play(); 
    }
    public void playerWalk(){
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/walk.mp3";
        WALK = new AudioClip(j);
        WALK.setCycleCount(1);
        WALK.play(); 
    }
    public void playerCollideWithHammer(){
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/taunt.wav";
        HAMMER = new AudioClip(j);
        HAMMER.setCycleCount(1);
        HAMMER.play(); 
    }
    
    public void angryGuyStart(){
         String j=new String();
        j=s;
        j+="Obstacle/src/Audio/dinosaur2.mp3";
        angryGuy = new AudioClip(j);
        angryGuy.setCycleCount(1);
        angryGuy.play();
        
    }
    public void PlayerJump()
    {
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/jump.wav";
        
        
        GAMEBACKGROUND_CLIP = new AudioClip(j);
        GAMEBACKGROUND_CLIP.setCycleCount(1);
        GAMEBACKGROUND_CLIP.play();
    }
    public void PlayerFootSteps()
    {
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/footsteps.wav";
        
        
        PLAYERFOOTSTEPS_CLIP = new AudioClip(j);
        PLAYERFOOTSTEPS_CLIP.setCycleCount(1);
        PLAYERFOOTSTEPS_CLIP.play();
    }
    public void PlayerHit()
    {
        Integer num=Math.abs((new Random().nextInt()%4))+1;
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/hit";
        j+=num.toString()+".wav";
        
        PLAYERHIT_CLIP = new AudioClip(j);
        PLAYERHIT_CLIP.setCycleCount(1);
        PLAYERHIT_CLIP.play();
        
    }
    
    public void PlayerFallIntoWater()
    {
        Integer num=Math.abs((new Random().nextInt()%6))+1;
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/hit";
        j+=num.toString()+".wav";
        
        PLAYERFALLINTOWATER_CLIP = new AudioClip(j);
        PLAYERFALLINTOWATER_CLIP.setCycleCount(1);
        PLAYERFALLINTOWATER_CLIP.play();
        
    }
    public void allstop()
    {
        
        GAMEBACKGROUND_CLIP.stop();
       
        /*PLAYERJUMP_CLIP.stop();
        PLAYERFOOTSTEPS_CLIP.stop();
        PLAYERHIT_CLIP.stop();
        PLAYERFALLINTOWATER_CLIP.stop();
        PLATFORM_HIT.stop();
        angryGuy.stop();
        * */
        
    }
    public void foot()
    {
        String j=new String();
        j=s;
        j+="click.wav";
        
        CLICK_AUDIOCLIP = new AudioClip(j);
        CLICK_AUDIOCLIP.setCycleCount(1);
        CLICK_AUDIOCLIP.play(1);
        
    }
    public void GulpSound()
    {
        String j=new String();
        j=s;
        j+="Obstacle/src/Audio/gulp1.mp3";
        
        Gulp_AUDIOCLIP = new AudioClip(j);
        Gulp_AUDIOCLIP.setCycleCount(1);
        Gulp_AUDIOCLIP.play(1);
    }
    
}
