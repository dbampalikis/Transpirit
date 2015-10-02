package Engine;

/**
 *
 * @author peramanathan
 */

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;


public class DataHandler {
    
    // Basic detail
    private String configFile ;
    private InputStream in;
    private XMLEventReader eventReader;
    private Level level = null;

    //For all tag names
    static final String LEVEL = "level";
    static final String ID    = "ID";
    static final String BG = "bg";
    static final String sPOSX = "startPosX";
    static final String sPOSY = "startPosY";
    static final String ePOSX = "endPosX";
    static final String ePOSY = "endPosY";
    static final String SPRITE = "Sprite";
    static final String SCORE = "score";
    static final String OBJ_SPRITE = "obj_Sprite";
    static final String SPRITE_TYPE = "type";
    static final String PATH = "path";
    static final String POS_X = "x";
    static final String POS_Y = "y";
    static final String VEL_X = "dx";
    static final String VEL_Y = "dy";
    static final String FRAME = "frame";
    
    
    

     public Level getLevel(){
        return this.level;
     }
     public void setLevel(Level lvl){
         this.level = lvl;
     }
     
     public String getConfigFile(){
         return this.configFile;     
     }
     public void setConfigFile(String configFile){
         this.configFile = configFile;     
     }
     
     public InputStream getStream(){
         return this.in;
     }
     
     public void setStream(InputStream in){
         this.in = in;     
     }
     
     public XMLEventReader getEventReader(){
         return this.eventReader;
     
     }
     
     public void setEventReader(XMLEventReader xER){
         this.eventReader = xER;
     
     }

    // Load All Sprites
    public void loadData(String configFile, EngineCore en){
        
        this.setConfigFile(configFile);
                
        try{
            // First create a new XMLInputFactory
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            // Setup a new eventReader
            // InputStream in = new FileInputStream(configFile) - won't work in jar !
            InputStream in = en.loadData(configFile);
            //this.setStream(in);
            XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
            this.setEventReader(eventReader);
            // Read the XML document
            //Sprite sprite = null;
            
            level = null;

            while (eventReader.hasNext()) {
                
                XMLEvent event = eventReader.nextEvent();
                
                
                if (event.isStartElement()) {
                    
                    StartElement startElement = event.asStartElement();
                    // If we have a item element we create a new item
                    
                    if (startElement.getName().getLocalPart().equals(LEVEL)) {

                        level = new Level();
                        Iterator<Attribute> attributes = startElement.getAttributes();
                        while (attributes.hasNext()) {

                            Attribute attribute = attributes.next();
                            if (attribute.getName().toString().equals(SCORE)) {
                                String scr = attribute.getValue();
                                Integer score = new Integer(scr);
                                level.setScore(score);
                            }
                            if (attribute.getName().toString().equals(BG)) {
                                level.setBG(en.loadImage(attribute.getValue()));
                            }
                            if (attribute.getName().toString().equals(sPOSX)) {
                                String pos = attribute.getValue();
                                Integer tmp = new Integer(pos);
                                level.setStartX(tmp);
                            }
                            if (attribute.getName().toString().equals(sPOSY)) {
                                String pos = attribute.getValue();
                                Integer tmp = new Integer(pos);
                                level.setStartY(tmp);
                            }
                            if (attribute.getName().toString().equals(ePOSX)) {
                                String pos = attribute.getValue();
                                Integer tmp = new Integer(pos);
                                level.setEndX(tmp);
                            }
                            if (attribute.getName().toString().equals(ePOSY)) {
                                String pos = attribute.getValue();
                                Integer tmp = new Integer(pos);
                                level.setEndY(tmp);
                            }
                        } // End of attributes for the level
                        
                        
                    }
                    
                    if (event.isEndElement()) {

                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equals(LEVEL)) {
                            this.setLevel(level);                            
                        }
                    } // End of this level
                    
                }
            }
        
        }catch (FileNotFoundException e) {
            this.setStream(null);
	} catch (XMLStreamException e) {
	}
           
    } 

} 
