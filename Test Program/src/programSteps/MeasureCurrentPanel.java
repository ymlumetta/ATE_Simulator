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
public class MeasureCurrentPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> measureCurrentArray = new ArrayList<Object>();
	String[] pinList = Main.getPinList();
	
	public MeasureCurrentPanel(int lineNumber) {
		
		
		
		
		for(String pin : pinList){
			if(!pin.isEmpty()){
				JCheckBox checkBox = new JCheckBox(pin);
				this.add(checkBox);
				measureCurrentArray.add(checkBox);
				checkBox.setName(pin);
				checkBox.addActionListener(new MeasureCurrentListener());
			}
		}
//		JTextField numberOfSamplesC = new JTextField();
//		numberOfSamplesC.setText("How Many Samples");
//		this.add(numberOfSamplesC);
//		measureCurrentArray.add(numberOfSamplesC);
//		numberOfSamplesC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
//		JTextField timeBetweenSamplesC = new JTextField();
//		timeBetweenSamplesC.setText("Time Between Samples");
//		this.add(timeBetweenSamplesC);
//		timeBetweenSamplesC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
//		measureCurrentArray.add(timeBetweenSamplesC);
//		JTextField variableNameC = new JTextField();
//		variableNameC.setText("Store As Variable Name");
//		this.add(variableNameC);
//		measureCurrentArray.add(variableNameC);
//		variableNameC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
		textLineNumber = lineNumber;
	}
	
//	public MeasureCurrentPanel(ArrayList<String> measI) {
//		JTextField numberOfSamplesC = new JTextField();
//		numberOfSamplesC.setText(measI.get(0));
//		this.add(numberOfSamplesC);
//		measureCurrentArray.add(numberOfSamplesC);
//		numberOfSamplesC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
//		JTextField timeBetweenSamplesC = new JTextField();
//		timeBetweenSamplesC.setText(measI.get(1));
//		this.add(timeBetweenSamplesC);
//		timeBetweenSamplesC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
//		measureCurrentArray.add(timeBetweenSamplesC);
//		JTextField variableNameC = new JTextField();
//		variableNameC.setText(measI.get(2));
//		this.add(variableNameC);
//		measureCurrentArray.add(variableNameC);
//		variableNameC.getDocument().addDocumentListener(
//				new MeasureCurrentListener());
//		textLineNumber = Main.programSteps.size();
//	}
	
	private class MeasureCurrentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			Iterator<Object> mIAI = measureCurrentArray.iterator();
			String measCurrent = "Measure I at";
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
//			Iterator<Object> mIAI = measureCurrentArray.iterator();
//			String measureI = "Take " + ((JTextField) mIAI.next()).getText()
//					+ " samples";
//			measureI = measureI + " measuring every "
//					+ ((JTextField) mIAI.next()).getText() + " us,";
//			measureI = measureI + " store as variable "
//					+ ((JTextField) mIAI.next()).getText();
//			measureI = measureI + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, measureI);
//			} else {
//				Main.dataLines.set(textLineNumber, measureI);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
//
//		@Override
//		public void removeUpdate(DocumentEvent arg0) {
//			Iterator<Object> mIAI = measureCurrentArray.iterator();
//			String measureI = "Take " + ((JTextField) mIAI.next()).getText()
//					+ " samples";
//			measureI = measureI + " measuring every "
//					+ ((JTextField) mIAI.next()).getText() + " us,";
//			measureI = measureI + " store as variable "
//					+ ((JTextField) mIAI.next()).getText();
//			measureI = measureI + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, measureI);
//			} else {
//				Main.dataLines.set(textLineNumber, measureI);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
//		}
	}
}
