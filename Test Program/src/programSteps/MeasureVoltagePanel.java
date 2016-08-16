package programSteps;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import testProgram.Main;

@SuppressWarnings("serial")
public class MeasureVoltagePanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> measureVoltageArray = new ArrayList<Object>();
	String[] pinList = Main.getPinList();
	
	public MeasureVoltagePanel(int lineNumber) {
		
		
		for(String pin : pinList){
			if(!pin.isEmpty()){
				JCheckBox checkBox = new JCheckBox(pin);
				this.add(checkBox);
				measureVoltageArray.add(checkBox);
				checkBox.setName(pin);
				checkBox.addActionListener(new MeasureVoltageListener());
			}
		}
		
		
		
//		JTextField numberOfSamplesV = new JTextField();
//		numberOfSamplesV.setText("How Many Samples");
//		this.add(numberOfSamplesV);
//		measureVoltageArray.add(numberOfSamplesV);
//		numberOfSamplesV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
//		JTextField timeBetweenSamplesV = new JTextField();
//		timeBetweenSamplesV.setText("Time Between Samples");
//		this.add(timeBetweenSamplesV);
//		timeBetweenSamplesV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
//		measureVoltageArray.add(timeBetweenSamplesV);
//		JTextField variableNameV = new JTextField();
//		variableNameV.setText("Store As Variable Name");
//		this.add(variableNameV);
//		measureVoltageArray.add(variableNameV);
//		variableNameV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
		textLineNumber = lineNumber;
	}
	
//	public MeasureVoltagePanel(ArrayList<String> measV) {
//		JTextField numberOfSamplesV = new JTextField();
//		numberOfSamplesV.setText(measV.get(0));
//		this.add(numberOfSamplesV);
//		measureVoltageArray.add(numberOfSamplesV);
//		numberOfSamplesV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
//		JTextField timeBetweenSamplesV = new JTextField();
//		timeBetweenSamplesV.setText(measV.get(1));
//		this.add(timeBetweenSamplesV);
//		timeBetweenSamplesV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
//		measureVoltageArray.add(timeBetweenSamplesV);
//		JTextField variableNameV = new JTextField();
//		variableNameV.setText(measV.get(2));
//		this.add(variableNameV);
//		measureVoltageArray.add(variableNameV);
//		variableNameV.getDocument().addDocumentListener(
//				new MeasureVoltageListener());
//		textLineNumber = Main.programSteps.size();
//	}
	
	private class MeasureVoltageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Iterator<Object> mIAI = measureVoltageArray.iterator();
			String measCurrent = "Measure V at";
			String sampleInfo = ", 4 samples ever 13us, store as";

			do{
				Object next =  mIAI.next();
				if(((AbstractButton) next).isSelected()){
					measCurrent = measCurrent +  " "  + ((Component) next).getName();
					sampleInfo = sampleInfo + " " + Main.getTestPrefix() + ((Component) next).getName();
				}
			}while(mIAI.hasNext());
			
			
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, measCurrent + sampleInfo + ", respectively\n");
			} else {
				Main.dataLines.set(textLineNumber, measCurrent + sampleInfo + ", respectively\n");
			}
			Main.programDisplay.setText(Main.dataLines.toString());
			
		}
//		@Override
//		public void changedUpdate(DocumentEvent arg0) {
//		}
//
//		@Override
//		public void insertUpdate(DocumentEvent arg0) {
//			Iterator<Object> mVAI = measureVoltageArray.iterator();
//			String measureV = "Take " + ((JTextField) mVAI.next()).getText()
//					+ " samples";
//			measureV = measureV + " measuring every "
//					+ ((JTextField) mVAI.next()).getText() + " us,";
//			measureV = measureV + " store as variable "
//					+ ((JTextField) mVAI.next()).getText();
//			measureV = measureV + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, measureV);
//			} else {
//				Main.dataLines.set(textLineNumber, measureV);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent arg0) {
//			Iterator<Object> mVAI = measureVoltageArray.iterator();
//			String measureV = "Take " + ((JTextField) mVAI.next()).getText()
//					+ " samples";
//			measureV = measureV + " measuring every "
//					+ ((JTextField) mVAI.next()).getText() + " us,";
//			measureV = measureV + " store as variable "
//					+ ((JTextField) mVAI.next()).getText();
//			measureV = measureV + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, measureV);
//			} else {
//				Main.dataLines.set(textLineNumber, measureV);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
	}
}
