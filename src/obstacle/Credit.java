/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;



import java.io.*;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;



/**
 *
 * @author FED
 */
public class Credit {
    
    String credit[];
    int count=0;
    String s;
    Stage p;
    Stage x;
    Scene mainmenu;
    
    public Credit(Stage primary) throws FileNotFoundException, IOException {
        SetLocation();
        credit=new String[100];
        p=primary;
        
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;
        System.out.println(s);
        try {
            inputStream = new BufferedReader(new FileReader(s+"Obstacle\\src\\Credit\\credit.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                
                if(l.compareTo("")!=0)
                {
                    credit[count++]=l;
                }
                l="";
                
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
        
        for(int i=0;i<count;i++)
        {
            System.out.println(credit[i]);
        }
        ViewCredit();
        
    }
    
    public void SetLocation() {
        String g1=new String();
        String j=new String();
        s=new String();
        s=this.getClass().getResource(g1).toString();
        
        
        int v=s.indexOf("Obstacle");
        for(int i=5;i<v;i++)
        {
            char ch;
            ch=s.charAt(i);
            if(ch=='/')
            {
                ch='\\';
            }
            j+=ch;
            
        }
        s=j;
        
     }
    
     public void ViewCredit()
     {
         x = new Stage();
         x.setFullScreen(true);
        //Grid properties and layout
         
         /*
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 50, 50, 50));
        * */
         
        Group b=new Group();
        Group c=new Group();
        Group root=new Group();
        Button ext=new Button("Exit Game");
        ext.setId("New-Game");
        b.getChildren().add(ext);
        
        for(int i=0;i<count;i++)
        {
            Text scenetitle = new Text(credit[i]);
            scenetitle.setId("Game-title");
            scenetitle.setX(600);
            scenetitle.setY(i*50);
            root.getChildren().add(scenetitle);
        }
        
        
        
        Path path = new Path();
        path.getElements().add(new MoveTo(800,0));
        path.getElements().add(new LineTo(800,900));
        path.getElements().add(new MoveTo(800,-400));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setPath(path);
        pathTransition.setNode(root);
        pathTransition.setOrientation(PathTransition.OrientationType.NONE);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(false);
        pathTransition.play();
        
        mainmenu=new Scene(c,1380,690);
        mainmenu.setFill(Color.BLACK);
        x.setResizable(false);
        x.setScene(mainmenu);
        
        c.getChildren().addAll(b,root);
        
        
        ext.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    x.close();
                    //p.show();
                    System.exit(1);
                    
                    
                    
                    
                    
                    
                }
            }
            
        });
        
        
        x.setFullScreen(true);
        x.show();
        mainmenu.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        
        
     }
    
}
