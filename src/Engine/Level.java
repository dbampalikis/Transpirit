package Engine;

/**
 *
 * @author peramanathan
*/

import java.awt.Image;
import java.util.ArrayList;
import Engine.GameObject;

public class Level {
    
    private Image BG;
    private int score;
    private int startPosX = 0;
    private int startPosY = 0;
    private int endPosX = 0;
    private int endPosY = 0;
    private ArrayList<GameObject> staticObjects;
    private ArrayList<GameObject> animatedObjects;
    
    public Level( ){
        
    }

    public Image getBG(){
        return BG;
        
    }
    public void setBG(Image BG) {
        this.BG = BG;
    }
    
    public void setStartX(int x) {
        this.startPosX = x;
    }
    public int getStartX() {
        return this.startPosX;
    }
    
    public void setStartY(int y) {
        this.startPosY = y;
    }
    public int getStartY() {
        return this.startPosY;
    }
    
    public void setEndX(int x) {
        this.endPosX = x;
    }
    public int getEndX() {
        return this.endPosX;
    }
    
    public void setEndY(int y) {
        this.endPosY = y;
    }
    public int getEndY() {
        return this.endPosY;
    }
    
    public int getScore(){
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    
    public ArrayList<GameObject> getArrGameStatic(){
        return staticObjects;
    }
    public void setArrGameStatic(ArrayList<GameObject> tmp) {
        this.staticObjects = tmp;
    }
    
    public ArrayList<GameObject> getArrGameAnim(){
        return animatedObjects;
    }
    public void setArrGameAnim(ArrayList<GameObject> tmp) {
        this.animatedObjects = tmp;
    }
    
    


}
