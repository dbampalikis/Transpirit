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
public class Jack extends GameObject {
    
    public Jack(EngineCore e){
        super();
        //Important to set, is used to determine wich objects that can be switched.
        this.setIsAnimated(true);
        this.setHealth(2000);
        
        Image[] runW = { e.loadImage("images/j_w_1.png"), e.loadImage("images/j_w_2.png"),
                         e.loadImage("images/j_w_3.png"), e.loadImage("images/j_w_4.png")};
        Image[] runE = { e.loadImage("images/j_e_1.png"), e.loadImage("images/j_e_2.png"),
                         e.loadImage("images/j_e_3.png"), e.loadImage("images/j_e_4.png")};
        Image[] runN = { e.loadImage("images/j_n_1.png"), e.loadImage("images/j_n_2.png"),
                         e.loadImage("images/j_n_3.png"), e.loadImage("images/j_n_4.png")};
        Image[] runS = { e.loadImage("images/j_s_1.png"), e.loadImage("images/j_s_2.png"),
                         e.loadImage("images/j_s_3.png"), e.loadImage("images/j_s_4.png")};
        
        Image[] attackW = { e.loadImage("images/ja_w_1.png"), e.loadImage("images/ja_w_2.png"),
                            e.loadImage("images/ja_w_3.png"), e.loadImage("images/ja_w_4.png"), e.loadImage("images/ja_w_5.png")};
        Image[] attackE = { e.loadImage("images/ja_e_1.png"), e.loadImage("images/ja_e_2.png"),
                            e.loadImage("images/ja_e_3.png"), e.loadImage("images/ja_e_4.png"), e.loadImage("images/ja_e_5.png")};
        Image[] attackN = { e.loadImage("images/ja_n_1.png"), e.loadImage("images/ja_n_2.png"),
                            e.loadImage("images/ja_n_3.png"), e.loadImage("images/ja_n_4.png"), e.loadImage("images/ja_n_5.png")};
        Image[] attackS = { e.loadImage("images/ja_s_1.png"), e.loadImage("images/ja_s_2.png"),
                            e.loadImage("images/ja_s_3.png"), e.loadImage("images/ja_s_4.png"), e.loadImage("images/ja_s_5.png")};
        
        Image[] idleS= { e.loadImage("images/j_s_2.png"), e.loadImage("images/j_s_2.png")};
        Image[] idleN= { e.loadImage("images/j_n_2.png"), e.loadImage("images/j_n_2.png")};
        Image[] idleW= { e.loadImage("images/j_w_2.png"), e.loadImage("images/j_w_2.png")};
        Image[] idleE= { e.loadImage("images/j_e_2.png"), e.loadImage("images/j_e_2.png")};
        
        Image[] die = new Image[idleE.length];
        
        for(int i=0 ; i<die.length; i++){            
            die[i] = e.getRotatedImage(idleE[i],3*Math.PI/2+Math.PI/4);            
        }
                  
                
        //Memory consuming??
        this.animEidle.loadAnim(idleE);
        this.animWidle.loadAnim(idleW);        
        this.animNidle.loadAnim(idleN);
        this.animSidle.loadAnim(idleS); // change it do idleS
        this.animE.loadAnim(runE);
        this.animW.loadAnim(runW);
        this.animN.loadAnim(runN);
        this.animS.loadAnim(runS);
        this.animEattack.loadAnim(attackE);
        this.animWattack.loadAnim(attackW);
        this.animNattack.loadAnim(attackN);
        this.animSattack.loadAnim(attackS);
        
        this.animDie.loadAnim(die);          
        
      
    } 
    
    
    
}
