/*
 * 
 */

package Mandoline;

import java.io.File;
import java.util.EventObject;
import uk.co.caprica.vlcj.medialist.MediaList;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class PlayerView extends JPanelView {

    /**
     * Creates new form PlayerView
     */
    public PlayerView(MainController mainController) {
        super(mainController);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    public void refresh(EventObject event) {
    }

    public void positionChanged(float position) {
    }

    public void badFileChoosen(File file) {
    }

    public void mediaAdded(MediaList mediaList) {
    }
}