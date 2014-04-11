package Mandoline;

import java.io.File;
import java.util.EventListener;
import java.util.EventObject;
import uk.co.caprica.vlcj.medialist.MediaList;

/**
 *
 * @author STEPHAN
 */
public interface ModelListener extends EventListener {
    /**
     *
     * @param event
     */
    public void refresh(EventObject event);
    /*
    public void positionChanged(float position);
    
    public void badFileChoosen(File file);

    public void mediaAdded(MediaList mediaList);*/
}