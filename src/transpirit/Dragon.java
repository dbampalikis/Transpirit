/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

import Engine.EngineCore;
import Engine.GameObject;
import java.awt.Image;

/**
 *
 * @author Dhoufishan
 */
public class Dragon extends GameObject {
        public Dragon(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/d_w_1.png"), e.loadImage("images/d_w_2.png"),
                         e.loadImage("images/d_w_3.png"), e.loadImage("images/d_w_4.png"),
                         e.loadImage("images/d_w_5.png"), e.loadImage("images/d_w_6.png"),
                         e.loadImage("images/d_w_7.png"), e.loadImage("images/d_w_8.png"),
                         e.loadImage("images/d_w_9.png"), e.loadImage("images/d_w_10.png")};
        
        Image[] runE = { e.loadImage("images/d_e_1.png"), e.loadImage("images/d_e_2.png"),
                         e.loadImage("images/d_e_3.png"), e.loadImage("images/d_e_4.png"),
                         e.loadImage("images/d_e_5.png"), e.loadImage("images/d_e_6.png"),
                         e.loadImage("images/d_e_7.png"), e.loadImage("images/d_e_8.png"),
                         e.loadImage("images/d_e_9.png"), e.loadImage("images/d_e_10.png")};
        
        Image[] runN = { e.loadImage("images/d_n_1.png"), e.loadImage("images/d_n_2.png"),
                         e.loadImage("images/d_n_3.png"), e.loadImage("images/d_n_4.png"),
                         e.loadImage("images/d_n_5.png"), e.loadImage("images/d_n_6.png"),
                         e.loadImage("images/d_n_7.png"), e.loadImage("images/d_n_8.png"),
                         e.loadImage("images/d_n_9.png"), e.loadImage("images/d_n_10.png")};
        
        Image[] runS = { e.loadImage("images/d_s_1.png"), e.loadImage("images/d_s_2.png"),
                         e.loadImage("images/d_s_3.png"), e.loadImage("images/d_s_4.png"),
                         e.loadImage("images/d_s_5.png"), e.loadImage("images/d_s_6.png"),
                         e.loadImage("images/d_s_7.png"), e.loadImage("images/d_s_8.png"),
                         e.loadImage("images/d_s_9.png"), e.loadImage("images/d_s_10.png")};
        
        Image[] attackW = { e.loadImage("images/da_w_1.png"), e.loadImage("images/da_w_1.png")};
        Image[] attackE = { e.loadImage("images/da_e_1.png"), e.loadImage("images/da_e_1.png")};
        Image[] attackN = { e.loadImage("images/da_n_1.png"), e.loadImage("images/da_n_1.png")};
        Image[] attackS = { e.loadImage("images/da_s_1.png"), e.loadImage("images/da_s_1.png")};
        
        Image[] idleS= { e.loadImage("images/d_s_1.png"), e.loadImage("images/d_s_2.png"),
                         e.loadImage("images/d_s_3.png"), e.loadImage("images/d_s_4.png"),
                         e.loadImage("images/d_s_5.png"), e.loadImage("images/d_s_6.png"),
                         e.loadImage("images/d_s_7.png"), e.loadImage("images/d_s_8.png"),
                         e.loadImage("images/d_s_9.png"), e.loadImage("images/d_s_10.png")};
        
        Image[] idleN= { e.loadImage("images/d_n_1.png"), e.loadImage("images/d_n_2.png"),
                         e.loadImage("images/d_n_3.png"), e.loadImage("images/d_n_4.png"),
                         e.loadImage("images/d_n_5.png"), e.loadImage("images/d_n_6.png"),
                         e.loadImage("images/d_n_7.png"), e.loadImage("images/d_n_8.png"),
                         e.loadImage("images/d_n_9.png"), e.loadImage("images/d_n_10.png")};
        
        Image[] idleW= { e.loadImage("images/d_w_1.png"), e.loadImage("images/d_w_2.png"),
                         e.loadImage("images/d_w_3.png"), e.loadImage("images/d_w_4.png"),
                         e.loadImage("images/d_w_5.png"), e.loadImage("images/d_w_6.png"),
                         e.loadImage("images/d_w_7.png"), e.loadImage("images/d_w_8.png"),
                         e.loadImage("images/d_w_9.png"), e.loadImage("images/d_w_10.png")};
        Image[] idleE= { e.loadImage("images/d_e_1.png"), e.loadImage("images/d_e_2.png"),
                         e.loadImage("images/d_e_3.png"), e.loadImage("images/d_e_4.png"),
                         e.loadImage("images/d_e_5.png"), e.loadImage("images/d_e_6.png"),
                         e.loadImage("images/d_e_7.png"), e.loadImage("images/d_e_8.png"),
                         e.loadImage("images/d_e_9.png"), e.loadImage("images/d_e_10.png")};
        
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


