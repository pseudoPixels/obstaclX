/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Admin
 */
public class Obstacle extends Application {

    /**
     * @param args the command line arguments
     */
    
    MainMenuAudio mp;
    NewGame newgame;
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        mp=new MainMenuAudio();
        mp.menuStart(); 
      
        MainMenu(primaryStage);
         
    }
    
    
    void NewGameMenu()
    {
        final Stage x = new Stage();
        
        x.setFullScreen(true);
        //Grid properties and layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 50, 50, 50));
        //Grid properties and layout
        
        //Welcome text
        Text scenetitle = new Text("select map");
        scenetitle.setId("Game-title");
        grid.add(scenetitle, 6, 5, 4, 1);
        
        //Map1 button
        Button map1=new Button("Easy");
        map1.setId("New-Game");
        grid.add(map1, 6, 6, 2, 1);
        
        //Map2 button
        Button map2 = new Button("Medium");
        map2.setId("New-Game");
        grid.add(map2,6,7,2,1);
        
        //Map3 button
        Button map3 = new Button("Hard");
        map3.setId("New-Game");
        grid.add(map3,6,8,2,1);
        
        //Back button
        Button back=new Button("back");
        back.setId("New-Game");
        grid.add(back, 6, 12, 2, 1);
        
        
        
        Scene mainmenu=new Scene(grid,1380,690);
        x.setResizable(false);
        x.setScene(mainmenu);
        
        mainmenu.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        x.show();
        
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    x.close();
                    mp.click();
                    MainMenu(new Stage());
                }
            }
            
        });
        
        map1.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    x.close();
                    mp.click();
                    newgame=new NewGame(1, x);
                    mp.menuStop();
                }
            }
            
        });
        
        map2.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    x.close();
                    mp.click();
                    newgame=new NewGame(2, x);
                    mp.menuStop();
                }
            }
            
        });
        
         map3.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    x.close();
                    mp.click();
                    newgame=new NewGame(3, x);
                    mp.menuStop();
                }
            }
            
        });
        
        
        
    }
    void MainMenu(final Stage primaryStage)
    {
        //Grid properties and layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 50, 50, 50));
        //Grid properties and layout
        
        //Welcome text
        Text scenetitle = new Text("OBSTACLE GAME");
        scenetitle.setId("Game-title");
        grid.add(scenetitle, 5, 5,4, 1);
        
        //NewGame button
        Button game=new Button("New Game");
        game.setId("New-Game");
        grid.add(game, 8, 6, 2, 1);
        
        //Options
        Button option=new Button("Option");
        option.setId("New-Game");
        grid.add(option, 8, 7, 2, 1);
        
        //Quit
        Button quit=new Button("Quit");
        quit.setId("New-Game");
        grid.add(quit, 8, 8, 2, 1);
        
        
        
        Scene mainmenu=new Scene(grid,1380,690);
        primaryStage.setResizable(false);
        primaryStage.setScene(mainmenu);
        mainmenu.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        primaryStage.show();
        primaryStage.setFullScreen(true);
        
        //ActionEvents
        game.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k)  {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                        
                    mp.click();
                    
                    primaryStage.close();
                    NewGameMenu();
                }
            }
            
        });
        
         quit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    mp.click();
                    primaryStage.close();
                }
            }
            
        });
         
         option.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k)  {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                        
                    mp.click();
                    
                    primaryStage.close();
                    OptionMenu();
                    
                }
            }
            
        });
        
        
        
    }
    
    public void OptionMenu()
    {
        final Stage x = new Stage();
        
        x.setFullScreen(true);
        //Grid properties and layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.BASELINE_LEFT);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(50, 50, 50, 50));
        
        //Welcome text
        Text scenetitle = new Text("Option Menu");
        scenetitle.setId("Game-title");
        grid.add(scenetitle, 5, 5,4, 1);
        
        //NewGame button
        Button score=new Button("Highscores");
        score.setId("New-Game");
        grid.add(score, 8, 6, 2, 1);
        
        //Options
        Button credit=new Button("Credits");
        credit.setId("New-Game");
        grid.add(credit, 8, 7, 2, 1);
        
        //Quit
        Button back=new Button("Back");
        back.setId("New-Game");
        grid.add(back, 8, 8, 2, 1);
        
        
        Scene mainmenu=new Scene(grid,1380,690);
        x.setResizable(false);
        x.setScene(mainmenu);
        
        mainmenu.getStylesheets().add(Obstacle.class.getResource("mainmenustyle.css").toExternalForm());
        x.show();
        
        back.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    x.close();
                    mp.click();
                    MainMenu(new Stage());
                }
            }
            
        });
        
        score.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    
                    mp.click();
                    
                }
            }
            
        });
        
        credit.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent k) {
                if(k.getEventType()==k.MOUSE_CLICKED)
                {
                    
                    
                    mp.click();
                    x.close();
                    try {
                        new Credit(x);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Obstacle.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Obstacle.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
            
        });
        
        
        
        
        
        
        
        
    }
    
    
}
