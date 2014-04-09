package Mandoline;

import java.util.EventListener;

public interface ViewListener extends EventListener {
    public void volumeChanged(VolumeChangedEvent event);
    
    public void positionChanged(float position);
}