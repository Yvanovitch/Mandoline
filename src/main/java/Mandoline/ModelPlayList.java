
package Mandoline;


import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Mathieu
 */
public class ModelPlayList extends JPanel {
    public ModelPlayList(){
        
        javax.swing.JTextArea text = new javax.swing.JTextArea("mon texte !");
        this.setAlignmentX(20);
        this.add(text);
        this.add(new JButton("click me"));
        this.doLayout();
    }
    
    
    
}
