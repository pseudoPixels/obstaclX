/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import javafx.scene.image.Image;

/**
 *
 * @author mostaeen
 */
public class hammer extends Sprite{
    
    Image img1,img2,img3,img4,img5,img6,img7;
    
    Animation Anim;
    String s;
    public hammer(float x, float y){
        super(x, y);
        SetLocation();
        points = 1;
        setVelocityX(0.0f);
        setVelocityY(0.0f);
        
        img1 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer1.png");
        img2 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer2.png");
        img3 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer3.png");
        img4 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer4.png");
        img5 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer5.png");
        img6 = new Image(s+"Obstacle\\src\\Pictures\\hammer\\hammer6.png");
        
        setImageView(img1);
        
        Anim = new Animation();
        
        Anim.addScene(img1, 100);
        Anim.addScene(img2, 100);
        Anim.addScene(img3, 100);
        Anim.addScene(img4, 100);
        Anim.addScene(img5, 100);
        Anim.addScene(img6, 100);
        
        setFlyCapability(false);
        setWidth(60);
        setHeight(50);
    }
    
    @Override
    public Animation getThisSpriteAnimation(){
        return Anim;
        
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
