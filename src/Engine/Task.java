/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;
import transpirit.Naga;
import transpirit.Transpirit;
import java.io.ByteArrayInputStream;
import java.io.*;
import javax.sound.sampled.*;
import java.lang.*;

/**
 *
 * @author obscure
 */
public class Task extends Thread {
    
    public int type;
    public String filename;
    //EngineCore en;
    public Task(int GivenType, String file) {
        this.type = GivenType;
        this.filename = file;
        //this.en = en;
        start();
    }
    
    
    public void run() {
        if(this.type == 1){
            SimpleSoundPlayer x = new SimpleSoundPlayer(this.filename);
            // create the stream to play
            ByteArrayInputStream s = new LoopingByteInputStream(x.getSamples());
            // play the sound
            x.play(s);
        }
        else if(this.type == 2) {
            SimpleSoundPlayer sound = new SimpleSoundPlayer(this.filename);
            // create the stream to play
            InputStream stream = new ByteArrayInputStream(sound.getSamples());
            // play the sound
            sound.play(stream);
        }
        /*else if(this.type == 3) {
            a1 = new ArrayList();
            Naga n1 = new Naga();
            a1.add(n1);
        }*/
    }
}
