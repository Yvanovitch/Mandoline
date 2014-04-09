
package Mandoline;

import java.util.Observable;



/**
 *
 * @author Mathieu
 */
public class Model extends Observable {
    private int volume;
    
    public Model(){
        volume = 100;
    }
    
    public int getVolume() {
        return volume;
    }
    
    public void setVolume(int volume) {
        this.volume = volume;
    }
}
