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
public class Chicken extends GameObject {
    
    public Chicken(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        
        Image[] runN = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] runS = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        
        Image[] attackW = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] attackE = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] attackN = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] attackS = { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        
        Image[] idleS= { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] idleN= { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        Image[] idleW= { e.loadImage("images/ch_1.png"), e.loadImage("images/ch_1.png"),e.loadImage("images/ch_2.png"), e.loadImage("images/ch_2.png")};
        
        Image[] idleE = new Image[runW.length];
        for(int i=0 ; i<idleE.length; i++){            
            idleE[i] = e.getMirrorImage(runW[i]);
            
        }
        
        Image[] runE = idleE;
        //Memory consuming??
        this.animEidle.loadAnim(idleE);
        this.animWidle.loadAnim(idleW);        
        this.animNidle.loadAnim(idleN);
        this.animSidle.loadAnim(idleS);
        this.animE.loadAnim(runE);
        this.animW.loadAnim(runW);
        this.animN.loadAnim(runN);
        this.animS.loadAnim(runS);
        this.animEattack.loadAnim(attackE);
        this.animWattack.loadAnim(attackW);
        this.animNattack.loadAnim(attackN);
        this.animSattack.loadAnim(attackS);
        
      
    } 
    
    public void AI(){
       if(Math.random() > 0.5){ 
       this.setVelocityX((float)Math.random()*(float)0.1);
       this.setVelocityY((float)Math.random()*(float)0.1);
       }
       else{
       this.setVelocityX((float)Math.random()*(float)-0.1);
       this.setVelocityY((float)Math.random()*(float)-0.1);
       }
    }
    
}
