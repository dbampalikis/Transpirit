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
public class Hexen extends GameObject {
        public Hexen(EngineCore e){
        super();
        this.setIsAnimated(true);
        this.setHealth(30);
        
        Image[] runW = { e.loadImage("images/m_w_1.png"), e.loadImage("images/m_w_2.png"),
                         e.loadImage("images/m_w_3.png"), e.loadImage("images/m_w_4.png"),
                         e.loadImage("images/m_w_5.png")};
        
        Image[] runE = { e.loadImage("images/m_e_1.png"), e.loadImage("images/m_e_2.png"),
                         e.loadImage("images/m_e_3.png"), e.loadImage("images/m_e_4.png"),
                         e.loadImage("images/m_e_5.png")};
        
        Image[] runN = { e.loadImage("images/m_n_1.png"), e.loadImage("images/m_n_2.png"),
                         e.loadImage("images/m_n_3.png"), e.loadImage("images/m_n_4.png")};
        
        Image[] runS = { e.loadImage("images/m_s_1.png"), e.loadImage("images/m_s_2.png"),
                         e.loadImage("images/m_s_3.png"), e.loadImage("images/m_s_4.png")};
        
        Image[] attackW = { e.loadImage("images/ma_w_1.png"), e.loadImage("images/ma_w_2.png"),
                            e.loadImage("images/ma_w_3.png")};
        
        Image[] attackE = { e.loadImage("images/ma_e_1.png"), e.loadImage("images/ma_e_2.png"),
                            e.loadImage("images/ma_e_3.png")};
        
        Image[] attackN = { e.loadImage("images/ma_n_1.png"), e.loadImage("images/ma_n_2.png"),
                            e.loadImage("images/ma_n_3.png")};
        
        Image[] attackS = { e.loadImage("images/ma_s_1.png"), e.loadImage("images/ma_s_2.png"),
                            e.loadImage("images/ma_s_3.png")};
        
        Image[] idleS= runS;
        
        Image[] idleN= runN;
        
        Image[] idleW= runW;
        
        Image[] idleE= runE;
        
        // Dying frames
        Image[] die = {e.loadImage("images/explode1.png"),e.loadImage("images/explode2.png"),
                       e.loadImage("images/explode3.png"),e.loadImage("images/explode4.png"),
                       e.loadImage("images/explode5.png"), e.loadImage("images/explode6.png"),
                       e.loadImage("images/explode7.png")};
        
        Image[] idleNlied = new Image[idleS.length];
        for(int i=0 ; i<idleNlied.length; i++){            
            idleNlied[i] = e.getRotatedImage(idleS[i],Math.PI);        
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
      
    } 
    
    
}


