/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

/**
 *
 * @author Peramanathan
 */
public class AI {
    
    // Default for all game objcets if they are not
    // Specified any stgy
    public void stgy0_none(GameObject gObj){
        
        gObj.setX(gObj.getX());
        gObj.setY(gObj.getY());
        gObj.setVelocityX(gObj.getVelocityX());
        gObj.setVelocityX(gObj.getVelocityX());
    
    }
    
    public void stgy1_random(GameObject gObj){        
    
    }
    
    public void stgy2_normal(GameObject gObj){
    
    }
    
    public void stgy3_moderate(GameObject gObj){
    
    }
    
    public void stgy4_hard(GameObject gObj){
    
    }
    
    public void stgy5_kill(GameObject gObj){
    
    }
    public void stgy6_road_x(GameObject gObj){}
    
    public void stgy7_road_y(GameObject gObj){}
    
}
