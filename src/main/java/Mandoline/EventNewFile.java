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
public class EventNewFile extends EventPlayList {
    File file;
    Boolean supported;
    
    public EventNewFile(Object source, File file, Boolean supported) {
        super(source);
        
        this.file = file;
        this.supported = supported;
    }
    
    public File getFile () {
        return file;
    }
    
    public Boolean isSupported () {
        return supported;
    }

}
