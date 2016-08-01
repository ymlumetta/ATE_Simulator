package vectorEditor;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class VectorTable extends AbstractTableModel {
	
	private ArrayList<String> columnHeaders = new ArrayList<String>();
	private ArrayList<Row> data;

	public VectorTable() {
		columnHeaders.add("Step");
		columnHeaders.add("Capture");
		columnHeaders.add("Function");
		data = new ArrayList<Row>();
		Row first = new Row();
		first.step = 1;
		first.function = "Halt";
		data.add(first);
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

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch(arg1) {
		case 0: return data.get(arg0).step;
		case 1: return data.get(arg0).capture;
		case 2: return data.get(arg0).function;
		default: return data.get(arg0).get(arg1); 
		}
	}
	
	@Override
	public Class<? extends Object> getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
	
	public Row getRow(int arg0) {
		return data.get(arg0);
	}

	private class Row {
		public int step = 0;
		public boolean capture = false;
		public String function = "";
		public ArrayList<Integer> vector = null;
		
		public Row() {
			vector = new ArrayList<Integer>();
		}
		
		public Integer get(int i) {
			if((i-2) > vector.size())
				return null;
			return vector.get(i-2);
		}
	}
}
