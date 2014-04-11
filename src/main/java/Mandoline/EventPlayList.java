/*
 * 
 */

package Mandoline;

import java.util.EventObject;

/**
 *
 * @author yvan.richer@gmail.com
 */
public abstract class EventPlayList extends EventObject {
    
    /**
     *
     * @param source
     */
    public EventPlayList(Object source) {
        super(source);
    }
    
}
