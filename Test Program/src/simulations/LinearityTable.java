package simulations;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class LinearityTable extends Table{
	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	
	
	
	public LinearityTable(){
		setLayout(new FlowLayout());
	}
	
	public LinearityTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;
	}
	
	public void toss(){
		Random random = new Random();
		int i = random.nextInt(data.get(0).measurements.size());
		System.out.println(i);
		
		String dnlData = data.get(0).measurements.get(i);
		String dnlStat = data.get(0).status.get(i);
		
		String inlData = data.get(1).measurements.get(i);
		String inlStat = data.get(1).status.get(i);
		
		
		
		
		Object[][] ContinuityData = {
				{"DNL", dnlStat, "-0.2", "-1", dnlData, "V"},
				{"INL", inlStat, "1", "0.2", inlData, "V"},
				};;
		table = new JTable(ContinuityData, columnNames);
		
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}

}
