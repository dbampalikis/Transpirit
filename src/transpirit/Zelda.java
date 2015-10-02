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
public class Zelda extends GameObject {
    
    public Zelda(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/s_w_1.png"), e.loadImage("images/s_w_2.png"),
                         e.loadImage("images/s_w_3.png"), e.loadImage("images/s_w_4.png")};
        Image[] runE = { e.loadImage("images/s_e_1.png"), e.loadImage("images/s_e_2.png"),
                         e.loadImage("images/s_e_3.png"), e.loadImage("images/s_e_4.png")};
        Image[] runN = { e.loadImage("images/s_n_1.png"), e.loadImage("images/s_n_2.png"),
                         e.loadImage("images/s_n_3.png"), e.loadImage("images/s_n_4.png")};
        Image[] runS = { e.loadImage("images/s_s_1.png"), e.loadImage("images/s_s_2.png"),};
        
        
        Image[] attackW = { e.loadImage("images/sa_w_1.png"), e.loadImage("images/sa_w_2.png"),
                            e.loadImage("images/sa_w_3.png"), e.loadImage("images/sa_w_4.png"), 
                            e.loadImage("images/sa_w_5.png"), e.loadImage("images/s_w_4.png") };
        
        Image[] attackE = { e.loadImage("images/sa_e_1.png"), e.loadImage("images/sa_e_2.png"),
                            e.loadImage("images/sa_e_3.png"), e.loadImage("images/sa_e_4.png"), 
                            e.loadImage("images/sa_e_5.png"), e.loadImage("images/s_e_1.png")};
        
        Image[] attackN = { e.loadImage("images/sa_n_1.png"), e.loadImage("images/sa_n_2.png"),
                            e.loadImage("images/sa_n_3.png"), e.loadImage("images/sa_n_4.png"), 
                            e.loadImage("images/sa_n_5.png"), e.loadImage("images/s_n_1.png")};
        
        Image[] attackS = { e.loadImage("images/sa_s_1.png"), e.loadImage("images/sa_s_2.png"),
                            e.loadImage("images/sa_s_3.png"), e.loadImage("images/sa_s_4.png"), 
                            e.loadImage("images/sa_s_5.png"), e.loadImage("images/s_ss_1.png")};
        
        Image[] idleS= { e.loadImage("images/s_ss_1.png"), e.loadImage("images/s_ss_1.png")};
        Image[] idleN= { e.loadImage("images/s_n_1.png"), e.loadImage("images/s_n_1.png")};
        Image[] idleW= { e.loadImage("images/s_w_4.png"), e.loadImage("images/s_w_4.png")};
        Image[] idleE= { e.loadImage("images/s_e_1.png"), e.loadImage("images/s_e_1.png")};
        
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
    
    
    
}
