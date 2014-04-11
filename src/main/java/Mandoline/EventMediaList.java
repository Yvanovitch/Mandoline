/*
 * 
 */

package Mandoline;

import java.io.File;
import java.util.EventObject;
import uk.co.caprica.vlcj.medialist.MediaList;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class EventMediaList extends EventPlayList {
    MediaList mediaList;
    
    public EventMediaList(Object source, MediaList mediaList) {
        super(source);
        
        this.mediaList = mediaList;
    }
    
    public MediaList getMediaList () {
        return mediaList;
    }

}
