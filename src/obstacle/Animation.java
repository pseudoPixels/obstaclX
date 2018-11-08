/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;


import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author mostaeen
 */
public class Animation {
    
    private ArrayList scenes; 
    private int sceneIndex;
    private long movieTime;
    private long totalTime;
    
    //CONSTRUCTOR
    public Animation()
    {
        scenes = new ArrayList();
        totalTime=0;
        start();
    }
    
    
    //add scenes to the arrayList and set time for each of the scene
    public  synchronized void addScene(Image i, long t)
    {
        totalTime+=t;
        scenes.add(new oneScene(i,totalTime));
        
    }
    
    
    //start the animation from begging
    public synchronized void start(){
        movieTime=0;
        sceneIndex=0;
    }
    
    
    //change the scene
    public synchronized void update(long timePassed)
    {
       
        if(scenes.size()>1)
        {
            movieTime+=timePassed;
            
            if(movieTime>=totalTime)
            {
                movieTime=0;
                sceneIndex=0;
            }
            
            while(movieTime>getScene(sceneIndex).endTime)sceneIndex++;
        }
    }
    
    
    //return the current image
    public synchronized Image getImage(){
        if(scenes.size()==0){
            return null;
        }
        else {
            return getScene(sceneIndex).img;
        }
    }
    
    
    //return the single object in details(contain both image and endTime)
    public oneScene getScene(int i){
        return  (oneScene)scenes.get(i);
    }
    
    
    
    ///////// private class (may be treated as the data sturture)///////
    private class oneScene{
         Image img;
         long endTime;
        
        oneScene(Image i, long t)
        {
            img=i;
            endTime=t;
        }
    }
}

