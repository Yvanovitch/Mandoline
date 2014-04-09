package Mandoline;

import java.io.File;
import java.util.Observable;
import javax.swing.event.EventListenerList;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.filter.MediaFileFilter;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.medialist.MediaListItem;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;

/**
 *
 * @author Mathieu
 */
public class MainModel extends Observable {

    private int volume;
    private float position;
    private EventListenerList listeners;
    private VlcListener vlcListener;
    private EmbeddedMediaPlayerComponent player;
    MediaPlayerFactory mediaPlayerFactory;
    MediaList mediaList;
    

    public MainModel(EmbeddedMediaPlayerComponent player) {
        volume = 100;
        vlcListener = new VlcListener(this);
        listeners = new EventListenerList();
        this.player = player;
        mediaPlayerFactory = new MediaPlayerFactory();
        mediaList = mediaPlayerFactory.newMediaList();
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
    
    public void setPause(){
        player.getMediaPlayer().pause();
    }

    public float getPosition() {
        return this.position;
    }
    
    public void setPosition(float position) {
        this.position = position;
        firePositionChanged();
    }
    public void setStop(){
        player.getMediaPlayer().stop();
    }
    public void setNext(){
        //TODO
    }
    public void setPrevious(){
        //TODO
    }
    public void addMedia(){
        //TODO
    }
    public void addFileToMediaList(File file){
        MediaFileFilter filter = new MediaFileFilter();
        if (filter.accept(file)){
            mediaList.addMedia(file.getPath());
            fireMediaAdded(mediaList);
        }
        else {
            System.out.println("Fichier invalide");
            fireBadFileChoosen(file);
        }
        
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

    private void fireBadFileChoosen(File file) {
        ViewListener[] listenerList = (ViewListener[]) listeners.getListeners(ViewListener.class);

        for (ViewListener listener : listenerList) {
            listener.badFileChoosen(file);
        }
    }

    private void fireMediaAdded(MediaList mediaList) {
        ViewListener[] listenerList = (ViewListener[]) listeners.getListeners(ViewListener.class);

        for (ViewListener listener : listenerList) {
            listener.mediaAdded(mediaList);
        }
    }
    
    
}
