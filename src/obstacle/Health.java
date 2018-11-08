/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.util.Random;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Admin
 */
public class Health extends Sprite{
    Image img;
    ImageView i;
    String s;
    String type;
    int points;

    public Health(float x, float y) {
        super(x, y);
        points = -1;
        
        int num=Math.abs((new Random()).nextInt()%6)+1;
        switch(num)
        {
            case 1: setType("apple");
                    setPoints(25);
                    break;
            case 2: setType("banana");
                    setPoints(25);
                    break;
            case 3: setType("grape");
                    setPoints(15);
                    break;
            case 4: setType("health");
                    setPoints(50);
                    break; 
            case 5: setType("strawberry");
                    setPoints(40);
                    break;     
                
            default: setType("watermelon");
                     setPoints(45);   
                    break;    
        }
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
        j+="Obstacle/src/Pictures/Health/";
        j+=type+".png";
        
        System.out.println(j);
        img=new Image(j);
        i=new ImageView(img);
        
        super.setHeight(40);
        super.setWidth(40);
        
        
        
    }
    public void setType(String x)
    {
        type=new String();
        type=x;
    }
    public void setPoints(int m)
    {
        points=m;
    }
    public int getPoints()
    {
        return points;
    }
}
