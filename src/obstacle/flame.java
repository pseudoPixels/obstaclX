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
public class flame extends Sprite{
    Image img1;
    Image img2;
    Image img3;
    Image img;
    Animation Anim;
    public flame(float x, float y){
        super(x, y);
        points=1;
        setVelocityX(0.0f);
        setVelocityY(0.0f);
        
        img1 = new Image("C:\\test\\fire1.png");
        img2 = new Image("C:\\test\\fire2.png");
        img3 = new Image("C:\\test\\fire3.png");
        Anim = new Animation();
        Anim.addScene(img1, 150);
        Anim.addScene(img2, 150);
        //Anim.addScene(img3, 150);
        
        img = new Image("C:\\test\\fire1.png");
        setImageView(img);
        setFlyCapability(false);
        setWidth(60);
        setHeight(40);
    }
    
    @Override
    public Animation getThisSpriteAnimation(){
        return Anim;
    } 
}
