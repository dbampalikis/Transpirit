/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;


/**
 *
 * @author Peramanathan
 */
import Engine.*;

public class AILevel1 extends AI{
    
    private Transpirit objGame;
    private Collision c;
    private EngineCore en;
    private Level l;

    AILevel1(Transpirit game, EngineCore en) {
        
        this.objGame = game;
        this.en = en;
        c = new Collision(en);
        
        //run();
        
    }
    
    public void run(){
        
        l = objGame.getcurrLevel();
        
        for(int i = 0; i<objGame.getCurAnimatedObjs().size();i++){
            
            GameObject gObj = objGame.getCurAnimatedObjs().get(i);        
                        
            playSTGY(gObj);   
            
            
        }
    
    }
    
    public void playSTGY(GameObject gObj){
        
        int stgy = gObj.getStgy();
        
        switch(gObj.getStgy()){
            
            case 0:
                // Calls method in AI
                // Otherwise we can override here
                stgy0_none(gObj); 
                break;
            case 1: 
                
                stgy1_random(gObj);
                break;
            case 2:
                stgy2_normal(gObj);
                break;
            case 5:
                stgy5_kill(gObj);
                break;
            case 6:
                stgy6_road_x(gObj);
                break;
            case 7:
                stgy7_road_y(gObj);
                break;
            case 9:
                stgy9_rotation(gObj);
                break;
            default:
                System.out.println("This stgy haven't implemented yet !");        
        
        }
    
    }
    
    @Override
    public void stgy1_random(GameObject gObj){
        
        float limit = (float) Math.random();
        
        if(objGame.getElapsedTime()% 10 == 5 ){
            
            if(limit < 0.3){

                gObj.setVelocityX(0.008f);
                gObj.setVelocityY(0);
            }
            else if (limit >= 0.3 && limit < 0.5){

                gObj.setVelocityX(-0.008f); 
                gObj.setVelocityY(0);
            }
            else if(limit >= 0.5 && limit <0.8){

                gObj.setVelocityY(0.008f);
                gObj.setVelocityX(0);
            }
            else{

                gObj.setVelocityY(-0.008f);        
                gObj.setVelocityX(0);
            }
        
        }
                                
        if(gObj.getVelocityX() > 0)
            gObj.setAnim(gObj.animE);
        else
            gObj.setAnim(gObj.animW);    
        
        //c.staticConstraint(objGame.getCurStaticObjs(), gObj);
    
    }
    
    @Override
    public void stgy2_normal(GameObject gObj){
        
        float player_x = objGame.getPlayer().getX();
        float player_y = objGame.getPlayer().getY();
        
        float monster_x = gObj.getX();
        float monster_y = gObj.getY();
        
        boolean staticCollision =  c.staticConstraint(objGame.getCurStaticObjs(), gObj);
        
        if(!c.isCollision(objGame.getPlayer(), gObj, 0)){
            if(!staticCollision){     


                if(player_x > monster_x )            
                    gObj.setVelocityX(0.01f); 
                else 
                    gObj.setVelocityX(-0.01f);

                if(player_y > monster_y)            
                    gObj.setVelocityY(0.02f); 
                else 
                    gObj.setVelocityY(-0.02f);

            }
        }
        else {
            gObj.setStgy(5);
            playSTGY(gObj);
        }
        if(gObj.getVelocityX() > 0)
            gObj.setAnim(gObj.animE);
        else
            gObj.setAnim(gObj.animW);
        
        c.staticConstraint(objGame.getCurStaticObjs(), gObj);
        
    
    }
    
    @Override
    public void stgy5_kill(GameObject gObj){
        
        if(! c.isCollision(gObj, objGame.getPlayer(), 0)) {
            gObj.setAnim(gObj.getPreAnim());
            gObj.setStgy(2);
            playSTGY(gObj);
        }
        else {
            
            objGame.handleAttack(gObj, objGame.getPlayer());
            gObj.setVelocityY(0.0f);
            gObj.setVelocityX(0.0f);
        }
    }
    
    @Override
    public void stgy6_road_x(GameObject gObj){
        //Monster to be initialized from (EndX + 30, EndY + 30)
        float monster_x = gObj.getX();
        float monster_y = gObj.getY();
        gObj.setVelocityY(0.0f);
        
         if(! c.isInRange(gObj, objGame.getPlayer(), 0)){
        
            if(gObj.getVelocityX() >=0 && monster_x < l.getEndX() + 30) {
                gObj.setAnim(gObj.animE);
                gObj.setVelocityX(0.01f); 
            }
            else if (gObj.getVelocityX() >= 0 && monster_x >= l.getEndX() + 30){
                gObj.setAnim(gObj.animW);
                gObj.setVelocityX(-0.01f); 
            }
            else if (gObj.getVelocityX() <= 0 && monster_x > l.getEndX()){
                gObj.setVelocityX(-0.01f);
            }
            else if (gObj.getVelocityX() <= 0 && monster_x <= l.getEndX()){
                gObj.setVelocityX(0.01f);
            }
        }
         else {
             gObj.setStgy(2);
             playSTGY(gObj);
        }
              
               
    }
    
    @Override
    public void stgy7_road_y(GameObject gObj){    
        //Monster to be initialized from (EndX + 30, EndY + 30)
        float monster_x = gObj.getX();
        float monster_y = gObj.getY();
        gObj.setVelocityX(0.0f);
        
        
        if(gObj.getVelocityY() > 0 && monster_y < l.getEndY() + 30) {
            gObj.setVelocityY(0.01f); 
        }
        else if (gObj.getVelocityY() > 0 && monster_y >= l.getEndY() + 30){
            gObj.setVelocityY(-0.01f); 
        }
        else if (gObj.getVelocityY() < 0 && monster_y > l.getEndY()){
            gObj.setVelocityY(-0.01f);
        }
        else if (gObj.getVelocityY() < 0 && monster_y <= l.getEndY()){
            gObj.setVelocityY(0.01f);
        }
    }
    
    public void stgy9_rotation(GameObject gObj){
        
        gObj.setVelocityX(0.008f);
        gObj.setVelocityY(0.008f);
        
        gObj.setAnim(gObj.animRotate);
    
    }
}
