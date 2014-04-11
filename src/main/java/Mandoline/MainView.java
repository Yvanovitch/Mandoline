/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mandoline;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.org.apache.xerces.internal.util.DOMUtil;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.EventObject;
import javax.swing.JButton;
import javax.swing.JPanel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventListener;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Mathieu
 */
public class MainView extends JFrameView implements ModelListener {

    JPanel playList;
    EmbeddedMediaPlayerComponent player;

    /**
     * Creates new form Player
     */
    public MainView(MainController mainController, EmbeddedMediaPlayerComponent player) {
        super(mainController);
        this.player = player;
        mediaPlayer = player;
       
        //player.getMediaPlayer().addMediaPlayerEventListener(new VlcListener(this));
        //mediaPlayerComponent.getMediaPlayer().start();
        System.out.println("Created");
        initComponents();

        playList = new PlayListView(this.getController());
        /*jFrame.add(jButton, BorderLayout.NORTH);
         jFrame.add(jButton2, BorderLayout.SOUTH);
         jFrame.setLayout(new BorderLayout()); //*/
        add(mediaPlayer, BorderLayout.CENTER);
        this.add(playList, BorderLayout.WEST);
        this.add(mediaPlayer);


        this.pack();

        this.display();
        this.startVideo();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        Pause = new javax.swing.JButton();
        stop = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Pause.setText("Pause");
        Pause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PauseActionPerformed(evt);
            }
        });

        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Repeat");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pause)
                .addGap(18, 18, 18)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stop)
                        .addComponent(jToggleButton1)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
        );

        jLabel1.getAccessibleContext().setAccessibleName("jTime");

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        controller.notifyPaused();
    }//GEN-LAST:event_PauseActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        controller.notifyStopped();
    }//GEN-LAST:event_stopActionPerformed
    private EmbeddedMediaPlayerComponent mediaPlayer;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pause;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables

    public void setPause(String str) {
        Pause.setText(str);
    }

    public boolean getToggleButton1state() {

        return jToggleButton1.isSelected();
    }

    public void setjlabel() {
        Time time = new Time(mediaPlayer.getMediaPlayer().getTime());
        jLabel1.setText(time.toString());
    }

    public int getjSlider1() {
        System.out.println(jSlider1.getValue());
        return jSlider1.getValue();
    }

    public void setPosition(float f) {

        mediaPlayer.getMediaPlayer().setPosition(f);

    }

    public void setjSlider1(int position) {
        jSlider1.setValue(position);
    }

    public void startVideo() {
        //jInternalFrame1.add(mediaPlayerComponent,BorderLayout.CENTER);
        System.out.println("Start video");
        mediaPlayer.getMediaPlayer().playMedia("test.avi");
        mediaPlayer.getMediaPlayer().start();
       



    }

    public void refresh(EventObject event) {
        if (event instanceof EventVolume) {
        } else if (event instanceof EventPosition) {
            this.positionChanged(event);
        } else if (event instanceof EventPlayList) {
            ((PlayListView) playList).refresh(event);
        }
    }

    public void positionChanged(EventObject event) {
        if (event instanceof EventPosition) {
            float position = ((EventPosition) event).getPosition();
            System.out.println("jslider1.setPos" + position);
        }
    }

    @Override
    public void display() {
        this.setVisible(true);
        this.startVideo();
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}