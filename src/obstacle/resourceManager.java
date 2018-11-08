/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.image.Image;

/**
 *
 * @author Admin
 */
public class resourceManager {
    Image brick ;
    int map_no;
    String s;
    Group root;
    public resourceManager(int x,Group gr){
        map_no=x;
        root=gr;
        SetLocation();
        
        loadMapComponentImages();
    }

    public void loadMapComponentImages(){ 
        String j=new String();
        j=s;
        j+="Obstacle/src/Pictures/Brick/";
        j+="red.png";
        brick = new Image(j);
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
    
    public map loadMap()throws IOException{
        Integer num=map_no;
        String j=new String();
        SetLocation();
        j=s;
        j+="Obstacle/src/Map/map";
        j+=num.toString();
        j+=".txt";
        System.out.println(j);
        String f=new String();
        for(int i=6;i<j.length();i++)
        {
            char g=j.charAt(i);
            if(g=='/')
            {
                g='\\';
            }
            f+=g;
        }
        j=f;
        ArrayList layers = new ArrayList();
        int width = 0;
        int height = 0;
        
        BufferedReader reader = new BufferedReader(new FileReader(j));
        
        while(true){
            String line = reader.readLine();
            
                    
            if(line == null){
                reader.close();
                break;
                
            }
            layers.add(line);
            width = Math.max(line.length(), width);
            
        }
        height = layers.size();
        
        
        map m = new map(width,height);
        
        int xCor=0,yCor=0;
        for(int y=0;y<height;y++){
             String l = (String)layers.get(y);
             
            for(int x=0;x<l.length();x++){
               char ch = l.charAt(x);
               if(ch=='A')
               {
                   m.setMapBricks(xCor, yCor,"ground");
                   xCor+=60;
               }
               else if(ch=='N'){
                   m.setMapBricks(xCor, yCor,"normal");
                   xCor+=60;
               }
               else if(ch=='R'){
                   m.setMapBricks(xCor, yCor, "rightWall");
                           xCor+=60;
               }
               else if(ch=='0'){
                   m.setMapBricks(xCor, yCor, "leftWall");
                           xCor+=60;
               }
               else if(ch=='2'){
                   m.setMapBricks(xCor, yCor, "leftWallEnding");
                   xCor+=60;
               }
               else if(ch=='3'){
                   m.setMapBricks(xCor, yCor, "rightWallEnding");
                   xCor+=60;
               }
               else if(ch=='4'){
                   m.setMapBricks(xCor, yCor, "leftRightUp");
                   xCor+=60;
               }
               else if(ch=='5'){
                   m.setMapBricks(xCor, yCor, "rightDownCorner");
                   xCor+=60;
               }
               else if(ch=='6'){
                   m.setMapBricks(xCor, yCor, "leftDownCorner");
                   xCor+=60;
               }
               else if(ch=='H')
               {
                   m.setHero(xCor,yCor+8);
                   xCor+=60;
               }
             else if(ch=='L')
               {
                   MovingPlatform A=new MovingPlatform(xCor, yCor);
                   m.addSprite(A);
                   
                   xCor+=60;
               }
             else if(ch=='!'){
                 hammer hm = new hammer(xCor, yCor);
                 m.addSprite(hm);
                 xCor+=90;
             }
               else if(ch=='W')
               {
                   Water A=new Water(xCor, yCor+20);
                   m.addSprite(A);
                   xCor+=60;
                  
                   
               }
               else if(ch=='#')
               {
                   Health A=new Health(xCor+20, yCor+20);
                   m.addSprite(A);
                   xCor+=60;
                  
                   
               }
               else if(ch=='T')
               {
                   Tree A=new Tree(xCor-60, yCor-180);
                   m.addSprite(A);
                   xCor+=60;
                   
               }
               else if(ch=='G'){
                   gravityInverter gI = new gravityInverter(xCor, yCor);
                   m.addSprite(gI);
                   m.setMapBricks(xCor, yCor, "leftDownCorner");
                   xCor+=60;
                   
               }
               else if(ch=='s'){
                   
                   angryGuy aG = new angryGuy(xCor, yCor);
                   
                   m.addSprite(aG);
                   
                   xCor+=60;
               }
               else if(ch=='F'){
                   flame fl = new flame(xCor,yCor);
                   m.addSprite(fl);
                   xCor+=60;
               }
               else if(ch=='B'){
                   flyingEnemy fE = new flyingEnemy(xCor, yCor);
                   m.addSprite(fE);
                   xCor+=60;
               }
               else if(ch=='?')
               {
                   endOfGame fE = new endOfGame(xCor, yCor);
                   m.addSprite(fE);
                   xCor+=60; 
               }
               else
               {
                   xCor+=60;
               }
                
                
            }
            yCor+=60;
            xCor=0;
        }
        
        
        return m;
    }
    
}
