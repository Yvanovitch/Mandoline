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
import java.io.File;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.binding.internal.libvlc_media_t;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Mathieu
 */
public class MainView extends AbstractView implements ViewListener {

    /**
     * Creates new form Player
     */
    public MainView(MainController mainController, EmbeddedMediaPlayerComponent player) {
        super(mainController);
        
        
        mediaPlayerComponent = player;

        //mediaPlayerComponent.getMediaPlayer().start();
        System.out.println("Created");
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

        explorer = new javax.swing.JFileChooser();
        errorFrame = new javax.swing.JFrame();
        fileErrorPane = new javax.swing.JOptionPane();
        jPlayList = new javax.swing.JPanel();
        next = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        add = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        Pause = new javax.swing.JButton();
        stop = new javax.swing.JButton();

        errorFrame.setMinimumSize(new java.awt.Dimension(350, 150));

        fileErrorPane.setMessage("Le fichier choisi n\'est pas supporté par VLC");

        javax.swing.GroupLayout errorFrameLayout = new javax.swing.GroupLayout(errorFrame.getContentPane());
        errorFrame.getContentPane().setLayout(errorFrameLayout);
        errorFrameLayout.setHorizontalGroup(
            errorFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 262, Short.MAX_VALUE)
            .addGroup(errorFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(errorFrameLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(fileErrorPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        errorFrameLayout.setVerticalGroup(
            errorFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 95, Short.MAX_VALUE)
            .addGroup(errorFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(errorFrameLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(fileErrorPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        next.setText("Suivant");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        previous.setText("Précédent");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPlayListLayout = new javax.swing.GroupLayout(jPlayList);
        jPlayList.setLayout(jPlayListLayout);
        jPlayListLayout.setHorizontalGroup(
            jPlayListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
            .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPlayListLayout.setVerticalGroup(
            jPlayListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPlayListLayout.createSequentialGroup()
                .addContainerGap(195, Short.MAX_VALUE)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previous)
                .addGap(10, 10, 10))
        );

        getContentPane().add(jPlayList, java.awt.BorderLayout.LINE_START);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Pause, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                    .addComponent(Pause, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PauseActionPerformed
        controller.notifyPaused();
    }//GEN-LAST:event_PauseActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        controller.notifyStopped();
    }//GEN-LAST:event_stopActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        controller.notifyNext();
    }//GEN-LAST:event_nextActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        controller.notifyPrevious();
    }//GEN-LAST:event_previousActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        explorer.setCurrentDirectory(new java.io.File("D:/Films"));
        
        if (explorer.showOpenDialog(null) == explorer.APPROVE_OPTION) {
                controller.notifyAdd(explorer.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_addActionPerformed




    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Pause;
    private javax.swing.JButton add;
    private javax.swing.JFrame errorFrame;
    private javax.swing.JFileChooser explorer;
    private javax.swing.JOptionPane fileErrorPane;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPlayList;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    private javax.swing.JButton stop;
    // End of variables declaration//GEN-END:variables

    public void startVideo() {
        add(mediaPlayerComponent,BorderLayout.CENTER);
        //jInternalFrame1.add(mediaPlayerComponent,BorderLayout.CENTER);
        System.out.println("Start video");
        mediaPlayerComponent.getMediaPlayer().playMedia("test.avi");
        mediaPlayerComponent.getMediaPlayer().start();

    }

    public void volumeChanged(VolumeChangedEvent event) {
        //TODO
    }
    
    public void positionChanged(float position) {
        System.out.println("jslider1.setPos"+position);
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

    public void badFileChoosen(File file) {
        System.out.println("badFileChoosen");
        errorFrame.setVisible(true);
    }

    public void mediaAdded(MediaList mediaList) {
        Object [][] mediaTable = null;
        MediaPlayerFactory factory = new MediaPlayerFactory();
        MediaPlayer mediaPlayer = factory.newHeadlessMediaPlayer();
        for (int i=0 ; i < mediaList.size() ; i++){
            System.out.println("Media : " + mediaList.items().get(i).name() + mediaList.items().get(i).mrl());
            mediaPlayer.playMedia(mediaList.items().get(i).mrl());
            MediaMeta mediaMeta = mediaPlayer.getMediaMeta();
            System.out.println("data : " + mediaMeta);
        }
    }
}