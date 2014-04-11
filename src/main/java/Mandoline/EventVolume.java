
//Pas encore implémenté
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
