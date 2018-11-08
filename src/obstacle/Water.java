/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Admin
 */
public class Water extends Sprite{
    
    Image img;
    ImageView i;
    String s;
    Animation animation;

    public Water(float x, float y) {
        super(x, y);
        points = 1;
        SetLocation();
        LoadImage();
        i.setX(x);
        i.setY(y);
        
        super.setVelocityX(0.0f);
        super.setVelocityY(0.0f);
        setMoveCapability(false);
        
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
        animation.play();
        
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
    private void LoadImage() {
        String j=new String();
        j=s;
        j+="Obstacle/src/Pictures/Water/water.png";
        
        
        img=new Image(j);
        i=new ImageView(img);
        
        super.setHeight(40);
        super.setWidth(60);
        
        
        
    }
    
}
