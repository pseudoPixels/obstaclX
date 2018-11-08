
package obstacle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;



public class NewGame {
    
    
    Timeline t;
    public static boolean dest=false;
    
    
    Image i1;
    Image i2;
    Image i3 ;
    Animation A;
        
        
        
    public Statusbar statusbar;
    
    Image life1,life2,life3;
    ImageView l1,l2,l3;
    ArrayList Life;
    Animation heroLife;
    
    
    
    public static Stage primaryStage;
    public static Group root;
    public static Scene scene;
    public static GameAudio soundeffect;
    public static Status state;
    
    
    
    float velX=0;
    float velY=0;
    public  static  float GRAVITY = 0.009f;
    
    
    Player b;
    map myMap;
    ArrayList bricks;
    ArrayList allSprites ;
    spriteManager mySpriteManager;
    public static boolean onGround = false;
    
    String sty;
   
    
    
    public NewGame(int num,Stage s) {
        
        SetLocation();
       
        heroLife = new Animation();
        /*
        i1 = new Image("C:\\test\\heart1.png");
        i2 = new Image("C:\\test\\heart2.png");
        i3 = new Image("C:\\test\\heart3.png");
        */
        
        life1 = new Image(sty+"Obstacle\\src\\Pictures\\Life\\heart1.png");
        life2 = new Image(sty+"Obstacle\\src\\Pictures\\Life\\heart2.png");
       
        
        
        heroLife.addScene(life1, 150);
        heroLife.addScene(life2, 150);
        
        l1 = new ImageView(life1);
        l2 = new ImageView(life1);
        l3 = new ImageView(life1);
        
        l1.setX(450);
        l1.setY(0);
        l2.setX(520);
        l2.setY(0);
        l3.setX(590);
        l3.setY(0);
        
        
        
        Life = new ArrayList();
        
        Life.add(l1);
        Life.add(l2);
        Life.add(l3);
        
        
        
        A = new Animation();
        A.addScene(i1, 50);
        A.addScene(i2, 100);
        A.addScene(i3, 150);
        
        
        
        
        
       
        
        primaryStage=s;
        root=new Group();
        scene=new Scene(root,1380,690);
        primaryStage.setResizable(false);
        BackGround x=new BackGround(2, root);
        state=new Status();
        
        resourceManager rM =  new resourceManager(num,root);
        try {
            myMap = rM.loadMap();
        } catch (IOException ex) {
            System.out.println("error in loading the specified map : "+ex.getMessage());
        }
        
        
        bricks = new ArrayList();
        bricks = myMap.getMapBricks();
        b = myMap.getHero();
        
        root.getChildren().add(b.getImageView());
        for(int l=0;l<Life.size();l++){
            root.getChildren().add((ImageView)Life.get(l));
        }
        for(int h =0 ;h<bricks.size();h++){
            
            ImageView imgV = (ImageView)bricks.get(h);
            
            root.getChildren().add(imgV);
            
        }
        allSprites = myMap.getAllSprites();
       
        
        mySpriteManager = new spriteManager(bricks, allSprites, b);
        
       
        
        
        for(int g = 0;g<allSprites.size();g++){
            
            Sprite spr = (Sprite)allSprites.get(g);
            ImageView iv = spr.getImageView();
            
            root.getChildren().add(iv);
            
           
        }
        
        
        primaryStage.setScene(scene);
        inputHandler(primaryStage);
        
        soundeffect=new GameAudio();
        soundeffect.gameBackGroundMusicStart();
        
        
        statusbar=new Statusbar(b);
            
        
       
       
        t = new Timeline(new KeyFrame(Duration.millis(15), new EventHandler<ActionEvent>() {

            
            
            //MAIN PORTION OF CONTROLLING THE GAME
            //UPDATE SPRITES, HERO,.....
            @Override
            public void handle(ActionEvent arg0) {
                statusbar.update();
                updateLife();
                 
                mySpriteManager.updateHero(1000/60);
                mySpriteManager.updateAllSprites(1000/60);
                mySpriteManager.animateAllSprites();
                
                
                if(b.death || dest)
                {
                    
                    primaryStage.close();
                    timeStop();
                }
                
               
                
               
               
            }
        }));
        t.setCycleCount(Timeline.INDEFINITE);
        t.play();
        
        
        
        
        
        
        
        
        
                    
       
       
        primaryStage.show();
        primaryStage.setFullScreen(true);
        
        
        
        
    }
    
     public void SetLocation() {
        String g1=new String();
        String j=new String();
        sty=new String();
        sty=this.getClass().getResource(g1).toString();
        
        
        int v=sty.indexOf("Obstacle");
        for(int i=5;i<v;i++)
        {
            char ch;
            ch=sty.charAt(i);
            j+=ch;
            
        }
        sty=j;
        
     }
    
    public void updateLife(){
        heroLife.update(10);
        
        
        
       
        
       
        
        if(b.life==2){
            root.getChildren().remove((ImageView)Life.get(2));
            ImageView iView1 = (ImageView)Life.get(1);
        iView1.setImage(heroLife.getImage());
        }
        else if(b.life==1){
            root.getChildren().remove((ImageView)Life.get(1));
            ImageView iView0 = (ImageView)Life.get(0);
             iView0.setImage(heroLife.getImage());
        }
        else if(b.life==0){
            root.getChildren().remove((ImageView)Life.get(0));
             
        }
        else{
            ImageView iView2 = (ImageView)Life.get(2);
             iView2.setImage(heroLife.getImage()); 
        }
    }
    public void timeStop()
    {
        t.stop();
        soundeffect.GAMEBACKGROUND_CLIP.stop();
        if(b.death)
        {
            new DeathSequence(1);
        }
        else if(dest)
        {
            try {
                primaryStage.close();
                new Credit(new Stage());
                //System.exit(1);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(NewGame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
    }
    public void show()
    {
        primaryStage.show();
    }
    public void close()
    {
        primaryStage.close();
    }
    public void hide()
    {
        primaryStage.hide();
    }
    public void inputHandler(Stage p)
   {
            
            EventHandler fire = new EventHandler<KeyEvent>(){

            @Override
            public void handle(KeyEvent k) {
                
                
                if(k.getEventType()==KeyEvent.KEY_PRESSED){
                   
                   
                  
                   if(k.getCode()==KeyCode.RIGHT)
                   {
                      velX+=b.getMaxHeroSpeed();
                      //soundeffect.foot();
                      
                      
                   }
                   
                   if(k.getCode()==KeyCode.LEFT){
                      velX-=b.getMaxHeroSpeed();
                     
                   }
                   if(k.getCode()==KeyCode.UP){
                      
                         if(spriteManager.PonGround==true){
                          b.setVelocityY(-5.5f);
                          spriteManager.PonGround = false;
                          soundeffect.PlayerJump();
                          //b.resetWait();
                         }
                       
                   }
                   if(velX<.2f&&velX>-.2f)b.setVelocityX(velX);
                   
                   else{
                       if(velX>=0)b.setVelocityX(0.2f);
                       else b.setVelocityX(-.2f);
                       
                   }
                }
                else if(k.getEventType()==KeyEvent.KEY_RELEASED){
                    if(k.getCode()==KeyCode.LEFT||k.getCode()==KeyCode.RIGHT){
                    velX=0;
                    b.setVelocityX(0.0f); 
                    }
                    
                }
                
                
            }
        };

           
        p.getScene().setOnKeyPressed(fire);
        p.getScene().setOnKeyReleased(fire);
           

            
   }
    
}
