/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

/**
 *
 * @author Admin
 */
public class Status {
    private boolean water;
    private boolean normal;
    private boolean fire;
    private boolean death;
    private boolean wait;
    private boolean hurt;
    private boolean health;
    
    String str;

    public Status() {
        water=false;
        normal=true;
        fire=false;
        death=false;
        wait=false;
        hurt=false;
        health=false;
        
        str=new String();
        str="normal";
    }
    
    public void changestatue(String j)
    {
        water=false;
        normal=false;
        fire=false;
        death=false;
        wait=false;
        hurt=false;
        health=false;
        str=new String();
        str=j;
        
        if(str.compareTo("water")==0)
        {
            water=true;
        }
        else if(str.compareTo("normal")==0)
        {
            normal=true;
        }
        else if(str.compareTo("fire")==0)
        {
            fire=true;
        }
        else if(str.compareTo("death")==0)
        {
            death=true;
        }
        else if(str.compareTo("wait")==0)
        {
            wait=true;
        }
        else if(str.compareTo("hurt")==0)
        {
            hurt=true;
        }
        else if(str.compareTo("health")==0)
        {
            health=true;
        }
    }
    
    public String getstatus()
    {
        return str;
    }
    
    public void reset()
    {
        water=false;
        normal=true;
        fire=false;
        death=false;
        wait=false;
        hurt=false;
        health=false;
        
        str=new String();
        str="normal";
    }
    
}
