/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transpirit;

/**
 *
 * @author Peramanathan
 */

import Engine.DataHandler;
import Engine.EngineCore;
import Engine.GameObject;
import Engine.Level;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class SpDataHandler {
    
    // For corresponding level
    private Level level;
    private String configFile;
    private InputStream in;
    private XMLEventReader eventReader;
    private EngineCore en;
    
    //xml tags
    static final String OBJ_SPRITE = "obj_Sprite";
    static final String SPRITE_TYPE = "type";
    static final String POS_X = "x";
    static final String POS_Y = "y";
    static final String VEL_X = "dx";
    static final String VEL_Y = "dy";
    static final String NATURE = "nature";
    
    // For Objects in the game
    private  ArrayList<GameObject> staticGameObjs;
    private  ArrayList<GameObject> animatedGameObjs;

    
    
    // For Sprite Types 
    public enum SpriteType {
       // just paste the type name (=class name) from xml order doesn't matter !
        Jack, Zelda, Tree,Chicken,Bomby,House,LightBase,LightHouse,Dragon,Hexen,Pocky,Lion,Beast,Kraken,Unknown;
        
        public static SpriteType toSprite(String str)
        {
            try {
                return valueOf(str);
            } 
            catch (Exception ex) {
                return Unknown;
            }
        }   
        
    }
    
    public enum Properties {
       // just paste the type name (=class name) from xml order doesn't matter !
        x,y,dx,dy,total,stgy,Unknown;
        
        public static Properties toProperty(String str)
        {
            try {
                return valueOf(str);
            } 
            catch (Exception ex) {
                return Unknown;
            }
        }   
        
    }
    
    SpDataHandler(DataHandler dh,EngineCore en) {
        
        this.configFile = dh.getConfigFile();
        this.level = dh.getLevel();
        this.in = dh.getStream();
        this.eventReader = dh.getEventReader();
        this.en = en;
        loadObjects();
    
    }
    
    // private otherwise not safe - since constructor calling this method
    private void loadObjects() {
        
        staticGameObjs   = new ArrayList<GameObject>();
        animatedGameObjs = new ArrayList<GameObject>();
        InputStream in = null;
        
        try{
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            in = en.loadData(configFile);
            //this.setStream(in);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            //Sprite sprite = null;
            GameObject curObj = null;
            //level = null;
            
            while (eventReader.hasNext()) {
                
                XMLEvent event = eventReader.nextEvent();                
                
                if (event.isStartElement()) {
                    
                    StartElement startElement = event.asStartElement();
                    
                    // If we have a item element we create a new item                                        
                    if (startElement.getName().getLocalPart().equals(OBJ_SPRITE)) {                                            
                                                
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {

                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(SPRITE_TYPE)) {                                
                                                               
                                String spriteName = attribute.getValue();
                                
                                curObj = createGameObjects(spriteName);
                            }
                            
                            if (attribute.getName().toString().equals(NATURE)) {
                                curObj.setNature(attribute.getValue());                            
                            }
                        }
                    }

                    else if (event.isStartElement() && curObj != null) {
                        
                        String property = event.asStartElement().getName().getLocalPart();
                        event = eventReader.nextEvent();
                        String data_Str = event.asCharacters().getData();
                        
                        configProperties(curObj,property,data_Str);
                    }
                    
                    
                }
                
                if (event.isEndElement() && curObj != null) {

                    EndElement endElement = event.asEndElement();
                    if (endElement.getName().getLocalPart().equals(OBJ_SPRITE)) {
                                                                    
                        if(curObj.getIsAnimated()){
                            this.animatedGameObjs.add(curObj);
                            // Create remaining GameObjects defined in xml tag <total>
                            if(curObj.getTotal() > 1){
                                for(int i = 0 ; i < curObj.getTotal()-1 ; i++){

                                    GameObject newCurObj = createGameObjects(curObj.getName());
                                    newCurObj.setX((float)Math.random()*600);
                                    newCurObj.setY((float)Math.random()*100);
                                    newCurObj.setName(curObj.getName());
                                    newCurObj.setStgy(curObj.getStgy());
                                    this.animatedGameObjs.add(newCurObj);                            

                                }
                            }                        
                        
                        }
                        else
                            this.staticGameObjs.add(curObj);
                    }
                }
            }
            
            //Send GameObject arrays to current Level
            this.level.setArrGameAnim(animatedGameObjs);
            this.level.setArrGameStatic(staticGameObjs);
            
            
        
        } catch (FileNotFoundException ex) {
            
        }catch (XMLStreamException e) {
	} 
           
    } 

    // Create Corresponding GameObject in the xml
    public GameObject createGameObjects(String spriteName){
        
        GameObject curObj = null; // cleaning the previous object 
        
        // Don't miss the break statement !
        switch(SpriteType.toSprite(spriteName)) {

            case Jack:
                curObj = new Jack(en);
                break;
            case Tree:
                curObj = new Tree(en);
                break;
            case Chicken:
                curObj = new Chicken(en);
                break;
            case Bomby:
                curObj = new Bomby(en);
                break;
            case House:
                curObj = new House(en);
                break;
            case LightBase:
                curObj = new LightBase(en);
                break;
            case LightHouse:
                curObj = new LightHouse(en);
                break;
            case Zelda:
                curObj = new Zelda(en);
                break;
            case Dragon:
                curObj = new Dragon(en);
                //System.out.println(curObj);
                break;
           case Hexen:
                curObj = new Hexen(en);
                //System.out.println(curObj);
                break;
          case Pocky:
                curObj = new Pocky(en);
                //System.out.println(curObj);
                break;
          case Lion:
                curObj = new Lion(en);
                //System.out.println(curObj);
                break;
              
          case Beast:
                curObj = new Beast(en);
                System.out.println(curObj);
                break;
              
         case Kraken:
                curObj = new Kraken(en);
                System.out.println(curObj);
                break;

            // Handles unknown type
            case Unknown:
                System.err.println("Found unknown type: " + spriteName);
                break;

            default:
                System.err.println("Object is not sprite");// Very unlikely - just safer side !


        }
        
        if(curObj != null)
            curObj.setName(spriteName);
        else
            // Handles unknown type and not defined objects    
            System.err.println("SpDataHandler :" + spriteName + 
                    " class may not be created and you only have it in xml file");  
    
        return curObj;
    
    }
    
    public void configProperties(GameObject curObj, String property,String data_Str) {
        
        switch(Properties.toProperty(property)){
                            
            case x: 

                Float x = new Float(data_Str);
                curObj.setX(x);
                break;  

            case y :

                Float y = new Float(data_Str);
                curObj.setY(y);
                break;

            case dx:

                Float vel_X = new Float(data_Str);
                curObj.setVelocityX(vel_X);
                break;

            case dy :

                Float vel_Y = new Float(data_Str);
                curObj.setVelocityY(vel_Y);
                break;

            case total:

                Integer total = new Integer(data_Str);
                curObj.setTotal(total);
                break;

            case stgy:

                Integer stgy = new Integer(data_Str);
                curObj.setStgy(stgy);
                break;

            case Unknown:
                System.err.println("Found unknown property: " + property );
                break;

        }
        
        
    }
    
    
}
    
    

    

