package simulations;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;


@SuppressWarnings("serial")
public class THDTable extends Table{
	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	
	
	
	public THDTable(){
		setLayout(new FlowLayout());

		
		this.add(newChip);
		this.add(runAgain);
	}
	
	public THDTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;

		
		this.add(newChip);
		this.add(runAgain);
	}
	
	
	public void toss(){
		Random random = new Random();
		int i = random.nextInt(data.get(0).measurements.size());
//		System.out.println(i);
		
		String Data = data.get(0).measurements.get(i);
		String Stat = data.get(0).status.get(i);
		
		
		
		
		Object[][] ContinuityData = {
				{"THD", Stat, "100", "-100", Data, "dB"},
				};;
		table = new JTable(ContinuityData, columnNames);
		
		JScrollPane pane = new JScrollPane(table);
		add(pane);
	}
	
	
}
