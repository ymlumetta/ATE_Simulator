package vectorEditor;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VectorTableModel extends AbstractTableModel implements TableModelListener {
	
	private ArrayList<String> columnHeaders = new ArrayList<String>();
	private ArrayList<Row> data;

	public VectorTableModel() {
		columnHeaders.add("Step");
		columnHeaders.add("Capture");
		columnHeaders.add("Function");
		data = new ArrayList<Row>();
		Row first = new Row();
		first.step = 1;
		first.function = "Halt";
		data.add(first);
	}
	
	public VectorTableModel(ArrayList<String> headers) {
		columnHeaders = headers;
	}
	
	public VectorTableModel(ArrayList<String> headers, ArrayList<Row> rows) {
		columnHeaders = headers;
		data = rows;
	}

	@Override
	public int findColumn(String columnName) {
		return columnHeaders.indexOf(columnName);
	}
	
	@Override
	public String getColumnName(int col) {
		return columnHeaders.get(col);
	}

	@Override
	public int getColumnCount() {
		return columnHeaders.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	public void addRows(int numRows)
	{
		for(int i = 0; i < numRows; i++)
		{
			data.add(new Row(data.size() + 1));
			for(int j = 3; j < columnHeaders.size(); j++)
				data.get(data.size() - 1).vector.add(new Integer(0));
		}
		fireTableRowsInserted(data.size() - numRows, data.size());
	}
	
	public void addColumn(String pinName)
	{
		columnHeaders.add(pinName);
		for(int i = 0; i < data.size(); i++)
			data.get(i).vector.add(new Integer(0));
		fireTableStructureChanged();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch(arg1) {
		case 0: return data.get(arg0).step;
		case 1: return data.get(arg0).capture;
		case 2: return data.get(arg0).function;
		default: return data.get(arg0).get(arg1); 
		}
	}
	
	public void setValueAt(Object value, int row, int col) {
		switch(col) {
		case 1:
			data.get(row).capture = (boolean) value;
			break;
		case 2:
			data.get(row).function = (String) value;
			break;
		default:
			data.get(row).vector.set(col-3, new Integer(value.toString()));
			break;
		}
		fireTableCellUpdated(row, col);
	}
	
	public boolean isCellEditable(int row, int col) {
		if(col > 0)
			return true;
		return false;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public Row getRow(int arg0) {
		return data.get(arg0);
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
		int col = e.getColumn();
		VectorTableModel model = (VectorTableModel) e.getSource();
		
		switch(col) {
		case 1:
			model.setValueAt(!((boolean) model.getValueAt(row, col)), row, col);
			break;
		default:
			break;
		}
	}
}
