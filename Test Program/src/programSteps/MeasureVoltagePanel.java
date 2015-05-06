package programSteps;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import testProgram.Main;

@SuppressWarnings("serial")
public class MeasureVoltagePanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> measureVoltageArray = new ArrayList<Object>();
	
	public MeasureVoltagePanel(int lineNumber) {
		JTextField numberOfSamplesV = new JTextField();
		numberOfSamplesV.setText("How Many Samples");
		this.add(numberOfSamplesV);
		measureVoltageArray.add(numberOfSamplesV);
		numberOfSamplesV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		JTextField timeBetweenSamplesV = new JTextField();
		timeBetweenSamplesV.setText("Time Between Samples");
		this.add(timeBetweenSamplesV);
		timeBetweenSamplesV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		measureVoltageArray.add(timeBetweenSamplesV);
		JTextField variableNameV = new JTextField();
		variableNameV.setText("Store As Variable Name");
		this.add(variableNameV);
		measureVoltageArray.add(variableNameV);
		variableNameV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		textLineNumber = lineNumber;
	}
	
	public MeasureVoltagePanel(ArrayList<String> measV) {
		textLineNumber = Main.programSteps.getTabCount() - 1;
		JTextField numberOfSamplesV = new JTextField();
		numberOfSamplesV.setText(measV.get(0));
		this.add(numberOfSamplesV);
		measureVoltageArray.add(numberOfSamplesV);
		numberOfSamplesV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		JTextField timeBetweenSamplesV = new JTextField();
		timeBetweenSamplesV.setText(measV.get(1));
		this.add(timeBetweenSamplesV);
		timeBetweenSamplesV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		measureVoltageArray.add(timeBetweenSamplesV);
		JTextField variableNameV = new JTextField();
		this.add(variableNameV);
		measureVoltageArray.add(variableNameV);
		variableNameV.getDocument().addDocumentListener(
				new MeasureVoltageListener());
		variableNameV.setText(measV.get(2));
	}
	
	private class MeasureVoltageListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mVAI = measureVoltageArray.iterator();
			String measureV = "Take " + ((JTextField) mVAI.next()).getText()
					+ " samples";
			measureV = measureV + " measuring every "
					+ ((JTextField) mVAI.next()).getText() + " us,";
			measureV = measureV + " store as variable "
					+ ((JTextField) mVAI.next()).getText();
			measureV = measureV + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, measureV);
			} else {
				Main.dataLines.set(textLineNumber, measureV);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mVAI = measureVoltageArray.iterator();
			String measureV = "Take " + ((JTextField) mVAI.next()).getText()
					+ " samples";
			measureV = measureV + " measuring every "
					+ ((JTextField) mVAI.next()).getText() + " us,";
			measureV = measureV + " store as variable "
					+ ((JTextField) mVAI.next()).getText();
			measureV = measureV + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, measureV);
			} else {
				Main.dataLines.set(textLineNumber, measureV);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
