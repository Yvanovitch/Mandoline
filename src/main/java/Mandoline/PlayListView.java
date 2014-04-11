/*
 * 
 */

package Mandoline;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.util.EventObject;
import java.util.Vector;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.medialist.MediaList;
import uk.co.caprica.vlcj.player.MediaMeta;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;

/**
 *
 * @author yvan.richer@gmail.com
 */
public class PlayListView extends JPanelView {
    
    private JTable table;

    /**
     *
     * @param controller
     */
    public PlayListView(MainController controller) {
        super(controller);
        initComponents();
        System.out.println("PlayListView created");
        
        
        table = new JTable(new MyTableModel(controller));

        table.setDragEnabled(true);
        table.setDropMode(DropMode.INSERT_ROWS);
        table.setTransferHandler(new TableRowTransferHandler(table));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickOnListPerformed(evt);
            }
        });
        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setAutoscrolls(true);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                //.addContainerGap(162, Short.MAX_VALUE)
                .addComponent(scrollPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previous)
                .addGap(27, 27, 27))
        );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        errorFrame = new javax.swing.JFrame();
        fileErrorPane = new javax.swing.JOptionPane();
        explorer = new javax.swing.JFileChooser();
        add = new javax.swing.JButton();
        previous = new javax.swing.JButton();
        next = new javax.swing.JButton();

        errorFrame.setMinimumSize(new java.awt.Dimension(350, 150));

        fileErrorPane.setMessage("Le fichier choisi n\'est pas supporté par VLC");
        fileErrorPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fileErrorPaneMouseClicked(evt);
            }
        });

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

        add.setText("Ajouter");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        previous.setText("Précédent");
        previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousActionPerformed(evt);
            }
        });

        next.setText("Suivant");
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(previous, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(279, Short.MAX_VALUE)
                .addComponent(add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(next)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previous)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        controller.notifyNext();
    }//GEN-LAST:event_nextActionPerformed

    private void previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousActionPerformed
        controller.notifyPrevious();
    }//GEN-LAST:event_previousActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        explorer.setCurrentDirectory(new java.io.File("C:/"));

        if (explorer.showOpenDialog(null) == explorer.APPROVE_OPTION) {
            controller.notifyAdd(explorer.getSelectedFile());
        } else {
            System.out.println("No Selection ");
        }
    }//GEN-LAST:event_addActionPerformed

    private void fileErrorPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fileErrorPaneMouseClicked
        errorFrame.setVisible(false);
    }//GEN-LAST:event_fileErrorPaneMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JFrame errorFrame;
    private javax.swing.JFileChooser explorer;
    private javax.swing.JOptionPane fileErrorPane;
    private javax.swing.JButton next;
    private javax.swing.JButton previous;
    // End of variables declaration//GEN-END:variables


    /**
     *
     * @param event
     */
    public void refresh(EventObject event) {
        if(event instanceof EventNewFile) {
            newMedia((EventNewFile) event);
        }
    }
        
    public void newMedia(EventNewFile event) {
        if(event.isSupported()) {
            ((MyTableModel)table.getModel()).setList(event.data);
        }
        else {
            System.out.println("badFileChoosen : " + event.file);
            errorFrame.setVisible(true);
        }
    }
    
    
    public void clickOnListPerformed(java.awt.event.MouseEvent evt) {
        int index = table.getSelectedRow();
        controller.notifyNewPlay(index);
    }
}
