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
public class angryGuy extends Sprite{
    Image img;
    Animation Anim;
    Image i1;
    Image i2;
    Image i3 ;
    Image i4 ;
    Image i5 ;
    
    public angryGuy(float x, float y){
        super(x, y);
        points = 3;
        setVelocityX(0.09f);
        setVelocityY(0.0f);
         i1 = new Image("C:\\test\\man1.png");
         i2 = new Image("C:\\test\\man2.png");
         i3 = new Image("C:\\test\\man3.png");
         i4 = new Image("C:\\test\\man4.png");
         i5 = new Image("C:\\test\\man5.png");
        
        Anim = new Animation();
        Anim.addScene(i1, 90);
        Anim.addScene(i2, 90);
        Anim.addScene(i3, 90);
        Anim.addScene(i4, 90);
        Anim.addScene(i5, 90);
        
        
        img = new Image("C:\\test\\angryMan.png");
        setImageView(img);
        setFlyCapability(false);
        setWidth(60);
        setHeight(55);
        
    }
    @Override
    public Animation getThisSpriteAnimation(){
        return Anim;
    }
    
}
