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
public class LightHouse extends GameObject{
    
    public LightHouse(EngineCore e){
        super();
        this.setIsAnimated(false);
        
        Image[] idle = { e.loadImage("images/light0000.png"), e.loadImage("images/light0001.png"),
            e.loadImage("images/light0002.png"), e.loadImage("images/light0003.png"),
            e.loadImage("images/light0004.png"), e.loadImage("images/light0005.png"),
            e.loadImage("images/light0006.png"), e.loadImage("images/light0007.png"),
            e.loadImage("images/light0008.png"), e.loadImage("images/light0009.png")};
        
        this.animSidle.loadAnim(idle);
    }
    
}
