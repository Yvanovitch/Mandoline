package Mandoline;

import java.util.Observable;
import javax.swing.event.EventListenerList;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 *
 * @author Mathieu
 */
public class MainModel extends Observable {

    private int volume;
    private float position;
    private EventListenerList listeners;
    private VlcListener vlcListener;

    public MainModel() {
        volume = 100;
        vlcListener = new VlcListener(this);
        listeners = new EventListenerList();
    }
    
    public VlcListener getVlcListener () {
        return vlcListener;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;

        fireVolumeChanged();
    }

    public float getPosition() {
        return this.position;
    }
    
    public void setPosition(float position) {
        this.position = position;
        firePositionChanged();
    }
    public void addListener(ViewListener listener) {
        listeners.add(ViewListener.class, listener);
    }

    public void removeListener(ViewListener l) {
        listeners.remove(ViewListener.class, l);
    }

    public void fireVolumeChanged() {
        ViewListener[] listenerList = (ViewListener[]) listeners.getListeners(ViewListener.class);

        for (ViewListener listener : listenerList) {
            listener.volumeChanged(new VolumeChangedEvent(this, getVolume()));
        }
    }
    
    public void firePositionChanged() {
        ViewListener[] listenerList = (ViewListener[]) listeners.getListeners(ViewListener.class);

        for (ViewListener listener : listenerList) {
            listener.positionChanged(getPosition());
        }
    }
}
