/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Engine;
import java.io.*;
import javax.sound.sampled.*;
import java.lang.*;

/**
 *
 * @author obscure
 */
public interface SoundPlayer {
    public byte[] getSamples();
    public void play(InputStream source);
    public void stop();
}
