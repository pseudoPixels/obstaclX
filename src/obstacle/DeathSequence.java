/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author mostaeen
 */
public class DeathSequence {
    Stage primary;
    Group root;
    int num;
    public DeathSequence(int map_no) {
        num=map_no;
        primary=new Stage();
        root=new Group();
        Scene scene=new Scene(root, 400,400);
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 50, 50, 50));
        
        
        
        Text scenetitle = new Text("Misssion Failed");
        scenetitle.setId("Game-title");
        grid.add(scenetitle, 6, 5, 4, 1);
        
        
        
        Button retry=new Button("Mainmenu");
        retry.setId("New-Game");
        grid.add(retry, 6, 6, 2, 1);
        
        
        Button quit=new Button("Quit");
        quit.setId("New-Game");
        grid.add(quit, 6, 7, 2, 1);
        
        
        
        quit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    primary.close();
                    new Obstacle().start(new Stage());
                    
                }
            }
            
        });
        
        
        retry.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    primary.close();
                    new NewGame(num,new Stage());
                    
                }
            }
            
        });
        
        root.getChildren().add(grid);
        
        scene.setFill(Color.BLACK);
        primary.setScene(scene);
        scene.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        primary.show();
        
    }
    
    
}
