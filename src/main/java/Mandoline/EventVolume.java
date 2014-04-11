
//N'est qu'un exemple d'événement gérable

//Permet d'envoyer à la Vue l'événement en sachant quel a été le model source de l'événement

package Mandoline;

import java.util.EventObject;
 
/**
 *
 * @author STEPHAN
 */
public class EventVolume extends EventObject{
	private int newVolume;
 
	/**
     *
     * @param source
     * @param newVolume
     */
    public EventVolume(Object source, int newVolume){
		super(source);
 
		this.newVolume = newVolume;
	}
 
	/**
     *
     * @return
     */
    public int getNewVolume(){
		return newVolume;
	}
}
