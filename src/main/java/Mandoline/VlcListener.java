package Mandoline;

import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;

/**
 *
 * @author STEPHAN
 */
public class VlcListener implements MediaPlayerEventListener {
    
    MainView view;
    
    /**
     *
     * @param view
     */
    public VlcListener(MainView view) {
        this.view = view;
    }
    
    /**
     *
     * @param mediaPlayer
     * @param media
     * @param mrl
     */
    public void mediaChanged(MediaPlayer mediaPlayer, libvlc_media_t media, String mrl) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void opening(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newCache
     */
    public void buffering(MediaPlayer mediaPlayer, float newCache) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void playing(MediaPlayer mediaPlayer) {
        view.setPause("pause");
        
        
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void paused(MediaPlayer mediaPlayer) {
        view.setPause("play");
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void stopped(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void forward(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void backward(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void finished(MediaPlayer mediaPlayer) {
        
        
        if (view.getToggleButton1state()) {
            view.startVideo();
            
        }
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newTime
     */
    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newPosition
     */
    public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
        float position = view.getjSlider1();
        view.setjSlider1((int) (newPosition * 100));
       
        view.setjlabel();
        
        
        
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newSeekable
     */
    public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newPausable
     */
    public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newTitle
     */
    public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param filename
     */
    public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newLength
     */
    public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newCount
     */
    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void error(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param metaType
     */
    public void mediaMetaChanged(MediaPlayer mediaPlayer, int metaType) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param subItem
     */
    public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newDuration
     */
    public void mediaDurationChanged(MediaPlayer mediaPlayer, long newDuration) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newStatus
     */
    public void mediaParsedChanged(MediaPlayer mediaPlayer, int newStatus) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void mediaFreed(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param newState
     */
    public void mediaStateChanged(MediaPlayer mediaPlayer, int newState) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void newMedia(MediaPlayer mediaPlayer) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param subItemIndex
     */
    public void subItemPlayed(MediaPlayer mediaPlayer, int subItemIndex) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     * @param subItemIndex
     */
    public void subItemFinished(MediaPlayer mediaPlayer, int subItemIndex) {
        //TODO
    }
    
    /**
     *
     * @param mediaPlayer
     */
    public void endOfSubItems(MediaPlayer mediaPlayer) {
        //TODO
    }
}