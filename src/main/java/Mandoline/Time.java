/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mandoline;

/**
 * a class which is used to convert a time to second minute and hour
 * @author STEPHAN
 */
public class Time {

    /**
     *
     */
    public int seconde;
    /**
     *
     */
    public int tempSec;
    /**
     *
     */
    public int minute;
    /**
     *
     */
    public int tempMin;
    /**
     *
     */
    public int hour;
    /**
     *
     */
    public int tempHour;

    /**
     *
     * @param time
     */
    public Time(float time) {
        tempSec = (int) (time / 1000);
        tempMin = tempSec / 60;
        tempHour = tempMin / 60;
        seconde = tempSec % 60;
        minute = tempMin % 60;
        hour = tempHour % 60;
    }

    public String toString() {
        return hour + " : " + minute + " : " + seconde;

    }
}
