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
public class gravityInverter extends Sprite{

    public gravityInverter(float x, float y) {
        super(x, y);
        setVelocityX(0.0f);
        setVelocityY(0.0f);
        Image img = new Image("C:\\test\\gravityInverter.png");
        setImageView(img);
        setFlyCapability(true);
        setWidth(64);
        setHeight(64);
    }
    
    
}
