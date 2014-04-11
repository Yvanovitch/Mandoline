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
    
    /**
     *
     * @param source
     * @param mediaList
     */
    public EventMediaList(Object source, MediaList mediaList) {
        super(source);
        
        this.mediaList = mediaList;
    }
    
    /**
     *
     * @return
     */
    public MediaList getMediaList () {
        return mediaList;
    }

}
