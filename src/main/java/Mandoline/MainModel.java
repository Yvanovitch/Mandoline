package Mandoline;

import java.io.File;
import java.util.EventObject;
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

        fireEvent(new EventVolume(this, getVolume()));
    }
    
    public void setPause(){
        player.getMediaPlayer().pause();
    }

    public float getPosition() {
        return this.position;
    }
    
    public void setPosition(float position) {
        this.position = position;
        fireEvent(new EventPosition(this, position));
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
            fireEvent(new EventMediaList(this, mediaList));
        }
        else {
            System.out.println("Fichier invalide");
            fireEvent(new EventBadFile(this, file));
        }
        
    }
    
    public void addListener(ModelListener listener) {
        listeners.add(ModelListener.class, listener);
    }

    public void removeListener(ModelListener l) {
        listeners.remove(ModelListener.class, l);
    }

    public void fireEvent(EventObject event) {
        ModelListener[] listenerList = listeners.getListeners(ModelListener.class);

        for (ModelListener listener : listenerList) {
            listener.refresh(event);
        }
    }
    
    
}
