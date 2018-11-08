/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Admin
 */
public class Sprite{
    int points=0;
    private float height,width;
    private float velocityX,velocityY,maxVelocityX=.2f;
    float xCor,yCor;
    private ImageView img;
    boolean fly=false,move=false;
    Animation A;
    public Sprite(float x,float y) {
        xCor=x;
        yCor=y;
        
    }
    public void setAnimation(Animation a){
        A = a;
    }
    
    public float getX()
    {
        return xCor;
    }
    
    public float getY()
    {
        return yCor;
    }
    
    public void setX(float x){
        xCor=x;
    }
    
    public void setY(float y){
        yCor=y;
    }
    
    public float getHeight()
    {
        return height;
    }
    
    public void setHeight(float x){
        height=x;
    }
    
    public float getWidth()
    {
        return width;
    }
    
    public void setWidth(float x){
        width=x;
    }
    
    public void setImageView(Image x)
    {
        
        img = new ImageView(x);
        img.setX(xCor);
        img.setY(yCor);
        
    }
    
    public ImageView getImageView()
    {
        return img;
    }
    
    public void setVelocityX(float x)
    {
        velocityX=x;
    }
    
    public void setVelocityY(float x)
    {
        velocityY=x;
    }
    
    public float getVelocityX()
    {
        return velocityX;
    }
    
    public float getVelocityY()
    {
        return velocityY;
    }
    
    public void update(){
        img.setX(xCor);
        img.setY(yCor);
        
        //A.update(20);
       //img.setImage(A.getImage());
        
        
    }
    
    public boolean  canItFly(){
        return fly;
    }
    public void  setFlyCapability(boolean y){
        fly=y;
        
    }
    public void  setMoveCapability(boolean y){
        move=y;
    }
    public boolean  canItMove(){
        return move;
    }
    
    
    public Rectangle getBounds()
    {
        Rectangle rec=new Rectangle(xCor, yCor, width, height);
        return rec;
    }
    public void setMaxVelocityX(float x)
    {
        maxVelocityX=x;
        
    }
    public void setImageViewArea(ImageView x)
    {
        img=new ImageView();
        img=x;
    }
    public void setpoints(int n)
    {
        points=n;
    }
    public int getPoints()
    {
        return points;
    }
    public void animate(String temp)
    {
        
    }
    public Animation getThisSpriteAnimation()
    {
        return null;
    }
}
