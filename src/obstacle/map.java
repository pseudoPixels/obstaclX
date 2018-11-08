
package obstacle;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class map {
    
    Random x;
    int layer_no;
    Layer lay;
    
    
    float mapX=0,mapY=0;
    Image img;
    String s;
    private Image[][] mapComponents;
    
    private ArrayList bricks;
    Player b;
    private ArrayList allSprites;
    String Location;
    
    
    public map(int width, int height){
        mapComponents = new Image[width][height];
        bricks = new ArrayList();
        allSprites = new ArrayList();
        
        x=new Random();
        layer_no=Math.abs(x.nextInt()%4)+1;
        lay=new Layer(layer_no);
    }
    
    public void SetLocation() {
        String g1=new String();
        String j=new String();
        Location=new String();
        Location=this.getClass().getResource(g1).toString();
        
        
        int v=Location.indexOf("Obstacle");
        for(int i=0;i<v;i++)
        {
            char ch;
            ch=Location.charAt(i);
            j+=ch;
            
        }
        Location=j;
        
     }
    
    public int getMapWidth(){
        return mapComponents.length;
    }
    
    public int getMapHeight(){
        return mapComponents[0].length;
    }
    
    
    //RETURN THE IMAGE OF GIVEN POSITION
    public Image getMapComponents(int x, int y){
        if(x<0||x>getMapWidth()||y<0||y>getMapHeight())return null;
        else {
            return mapComponents[x][y];
        }
        
    }
    
    public void setMapComponent(int x, int y, Image img){
        mapComponents[x][y] = img;
    }
    
    
    
    public void setMapBricks(int x, int y){
        
        
        
        String j=new String();
        
        j=lay.getLayer();
        img = new Image(j);
        ImageView imV = new ImageView(img);
        imV.setX(x);
        imV.setY(y);
        
        bricks.add(imV);
        
    }
    
    public void setMapBricks(int x, int y,String brickType){
        if(brickType=="ground"){
            
            Image img1 = new Image("C:\\test\\ground.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="normal"){
            Image img1 = new Image("C:\\test\\normal.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="rightWall"){
            Image img1 = new Image("C:\\test\\rightWall.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="leftWall"){
            Image img1 = new Image("C:\\test\\leftWall.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="rightWallEnding"){
            Image img1 = new Image("C:\\test\\rightWallEnding.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="leftWallEnding"){
            Image img1 = new Image("C:\\test\\leftWallEnding.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="leftRightUp"){
            Image img1 = new Image("C:\\test\\leftRightUp.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="leftDownCorner"){
            Image img1 = new Image("C:\\test\\leftDownCorner.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        else if(brickType=="rightDownCorner"){
            Image img1 = new Image("C:\\test\\rightDownCorner.png");
            
            ImageView imV = new ImageView(img1);
            imV.setX(x);
            imV.setY(y);
            bricks.add(imV);
        }
        
    }
    
    public ArrayList getMapBricks(){
        return bricks;
    }
    
    public void setHero(int x, int y){
       b = new Player(x,y); 
       
        
    }
    
    public Player getHero(){
        return b;
    }
    
    public void addSprite(Sprite s){
        allSprites.add(s);
        
    }
    
    public ArrayList getAllSprites(){
        
        return allSprites;
    }
    
}
