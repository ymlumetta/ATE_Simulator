package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import testProgram.Main;

@SuppressWarnings("serial")
public class SetVoltagePanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> setVoltageArray = new ArrayList<Object>();
	ArrayList<String> setVoltageDataLines = new ArrayList<String>();
	
	public SetVoltagePanel(int lineNumber) {
		
		JComboBox<String> pinList = new JComboBox<String>(
				new String[] {"", "VCC", "VEE"});
		this.add(pinList);
		setVoltageArray.add(pinList);
		pinList.addActionListener(new setVoltageListener());
		
		JComboBox<String> currentOptions = new JComboBox<String>(
				new String[] {"", "0 V"});
		this.add(currentOptions);
		setVoltageArray.add(currentOptions);
		currentOptions.addActionListener(new setVoltageListener());
		
		JButton confirm = new JButton("Confirm");
		this.add(confirm);
		setVoltageArray.add(confirm);
		confirm.addActionListener(new confirmListener());
		
		JButton clear = new JButton("Clear");
		this.add(clear);
		setVoltageArray.add(clear);
		clear.addActionListener(new clearListener());
		
		
		
		
		
//		JTextField whereV = new JTextField();
//		whereV.setText("Where");
//		this.add(whereV);
//		setVoltageArray.add(whereV);
//		whereV.addActionListener(new setVoltageListener());
//		JTextField Voltage = new JTextField();
//		Voltage.setText("0.0");
//		this.add(Voltage);
//		setVoltageArray.add(Voltage);
//		Voltage.addActionListener(new setVoltageListener());
//		JComboBox<String> voltageRangeV = new JComboBox<String>(
//				new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
//		this.add(voltageRangeV);
//		setVoltageArray.add(voltageRangeV);
//		voltageRangeV.addActionListener(new setVoltageListener());
//		JComboBox<String> currentRangeV = new JComboBox<String>(
//				new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
//		this.add(currentRangeV);
//		setVoltageArray.add(currentRangeV);
//		currentRangeV.addActionListener(new setVoltageListener());
//		textLineNumber = lineNumber;
	}
	
//	public SetVoltagePanel(ArrayList<String> setV) {
//		JTextField whereV = new JTextField();
//		whereV.setText(setV.get(0));
//		this.add(whereV);
//		setVoltageArray.add(whereV);
//		whereV.addActionListener(new setVoltageListener());
//		JTextField Voltage = new JTextField();
//		Voltage.setText(setV.get(1));
//		this.add(Voltage);
//		setVoltageArray.add(Voltage);
//		Voltage.addActionListener(new setVoltageListener());
//		JComboBox<String> voltageRangeV = new JComboBox<String>(
//				new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
//		voltageRangeV.setSelectedItem((Object) setV.get(2));
//		this.add(voltageRangeV);
//		setVoltageArray.add(voltageRangeV);
//		voltageRangeV.addActionListener(new setVoltageListener());
//		JComboBox<String> currentRangeV = new JComboBox<String>(
//				new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
//		currentRangeV.setSelectedItem((Object) setV.get(3));
//		this.add(currentRangeV);
//		setVoltageArray.add(currentRangeV);
//		currentRangeV.addActionListener(new setVoltageListener());
//		textLineNumber = Main.programSteps.size();
//	}
	
	private class setVoltageListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			updateDataLines();
		}
	}
	
	
	
	private class confirmListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	
	
	private class clearListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			setVoltageDataLines.clear();
		}
	}
	
	
	
	
	
	
	
	private void updateDataLines(){
		String setVoltage = "Set Voltage";
		Iterator<Object> sVAI = setVoltageArray.iterator();
		setVoltage = setVoltage + " at "
				+ ((JTextField) sVAI.next()).getText();
		setVoltage = setVoltage + " "
				+ ((JTextField) sVAI.next()).getText() + " V,";
		setVoltage = setVoltage + " V Range "
				+ ((JComboBox<String>) sVAI.next()).getSelectedItem() + ",";
		setVoltage = setVoltage + " I Range "
				+ ((JComboBox<String>) sVAI.next()).getSelectedItem();
		setVoltage = setVoltage + "\n";
		if (Main.dataLines.size() < textLineNumber + 1) {
			Main.dataLines.add(textLineNumber, setVoltage);
		} else {
			Main.dataLines.set(textLineNumber, setVoltage);
		}
		Main.programDisplay.setText(Main.dataLines.toString());
	}
}
