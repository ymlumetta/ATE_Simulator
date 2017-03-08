package simulations;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class ContinuityTable extends Table{
	
	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	
	
	
	public ContinuityTable(){
		setLayout(new FlowLayout());
	}
	
	public ContinuityTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;
	}
	
	
	
	public void toss(){
		Random random = new Random();
		int i = random.nextInt(data.get(0).measurements.size());
		System.out.println(i);
		
		String vinmData = data.get(0).measurements.get(i);
		String vinmStat = data.get(0).status.get(i);
		
		String voutData = data.get(1).measurements.get(i);
		String voutStat = data.get(1).status.get(i);
		
		String vinpData = data.get(2).measurements.get(i);
		String vinpStat = data.get(2).status.get(i);
		
		String vccData = data.get(3).measurements.get(i);
		String vccStat = data.get(3).status.get(i);
		
		String veeData = data.get(4).measurements.get(i);
		String veeStat = data.get(4).status.get(i);
		
		
		
		
		Object[][] ContinuityData = {
				{"ContVinm", vinmStat, "-0.2", "-1", vinmData, "V"},
				{"ContVout", voutStat, "1", "0.2", voutData, "V"},
				{"ContVinp", vinpStat, "-0.2", "-1", vinpData, "V"},
				{"ContVCC", vccStat, "-0.2", "-1", vccData, "V"},
				{"ContVEE", veeStat, "1", "0.2", veeData, "V"}
				};;
		table = new JTable(ContinuityData, columnNames);
		
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}
			
	public void setMeasurement(){
		
	}
}
