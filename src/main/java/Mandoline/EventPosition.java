/*
 * 
 */

package Mandoline;

import java.util.EventObject;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class EventPosition extends EventObject {
    float position;
    
    public EventPosition(Object source, float position) {
        super(source);
        
        this.position = position;
    }
    
    public float getPosition () {
        return position;
    }

}
