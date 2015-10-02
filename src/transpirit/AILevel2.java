/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

/**
 *
 * @author Peramanathan
 */
import Engine.AI;
import Engine.GameObject;
import Engine.Collision;
import Engine.EngineCore;

public class AILevel2 extends AI{
    
    private Transpirit objGame;
    private Collision c;
    private EngineCore en;
    
    AILevel2(Transpirit game, EngineCore en) {
        
        this.objGame = game;
        this.en = en;
        c = new Collision(en);
        //run();
        
    }
    
    public void run(){
        
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
            }
            else if (limit >= 0.3 && limit < 0.5){

                gObj.setVelocityX(-0.008f);        
            }
            else if(limit >= 0.5 && limit <0.8){

                gObj.setVelocityY(0.008f);        
            }
            else{

                gObj.setVelocityY(-0.008f);        
            }
        
        }
                                
        if(gObj.getVelocityX() > 0)
            gObj.setAnim(gObj.animE);
        else
            gObj.setAnim(gObj.animW);    
    
    }
    
    @Override
    public void stgy2_normal(GameObject gObj){
        
        float player_x = objGame.getPlayer().getX();
        float player_y = objGame.getPlayer().getY();
        
        float monster_x = gObj.getX();
        float monster_y = gObj.getY();
        
                
        if(player_x > monster_x)            
            gObj.setVelocityX(0.01f); 
        else 
            gObj.setVelocityX(-0.01f);
        
        if(player_y > monster_y)            
            gObj.setVelocityY(0.02f); 
        else 
            gObj.setVelocityY(-0.02f);
        
        if(gObj.getVelocityX() > 0)
            gObj.setAnim(gObj.animE);
        else
            gObj.setAnim(gObj.animW);
    
    
    }
    
    @Override
    public void stgy5_kill(GameObject gObj){
        
        if(! c.checkCollision(gObj, objGame.getPlayer()))
            gObj.setAnim(gObj.getPreAnim());
//        else
//            gObj.setAnim(gObj.animSidle);
        objGame.handleAttack(gObj, objGame.getPlayer());
    
    }
    
}
