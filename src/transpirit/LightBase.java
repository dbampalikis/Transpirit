/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

import Engine.EngineCore;
import java.awt.Image;
import Engine.GameObject;

/**
 *
 * @author Peramanathan
 */
public class LightBase extends GameObject {
    
    public LightBase(EngineCore e){
        super();
        this.setIsAnimated(false);
        
        Image[] idle = { e.loadImage("images/lightBase.png"), e.loadImage("images/lightBase.png")};
        
        this.animSidle.loadAnim(idle);
    
    }
    
}
