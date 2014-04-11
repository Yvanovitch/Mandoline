/*
 * 
 */

package Mandoline;

import java.io.File;
import java.util.EventObject;
import java.util.Vector;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class EventNewFile extends EventPlayList {
    File file;
    Boolean supported;
    Vector<Vector<Object>> data;
            
    public EventNewFile(Object source, File file, Vector<Vector<Object>> data, Boolean supported) {
        super(source);
        
        this.file = file;
        this.supported = supported;
        this.data = data;
    }
    
    public File getFile () {
        return file;
    }
    
    public Boolean isSupported () {
        return supported;
    }

}
