package simulations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

//import programSteps.SetVoltagePanel.setVoltageListener;
import testProgram.Main;

@SuppressWarnings("serial")
public class Table extends JFrame{
	
	
	
	String[] chipset = {"Chip 1", "Chip 2", "Chip 3", "Chip 4", "Chip 5"};



	
	JButton runAgain = new JButton("Run Again");
	JComboBox<String> newChip = new JComboBox<String>(chipset);
	
	
//	public static JLabel chipNumber = new JLabel(Main.chipInUse);
	
	JTable table;
	Object[][] data = {{"","","","","",""}};
	String[] columnNames = {"Test Name", "P/F", "Upper Limits", "Lower Limits", "Measurement", "Unit"};
	
	@SuppressWarnings("unused")
	public Table(){
		
		JComboBox<String> newChip = new JComboBox<String>(chipset);
		
		
		runAgain.addActionListener(new RunAgainListener());
		
	}
	
	public void toss(){
		
	}
	
	private class RunAgainListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String chipInUse = "Currently using: ";
			
			chipInUse = chipInUse + newChip.getSelectedItem();
			
			Main.chipInUse = chipInUse;
			System.out.println(Main.chipInUse);
			
			SimRunner runner = new SimRunner();
			runner.runSim(Main.test, Main.part);
			
			
		}
		
	}
	
		
}
