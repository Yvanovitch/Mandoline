package Mandoline;

import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;


public class VlcListener implements MediaPlayerEventListener {

    public void mediaChanged(MediaPlayer mediaPlayer, libvlc_media_t media, String mrl) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void opening(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void buffering(MediaPlayer mediaPlayer, float newCache) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void playing(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void paused(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void stopped(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void forward(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void backward(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void finished(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void timeChanged(MediaPlayer mediaPlayer, long newTime) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void positionChanged(MediaPlayer mediaPlayer, float newPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void seekableChanged(MediaPlayer mediaPlayer, int newSeekable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void pausableChanged(MediaPlayer mediaPlayer, int newPausable) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void titleChanged(MediaPlayer mediaPlayer, int newTitle) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void snapshotTaken(MediaPlayer mediaPlayer, String filename) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void lengthChanged(MediaPlayer mediaPlayer, long newLength) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void error(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaMetaChanged(MediaPlayer mediaPlayer, int metaType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaSubItemAdded(MediaPlayer mediaPlayer, libvlc_media_t subItem) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaDurationChanged(MediaPlayer mediaPlayer, long newDuration) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaParsedChanged(MediaPlayer mediaPlayer, int newStatus) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaFreed(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mediaStateChanged(MediaPlayer mediaPlayer, int newState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void newMedia(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void subItemPlayed(MediaPlayer mediaPlayer, int subItemIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void subItemFinished(MediaPlayer mediaPlayer, int subItemIndex) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void endOfSubItems(MediaPlayer mediaPlayer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}