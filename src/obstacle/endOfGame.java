/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author mostaeen
 */
public class endOfGame extends Sprite{

    Image img;
    ImageView i;
    String s;
    public endOfGame(float x, float y) {
        super(x, y);
        
        
        
        
        SetLocation();
        img = new Image(s+"Obstacle\\src\\Pictures\\Destination\\destination1.png");
        setImageView(img);
        
               
        
        super.setVelocityX(0.0f);
        super.setVelocityY(0.0f);
        setMoveCapability(false);
        setFlyCapability(true);
        setHeight(60);
        setWidth(60);
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
