/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;


/**
 *
 * @author adam
 */
public class EngineCore {
    
    private static final DisplayMode POSSIBLE_MODES[] = {
        new DisplayMode(800, 600, 32, 0),
        new DisplayMode(800, 600, 24, 0),
        new DisplayMode(800, 600, 16, 0),
        new DisplayMode(640, 480, 32, 0),
        new DisplayMode(640, 480, 24, 0),
        new DisplayMode(640, 480, 16, 0)
    };

    

    //Screen specific
    private ScreenManager screen;
    private DisplayMode displayMode;
    private InputHandler input;
    private static Graphics2D g;
    private Image bgImage;
    private GraphicsConfiguration gc;
    //private Animation anim;
    
    public void setupInput(){
        input = new InputHandler(screen.getFullScreenWindow());
    }
            
    public void setupScreen(){
        screen = new ScreenManager();
        displayMode = screen.findFirstCompatibleMode(POSSIBLE_MODES);        //screen.setFullScreen(displayMode);
        screen.setFullScreen(displayMode);
    }
    
    public void closeScreen(){
        screen.restoreScreen();
    }
    
    public void prepareGraphics(){
        g = screen.getGraphics();
        
    }
    
    public void UpdateGraphics() {
        g.dispose();
        screen.update();
    }
    
    public void setBackgroundImage(Image img){
        bgImage = img;
    }
    
   
    public Image loadImage(String fileName) {
        URL file = this.getClass().getClassLoader().getResource(fileName);
        return new ImageIcon(file).getImage();
    }
    
    /** We can't use FileInputStream in jar, but this function returns
        BufferedInputStream which will convenient for DataHandler.
        That's why return type is general InputStream.
     **/
    public InputStream loadData(String fileName) throws FileNotFoundException{
        
        return this.getClass().getClassLoader().getResourceAsStream(fileName);
    }
    
    public URL loadSound(String soundName){
    
        return this.getClass().getClassLoader().getResource(soundName);
    }
    
    public void draw(Sprite sp){
        g.drawImage(sp.getImage(),Math.round(sp.getX()),Math.round(sp.getY()),null);
    }
   

    public void drawBG(){
       g.drawImage(bgImage, 0, 0, null);
    }
    
    public void drawString (String str, int x, int y, Color t, Font f){
        g.setColor(t);
        g.setFont(f);

        g.drawString(str,x,y);
    }

    
    public void drawRect2 (int x, int y, int width, int height){
        g.setColor(Color.RED);
        g.fillRect(x,y,width,height);
    }
    

    
    public void drawRect (int posx, int posy, int w, int h, Color t, boolean round){   
        g.setColor(t);
        if(round){
            g.drawRoundRect(posx, posy, w, h, 10, 10);
            g.fillRoundRect(posx, posy, w, h, 10, 10);
        }
        else{
            g.drawRect(posx, posy, w, h);
            g.fillRect(posx, posy, w, h);
        }
    }
    
    public void drawCircle (int posx, int posy, int w, int h, Color t){   
        g.setColor(t);
        Shape circle = new Ellipse2D.Float(posx, posy, w, h);
        g.draw(circle);
    }
    
    

    public int getWindowWidth(){
        return screen.getWidth();
    }
    
    public int getWindowHeight(){
        return screen.getHeight();
    }
    
    public boolean[] keyUpdate()
    { 
    	boolean keys[] = {false,false,false,false,false,false,false,false,false};
	
	           if (input.isKeyDown(KeyEvent.VK_RIGHT)) 
	           { 
                           keys[0] = true;     
	           } 
	           if (input.isKeyDown(KeyEvent.VK_LEFT)) 
	           { 
	        	   keys[1] = true;        
	           } 
	           if (input.isKeyDown(KeyEvent.VK_UP)) 
	           { 
	        	   keys[2] = true;        
	           } 
	           if (input.isKeyDown(KeyEvent.VK_DOWN)) 
	           { 
	        	   keys[3] = true;         
	           } 
                   
                   if (input.isKeyDown(KeyEvent.VK_ESCAPE)) 
	           { 
	        	   keys[4] = true;         
	           } 
                   if (input.isKeyDown(KeyEvent.VK_SPACE)) 
	           { 
	        	   keys[5] = true;         
	           } 
                    if (input.isKeyDown(KeyEvent.VK_A)) 
	           { 
	        	   keys[6] = true;         
	           } 
                    if (input.isKeyDown(KeyEvent.VK_S)) 
	           { 
	        	   keys[7] = true;         
	           } 
	           
	           return keys;
    } 
    
    public Image getMirrorImage(Image image){
        return getScaledImage(image, -1,1);
    
    }
    
    public Image getFlippedImage(Image image){
        return getScaledImage(image,1,-1);
    
    }
    
    /**
     * Not much help found both in book and Internet. They are simple ones.
     * Here I have implemented complete Rotation that works for 
     * Any angle between 0 to 2*PI (8 Angles):
     * 0,PI/4,PI/2,3*PI/4,PI,PI+PI/4,3*PI/2,3*PI/2+PI/4
     * Other angles will suffer translation problem
     * We can use if we want an animation for rotating objects
     * In trigonometry rotation is counter clockwise
     * But here it is clock wise. 
     */
    public Image getRotatedImage(Image image, double angle){
        
        Image newImage;
        int x = image.getWidth(null);
        int y = image.getHeight(null); 
        double diff;
        
        AffineTransform transform = new AffineTransform();        
        transform.rotate(angle,image.getWidth(null)/2,image.getHeight(null)/2);
        diff = Math.abs(image.getHeight(null)-image.getWidth(null));
        
        gc = screen.getFullScreenWindow().getGraphicsConfiguration();
        
        if(angle % Math.PI == 0)
            newImage = gc.createCompatibleImage(image.getWidth(null),image.getHeight(null), Transparency.BITMASK);        
        else if(angle % Math.PI == Math.PI/2){
            diff = Math.abs(image.getHeight(null)-image.getWidth(null));
            newImage = gc.createCompatibleImage(image.getHeight(null),image.getWidth(null), Transparency.BITMASK);
            if(angle == Math.PI/2)
                transform.translate(-diff/2, -diff/2);
            else
                transform.translate(diff/2, diff/2);
        }
        else{
            
            double shortAngle = angle;
            while(shortAngle > Math.PI/2) // Mod doesn't work for double 
                shortAngle -= Math.PI/2;
            
            int width = (int) (x*Math.cos(shortAngle) + y*Math.cos(Math.PI/2 - shortAngle));
            int height = (int) (x*Math.sin(shortAngle) +y*Math.sin(Math.PI/2 - shortAngle));
            double transX = Math.abs(width-image.getWidth(null));
            double transY = Math.abs(height-image.getHeight(null));
            
            if(angle < Math.PI/2)
                transform.translate(transX/2,-transY/2);
            
            else if(angle > Math.PI/2 && angle < Math.PI){
                transform.translate(transY/2,-transX/2);
            }
            else if(angle > Math.PI && angle < 3*Math.PI/2){
                transform.translate(-transX/2,transY/2);
            }
            else if(angle > 3*Math.PI/2 && angle < 2*Math.PI){
                transform.translate(transY/2,transX/2);
            } 
            newImage = gc.createCompatibleImage(width,height,Transparency.BITMASK);        
            
        }      
        // draw image
        Graphics2D g1 = (Graphics2D) newImage.getGraphics();     
        g1.drawImage(image,transform,null);        
        g1.dispose();        
               
        return newImage;    
    }
    

    private Image getScaledImage(Image image, float x, float y) {    
        
        
        AffineTransform transform = new AffineTransform();
        transform.scale(x,y);
        transform.translate((x-1)*image.getWidth(null)/2, (y-1)*image.getHeight(null)/2);
        
        // transparent
        gc = screen.getFullScreenWindow().getGraphicsConfiguration();        
        Image newImage = gc.createCompatibleImage(image.getWidth(null),image.getHeight(null), Transparency.BITMASK);
               
        // draw image
        Graphics2D g1 = (Graphics2D) newImage.getGraphics();
        g1.drawImage(image,transform,null);
        
        g1.dispose();   
        
        return newImage;
    }
    
    
}
