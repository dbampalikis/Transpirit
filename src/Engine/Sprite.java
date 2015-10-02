/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.Image;
/**
 *
 * @author adam
 */
public class Sprite {
    
    public Animation animW;
    public Animation animE;
    public Animation animN;
    public Animation animS;
    public Animation animWidle;
    public Animation animEidle;
    public Animation animNidle;
    public Animation animSidle;
    public Animation animWattack;
    public Animation animEattack;
    public Animation animNattack;
    public Animation animSattack;
    public Animation animDie;
    public Animation animRotate;
    
    private Animation currAnim;
    private Animation preAnim;
    private float x;
    private float y;
    private float dx;
    private float dy;
    private String name;
    private String dir;
    private String prevDir;
    private int state;
    
        
    public Sprite(){
       this.animE = new Animation();
       this.animW = new Animation();
       this.animN = new Animation();
       this.animS = new Animation();
       this.animEidle = new Animation();
       this.animWidle = new Animation();
       this.animNidle = new Animation();
       this.animSidle   = new Animation();
       this.animEattack = new Animation();
       this.animWattack = new Animation();
       this.animNattack = new Animation();
       this.animSattack = new Animation();
       this.animDie = new Animation();
       this.animRotate = new Animation();
       
       this.preAnim = new Animation();
       this.dir = "S";
       this.prevDir = "NO";
       this.changeState(1);
    }
    
    
    public void update(long elapsedTime){
        x += dx * elapsedTime;
        y += dy * elapsedTime;
    }
    
    public float getX(){
        return x;
    }
    
    public float getY(){
        return y;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
    public void setY(float y){
        this.y = y;
    }
    
    public void setDir(String dr){
        this.dir = dr;
    }
    
    public void setPrevDir(String dr){
        this.prevDir = dr;
    }
    
    public void changeState(int st){
        this.state = st;
        this.setAnim();
    }
    
    private void setAnim(){
        
               
       //state = 1 is idle animation  
       if(this.state == 1){
            if(dir.equals("S") || dir.equals("s"))
                this.currAnim = this.animSidle;
            if(dir.equals("N") || dir.equals("n"))
                this.currAnim = this.animNidle;
            if(dir.equals("E") || dir.equals("e"))     
                this.currAnim = this.animEidle;
            if(dir.equals("W") || dir.equals("w"))
                this.currAnim = this.animWidle;  
       } 
       //state = 2 is run animation  
       else if(state == 2){
            if(dir.equals("S") || dir.equals("s"))
                this.currAnim = this.animS;
            if(dir.equals("N") || dir.equals("n"))
                this.currAnim = this.animN;
            if(dir.equals("E") || dir.equals("e"))     
                this.currAnim = this.animE;
            if(dir.equals("W") || dir.equals("w"))
                this.currAnim = this.animW;
            
       } 
       //state = 3 is jump animation  
       else if(state == 3){
           
       } 
       //state = 4 is attack animation  
       else if(state == 4){
           if(dir.equals("S"))
                this.currAnim = this.animSattack;
           if(dir.equals("N"))
                this.currAnim = this.animNattack;
           if(dir.equals("E"))
                this.currAnim = this.animEattack;
           if(dir.equals("W"))
                this.currAnim = this.animWattack;      
       } 
       
       // die
       else if(state == 5){
           this.currAnim = this.animDie;
       }
       
       this.setAnim(this.currAnim);
  
           
    }
    
    public String getDir(){
        return this.dir;
    }
    
    public String getPrevDir(){
        return this.prevDir;
    }
        
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    
    }
    
    public int getHeight(){
        return currAnim.getImage().getHeight(null);
    }
    
    public int getWidth(){
        return currAnim.getImage().getWidth(null);
    }
    
    public float getVelocityY(){
        return dy;
    }
    
    public float getVelocityX(){
        return dx;
    }
    
    public void setVelocityX(float dx){
        this.dx = dx;
    }
    
    public void setVelocityY(float dy){
        this.dy = dy;
    }
    
    public Image getImage(){
        return currAnim.getImage();
    }
    
    public Animation getAnim(){
        return this.currAnim;
    }
    public Animation getPreAnim(){
        return this.preAnim;
    }
    
    public void setAnim(Animation a){
        
        if(this.currAnim != this.animSattack && 
                this.currAnim != this.animNattack &&
                this.currAnim != this.animEattack &&
                this.currAnim != this.animWattack)
            this.preAnim = this.currAnim;
        
        this.currAnim = a;
    }
    
    public int getState(){
        return this.state;
    } 
}
