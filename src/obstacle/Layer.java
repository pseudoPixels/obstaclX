/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package obstacle;

/**
 *
 * @author Admin
 */
public class Layer {
    int layer_no;
    String color,s;
    int cycle,count;
    
    public Layer(int num) {
        SetLocation();
        layer_no=num;
        count=1;
        switch(num)
        {
            case 1: setColor("baked");
                    setCycle(15);
                    break;
            case 2: setColor("style");
                    setCycle(15);
                    break;
            case 3: setColor("mixed");
                    setCycle(25);
                    break;
            case 4: setColor("sand");
                    setCycle(14);
                    break; 
                
            default: setColor("mixed");
                     setCycle(25);   
                    break;    
        }
    }

    private void setColor(String l) {
        color=new String();
        color=l;
    }

    private void setCycle(int x) {
        cycle=x;
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
    
    public String getLayer()
    {
        Integer n;
        n=count;
        String j=new String();
        j=s;
        j+="Obstacle/src/Pictures/Brick/";
        j+=color;
        j+=n.toString();
        j+=".png";
        count=(count)%cycle+1;
        return j;
        
    }
}
    
    
    

