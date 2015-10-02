/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

import java.awt.Image;
import Engine.EngineCore;
import Engine.GameObject;

/**
 *
 * @author adam
 */
public class House extends GameObject {
    
    public House(EngineCore e){
        super();
        this.setIsAnimated(false);
        
        Image[] idle = { e.loadImage("images/house.png"), e.loadImage("images/house.png")};
        
        //Memory consuming??  
        this.animSidle.loadAnim(idle);
      
    } 
    
    
    
}

