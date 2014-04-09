package Mandoline;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DndTest extends JFrame {

    JTable table;
    JList<String> myList;
    DefaultListModel<String> myListModel;

    public DndTest() {

        JTable table = new JTable(new MyTableModel());

        //JTable(Vector rowData, Vector columnNames)
        //JTable table = new JTable(Object[][] rowData, Object[] columnNames);
        table.setDragEnabled(true);
        table.setDropMode(DropMode.INSERT_ROWS);
        table.setTransferHandler(new TableRowTransferHandler(table));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(table);
        JPanel content = new JPanel();
        content.add(scrollPane);
        this.add(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new DndTest();
    }
}
