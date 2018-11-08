/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author mostaeen
 */

public class spriteManager {
   
    ArrayList bricks;
    ArrayList allSprites;
    Player b;
    public static float xG=0,yG=0;
    GameAudio effect = new GameAudio();
   
    boolean PPLeftXCollision = false;
    boolean PPRightXCollision = false;
    boolean PPDownYCollsion = false;
    boolean PPUpYCollision = false;
    
    
    
    boolean PSLeftXCollision = false;
    boolean PSRightXCollision = false;
    boolean PSDownYCollsion = false;
    boolean PSUpYCollision = false;
    
    
    boolean bool=false,hit=false;
    
    public static boolean PonGround=false;
    public float PnewX,PnewY,PoldX,PoldY,PnewvelX,PnewvelY,PoldvelX,PoldvelY;
    public float SnewX,SnewY,SoldX,SoldY;
    
    public spriteManager(ArrayList bricks, ArrayList allSprites, Player b){
       this.bricks = bricks;
       this.allSprites = allSprites;
       this.b = b;
        
    }
    
    
  
    public void checkPlayerPlatformCollisionDirectionAll(float newX,float newY)
    {
        hit=false;
        for(int i=0;i<bricks.size();i++)
        {
            
           ImageView  view = (ImageView)bricks.get(i);
           Rectangle A=new Rectangle(newX, newY,b.getWidth()-1,b.getHeight()-1);
           Rectangle B=new Rectangle(view.getX(), view.getY(), 60, 60);
           if(A.intersects(view.getX(), view.getY(), 60, 60))
           {
               hit=true;
               break;
               
           }
                      
           
            
        }
        
    }
   
   public void HandlePlayerPlatformCollision(long t)
   {
       PoldX = b.getX();
       PnewX = PoldX + b.getVelocityX()*t;
       PoldvelX=b.getVelocityX();
       PnewvelX=b.getVelocityX();
       
       PoldvelY = b.getVelocityY();
       PnewvelY = b.getVelocityY()+NewGame.GRAVITY*t/2;
       PoldY = b.getY();
       PnewY = PoldY +  b.getVelocityY()+NewGame.GRAVITY*t/2;
       
       
       
       
       
       
       
           
       if(PnewvelX!=0)
       {
           checkPlayerPlatformCollisionDirectionAll(PnewX, PoldY);
           if(!hit)
           {
               fixGameCameraPosition(PnewX);
           }
       }
       
       if(PnewY!=0)
       {
           checkPlayerPlatformCollisionDirectionAll(PoldX, PnewY);
           if(hit)
           {
               if(PnewvelY>0)
               {
                    PonGround=true;
                    b.setY(PoldY);
                    b.setVelocityY(0.0f);
                   
               }
               else
               {
                   b.setVelocityY(NewGame.GRAVITY*t);
                   
               }
               
           }
           else
           {
               b.setY(PnewY);
               b.setVelocityY(PnewvelY+NewGame.GRAVITY*t/2);
               b.update();
                
           }
           
       }
       
       
       
       
       
       
   }
   
   public boolean checkPlayerSpriteCollision(float x,float y)
   {
        for(int i=0;i<allSprites.size();i++)
        {
           Sprite A=(Sprite)allSprites.get(i); 
        
           
           Rectangle temp=new Rectangle(A.getX(),A.getY(),A.getWidth()-1,A.getHeight()-1);
            
           if(temp.intersects(x,y,b.getWidth(),b.getHeight()))
           {
               return true;
           }
        }
       
       
        return false;
   }
   
     
   public void updateHero(long t){
       
       
       HandlePlayerPlatformCollision(t);
       HandlePlayerSpriteCollision(t);
       
   }
   
   public void updateAllSprites(long t)
   {
       
       
       for(int i =0 ;i<allSprites.size();i++){
           
           Sprite sprA = (Sprite)allSprites.get(i);
           SoldX = sprA.getX();
           SnewX = SoldX + sprA.getVelocityX()*t;
           SoldY = sprA.getY();
           SnewY = SoldY + sprA.getVelocityY()*t;
           for(int j=0;j<allSprites.size();j++)
           {
               if(i!=j)
               {
                   Sprite sprB = (Sprite)allSprites.get(j);
                   Rectangle A=new Rectangle(SnewX, SnewY, sprA.getWidth()-1, sprA.getHeight()-1);
                   
                   if(A.intersects(sprB.getX(), sprB.getY(),sprB.getWidth()-1 , sprB.getHeight()-1))
                   {
                    
                        HandleSpriteSpriteCollision(sprA,sprB);
                   }
               }
           }
       }
       
       
       for(int i =0 ;i<allSprites.size();i++){
           Sprite sprA = (Sprite)allSprites.get(i);
           SoldX = sprA.getX();
           SnewX = SoldX + sprA.getVelocityX()*t;
          
         
           
           
           boolean flag = false;
           for(int j=0;j<bricks.size();j++)
           {
                ImageView  view = (ImageView)bricks.get(j);
                Rectangle temp=new Rectangle(view.getX(),view.getY(),60-1,60-1);
            
                if(temp.intersects(SnewX,sprA.getY(),sprA.getWidth()-1,sprA.getHeight()-1))
                {
                        flag = true;
                        break;
                }
               
           }
           if(flag==false){
               
               sprA.setX(SnewX);
               sprA.update();
               
           }
           else {
               HandleSpritePlatformCollision(sprA);
           }
           
       
       }
       
       
       for(int i =0 ;i<allSprites.size();i++){
           
           Sprite sprA = (Sprite)allSprites.get(i);
           
           
           if(sprA.canItFly()==false){
               sprA.setVelocityY(sprA.getVelocityY()+NewGame.GRAVITY*t);
               
           }
           float newY = sprA.getY()+ sprA.getVelocityY()*t;
           
          
         
           
           
           boolean flag = false;
           for(int j=0;j<bricks.size();j++)
           {
                ImageView  view = (ImageView)bricks.get(j);
                Rectangle temp=new Rectangle(view.getX(),view.getY(),60-1,60-1);
            
                if(temp.intersects(sprA.getX(),newY,sprA.getWidth()-1,sprA.getHeight()-1))
                {
                        flag = true;
                        break;
                }
               
           }
           if(flag==false){
               
               sprA.setY(newY);
               sprA.update();
               
           }
           else {
               
               sprA.setVelocityY(0.0f);
           }
            
       }
      
       
   }
    
   public void HandleSpriteSpriteCollision(Sprite A,Sprite B)
   {
       
       if(A instanceof MovingPlatform)
       {
           
           A.setVelocityX(-A.getVelocityX());
           if(B instanceof MovingPlatform)effect.platformGotHitStart();
           
       }
       if(A instanceof Player)
       {
           if(B instanceof endOfGame)
           {
               NewGame.dest=true;
                
           }
           if(B instanceof flame){
               
               A.setpoints(-B.getPoints());
               effect.playerCollideWithHammer();
             
           }
           if(B instanceof hammer){
               A.setpoints(-B.getPoints());
               effect.playerCollideWithHammer();
               
               
                 
           }
           
           if(B instanceof Water){
               A.setpoints(-B.getPoints());
               effect.playerInWater();
           }
           if(B instanceof flyingEnemy){
               A.setpoints(-B.getPoints());
               effect.playerCollideWithHammer();
               if(PSUpYCollision)
               {
                     
                     A.setY(PoldY);
                     A.setVelocityY(NewGame.GRAVITY*2);
                     A.update();
                }
               else if(PSLeftXCollision || PSRightXCollision)
                   {
                       if(PSLeftXCollision)
                       {
                           
                            PnewX=B.getX()+B.getWidth()+1;
                          
                       }
                       else if(PSRightXCollision)
                       {
                           
                            PnewX=B.getX()-A.getWidth()-1;
                            
                       }
                       checkPlayerPlatformCollisionRightDirection();
                       checkPlayerPlatformCollisionLeftDirection();
                       if(!PPRightXCollision && !PPLeftXCollision)
                       {
                            fixGameCameraPosition(PnewX);
                           
                            A.update();
                       }
                       else
                       {
                           B.setVelocityX(-B.getVelocityX());
                       }
                   
                   
                   
               }
               
               
           }
           
           if(B instanceof Health)
           {
               A.setpoints(A.getPoints()+B.getPoints());
               NewGame.root.getChildren().remove(B.getImageView());
               allSprites.remove(B);
               NewGame.state.changestatue("health");
                ////Changed
               A.setpoints(B.getPoints());
               effect.GulpSound();
           }
           
           if(B instanceof angryGuy){
               
               A.setpoints(-2);
               effect.playerCollideWithHammer();
               
           }
           
           if(B instanceof MovingPlatform)
           {
               if(PSDownYCollsion)
               {
                   
                   A.setX(PoldX);
                   A.setY(PoldY);
                   A.setVelocityX(B.getVelocityX());
                   A.setVelocityY(0.0f);
                   PonGround=true;
                   A.update();
                   
                   
                   
               }
               
               
               else if(PSUpYCollision)
               {
                     
                     A.setY(PoldY);
                     A.setVelocityY(NewGame.GRAVITY*2);
                     A.update();
                }
                else if(PSLeftXCollision || PSRightXCollision)
                   {
                       if(PSLeftXCollision)
                       {
                           
                            PnewX=B.getX()+B.getWidth()+1;
                          
                       }
                       else if(PSRightXCollision)
                       {
                           
                            PnewX=B.getX()-A.getWidth()-1;
                            
                       }
                       checkPlayerPlatformCollisionRightDirection();
                       checkPlayerPlatformCollisionLeftDirection();
                       if(!PPRightXCollision && !PPLeftXCollision)
                       {
                            fixGameCameraPosition(PnewX);
                           
                            A.update();
                       }
                       else
                       {
                           B.setVelocityX(-B.getVelocityX());
                       }
                   
                   
                   
               }
               
               
           }
          
           
           if(B instanceof gravityInverter){
              
               
               if(Math.round(yG)!=Math.round(A.getY() ) ){
                   if(Math.round(yG)>Math.round(A.getY())){
                       if(Math.round(yG)-Math.round(A.getY())>=54)NewGame.GRAVITY = - NewGame.GRAVITY;
                   }
                   else {
                       if(Math.round(A.getY())-Math.round(yG)>=54)NewGame.GRAVITY = - NewGame.GRAVITY;
                   }
                   
                   yG = A.getY();
               }
              
           }
           if(B instanceof Water){
             A.setpoints(-B.getPoints());
           }
           
           
           
           
       }
       
   }
   
   public void HandleSpritePlatformCollision(Sprite A)
   {
       if(A instanceof MovingPlatform)
       {
           A.setVelocityX(-A.getVelocityX());
           if(A.getX()>=0&&A.getX()<=1380)effect.platformGotHitStart();
       }
       
      
       
       else if(A instanceof angryGuy){
           A.setVelocityX(-A.getVelocityX());
           
       }
       else if(A instanceof flyingEnemy){
           A.setVelocityX(-A.getVelocityX());
          
       }
       
   }
   public void fixGameCameraPosition(float newX){
       
       if(b.getX()<512){
       b.setX(newX);
       b.update();
       }
       else {
       float offsetX = newX - 512;
       
       b.setX(512);
       b.update();
       for(int i = 0;i<bricks.size();i++){
           ImageView iView = (ImageView)bricks.get(i);
           iView.setX(iView.getX()-offsetX);
           
       }
      
       
       for(int m =0;m<allSprites.size();m++){
           Sprite spr = (Sprite)allSprites.get(m);
           
            spr.setX(spr.getX()-offsetX);
           
       }
       }
       
   }
   
   public void HandlePlayerSpriteCollision(long t)
   {
       
       for(int i=0;i<allSprites.size();i++)
       {
           Sprite sprA=(Sprite)allSprites.get(i);
           if(sprA instanceof Tree){
               
           }
           else{
            Rectangle A=new Rectangle(PnewX, PnewY, b.getWidth(), b.getHeight());
                   
                   if(A.intersects(sprA.getX(), sprA.getY(),sprA.getWidth(),sprA.getHeight()))
                   {
                       if(sprA instanceof MovingPlatform || sprA instanceof flyingEnemy || sprA instanceof hammer){
                       PSLeftXCollision = false;
                       PSRightXCollision = false;
                       PSDownYCollsion = false;
                       PSUpYCollision = false;
                       
                       checkPlayerSpriteCollisionDirection(b, sprA);
                       
                       //HandleSpriteSpriteCollision(b,sprA);
                       }
                       HandleSpriteSpriteCollision(b,sprA);
                       
                   }
           
       }
       }
   }
   
   public void checkPlayerPlatformCollisionRightDirection(){
       for(int u = 0; u< bricks.size();u++){
           ImageView  view = (ImageView)bricks.get(u);
           Rectangle A=new Rectangle(PnewX+52-10, PoldY+2,10,b.getHeight()-2);
           Rectangle B=new Rectangle(view.getX(), view.getY()+2, 10, 60-2);
           PPRightXCollision=A.intersects(B.getX(),B.getY(),B.getWidth(),B.getHeight());
           if(PPRightXCollision)
           {
               break;
           }
       }
       
       
       
   }
   
   
    public void checkPlayerPlatformCollisionLeftDirection(){
       for(int u = 0; u< bricks.size();u++){
           ImageView  view = (ImageView)bricks.get(u);
           Rectangle A=new Rectangle(PnewX, PoldY+2,10,b.getHeight()-2);
           Rectangle B=new Rectangle(view.getX()+60-10, view.getY()+2, 10, 60-2);
           PPLeftXCollision=A.intersects(B.getX(),B.getY(),B.getWidth(),B.getHeight());
           if(PPLeftXCollision)
           {
               break;
           }
           
       }
    }
    
    public void checkPlayerPlatformCollisionUpDirection(){
       for(int u = 0; u< bricks.size();u++){
           ImageView  view = (ImageView)bricks.get(u);
           Rectangle A=new Rectangle(PnewX+2, PnewY,b.getWidth()-2,10);
           Rectangle B=new Rectangle(view.getX()+2, view.getY()+60-10, 60-2, 10);
           PPUpYCollision=A.intersects(B.getX(),B.getY(),B.getWidth(),B.getHeight());
           if(PPUpYCollision)
           {
              
               break;
           }
       }
    }
    
    public void checkPlayerPlatformCollisionDownDirection(){
       for(int u = 0; u< bricks.size();u++){
           ImageView  view = (ImageView)bricks.get(u);
           Rectangle A=new Rectangle(PnewX+2, PnewY+42,b.getWidth()-2,10);
           Rectangle B=new Rectangle(view.getX()+2, view.getY(), 60-10, 10);
           PPDownYCollsion=A.intersects(B.getX(),B.getY(),B.getWidth(),B.getHeight());
           if(PPDownYCollsion)
           {
               
               break;
           }
       }
    }
    
   /*
   public void checkPlayerSpriteCollisionDirection(Sprite sprA,Sprite sprB)
   {
       
       Rectangle A=new Rectangle(sprA.getX()+sprA.getWidth()-10, sprA.getY()+2, 10, sprA.getHeight()-2);
       Rectangle B=new Rectangle(sprB.getX(), sprB.getY()+2,10, sprB.getHeight()-2);
       PSRightXCollision=A.intersects(B.getX(), B.getY(), B.getWidth(), B.getHeight());
       if(PSRightXCollision)
       {
           System.out.println("Right");
           return;
       }
       A=new Rectangle(sprA.getX(), sprA.getY()+2, 10, sprA.getHeight()-2);
       B=new Rectangle(sprB.getX()+sprB.getWidth()-10, sprB.getY()+2,10, sprB.getHeight()-2);
       PSLeftXCollision=A.intersects(B.getX(), B.getY(), B.getWidth(), B.getHeight());
       if(PSLeftXCollision)
       {
           System.out.println("Left");
           return;
       }
       A=new Rectangle(sprA.getX()+2, sprA.getY(),sprA.getWidth()-2, 10);
       B=new Rectangle(sprB.getX()+2, sprB.getY()+sprB.getHeight()-10,sprB.getWidth()-2, 10);
       PSUpYCollision=A.intersects(B.getX(), B.getY(), B.getWidth(), B.getHeight());
       if(PSUpYCollision)
       {
           System.out.println("Up");
           return;
       }
       A=new Rectangle(sprA.getX()+2, sprA.getY()+sprA.getHeight()-10,sprA.getWidth()-2, 10);
       B=new Rectangle(sprB.getX()+2, sprB.getY(),sprB.getWidth()-2, 10);
       PSDownYCollsion=A.intersects(B.getX(), B.getY(), B.getWidth(), B.getHeight());
       if(PSDownYCollsion)
       {
           System.out.println("Down");
       }
       
   }
   */
    
    public void checkPlayerSpriteCollisionDirection(Sprite sprA,Sprite sprB){
        
        
        //STARTED HERE>...........................................................
        if(sprB.getVelocityX()==0){
            /*if(sprA.getVelocityX()>0&& (PnewX<sprB.getX()) ){
                PSRightXCollision = true;
                PSLeftXCollision = false;
                return;
            }
            if(sprA.getVelocityX()<0){
                
                PSLeftXCollision  = true;
                PSRightXCollision = false;
                return;
            }*/
            HandlePlayerPlatformCollision(15);
            if(sprA.getVelocityX()>=0&&PnewX+54>=sprB.getX()-10&&PnewX+64<=sprB.getX()-10+54){
                PSRightXCollision = true;
                PSLeftXCollision = false;
                return;
            }
            
            
        }
        
            
            
            
            
            
            
         //SHOULD FINISH HERE........................................................   
        if(sprA.getVelocityY()>0 && (PoldY+sprA.getHeight())<=sprB.getY()){
            PSDownYCollsion=true;
            PSUpYCollision=false;
            return;
            
        }
        if(sprA.getVelocityY()<0 && PoldY>=(sprB.getY()+sprB.getHeight()))
        {
            PSDownYCollsion=false;
            PSUpYCollision=true;
            return;
            
        }
        
        
        
        //right
        if(sprA.getVelocityX()>=0 &&sprB.getVelocityX()<0){
            PSRightXCollision=true;
            PSLeftXCollision=false;
            return;
            
        }
        if(sprA.getVelocityX()>=0&&sprB.getVelocityX()>0&&sprA.getX()<sprB.getX()){
            PSRightXCollision=true;
            PSLeftXCollision=false;
            return;
            
        }
        if(sprA.getVelocityX()<=0&&sprB.getVelocityX()<0&&sprA.getX()<sprB.getX()){
            PSRightXCollision=true;
            PSLeftXCollision=false;
            return;
            
        }
        
        
        //left
        
        if(sprA.getVelocityX()<=0 &&sprB.getVelocityX()>0){
            PSLeftXCollision=true;
            PSRightXCollision=false;
            return;
            
        }
        if(sprA.getVelocityX()>=0&&sprB.getVelocityX()>0&&sprA.getX()>sprB.getX()){
            PSLeftXCollision=true;
            PSRightXCollision=false;
            return;
        }
        if(sprA.getVelocityX()<=0&&sprB.getVelocityX()<0&&sprA.getX()>sprB.getX()){
            PSLeftXCollision=true;
            PSRightXCollision=false;
            return;
            
        }
        
        //up
        
        
        
        
    }
    
    public void animateAllSprites(){
        for(int g = 0;g<allSprites.size();g++){
            
                   Sprite spr = (Sprite)allSprites.get(g);
                   if(spr instanceof angryGuy || spr instanceof flame || spr instanceof flyingEnemy || spr instanceof hammer){
                   ImageView iv = spr.getImageView();
                   Animation aN = spr.getThisSpriteAnimation();
                   aN.update(10);
                   iv.setImage(aN.getImage());
                   }
            
            
           
        }
        ImageView iView = b.getImageView();
        Animation animate = b.getThisSpriteAnimation();
        animate.update(10);
        iView.setImage(animate.getImage());
        
    }
            
   
   
}
