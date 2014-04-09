package Mandoline;

import java.io.File;
import java.util.EventListener;
import uk.co.caprica.vlcj.medialist.MediaList;

public interface ViewListener extends EventListener {
    public void volumeChanged(VolumeChangedEvent event);
    
    public void positionChanged(float position);
    
    public void badFileChoosen(File file);

    public void mediaAdded(MediaList mediaList);
}