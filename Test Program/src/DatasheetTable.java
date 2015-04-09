import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class DatasheetTable extends AbstractTableModel {
	
	private String[] columnHeaders = {"Test Label", "Lower Limit", "Upper Limit", "Units"};
	private ArrayList<Row> data;

	public DatasheetTable() {
		data = new ArrayList<Row>();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnHeaders[col];
	}

	@Override
	public int getColumnCount() {
		return columnHeaders.length;
	}

	@Override
	public int getRowCount() {
		return data.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		switch (arg1) {
			case 0: return data.get(arg0).label;
			case 1: return data.get(arg0).lower;
			case 2: return data.get(arg0).upper;
			case 3: return data.get(arg0).unit;
			default: return null;
		}
	}
	
	public Row getRow(int arg0) {
		return data.get(arg0);
	}

	private class Row {
		private String label = "";
		private double lower = 0.0;
		private double upper = 0.0;
		private String unit = "";
		
		public Row() {
			
		}
	}
}
