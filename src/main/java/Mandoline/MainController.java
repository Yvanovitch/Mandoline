package Mandoline;

import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

/**
 * It's the controller of the application
 *
 * @author STEPHAN
 */
public class MainController {

    /**
     *
     */
    public MainView mainView;
    /**
     *
     */
    public VlcListener listener;
    private MainModel model = null;

    /**
     * constructor of the mainController
     *
     * @param model
     * @param player
     */
    public MainController(MainModel model, EmbeddedMediaPlayerComponent player) {
        this.model = model;

        mainView = new MainView(this, player);
        listener = new VlcListener(mainView);
        player.getMediaPlayer().addMediaPlayerEventListener(listener);
        addListenersToModel();
    }

    private void addListenersToModel() {
        model.addListener(mainView);
    }
    /*public void displayViews(){
     mainView.display();
     }
     public void closeViews(){
     mainView.close();
     }*/

    /**
     *
     * @param volume
     */
    public void notifyVolumeChanged(int volume) {
        model.setVolume(volume);
    }

    /**
     *
     */
    public void notifyPaused() {
        model.setPause();
    }

    /**
     *
     */
    public void notifyStopped() {
        model.setStop();
    }

    /**
     *
     */
    public void notifyNext() {
        model.setNext();
    }

    /**
     *
     */
    public void notifyPrevious() {
        model.setPrevious();
    }

    /**
     *
     * @param file
     */
    public void notifyAdd(File file) {
        model.addFileToMediaList(file);
    }
    
    public void notifyNewPlay(String mrl) {
        model.playFile(mrl);
    }
}
