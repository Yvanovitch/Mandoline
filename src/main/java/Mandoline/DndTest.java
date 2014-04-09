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
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class DndTest extends JFrame {

    JTable table;
    JList<String> myList;
    DefaultListModel<String> myListModel;

    public DndTest() {
        String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};

        Object[][] data = {
            {"Kathy", "Smith",
                "Snowboarding", new Integer(5), new Boolean(false)},
            {"John", "Doe",
                "Rowing", new Integer(3), new Boolean(true)},
            {"Sue", "Black",
                "Knitting", new Integer(2), new Boolean(false)},
            {"Jane", "White",
                "Speed reading", new Integer(20), new Boolean(true)},
            {"Joe", "Brown",
                "Pool", new Integer(10), new Boolean(false)}
        };

        JTable table = new JTable(data, columnNames);

        //JTable(Vector rowData, Vector columnNames)
        //JTable table = new JTable(Object[][] rowData, Object[] columnNames);
        table.setDragEnabled(true);
        table.setDropMode(DropMode.INSERT_ROWS);
        table.setTransferHandler(new TableRowTransferHandler(table));

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        /*
         myListModel = createStringListModel();
         myList = new JList<String>(myListModel);
         MyMouseAdaptor myMouseAdaptor = new MyMouseAdaptor();
         myList.addMouseListener((MouseListener) myMouseAdaptor);
         myList.addMouseMotionListener((MouseMotionListener) myMouseAdaptor);
         */
        JPanel content = new JPanel();
        content.add(table);
        this.add(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private class MyMouseAdaptor extends MouseInputAdapter {

        private boolean mouseDragging = false;
        private int dragSourceIndex;

        @Override
        public void mousePressed(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e)) {
                dragSourceIndex = myList.getSelectedIndex();
                mouseDragging = true;
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            mouseDragging = false;
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (mouseDragging) {
                int currentIndex = myList.locationToIndex(e.getPoint());
                if (currentIndex != dragSourceIndex) {
                    int dragTargetIndex = myList.getSelectedIndex();
                    String dragElement = myListModel.get(dragSourceIndex);
                    myListModel.remove(dragSourceIndex);
                    myListModel.add(dragTargetIndex, dragElement);
                    dragSourceIndex = currentIndex;
                }
            }
        }
    }

    private DefaultListModel<String> createStringListModel() {
        final String[] listElements = new String[]{"Cat", "Dog", "Cow", "Horse", "Pig", "Monkey"};
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        for (String element : listElements) {
            listModel.addElement(element);
        }
        return listModel;
    }

    public static void main(String[] args) {
        new DndTest();
    }
}
