package Mandoline;

import java.io.File;
import java.util.EventObject;
import java.util.Observable;
import java.util.Vector;
import javax.swing.event.EventListenerList;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.filter.MediaFileFilter;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.medialist.MediaListItem;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;

/**
 * It is the model of the application
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
    int currentMedia;
    

    /**
     *
     * @param player
     */
    public MainModel(EmbeddedMediaPlayerComponent player) {
        volume = 100;
        //vlcListener = new VlcListener(this);
        listeners = new EventListenerList();
        this.player = player;
        mediaPlayerFactory = new MediaPlayerFactory();
        mediaList = mediaPlayerFactory.newMediaList();
        currentMedia = 0;
    }
    
    /**
     *
     * @return
     */
    public VlcListener getVlcListener () {
        return vlcListener;
    }

    /**
     *
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;

        fireEvent(new EventVolume(this, getVolume()));
    }
    
    /**
     *
     */
    public void setPause(){
        player.getMediaPlayer().pause();
    }

    /**
     *
     * @return
     */
    public float getPosition() {
        return this.position;
    }
    
    /**
     *
     * @param position
     */
    public void setPosition(float position) {
        this.position = position;
        fireEvent(new EventPosition(this, position));
    }
    /**
     *
     */
    public void setStop(){
        player.getMediaPlayer().stop();
    }
    /**
     *
     */
    public void setNext(){
        if(mediaList.items().size() > currentMedia + 1) {
            playFile(currentMedia + 1);
        }
        else {
            System.out.println("Liste de lecture terminée.");
        }
    }
    /**
     *
     */
    public void setPrevious(){
        if(currentMedia > 0) {
            playFile(currentMedia -1);
        }
        else {
            System.out.println("Pas de fichier précédent");
        }
    }
    /**
     *
     */
    public void addMedia(){
        //TODO
    }
    
    public void reorder(int fromIndex, int toIndex) {
        System.out.println(fromIndex+" -> "+toIndex);
        MediaListItem item = mediaList.items().get(toIndex);
        mediaList.items().set(toIndex, mediaList.items().get(fromIndex));
        mediaList.items().set(fromIndex, item);
    }
    /**
     *
     * @param file
     */
    public void addFileToMediaList(File file){
        MediaFileFilter filter = new MediaFileFilter();
        if (filter.accept(file)){
            //On ajoute à notre playList
            mediaList.addMedia(file.getAbsolutePath());
            
            //On construit l'affichage
            MediaPlayerFactory factory = new MediaPlayerFactory();
            MediaPlayer mediaPlayer = factory.newHeadlessMediaPlayer();
            Vector data = new Vector<Vector<Object>>();
            
            for (MediaListItem item : mediaList.items()) {
                mediaPlayer.prepareMedia(item.mrl());
                mediaPlayer.parseMedia();
                MediaMeta mediaMeta = mediaPlayer.getMediaMeta();
                //System.out.println("MediaList changed, data : " + mediaMeta);
                Vector<Object> row = new Vector<Object>();
                row.add(mediaMeta.getTitle());
                row.add(file.getAbsolutePath());
                row.add(mediaMeta.getArtist());
                row.add(mediaMeta.getAlbum());
                data.add(row);
            }

            fireEvent(new EventNewFile(this, file, data, true));
        }
        else {
            System.out.println("Fichier invalide");
            fireEvent(new EventNewFile(this, file, null, false));
        }
    }
    
    public void playFile(int row) {
        MediaListItem item = mediaList.items().get(row);
        String mrl = item.mrl();
        player.getMediaPlayer().playMedia(mrl);
        player.getMediaPlayer().start();
        System.out.println("Mandoline joue "+mrl);
        currentMedia = row;
    }
    
    /**
     *
     * @param listener
     */
    public void addListener(ModelListener listener) {
        listeners.add(ModelListener.class, listener);
    }

    /**
     *
     * @param l
     */
    public void removeListener(ModelListener l) {
        listeners.remove(ModelListener.class, l);
    }

    /**
     *
     * @param event
     */
    public void fireEvent(EventObject event) {
        ModelListener[] listenerList = listeners.getListeners(ModelListener.class);

        for (ModelListener listener : listenerList) {
            listener.refresh(event);
        }
    }
    
    
}
