/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Mandoline;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author STEPHAN
 */
public class ChangeListener implements MouseMotionListener {
    private MainView view;

    
    public ChangeListener(MainView view){
        this.view = view;
    }
    
    public void mouseDragged(MouseEvent e) {
        
    }

    public void mouseMoved(MouseEvent e) {
        view.setPosition(view.getjSlider1()/100);
    }
}
