package programSteps;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import testProgram.Main;

@SuppressWarnings("serial")
public class DatalogPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> datalogArray = new ArrayList<Object>();
	
	public DatalogPanel(int lineNumber) {
		JTextField whatVariable = new JTextField();
		this.add(whatVariable);
		datalogArray.add(whatVariable);
		whatVariable.getDocument().addDocumentListener(
				new DatalogListener());
		textLineNumber = lineNumber;
	}
	
	public DatalogPanel(ArrayList<String> datalog) {
		textLineNumber = Main.programSteps.getTabCount() - 1;
		JTextField whatVariable = new JTextField();
		this.add(whatVariable);
		datalogArray.add(whatVariable);
		whatVariable.getDocument().addDocumentListener(
				new DatalogListener());
		whatVariable.setText(datalog.get(0));
	}
	
	private class DatalogListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> dAI = datalogArray.iterator();
			String datalog = "Datalog " + ((JTextField) dAI.next()).getText();
			datalog = datalog + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, datalog);
			} else {
				Main.dataLines.set(textLineNumber, datalog);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> dAI = datalogArray.iterator();
			String datalog = "Datalog " + ((JTextField) dAI.next()).getText();
			datalog = datalog + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, datalog);
			} else {
				Main.dataLines.set(textLineNumber, datalog);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
