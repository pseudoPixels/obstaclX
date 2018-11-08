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
public class flyingEnemy extends Sprite{

    Image img1;
    Image img2;
    Image img3;
    
    Image img4;
    Image img5;
    Image img6;
    
    Image img;
    Animation AnimLeft;
    Animation AnimRight;
    String s;
    public flyingEnemy(float x, float y) {
        super(x, y);
        SetLocation();
        setVelocityX(-0.1f);
        setVelocityY(0.0f);
        points = 2;
        
        img1 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flying1.png");
        img2 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flying2.png");
        img3 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flying3.png");
        
        AnimLeft = new Animation();
        AnimLeft.addScene(img1, 130);
        AnimLeft.addScene(img2, 130);
        AnimLeft.addScene(img3, 150);
        
        img4 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flyingRight1.png");
        img5 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flyingRight2.png");
        img6 = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flyingRight3.png");
        
        AnimRight = new Animation();
        AnimRight.addScene(img4, 130);
        AnimRight.addScene(img5, 130);
        AnimRight.addScene(img4, 150);
        
        img = new Image(s+"Obstacle\\src\\Pictures\\flyingEnemy\\flying1.png");
        setImageView(img);
        setFlyCapability(true);
        setWidth(60);
        setHeight(40);
        
        
    }
    
    @Override
    public Animation getThisSpriteAnimation(){
        if(getVelocityX()<0)return AnimLeft;
        else return AnimRight;
        
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
