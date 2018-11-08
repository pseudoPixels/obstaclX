/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;


import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Control;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Admin
 */
public class Statusbar{
    Player p;
    Group root;
     HBox hb;
     double x,y,width,height;
     Rectangle rectangle;
     int life;
     ImageView im;
     Image img;
     
     
     
    /*
    ProgressBar pb;
    public Statusbar(Player b) {
        p=b;
        
        pb=new ProgressBar();
        
        pb.setProgress(0.5f);
        pb.setId("MyProgressBarGreen");
        hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.TOP_LEFT);
        hb.getChildren().addAll( pb);
        hb.setLayoutX(25.0f);
        hb.setLayoutY(25.0f);
        
        
        NewGame.root.getChildren().add(hb);
        NewGame.scene.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        
            
    }
    
    public void update()
    {
        double progress;
        progress=(double)p.getPoints()/(double)200;
        if(progress<.3)
        {
            pb.setId("MyProgressBarRed");
        }
        else pb.setId("MyProgressBarGreen");
        pb.setProgress(progress);
        
        
    }
    
    */

    public Statusbar(Player b) {
        
        p=b;
        root=new Group();
        x=25;
        y=25;
        width=400;
        height=30;
        life=b.life;
        img=new Image("C:\\test\\Life2.png");
        
        for(int i=1;i<=life;i++)
        {
            im=new ImageView(img);
            im.setX(x+width+10+i*60);
            im.setY(y);
            root.getChildren().add(im);
        }
        
        
        Line l1=new Line(x-5, y-5, x+width+5, y-5);
        l1.setFill(Color.BLACK);
        Line l2=new Line(x+width+5, y-5, x+width+5, y+height+5);
        l2.setFill(Color.BLACK);
        Line l3=new Line(x+width+5, y+height+5, x-5, y+height+5);
        l3.setFill(Color.BLACK);
        Line l4=new Line(x-5, y+height+5, x-5, y-5);
        l4.setFill(Color.BLACK);
        root.getChildren().addAll(l1,l2,l3,l4);
        
        rectangle=new Rectangle(x, y, width, height);
        rectangle.setFill(Color.GREEN);
        root.getChildren().addAll(rectangle);
        NewGame.root.getChildren().add(root);
    }
    
    
    public void update()
    {
        double progress;
        progress=p.getPoints()*2;
        rectangle.setWidth(progress);
        if(progress<100)
        {
            rectangle.setFill(Color.RED);
            
        }
        else
        {
            rectangle.setFill(Color.GREEN);
        }
        if(life!=p.life)
        {
            for(int i=1;i<=life;i++)
            {
                root.getChildren().remove(im);
                
            }
            life=p.life;
            for(int i=1;i<=life;i++)
            {
                im=new ImageView(img);
                im.setX(x+width+10+i*60);
                im.setY(y);
                root.getChildren().add(im);
            }
            
        }
        
    } 
     
     
    
}
