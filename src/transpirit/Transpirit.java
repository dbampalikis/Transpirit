/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

import Engine.*;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.InputStream;

public class Transpirit {
    
    private EngineCore e;
    private ArrayList<Level> levelList;
    private ArrayList<GameObject> currStaticObjs;
    private ArrayList<GameObject> currAnimatedObjs;
    private GameObject player;
    private Level currLevel;
    private boolean[] keys;
    private boolean[] keysOld = {false,false,false,false,false,false,false,false,false};
    private int score;
    private DataHandler read;
    private static AILevel1 objAI1;  
    private long elapsedTime;
    private Collision c;
    private int mana;
    private int currMana;
       
  
    
    
    public static void main(String args[]) {
        Transpirit game = new Transpirit();        
        game.e = new EngineCore();
        game.c = new Collision(game.e);
        objAI1 = new AILevel1(game,game.e);
        game.run();
    }
    
    public Level getcurrLevel() {
        return this.currLevel;
    }
    public ArrayList<GameObject> getCurAnimatedObjs(){
        return this.currAnimatedObjs;    
    }
    
    public ArrayList<GameObject> getCurStaticObjs(){
        return this.currStaticObjs;    
    }
    
    public GameObject getPlayer(){
        return this.player;
    }
     
    public long getElapsedTime(){
        return this.elapsedTime;
    }
    
    public void init(){
        e.setupScreen();
        e.setupInput();
        this.keys = e.keyUpdate();
        //e.setCollision(); 
        read = new DataHandler();
        levelList = new ArrayList<Level>();
        
        //Load start screen
        e.prepareGraphics();
        e.drawRect(0, 0, e.getWindowWidth(), e.getWindowHeight(), Color.BLACK, false);
        e.drawString("TRANSPIRIT", e.getWindowWidth()/2-250, e.getWindowHeight()/2-40, Color.WHITE, new Font("Arial",Font.BOLD,80));
        e.drawString("Starting Game", e.getWindowWidth()/2-130, e.getWindowHeight()/2, Color.WHITE, new Font("Arial",Font.BOLD,20));
        e.UpdateGraphics();
        
        //Load levels from xml and populate levelList
        loadLevelData("data/Level1.xml");
        loadLevelData("data/Level2.xml");
        loadLevelData("data/Level3.xml");
        
        try {
           Thread.sleep(3000);                    
        }
        catch (InterruptedException ex) { }
        
        //load level with index 1 in LevelList
        loadLevel(0);
        
        //Set player default charachter
        player = soulSwitch(0);
        
       this.mana = 100;
       this.currMana = this.mana;
        
        // Running the AI - calling here 
        // will set up AI only once
        // objAI1.run();

     }


    public void run() {
        try {
            init();
            gameLoop();
        }
        finally {
            end();
        }
    }

    public void end(){
        e.closeScreen();
    }
    
    //Change the player gameObject by replacing it with an object from the arraylist
    public GameObject soulSwitch(int i){
        try{
            GameObject tmp = this.currAnimatedObjs.get(i); 
            if(this.player == null){
                this.currAnimatedObjs.remove(i);           
            }
            else{               
                this.currAnimatedObjs.remove(i);  
                this.player.idle();
                this.currAnimatedObjs.add(this.player);
            }
                
            return tmp;   
            
        }
        catch(Exception e){
            return null;
        }
    }
    
    public void loadLevelData(String lvl){
        read.loadData(lvl,e); 
        // load all game objects
        new SpDataHandler(read,e);
        this.levelList.add(read.getLevel()); 
    }
    
    public void loadLevel(int lvl){
        
        e.prepareGraphics();
        e.drawRect(0, 0, e.getWindowWidth(), e.getWindowHeight(), Color.BLACK, false);
        e.drawString("Loading level: "+(lvl+1), e.getWindowWidth()/2-150, e.getWindowHeight()/2-40, 
                Color.WHITE, new Font("SansSerif",Font.BOLD,40));
        e.UpdateGraphics();   
        
        //Load level & gameObjects 
        this.currLevel = this.levelList.get(lvl);
        e.setBackgroundImage(currLevel.getBG());
        this.currAnimatedObjs = currLevel.getArrGameAnim();
        this.currStaticObjs   = currLevel.getArrGameStatic();
        
        
        if(this.player != null){
            player.setX(this.currLevel.getStartX());
            player.setY(this.currLevel.getStartY());
        }
        
        try {
           Thread.sleep(3000);                    
        }
        catch (InterruptedException ex) { }
        
    }
    
    public void renderHealthBar(){
        
        int h1 = player.getHealth();
        int h2 = player.getCurrHealth();
        if(h1 > 0){
            int numberOfBars = Math.round(h2/(h1/5));
            for(int i=0; i < numberOfBars; i++)
                e.drawRect((40+i*30), 30, 25, 15, Color.RED, true);
        }
    }
    
    public void renderManaBar(){
        
        int h1 = this.mana;
        int h2 = this.currMana;
        if(h1 > 0){
            int numberOfBars = Math.round(h2/(h1/5));
            for(int i=0; i < numberOfBars; i++)
                e.drawRect((40+i*30), 60, 25, 15, new Color(225, 0, 255), true);
        }
    }
    

    public void gameLoop() {
        long startTime = System.currentTimeMillis();
        long currTime = startTime;
        
        Task backGroundMusic = new Task(1, "Sound/theme1.wav");
        while (!this.keys[4]) {
            elapsedTime = System.currentTimeMillis() - currTime;
            currTime += elapsedTime;
            this.keys = e.keyUpdate();
            e.prepareGraphics();
            e.drawBG();
            update(elapsedTime);
            renderHealthBar();
            renderManaBar();
            e.UpdateGraphics();
            // take a nap
            try {
                Thread.sleep(20);
            }
            catch (InterruptedException ex) { }
        }
        backGroundMusic.stop();

    }
     
   public void update(long elapsedTime){
       
        //Player      
        //Check Collision
      
        for(int j=0; j < currAnimatedObjs.size();j++){
           
                if(c.isCollision(this.player, currAnimatedObjs.get(j),0)){
                    this.player.setCollision(true);  
                }
                if(c.isCollision(this.player, currAnimatedObjs.get(j),20) ){                    
                    e.drawCircle(((int)this.player.getX()+this.player.getWidth()/2-60/2), ((int)this.player.getY()+this.player.getHeight()/2-60/2), 60, 60, Color.blue);
                    
                   // this.player.getAnim().getImage().
                    
                    if(keys[7] == true){
                        if(!keysOld[7]){
                            this.player = this.soulSwitch(j);
                            keysOld[7] = true;
                        }   
                    }
                    else
                        keysOld[7] = false;
                }
                    
        }
        for(int j=0; j < currStaticObjs.size();j++){
                if(c.isCollision(this.player, currStaticObjs.get(j),0)){
                    this.player.setCollision(true);
                   //this.player = this.soulSwitch(j);
                }                    
        }
         
         //Check if load new level   
         if(this.player.getX() >= this.currLevel.getEndX()   && this.player.getX() <= this.currLevel.getEndX()+30 && 
            this.player.getY() <= this.currLevel.getEndY()){
             loadLevel(levelList.indexOf(currLevel)+1);
         }

         
        //Check keyboard inputS
        if (keys[0] == true) //Input RIGHT arrow
            player.run("E");                      
        if (keys[1] == true) //Input left arrow
            player.run("W");        
        if (keys[2] == true) //Input arrow UP  
            player.run("N");
        if (keys[3] == true) //Input arrow DOWN                    
            player.run("S");
        if (keys[6] == true) { //Key-A
            player.attack();
        }
   
       
        
        if(!keys[0] && !keys[1] && !keys[2] & !keys[3] && !keys[6] )
                player.idle();
        
        
        // Reducing attacking handles for unnecessary objects
        ArrayList<GameObject> victims = c.with_in_radii(player, currAnimatedObjs, 10);
        if(!victims.isEmpty() && keys[6] == true){
            for(int i=0;i<victims.size();i++){
                handleAttack(this.player,victims.get(i)); 
            }
        }
        
        c.borderConstraint(this.player);
        
        objAI1.run();
        //Player
        player.getAnim().update(elapsedTime);
        player.update(elapsedTime);
        e.draw(player);
        
        
        //Debug information
        e.drawString("X: "+ player.getX() + "Y: " + player.getY() + "D: " + player.getDir() ,155,550, Color.BLACK,new Font("SansSerif",Font.BOLD,20));
        this.player.setCollision(false);
 
        // Dynamic vs Static Collision
        
        //c.alt_AnimObjsConstraint(currAnimatedObjs);
        // or call
        c.animatedObjsConstraint(currAnimatedObjs);
        c.staticObjsConstraint(currStaticObjs,currAnimatedObjs);
        
        
        //Objects
        if(!currAnimatedObjs.isEmpty()){   
            for(int i=0; i<currAnimatedObjs.size();i++){
                GameObject gObj = currAnimatedObjs.get(i);
                gObj.getAnim().update(elapsedTime);
                e.drawString("Score:"+ Integer.toString(this.score),40,85, Color.BLACK,new Font("SansSerif",Font.BOLD,20));
                // Being Attacked by the player ?
                
                //Check collision with walls
                c.borderConstraint(gObj);
                gObj.update(elapsedTime);
                e.draw(gObj);
            }
        }
        
        if(!currStaticObjs.isEmpty()){   
            //for (Sprite sprite: allSprites){
            for(int i=0; i<currStaticObjs.size();i++){
                GameObject gObj = currStaticObjs.get(i);
                gObj.getAnim().update(elapsedTime);                      
                //Check collision with walls
                c.borderConstraint(gObj);
                gObj.update(elapsedTime);
                e.draw(gObj);
            }
        }
        
        
    }
   
    public void handleAttack(GameObject attacker, GameObject victim){
        
        if(c.checkCollision(attacker, victim)){
            attacker.attack();
            
            if(attacker == this.player){
                e.drawRect2((int)victim.getX()-5,(int)victim.getY()-15,victim.getHealth(),10);
                Task alarm = new Task(2, "Sound/Axe_2.wav");
            }
           
            
            // Health may go minus by jumping zero
            // Depends upon the opponents' damage power. ex: 10 - 20 = -10
            if(victim.getHealth() < 0)
                victim.setHealth(0);

            if(victim.getHealth()==0){

                if(victim == this.player){
                        e.drawString("Game Over", e.getWindowWidth()/2, 
                                e.getWindowHeight()/2, Color.red, new Font("SansSerif",Font.BOLD,30));
                        //victim.setX(victim.getX()-5);
                }                            

                // change the state into dead
                
                victim.changeState(5);
                victim.update(elapsedTime);
                e.draw(victim);  

                try {
                    Thread.sleep(200);
                    if(victim != this.player ){
                        int i = currAnimatedObjs.indexOf(victim);
                        currAnimatedObjs.remove(i);
                    }

                }
                catch (InterruptedException ex) { }

            }                   
            else{
                victim.setHealth(victim.getHealth()-20);
                if(attacker == this.player)
                    this.score=this.score+20;
            } 
        }
        c.borderConstraint(victim);
        victim.update(elapsedTime);
        e.draw(victim);
    }
     
    
 }   
