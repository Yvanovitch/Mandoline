
//N'est qu'un exemple d'événement gérable

//Permet d'envoyer à la Vue l'événement en sachant quel a été le model source de l'événement

package Mandoline;

import java.util.EventObject;
 
public class VolumeChangedEvent extends EventObject{
	private int newVolume;
 
	public VolumeChangedEvent(Object source, int newVolume){
		super(source);
 
		this.newVolume = newVolume;
	}
 
	public int getNewVolume(){
		return newVolume;
	}
}
