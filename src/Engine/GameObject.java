/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;
import transpirit.*;
import Engine.Sprite;
import java.awt.Image;
/**
 *
 * @author adam
 */
public abstract class GameObject extends Sprite {
    
    private boolean hasCollision;
    private boolean isAnimated;
    static final float SPEED = 0.05f;
    private int currHealth;
    private int health;
    
    private String nature;
    private int total;
    private int stgy;
    
    
    
    //What type of state the object is in. 
    // Run, attack, idle, jump
    
    
    public void attack(){
        //Change state to attack => changes animation according to current direction
        this.changeState(4);
       
    }
    
    public void die(){
    
    }
    public void jump(){
        //this.setState(3);
        this.setX(this.getX()+10.0f);
    }
    
    public void run(String dir){
        
        this.setDir(dir);
        this.changeState(2);
        
        //Ensure that velocity is zero before determining new velocity
        this.setVelocityX(0);
        this.setVelocityY(0);
        
        if(!this.getCollision()){
             this.setPrevDir("NO");
             if(dir.equals("W"))
                this.setVelocityX(-SPEED); 
             if(dir.equals("E"))
                this.setVelocityX(SPEED);  
             if(dir.equals("S"))
                this.setVelocityY(SPEED);  
             if(dir.equals("N"))
                this.setVelocityY(-SPEED);  
      
        }
        else{
            if(this.getPrevDir().equals("NO")){
                if(dir.equals("S")){
                    this.setPrevDir("S");   
                }
                if(dir.equals("N")){
                    this.setPrevDir("N");    
                }
                if(dir.equals("E")){
                    this.setPrevDir("E");  
                }
                if(dir.equals("W")){
                    this.setPrevDir("W"); 
                } 
            }
            else{
                if (dir.equals("N") && this.getPrevDir().equals("S"))
                    this.setVelocityY(-SPEED);
                else if (dir.equals("S") && this.getPrevDir().equals("N"))
                    this.setVelocityY(SPEED);
                else if (dir.equals("W") && this.getPrevDir().equals("E"))
                    this.setVelocityX(-SPEED);
                else if (dir.equals("E") && this.getPrevDir().equals("W"))
                    this.setVelocityX(SPEED);
                    
                
            }
            
        }
            
            
        //Changes animation and direction of character    
    }
    
    public void idle(){
        this.changeState(1);
        this.setVelocityX(0);
        this.setVelocityY(0);
        //Changes animation and direction of character
    } 
    
    public boolean getCollision(){
        return this.hasCollision;
    }
    
    public boolean getIsAnimated(){
        return this.isAnimated;
    }
    
    public void setIsAnimated(boolean bl){
         this.isAnimated = bl;
    }
    public void setHealth(int h){
        this.health = h;
        this.currHealth = this.health;
    }
    public int getHealth(){
        return this.health;
    }
    public int getCurrHealth(){
        return this.currHealth;
    }
     public void setCurrHealth(int h){
       this.currHealth = h;
    }
    public void setCollision(boolean isC){
        this.hasCollision = isC;
        //Set the direction when collision occured
        
    }
    
//    public void AI(){
//        
//    }

    
    
    public GameObject(){
        super();
        this.setCollision(false);
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
    
    public String getNature(){
        return this.nature;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    public int getTotal(){
        return this.total;    
    }

    public void setStgy(int stgy) {
        this.stgy = stgy;
    }
    
    public int getStgy(){
        return this.stgy;    
    }
   
    
}
