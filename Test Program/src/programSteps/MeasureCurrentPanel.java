package programSteps;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import testProgram.Main;

@SuppressWarnings("serial")
public class MeasureCurrentPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> measureCurrentArray = new ArrayList<Object>();
	
	public MeasureCurrentPanel(int lineNumber) {
		JTextField numberOfSamplesC = new JTextField();
		numberOfSamplesC.setText("How Many Samples");
		this.add(numberOfSamplesC);
		measureCurrentArray.add(numberOfSamplesC);
		numberOfSamplesC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		JTextField timeBetweenSamplesC = new JTextField();
		timeBetweenSamplesC.setText("Time Between Samples");
		this.add(timeBetweenSamplesC);
		timeBetweenSamplesC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		measureCurrentArray.add(timeBetweenSamplesC);
		JTextField variableNameC = new JTextField();
		variableNameC.setText("Store As Variable Name");
		this.add(variableNameC);
		measureCurrentArray.add(variableNameC);
		variableNameC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		textLineNumber = lineNumber;
	}
	
	public MeasureCurrentPanel(ArrayList<String> measI) {
		textLineNumber = Main.programSteps.getTabCount() - 1;
		JTextField numberOfSamplesC = new JTextField();
		numberOfSamplesC.setText(measI.get(0));
		this.add(numberOfSamplesC);
		measureCurrentArray.add(numberOfSamplesC);
		numberOfSamplesC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		JTextField timeBetweenSamplesC = new JTextField();
		timeBetweenSamplesC.setText(measI.get(1));
		this.add(timeBetweenSamplesC);
		timeBetweenSamplesC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		measureCurrentArray.add(timeBetweenSamplesC);
		JTextField variableNameC = new JTextField();
		this.add(variableNameC);
		measureCurrentArray.add(variableNameC);
		variableNameC.getDocument().addDocumentListener(
				new MeasureCurrentListener());
		variableNameC.setText(measI.get(2));
	}
	
	private class MeasureCurrentListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mIAI = measureCurrentArray.iterator();
			String measureI = "Take " + ((JTextField) mIAI.next()).getText()
					+ " samples";
			measureI = measureI + " measuring every "
					+ ((JTextField) mIAI.next()).getText() + " us,";
			measureI = measureI + " store as variable "
					+ ((JTextField) mIAI.next()).getText();
			measureI = measureI + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, measureI);
			} else {
				Main.dataLines.set(textLineNumber, measureI);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mIAI = measureCurrentArray.iterator();
			String measureI = "Take " + ((JTextField) mIAI.next()).getText()
					+ " samples";
			measureI = measureI + " measuring every "
					+ ((JTextField) mIAI.next()).getText() + " us,";
			measureI = measureI + " store as variable "
					+ ((JTextField) mIAI.next()).getText();
			measureI = measureI + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, measureI);
			} else {
				Main.dataLines.set(textLineNumber, measureI);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
