package simulations;

import java.awt.FlowLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ContinuityTable extends Table{
	
	
	Object[][] ContinuityData = {
			{"ContVinm", "", "-0.2", "-1", "", "V"},
			{"ContVout", "", "1", "0.2", "", "V"},
			{"ContVinp", "", "-0.2", "-1", "", "V"},
			{"ContVCC", "", "-0.2", "-1", "", "V"},
			{"ContVEE", "", "1", "0.2", "", "V"}
			};;

			
	public ContinuityTable(){
		setLayout(new FlowLayout());
		table = new JTable(ContinuityData, columnNames);
				
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}
			
	public void setMeasurement(){
		
	}
}
