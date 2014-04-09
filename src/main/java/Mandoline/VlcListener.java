package Mandoline;

import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;


public class VlcListener implements MediaPlayerEventListener {
    MainModel mainModel;
    
    public VlcListener (MainModel mainModel) {
        this.mainModel = mainModel;
    }

    public void mediaChanged(MediaPlayer mediaPlayer, libvlc_media_t media, String mrl) {
        //TODO
    }

    public void opening(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void buffering(MediaPlayer mediaPlayer, float newCache) {
        //TODO
    }

    public void playing(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void paused(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void stopped(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void forward(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void backward(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void finished(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
        //TODO
    }

    public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
        mainModel.setPosition(newPosition);
    }

    public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
        //TODO
    }

    public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
        //TODO
    }

    public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
        //TODO
    }

    public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
        //TODO
    }

    public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
        //TODO
    }

    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
        //TODO
    }

    public void error(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void mediaMetaChanged(MediaPlayer mediaPlayer, int metaType) {
        //TODO
    }

    public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
        //TODO
    }

    public void mediaDurationChanged(MediaPlayer mediaPlayer, long newDuration) {
        //TODO
    }

    public void mediaParsedChanged(MediaPlayer mediaPlayer, int newStatus) {
        //TODO
    }

    public void mediaFreed(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void mediaStateChanged(MediaPlayer mediaPlayer, int newState) {
        //TODO
    }

    public void newMedia(MediaPlayer mediaPlayer) {
        //TODO
    }

    public void subItemPlayed(MediaPlayer mediaPlayer, int subItemIndex) {
        //TODO
    }

    public void subItemFinished(MediaPlayer mediaPlayer, int subItemIndex) {
        //TODO
    }

    public void endOfSubItems(MediaPlayer mediaPlayer) {
        //TODO
    }
    
}