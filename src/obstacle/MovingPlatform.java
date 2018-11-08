/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Admin
 */
public class MovingPlatform extends Sprite{
    Image img;
    ImageView i;
    String s,color;
    public MovingPlatform(float x, float y) {
        super(x, y);
        Random ran=new Random();
        int num=Math.abs(ran.nextInt())%5;
        num++;
        switch(num)
        {
            case 1: setColor("blue");
                    
                    break;
            case 2: setColor("red");
                    
                    break;
            case 3: setColor("red");
                    
                    break;
            case 4: setColor("red");
                    
                    break; 
            case 5: setColor("green");
                    
                    break;     
                
            default: setColor("red");
                       
                    break;    
        }
        SetLocation();
        LoadImage();
        i.setX(x);
        i.setY(y);
        
        super.setVelocityX(0.2f);
        super.setVelocityY(0.0f);
        setMoveCapability(true);
        setFlyCapability(true);
        
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
        j+="Obstacle/src/Pictures/MovingPlatform/";
        j+=color+".png";
        img=new Image(j);
        i=new ImageView(img);
        super.setImageView(img);
        super.setHeight((float)img.getHeight());
        super.setWidth((float)img.getWidth());
        
        
        
    }
    
    private void setColor(String l) {
        color=new String();
        color=l;
    }
    
    
}
