
package Mandoline;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;


public class MyTableModel extends AbstractTableModel implements Reorderable {
    private String[] columnNames = {"Name", "mrl", "Artiste", "Album"};
    private Vector<Vector<Object>> data;
    private int lastIndex = 0;
    private MainController controller;

    public MyTableModel (MainController controller) {
        data = new Vector<Vector<Object>>();
        lastIndex = 0;
        this.controller = controller;
        
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
        if(data.size() < row) {
            return;
        }
        
        data.get(row).set(col, value);
        
        fireTableCellUpdated(row, col);

    }
    
    public Object mySetElementAt(Vector vector, int index, Object value) {
        while(vector.size() < index + 1) {
            vector.add("");
        }
        return vector.set(index, value);
    }

    public void reorder(int fromIndex, int toIndex) {
        if(toIndex > 0) 
            toIndex -= 1;
        System.out.println(fromIndex+" -> "+toIndex);
        Vector<Object> temp = (Vector<Object>)data.get(toIndex).clone();
        data.set(toIndex, data.get(fromIndex));
        data.set(fromIndex, temp);
        controller.notifyReorder(fromIndex, toIndex);
    }
    
    public void setRow(Vector<Object> row) {
        data.set(lastIndex, row);
        for(int i = 0; i < row.size(); i++) {
            setValueAt(row.get(i), lastIndex, i);
        }
        
        lastIndex++;
    }
    
    public String getMrl(int index) {
        return (String)data.get(index).get(1);
    }
    
    public void setList(Vector<Vector<Object>> data) {
        for(int i = 0; i < data.size(); i++) {
            for(int j = 0; j < data.get(i).size(); j++) {
                setValueAt(data.get(i).get(j), i, j);
            }
        }
    }
}