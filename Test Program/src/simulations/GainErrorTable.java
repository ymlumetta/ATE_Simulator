package simulations;

import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class GainErrorTable extends Table{

	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	
	
	
	public GainErrorTable(){
		setLayout(new FlowLayout());
	}
	
	public GainErrorTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;
	}
	
	
	
	public void toss(){
		Random random = new Random();
		int i = random.nextInt(data.get(0).measurements.size());
		System.out.println(i);
		
		String zseData = data.get(0).measurements.get(i);
		String zseStat = data.get(0).status.get(i);
		
		String geData = data.get(1).measurements.get(i);
		String geStat = data.get(1).status.get(i);
		
		
		
		Object[][] ContinuityData = {
				{"ZSE", zseStat, "0.01", "-0.01", zseData, "V"},
				{"GE", geStat, "0.6", "-0.6", geData, "%"},
				};;
		table = new JTable(ContinuityData, columnNames);
		
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}

}
