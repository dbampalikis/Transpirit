/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.util.ArrayList;

/**
 *
 * @author adam
 */
public class Collision {
    
    private int sWidth;
    private int sHeight;
    private EngineCore en;
    
    // Simple Contructor 
    Collision() {
        
    }
    
    // Special contructor 
    public Collision(EngineCore en){
        this.en = en;               
    }

    
    
    public boolean isCollision(GameObject s1, GameObject s2, int diff){
        
        if(s1 == s2)
            return false;
        
        double dx = (s1.getX()+s1.getWidth()/2) - (s2.getX()+s2.getWidth()/2);
        double dy = (s1.getY()+s1.getHeight()/2)- (s2.getY()+s2.getHeight()/2);
        
        double r1 = Math.min(s1.getWidth(),s1.getHeight());
        double r2 = Math.min(s2.getWidth(),s2.getHeight());
        
        double distance = Math.sqrt(dx*dx+dy*dy);
        
        try{
            if(distance <= ((r1+r2)/2+diff)){
                return true;
            }
            else
                return false;
        }
        catch(Exception e){
            return false;
        }
            
    }
    
    
    public boolean isInRange(GameObject s1, GameObject s2, int diff){
        
        if(s1 == s2)
            return false;
        
        double dx = (s1.getX()+s1.getWidth()/2) - (s2.getX()+s2.getWidth()/2);
        double dy = (s1.getY()+s1.getHeight()/2)- (s2.getY()+s2.getHeight()/2);
        
        double r1 = Math.min(s1.getWidth(),s1.getHeight());
        double r2 = Math.min(s2.getWidth(),s2.getHeight());
        
        double distance = Math.sqrt(dx*dx+dy*dy);
        
        try{
            if(distance <= 2*((r1+r2)/2+diff)){
                return true;
            }
            else
                return false;
        }
        catch(Exception e){
            return false;
        }
            
    }
    
    public boolean staticConstraint(ArrayList<GameObject> staticG1, GameObject s2){
        
       for(int i=0; i<staticG1.size();i++){ 
            GameObject s1 = staticG1.get(i);
            
                if(isCollision(s1,s2,10)){                    
                   return true;            
                }            
        }
        
        return false;        
        
    }
    
    public ArrayList<GameObject> with_in_radii(GameObject gObj,ArrayList<GameObject> gObjList, int radii){
        
        ArrayList<GameObject> neighbours = new ArrayList<GameObject>();
        //neighbours = null;
        
        // We can use when we need all objects with in the radii
        
        for(int i=0; i<gObjList.size();i++){
            
            if(isCollision(gObj, gObjList.get(i), radii)){
                neighbours.add(gObjList.get(i));
            }      
        }  
               
        return neighbours;
    }
    
        
    public void borderConstraint(GameObject s1){
       
        int width  = en.getWindowWidth();
        int height = en.getWindowHeight();
        
        try{
             //Collision detection
            if(s1.getX() < 0){
                //sprite.setX(0);
                s1.setVelocityX(Math.abs(s1.getVelocityX()));
            }
            else if(s1.getX()+ s1.getWidth() >= width){
                //sprite.setX(e.getWindowWidth());
                s1.setVelocityX(-Math.abs(s1.getVelocityX()));
            }
            if(s1.getY() < 0){
                //sprite.setY(0);
                s1.setVelocityY(Math.abs(s1.getVelocityY()));
            }
            else if(s1.getY()+ s1.getHeight() >= height){
                //sprite.setY(e.getWindowHeight());
                s1.setVelocityY(-Math.abs(s1.getVelocityY()));
            }
        }
        catch(Exception e){
            
        }
            
    }
    
    // Always keep static objects list first
    public void staticObjsConstraint(ArrayList<GameObject> staticG1, ArrayList<GameObject> dynamicG2){
        
        for(int i=0; i<staticG1.size();i++){ 
            GameObject s1 = staticG1.get(i);
            for(int j=0; j<dynamicG2.size();j++){
                GameObject s2 = dynamicG2.get(j);
                if(isCollision(s1,s2,10)){
                    
                    if(s2.getVelocityX()<0 ){
                        s2.setVelocityX(Math.abs(s2.getVelocityX()));                    
                    }
                    else if(s2.getVelocityX()>0){
                        s2.setVelocityX(-Math.abs(s2.getVelocityX()));                                        
                    }
                    if(s2.getVelocityY()<0){
                        s2.setVelocityY(Math.abs(s2.getVelocityY()));                                                            
                    }
                    else if(s2.getVelocityY()>0){
                        s2.setVelocityY(-Math.abs(s2.getVelocityY()));                                        
                    }
                    //System.out.println(s2+ " "+s2.getVelocityX());                
                }
            
            }
        
        
        }
    }
    
    
    // Animated objects collision handling
    
    public void animatedObjsConstraint(ArrayList<GameObject> dynamicG1){
        
        if(dynamicG1.size() >= 2){
        
            for(int i=0; i<dynamicG1.size();i++){ 
                GameObject s1 = dynamicG1.get(i);
                for(int j=i+1; j<dynamicG1.size();j++){
                    GameObject s2 = dynamicG1.get(j);
                    if(isCollision(s1,s2,2)){

                        if(s2.getVelocityX()<0 ){
                            s2.setVelocityX(Math.abs(s2.getVelocityX()));                    
                        }
                        else if(s2.getVelocityX()>0){
                            s2.setVelocityX(-Math.abs(s2.getVelocityX()));                                        
                        }
                        if(s2.getVelocityY()<0 ){
                            s2.setVelocityY(Math.abs(s2.getVelocityY()));                                                            
                        }
                        else if(s2.getVelocityY()>0 ){
                            s2.setVelocityY(-Math.abs(s2.getVelocityY()));                                        
                        }

                        if(s1.getVelocityX()<0 ){
                            s1.setVelocityX(Math.abs(s1.getVelocityX()));                    
                        }
                        else if(s1.getVelocityX()>0 ){
                            s1.setVelocityX(-Math.abs(s1.getVelocityX()));                                        
                        }
                        if(s1.getVelocityY()<0 ){
                            s1.setVelocityY(Math.abs(s1.getVelocityY()));                                                            
                        }
                        else if(s1.getVelocityY()>0 ){
                            s1.setVelocityY(-Math.abs(s1.getVelocityY()));                                        
                        }
                    }            
                }       
            }
        
        }
    }
    
    public void alt_AnimObjsConstraint(ArrayList<GameObject> dynamicG1){
        
        if(dynamicG1.size() >= 2){
                        
            for(int i=0; i<dynamicG1.size();i++){ 
                GameObject s1 = dynamicG1.get(i);
                for(int j=i+1; j<dynamicG1.size();j++){
                    
                    GameObject s2 = dynamicG1.get(j);
                    float dx = s1.getX() - s2.getX();            
                    float dy = s1.getY() - s2.getY();
                    float minDist = Math.max(s1.getWidth(),s1.getHeight());
                    
                    if(isCollision(s1,s2,2)){
                        
                        float v1x = s1.getVelocityX();
                        float v1y = s1.getVelocityY();
                        float v2x = s2.getVelocityX();
                        float v2y = s2.getVelocityY();

                        if(v1x*v2x > 0 && v1y*v2y >0) { // traveling in same direction 

                                s1.setVelocityX(-Math.abs(s1.getVelocityX()));
                                s1.setVelocityY(-Math.abs(s1.getVelocityY()));
                                //s1.setX(s1.getX()+minDist+1); // handles very close mouse clicks
                                s2.setVelocityX(Math.abs(s2.getVelocityX()));
                                s2.setVelocityY(Math.abs(s2.getVelocityY()));

                        }
                        else if(v1x*v2x > 0 && v1y*v2y < 0){// traveling opposite vertically

                            s1.setVelocityY(v2y);
                            //s1.setY(s1.getY()+ dy); // avoids influencing each other and travel along
                            s2.setVelocityY(v1y);
                        }
                        else if(v1x*v2x < 0 && v1y*v2y > 0){// traveling opposite horizontally

                            s1.setVelocityX(v2x);
                            //s1.setX(s1.getX()+ dx); // avoids influencing each other and travel along
                            s2.setVelocityX(v1x);
                        }
                        else { // traveling opposite both vertically and horizontally

                            s1.setVelocityX(v2x);
                            s1.setVelocityY(v2y);
                            //s1.setX(s1.getX()+dx);// avoids influencing each other and travel along
                            s2.setVelocityX(v1x);
                            s2.setVelocityY(v1y);          

                        }
                        
                    
                    }
                }
            }

        
        
        }
    
    
    }
    
    
    
    
    // This we tried to avoid many collision checking but we will not use
    // Divides the screen into 4 and checks the objects if they are
    // in same rectangular region
    public boolean checkCollision(GameObject g1,GameObject g2){
        
        float x1 = g1.getX();
        float y1 = g1.getY();
        float x2 = g2.getX();
        float y2 = g2.getY();
        
        sWidth = en.getWindowWidth();
        sHeight = en.getWindowHeight();
        
        float cX1 = sWidth/2;
        float cY1 = sHeight/2;
        
        int Rect1=0,Rect2=-1;
        
        if(x1 < cX1){
            if(y1 < cY1){
                
                if(x1+g1.getWidth() <= cX1 && y1+g1.getHeight() <= cY1)   
                    Rect1 = 1;
                else 
                    return isCollision(g1,g2,0);
            
            }
            else{
                if(y1+g1.getHeight() <= cY1)
                    Rect1 = 2;
                else 
                    return isCollision(g1,g2,0);
            
            }
        }
        else{
            
            if(y1 <= cY1){
                
                if(x1+g1.getWidth() <= cX1)                
                    Rect1 = 3;
                else 
                    return isCollision(g1,g2,0);
            
            }
            else
                Rect1 = 4;
        
        
        
        }
        
        if(x2 < cX1){
            if(y2 < cY1){
                
                if(x2+g2.getWidth() <= cX1 && y2+g2.getHeight() <= cY1)   
                    Rect2 = 1;
                else 
                    return isCollision(g1,g2,0);
            
            }
            else{
                if(y2+g2.getHeight() <= cY1)
                    Rect2 = 2;
                else 
                    return isCollision(g1,g2,0);
            
            }
        }
        else{
            
            if(y2 <= cY1){
                
                if(x2+g2.getWidth() <= cX1)                
                    Rect2 = 3;
                else 
                    return isCollision(g1,g2,0);
            
            }
            else
                Rect2 = 4;
        
               
        }
            
            
        if (Rect1 == Rect2)
            return isCollision(g1,g2,0);
      
        
        return false;
        
    
    }
    
}
