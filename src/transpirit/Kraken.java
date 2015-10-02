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
public class Kraken extends GameObject {
        public Kraken(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/k_w_1.png"), e.loadImage("images/k_w_2.png"),
                         e.loadImage("images/k_w_3.png"), e.loadImage("images/k_w_4.png")};
        
        Image[] runE = { e.loadImage("images/k_e_1.png"), e.loadImage("images/k_e_2.png"),
                         e.loadImage("images/k_e_3.png"), e.loadImage("images/k_e_4.png")};
        
        Image[] runN = { e.loadImage("images/k_n_1.png"), e.loadImage("images/k_n_2.png"),
                         e.loadImage("images/k_n_3.png"), e.loadImage("images/k_n_4.png")};
        
        Image[] runS = { e.loadImage("images/k_s_1.png"), e.loadImage("images/k_s_2.png"),
                         e.loadImage("images/k_s_3.png"), e.loadImage("images/k_s_4.png")};
        
        Image[] attackW = { e.loadImage("images/ka_w_1.png"), e.loadImage("images/ka_w_2.png"),
                            e.loadImage("images/ka_w_3.png")};
        
        Image[] attackE = {  e.loadImage("images/ka_e_1.png"), e.loadImage("images/ka_e_2.png"),
                            e.loadImage("images/ka_e_3.png")};
        
        Image[] attackN = { e.loadImage("images/ka_n_1.png"), e.loadImage("images/ka_n_2.png")};
        
        Image[] attackS = { e.loadImage("images/ka_s_1.png"), e.loadImage("images/ka_s_2.png")};
        
        Image[] idleS= { e.loadImage("images/k_s_1.png"),e.loadImage("images/k_s_1.png")};
        
        Image[] idleN= { e.loadImage("images/k_n_1.png"), e.loadImage("images/k_n_1.png")};
        
        Image[] idleW= { e.loadImage("images/k_w_1.png"), e.loadImage("images/k_w_1.png")};
        
        Image[] idleE= { e.loadImage("images/k_e_1.png"), e.loadImage("images/k_e_1.png")};
        
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


