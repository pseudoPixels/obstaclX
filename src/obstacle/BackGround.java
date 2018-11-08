/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.util.Random;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.*;
import javafx.util.Duration;


/**
 *
 * @author FED
 */
public class BackGround {
    Group root;
    int xCor,yCor;
    String s;
    public BackGround(int x,Group g) {
        root=g;
        switch(x){
            case 1: CreateBackGround01();
                    break;
            case 2:CreateBackGround02();
                   break;
        }
    }

    
    private void CreateBackGround01() {
        Rectangle colors = new Rectangle(900,600,
     new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
         Stop[]{
         
            new Stop(0.14, Color.web("#F0F8FF")),
            new Stop(0.20, Color.web("#87CEEB")),
            new Stop(0.28, Color.web("#F5F5F5")),
            new Stop(0.43, Color.web("#87CEEB")),
            new Stop(0.57, Color.web("#F5F5F5")),
            new Stop(0.71, Color.web("#87CEEB")),
            new Stop(0.85, Color.web("#F5F5F5")),
            new Stop(1, Color.web("#F5F5F5")),}));
        BoxBlur bb = new BoxBlur();
        bb.setWidth(800);
        bb.setHeight(600);
        bb.setIterations(1);
        colors.setEffect(bb);
        root.getChildren().add(colors);
        CreateCloud();
        
        
        
    }
    
    private void CreateBackGround02(){
        SetLocation();
        Image img = new Image(s+"Obstacle/src/Pictures/BG/map1.jpg");
        ImageView imgV = new ImageView(img);
        imgV.setX(0.0);
        imgV.setY(-200.0);
        
        root.getChildren().add(imgV);
        
        CreateCloud();
    }

    private void CreateCloud() {
        
        
        Random x=new Random();
        for(int i=0;i<4+(x.nextInt()%3);i++)
        {
            xCor=Math.abs(x.nextInt()%800);
            yCor=Math.abs(x.nextInt()%100)+100;
        
            int Dur=Math.abs(x.nextInt()%10000);
            int radX=x.nextInt()%5;
            int radY=x.nextInt()%5;
            
            Group l=new Group();
            
            Ellipse e3=new Ellipse(xCor, yCor, 65+radX, 40+radY);
            e3.setRotate(180);
            e3.setFill(Color.WHITE);
            l.getChildren().add(e3);
            
            
            Ellipse e5=new Ellipse(xCor-20, yCor+20, 40+radX, 35+radY);
            e5.setFill(Color.WHITE);
            l.getChildren().add(e5);
            
            Ellipse e1=new Ellipse(xCor-10, yCor-20, 35+radX, 30+radY);
            e1.setFill(Color.WHITE);
            e1.setRotate(135);
            l.getChildren().add(e1);
            
            Ellipse e2=new Ellipse(xCor-10, yCor-30, 50+radX, 30+radY);
            e2.setFill(Color.WHITE);
            e2.setRotate(180);
            l.getChildren().add(e2);
            
            Ellipse e4=new Ellipse(xCor+20, yCor-30, 35+radX, 30+radY);
            e4.setFill(Color.WHITE);
            l.getChildren().add(e4);
            
            
            root.getChildren().add(l);
            
            
            Path path = new Path();
            path.getElements().add(new MoveTo(xCor,yCor));
            path.getElements().add(new LineTo(-100, yCor));
            path.getElements().add(new MoveTo(1490, yCor));
            path.getElements().add(new LineTo(xCor, yCor));
            PathTransition pathTransition = new PathTransition();
            pathTransition.setDuration(Duration.millis(30000-Dur));
            pathTransition.setPath(path);
            pathTransition.setNode(l);
            pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pathTransition.setCycleCount(Timeline.INDEFINITE);
            pathTransition.setAutoReverse(false);
            pathTransition.play();
        }
      
            
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

}
