package simulations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Table extends JFrame{
	
	
	JButton newChip = new JButton("New Chip");
	JButton runAgain = new JButton("Run Again");
	JTable table;
	Object[][] data = {{"","","","","",""}};
	String[] columnNames = {"Test Name", "P/F", "Upper Limits", "Lower Limits", "Measurement", "Unit"};
	
	public Table(){
		
		runAgain.addActionListener(new RunAgainListener());
		newChip.addActionListener(new NewChipListener());
		
		this.add(newChip);
		this.add(runAgain);
	}
	
	public void toss(){
		
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
