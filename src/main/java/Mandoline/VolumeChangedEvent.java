
//N'est qu'un exemple d'événement gérable

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
