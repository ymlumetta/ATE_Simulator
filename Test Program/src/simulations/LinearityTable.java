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
public class LinearityTable extends Table{
	ArrayList<DataContainer> data = new ArrayList<DataContainer>();
	
	
	
	public LinearityTable(){
		setLayout(new FlowLayout());
		runAgain.addActionListener(new RunAgainListener());
		newChip.addActionListener(new NewChipListener());
		
		this.add(newChip);
		this.add(runAgain);
		this.add(new JLabel(Main.chipInUse));
	}
	
	public LinearityTable(ArrayList<DataContainer> d){
		setLayout(new FlowLayout());
		data = d;
		runAgain.addActionListener(new RunAgainListener());
		newChip.addActionListener(new NewChipListener());
		
		this.add(newChip);
		this.add(runAgain);
		this.add(new JLabel(Main.chipInUse));
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
	
	private class RunAgainListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		
	}
	
	private class NewChipListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
