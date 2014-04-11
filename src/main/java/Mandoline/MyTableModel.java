
package Mandoline;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class MyTableModel extends AbstractTableModel implements Reorderable {
    private String[] columnNames = {"Name", "Length", "Artiste", "Album"};
    private Vector<Vector<Object>> data;

        /*Object[][] data = {
            {"Kathy", "00", "Kathy", "Album sans titre"},
            {"John", "Doe", "Kathy", "Album sans titre"},
            {"Sue", "Black", "Kathy", "Album sans titre"},
            {"Jane", "White", "Kathy", "Album sans titre"},
            {"Joe", "Brown", "Kathy", "Album sans titre"}
        };*/
    
        
    public MyTableModel () {
        data = new Vector<Vector<Object>>();
        
        Vector<Object> row2 = new Vector<Object>(4);
        for(int i = 0; i < 50; i++) {
            Vector<Object> row = new Vector<Object>(4);
            mySetElementAt(row, 3, "");
            data.add(row);
        }
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.size();//.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        //return data[row][col];
        if(data.size() < row)
            return null;
        if(data.get(row).size() < col)
            return null;
        return data.get(row).get(col);
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        //Note that the data/cell address is constant,
        //no matter where the cell appears onscreen.
        if (col < 2) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    @Override
    public void setValueAt(Object value, int row, int col) {
        //data[row][col] = value;
        /*Vector<Object> rowVector = new Vector<Object>(4);
        mySetElementAt(rowVector, value, col);
        
        while(data.size() < row) {
            this.addRow(new Vector<Object>());
        }
        this.addRow(rowVector);
        */
        if(data.size() < row) {
            return;
        }
        
        data.get(row).set(col, value);
        
        //System.out.println("data " + this.dataVector.size() + " row " + row);
        fireTableCellUpdated(row, col);

    }
    
    public Object mySetElementAt(Vector vector, int index, Object value) {
        while(vector.size() < index + 1) {
            vector.add("");
        }
        return vector.set(index, value);
    }

    public void reorder(int fromIndex, int toIndex) {
        data.set(fromIndex, data.set(toIndex, data.get(fromIndex)));
    }
}