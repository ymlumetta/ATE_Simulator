package simulations;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import testProgram.Main;

@SuppressWarnings("serial")
public class ContinuityTable extends Table{
	
	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	JScrollPane pane = new JScrollPane();
	
	
	
	public ContinuityTable(){
		setLayout(new FlowLayout());
		
		this.add(newChip);
		this.add(runAgain);
		this.add(new JLabel(Main.chipInUse));
	}
	
	public ContinuityTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;
	
		this.add(newChip);
		this.add(runAgain);
		this.add(new JLabel(Main.chipInUse));
	}
	
	
	
	public void toss(){
		remove(pane);
		Random random = new Random();
		int i = random.nextInt(data.get(0).measurements.size());
		//System.out.println(i);
		
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
		
		pane = new JScrollPane(table);
		add(pane);
	}
	
	
	
	private class RunAgainListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			remove(pane);
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
			
			
			pane = new JScrollPane(new JTable(ContinuityData, columnNames));
			add(pane);
			
			table.repaint();
		}
		
	}
	
	private class NewChipListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
			
}
