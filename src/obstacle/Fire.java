/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;


//import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.util.Duration;

/**
 *
 * @author Admin
 */
public class Fire extends Sprite{
    Image img1;
    Image img2;
    Image img3;
    Image img;
    //ImageView i;
    String s;
    
    Animation animation;

    public Fire(float x, float y) {
        super(x, y);
        //SetLocation();
        //LoadImage();
        //i.setX(x);
        //i.setY(y);
        
        
        setVelocityX(0.0f);
        setVelocityY(0.0f);
        //setMoveCapability(false);
        //img = new Image("C:\\test\\fire1.png");
        setFlyCapability(false);
        //setImageView(img);
        
        
        /*
        img1 = new Image("C:\\test\\fire1.png");
        img2 = new Image("C:\\test\\fire2.png");
        img3 = new Image("C:\\test\\fire3.png");
        */
        
        
        
        animation = new Animation();
        animation.addScene(img1, 150);
        animation.addScene(img2, 150);
        animation.addScene(img3, 150);
        
        //img = new Image("C:\\test\\fire1.png");
        setImageView(img);
        
        setWidth(60);
        setHeight(60);
        
        /*
        i.setViewport(new Rectangle2D(0, 0, 60, 40));
        super.setImageViewArea(i);
        animation = new SpriteAnimation(
                i,
                Duration.millis(500),
                4, 4,
                0, 0,
                60, 40
        );
        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();*/
        
    }
    private void SetLocation() {
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
    /*
    private void LoadImage() {
        String j=new String();
        j=s;
        j+="Obstacle/src/Pictures/Flame/flame.png";
        
        
        img=new Image(j);
        i=new ImageView(img);
        
        super.setHeight(40);
        super.setWidth(60);
        
        
        
    }*/
    
     @Override
    public Animation getThisSpriteAnimation(){
        return animation;
    }
    
}
