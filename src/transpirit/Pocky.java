/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

import Engine.Animation;
import Engine.EngineCore;
import java.awt.Image;
import Engine.GameObject;

/**
 *
 * @author Dhoufishan
 */
public class Pocky extends GameObject {
    
        public Pocky(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/p_w_1.png"), e.loadImage("images/p_w_2.png"),
                         e.loadImage("images/p_w_3.png"), e.loadImage("images/p_w_4.png"),
                         e.loadImage("images/p_w_5.png")};
        
        Image[] runE = { e.loadImage("images/p_e_1.png"), e.loadImage("images/p_e_2.png"),
                         e.loadImage("images/p_e_3.png"), e.loadImage("images/p_e_4.png"),
                         e.loadImage("images/p_e_5.png")};
        
        Image[] runN = { e.loadImage("images/p_n_1.png"), e.loadImage("images/p_n_2.png"),
                         e.loadImage("images/p_n_3.png"), e.loadImage("images/p_n_4.png"),
                         e.loadImage("images/p_n_5.png")};
        
        Image[] runS = { e.loadImage("images/p_s_1.png"), e.loadImage("images/p_s_2.png"),
                         e.loadImage("images/p_s_3.png"), e.loadImage("images/p_s_4.png"),
                         e.loadImage("images/p_s_5.png")};
        
        Image[] attackW = { e.loadImage("images/pa_w_1.png"), e.loadImage("images/pa_w_2.png"),
                            e.loadImage("images/pa_w_3.png"),e.loadImage("images/pa_w_4.png"),
                            e.loadImage("images/pa_w_5.png"),e.loadImage("images/pa_w_6.png")};
        
        Image[] attackE = { e.loadImage("images/pa_e_1.png"), e.loadImage("images/pa_e_2.png"),
                            e.loadImage("images/pa_e_3.png"),e.loadImage("images/pa_e_4.png"),
                            e.loadImage("images/pa_e_5.png"),e.loadImage("images/pa_e_6.png")};
        
        Image[] attackN = { e.loadImage("images/pa_n_1.png"), e.loadImage("images/pa_n_2.png"),
                            e.loadImage("images/pa_n_3.png"),e.loadImage("images/pa_n_4.png"),
                            e.loadImage("images/pa_n_5.png"),e.loadImage("images/pa_n_6.png")};
        
        Image[] attackS = { e.loadImage("images/pa_s_1.png"), e.loadImage("images/pa_s_2.png"),
                            e.loadImage("images/pa_s_3.png"),e.loadImage("images/pa_s_4.png"),
                            e.loadImage("images/pa_s_5.png"),e.loadImage("images/pa_s_6.png"),
                            e.loadImage("images/pa_s_7.png"),e.loadImage("images/pa_s_8.png")};
        
        Image[] idleS= { e.loadImage("images/p_s_3.png"), e.loadImage("images/p_s_3.png")};
        
        Image[] idleN= { e.loadImage("images/p_n_3.png"), e.loadImage("images/p_n_3.png")};
        
        Image[] idleW= { e.loadImage("images/p_w_1.png"), e.loadImage("images/p_w_1.png")};
        
        Image[] idleE= { e.loadImage("images/p_e_1.png"), e.loadImage("images/p_e_2.png")};
        
        // Dying frames
        Image[] die = {e.loadImage("images/explode1.png"),e.loadImage("images/explode2.png"),
                       e.loadImage("images/explode3.png"),e.loadImage("images/explode4.png"),
                       e.loadImage("images/explode5.png"), e.loadImage("images/explode6.png"),
                       e.loadImage("images/explode7.png")};
        
        Image pockyE = idleE[0];
        Image[] rotate = new Image[8];
        double angle =0;
        for(int i=0 ; i<rotate.length; i++){            
            rotate[i] = e.getRotatedImage(pockyE,angle);
            angle = angle+Math.PI/4;
        }
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
        this.animRotate.loadAnim(rotate);
      
    } 
    
    
}


