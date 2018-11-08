
package obstacle;



//import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class Player extends Sprite{
    
    /////////////changed
    int life;
    boolean death;
    
    String s;
    /////////changed
    
    Image img;
    Image img1,img2,img3,img4;
    
    Image left1,left2,left3,left4,left5,left6;
    Image right1,right2,right3,right4,right5,right6;
    Image rightJump1,rightJump2,rightJump3,rightJump4,rightJump5,rightJump6,rightJump7,rightJump8,rightJump9;
    Image leftJump4,leftJump7;
    
    
    Animation heroStanding;
    Animation heroWalkingLeft;
    Animation heroWalkingRight;
    Animation heroJumpingRightUp;
    Animation heroJumapingRightDown;
    Animation heroJumpingLeftUp;
    Animation heroJumpingLeftDown;
    
    
    
    Player(float x, float y){
        super(x, y);
        SetLocation();
        /////////changed
        life=3;
        points=200;
        death=false;
        /////////changed
        
        
        setVelocityX(0.0f);
        setVelocityY(0.0f);
        img = new Image("C:\\test\\heroStanding.png");
        setImageView(img);
        
        
       
        
        //FOR HERO WALKING LEFT DIRECTION
        left1= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk1.png");
        left2= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk2.png");
        left3= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk3.png");
        left4= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk4.png");
        left5= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk5.png");
        left6= new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk left\\walk6.png");
        
        heroWalkingLeft = new Animation();
        heroWalkingLeft.addScene(left1, 50);
        heroWalkingLeft.addScene(left2, 50);
        heroWalkingLeft.addScene(left3, 50);
        heroWalkingLeft.addScene(left4, 50);
        heroWalkingLeft.addScene(left5, 50);
        heroWalkingLeft.addScene(left6, 50);
        
        
        //FOR HERO WALKING RIGHT DIRECTION
        right1 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk1.png");
        right2 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk2.png");
        right3 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk3.png");
        right4 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk4.png");
        right5 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk5.png");
        right6 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero walk\\walk6.png");
        
        heroWalkingRight = new Animation();
        heroWalkingRight.addScene(right1, 50);
        heroWalkingRight.addScene(right2, 50);
        heroWalkingRight.addScene(right3, 50);
        heroWalkingRight.addScene(right4, 50);
        heroWalkingRight.addScene(right5, 50);
        heroWalkingRight.addScene(right6, 50);
        
        
        
        //FOR HERO JUMPING RIGHT DIRECTION
        //rightJump1 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump1.png");
        //rightJump2 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump2.png");
        //rightJump3 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump3.png");
        rightJump4 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump4.png");
        //rightJump5 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump5.png");
        //rightJump6 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump6.png");
        rightJump7 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump7.png");
        //rightJump8 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump8.png");
        //rightJump9 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump right\\Hero jump\\jump9.png");
        
        heroJumpingRightUp = new Animation();
       // heroJumpingRight.addScene(rightJump1, 400);
       // heroJumpingRight.addScene(rightJump2, 400);
        //heroJumpingRightUp.addScene(rightJump3, 300);
        heroJumpingRightUp.addScene(rightJump4, 500);
        /*heroJumpingRight.addScene(rightJump5, 700);
       // heroJumpingRight.addScene(rightJump6, 500);
        heroJumpingRight.addScene(rightJump7, 300);
        heroJumpingRight.addScene(rightJump8, 300);
        heroJumpingRight.addScene(rightJump9, 400);*/
        
        heroJumapingRightDown = new Animation();
        //heroJumapingRightDown.addScene(rightJump5, 500);
        heroJumapingRightDown.addScene(rightJump7, 1000);
        
               
        //FOR HERO JUMPING LEFT
        leftJump4 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump left\\jump4.png");
        leftJump7 = new Image(s+"Obstacle\\src\\Pictures\\myHero\\Hero jump left\\jump7.png");
        
        heroJumpingLeftUp = new Animation();
        heroJumpingLeftUp.addScene(leftJump4, 1000);
        
        heroJumpingLeftDown = new Animation();
        heroJumpingLeftDown.addScene(leftJump7, 1000);
        
        //FOR HERO STANDING
        heroStanding = new Animation();
        heroStanding.addScene(right1, 150);
       
        
        
        
       
        
        setHeight(57);
        setWidth(40);
        
    }
    
    public float getMaxHeroSpeed(){
        return .009f;
    }
    
    
    @Override
    public Animation getThisSpriteAnimation(){
        
        
        
        if(getVelocityX()>0&&getVelocityY()<0)return heroJumpingRightUp;
        if(getVelocityX()>0&&getVelocityY()>0)return heroJumapingRightDown;
        
        if(getVelocityX()<0&&getVelocityY()<0)return heroJumpingLeftUp;
        if(getVelocityX()<0&&getVelocityY()>0)return heroJumpingLeftDown;
        
        if(getVelocityX()<0)return heroWalkingLeft;
        
        if(getVelocityX()>0)return heroWalkingRight;
        
        if(getVelocityX()==0)return heroStanding;
         
         return null;
        
    }
    
    
     /////////////changed
    
    @Override
    public void setpoints(int n)
    {
        points+=n;
        if(points>=200)
        {
            points=200;
            life++;
            if(life>3)
            {
                life=3;
            }
        }
        if(points<=0)
        {
            points=200;
            life--;
            if(life<=0)
            {
                death=true;
            }
        }
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
    
    
    
}



/*
public class Player extends Sprite{
    
    Animation animation;
    
    
    Image img;
    ImageView i;
    int startX,startY;
    float maxVelocity= .55f;
    float velocity=0.55f;
    
    float velocityX,velocityY;
    String str;
    
    long wait=0;
    
    public Player(float x,float y) {
        super(x, y-20);
        SetLocation();
        LoadPlayerImage();
        velocityX=0.0f;
        velocityY=0.0f;
        
        
            
        
    }
    
    
    
   
    

    
    //MAX SPEED OF THE PLAYER......
    public float getMaxHeroSpeed(){
        return .2f;
    }

    //RETURN CURRENT X
    
    
    //RETURN THE CURRENT Y
   
    
    
    
    
    
    
    
    
    
    
    public void update(float x1,float y1){
       i.setX(x1);
       i.setY(y1);
        
    }
    
   

    public void SetLocation() {
        String g1=new String();
        String j=new String();
        str=new String();
        str=this.getClass().getResource(g1).toString();
        
        
        int v=str.indexOf("Obstacle");
        for(int i=0;i<v;i++)
        {
            char ch;
            ch=str.charAt(i);
            j+=ch;
            
        }
        str=j;
        
        
        
    }

    public void LoadPlayerImage() {
        
        
        String f=new String();
        
        f="";
        f=str;
        f+="Obstacle/src/Pictures/Player/";
        f+="Player.png";
        
        img = new Image(f);
        super.setImageView(img);
        
        super.setHeight(52);
        super.setWidth(52);
        i = new ImageView(img);
        super.setImageViewArea(i);
        i.setX(xCor);
        i.setY(yCor);
        
        startX=0;
        startY=0;
        
        i.setViewport(new Rectangle2D(startX,startY, 52,52));
        
        
        
    }
    public void increaseWait(long w)
    {
        wait+=w;
        checkwait();
    }
    public void resetWait()
    {
        wait=0;
        NewGame.state.reset();
    }
    public long getWait()
    {
        return wait;
    }
    public void checkwait()
    {
        if(wait>=5000)
        {
            NewGame.state.changestatue("wait");
        }
               
    }

    @Override
    public void animate(String temp) {
        SetLocation();
        String temp2=new String();
        temp2=str;
        temp2+="Obstacle/src/Pictures/Player/";
        
        if(temp.compareTo("wait")==0)
        {
            temp2+="wait4.png";
            
            
            
        }
        else if(temp.compareTo("normal")==0)
        {
            temp2+="player.png";
            
            
            
        }
        else if(temp.compareTo("water")==0)
        {
            temp2+="water.png";
            
            
            
        }
        else if(temp.compareTo("fire")==0)
        {
            temp2+="fire.png";
            
            
            
        }
        else if(temp.compareTo("death")==0)
        {
            temp2+="death.png";
            
            
            
            
        }
        else if(temp.compareTo("hurt")==0)
        {
            temp2+="hurt.png";
            
            
        }
        else if(temp.compareTo("health")==0)
        {
            temp2+="health.png";
            
        }
        else
        {
            temp2+="player.png";
            
            
            
        }
        NewGame.root.getChildren().remove(getImageView());
        Image ij=new Image(temp2);
        ImageView fg=new ImageView(ij);

        fg.setX(getX());
        fg.setY(getY());
        setImageViewArea(fg);
        NewGame.root.getChildren().add(fg);
        
        
        
        
    }
    
      
    
}*/
