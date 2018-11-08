/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.util.Random;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Admin
 */
public class Tree extends Sprite{
    Image img;
    ImageView i;
    String s;
    
    public Tree(float x, float y) {
        super(x, y);
        xCor=x;
        yCor=y;
       
        SetLocation();
        LoadImage();
        
        i.setX(x);
        i.setY(y);
        super.setImageView(img);
        
        super.setVelocityX(0.0f);
        super.setVelocityY(0.0f);
        setMoveCapability(false);
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
        j+="Obstacle/src/Pictures/Tree/Tree";
        Integer num=Math.abs(new Random().nextInt()%13)+1;
        j+=num.toString()+".png";
        
        System.out.println(j);
        img=new Image(j);
        i=new ImageView(img);
        
        
        super.setHeight((float)img.getHeight());
        super.setWidth((float)img.getWidth());
        
        
        
    }
    
        
        
        
    
    
    
}
