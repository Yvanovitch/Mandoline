package Mandoline;

import java.io.File;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;


public class MainController {
	public MainView mainView;
        public VlcListener listener;
 
	private MainModel model = null;
 
	public MainController (MainModel model, EmbeddedMediaPlayerComponent player){
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
 
	public void notifyVolumeChanged(int volume){
		model.setVolume(volume);
	}
        public void notifyPaused(){
                model.setPause();
        }
        public void notifyStopped(){
                model.setStop();
        }
        public void notifyNext(){
                model.setNext();
        }
        public void notifyPrevious(){
                model.setPrevious();
        }
        public void notifyAdd(File file){
                model.addFileToMediaList(file);
        }
}
