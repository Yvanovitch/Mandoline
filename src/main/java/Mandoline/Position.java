/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mandoline;


import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.BorderLayout;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Mathieu
 */
public class Position implements Runnable{
    javax.swing.JSlider jSlider;
    
    public Position(javax.swing.JSlider jSlider){
        this.jSlider  = jSlider;
    }
    public void run() {
       EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
       double position;
       position = mediaPlayerComponent.getMediaPlayer().getPosition();
       jSlider.setValue((int)position);
        
    }

    
    
}
