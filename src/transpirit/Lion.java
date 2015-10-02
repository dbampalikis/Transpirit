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
 * @author Dhoufishan
 */
public class Lion extends GameObject {
        public Lion(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/l_w_1.png"), e.loadImage("images/l_w_2.png"),
                         e.loadImage("images/l_w_3.png"), e.loadImage("images/l_w_4.png"),
                         e.loadImage("images/l_w_5.png"), e.loadImage("images/l_w_6.png"),
                         e.loadImage("images/l_w_7.png"), e.loadImage("images/l_w_8.png"),
                         e.loadImage("images/l_w_9.png")};
        
        Image[] runE = { e.loadImage("images/l_e_1.png"), e.loadImage("images/l_e_2.png"),
                         e.loadImage("images/l_e_3.png"), e.loadImage("images/l_e_4.png"),
                         e.loadImage("images/l_e_5.png"), e.loadImage("images/l_e_6.png"),
                         e.loadImage("images/l_e_7.png"), e.loadImage("images/l_e_8.png"),
                         e.loadImage("images/l_e_9.png")};
        
        Image[] runN = { e.loadImage("images/l_n_1.png"), e.loadImage("images/l_n_2.png")};
        
        Image[] runS = { e.loadImage("images/l_s_1.png"), e.loadImage("images/l_s_2.png"),
                         e.loadImage("images/l_s_3.png"), e.loadImage("images/l_s_4.png"),
                         e.loadImage("images/l_s_5.png")};
        
        Image[] attackW = { e.loadImage("images/la_w_1.png"), e.loadImage("images/la_w_2.png"),
                            e.loadImage("images/la_w_3.png"), e.loadImage("images/la_w_4.png"), 
                            e.loadImage("images/la_w_5.png")};
        
        Image[] attackE = { e.loadImage("images/la_e_1.png"), e.loadImage("images/la_e_2.png"),
                            e.loadImage("images/la_e_3.png"), e.loadImage("images/la_e_4.png"), 
                            e.loadImage("images/la_e_5.png")};
        
        Image[] attackN = { e.loadImage("images/la_e_1.png"), e.loadImage("images/la_e_2.png"),
                            e.loadImage("images/la_e_3.png"), e.loadImage("images/la_e_4.png"), 
                            e.loadImage("images/la_e_5.png")};
        
        Image[] attackS = { e.loadImage("images/la_e_1.png"), e.loadImage("images/la_e_2.png"),
                            e.loadImage("images/la_e_3.png"), e.loadImage("images/la_e_4.png"), 
                            e.loadImage("images/la_e_5.png")};
        
        Image[] idleS= { e.loadImage("images/l_s_1.png"),e.loadImage("images/l_s_1.png")};
        
        Image[] idleN= { e.loadImage("images/l_n_1.png"), e.loadImage("images/l_n_1.png")};
        
        Image[] idleW= { e.loadImage("images/l_w_1.png"), e.loadImage("images/l_w_2.png")};
        
        Image[] idleE= { e.loadImage("images/l_e_1.png"), e.loadImage("images/l_e_2.png")};
        
        // Dying frames
        Image[] die = {e.loadImage("images/explode1.png"),e.loadImage("images/explode2.png"),
                       e.loadImage("images/explode3.png"),e.loadImage("images/explode4.png"),
                       e.loadImage("images/explode5.png"), e.loadImage("images/explode6.png"),
                       e.loadImage("images/explode7.png")};
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
        
        // Dying Animation loading
        this.animDie.loadAnim(die);
      
    } 
    
    
}


