/*
 * 
 */

package Mandoline;

import java.io.File;
import java.util.EventObject;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class EventBadFile extends EventPlayList {
    File file;
    
    /**
     *
     * @param source
     * @param file
     */
    public EventBadFile(Object source, File file) {
        super(source);
        
        this.file = file;
    }
    
    /**
     *
     * @return
     */
    public File getFile () {
        return file;
    }

}
