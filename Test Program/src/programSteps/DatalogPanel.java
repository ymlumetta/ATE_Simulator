package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import testProgram.Main;

@SuppressWarnings("serial")
public class DatalogPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> datalogArray = new ArrayList<Object>();
	
	public DatalogPanel(int lineNumber) {
		JComboBox<String> whatVariable = new JComboBox<String>(Main.getPinList());
		this.add(whatVariable);
		datalogArray.add(whatVariable);
		whatVariable.addActionListener(
				new DatalogListener());
		textLineNumber = lineNumber;
	}
	
	public DatalogPanel(ArrayList<String> datalog) {
		JComboBox<String> whatVariable = new JComboBox<String>(Main.getPinList());

		this.add(whatVariable);
		datalogArray.add(whatVariable);
		whatVariable.addActionListener(
				new DatalogListener());
		textLineNumber = Main.programSteps.size();
	}
	
	private class DatalogListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Iterator<Object> dAI = datalogArray.iterator();
			String datalog = "Datalog " +getTestPrefix() + ((JComboBox<?>) dAI.next()).getSelectedItem();
			datalog = datalog + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, datalog);
			} else {
				Main.dataLines.set(textLineNumber, datalog);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
			
		}
//		@Override
//		public void changedUpdate(DocumentEvent arg0) {
//		}
//
//		@Override
//		public void insertUpdate(DocumentEvent arg0) {
//			Iterator<Object> dAI = datalogArray.iterator();
//			String datalog = "Datalog " + ((JTextField) dAI.next()).getText();
//			datalog = datalog + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, datalog);
//			} else {
//				Main.dataLines.set(textLineNumber, datalog);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent arg0) {
//			Iterator<Object> dAI = datalogArray.iterator();
//			String datalog = "Datalog " + ((JTextField) dAI.next()).getText();
//			datalog = datalog + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, datalog);
//			} else {
//				Main.dataLines.set(textLineNumber, datalog);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
	}
	
	private static String getTestPrefix(){
		if(Main.test == null)
			return "";
		switch(Main.test){
		case "Continuity":
			return "Cont";
		default:
			return "";
		}
	}
}
