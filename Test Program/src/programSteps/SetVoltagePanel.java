package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import testProgram.Main;

@SuppressWarnings("serial")
public class SetVoltagePanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> setVoltageArray = new ArrayList<Object>();
	ArrayList<String> setVoltageDataLines = new ArrayList<String>();
	int numberOfLines = 0;
	
	public SetVoltagePanel(int lineNumber) {
		
		JComboBox<String> pinList = new JComboBox<String>(getPinList());
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
		textLineNumber = lineNumber;
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
		public void actionPerformed(ActionEvent e) {
			//does nothing~
		}
	}
	
	private class confirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String setCurrent = "Set Current";
			Iterator<Object> sCAI = setVoltageArray.iterator();
			setCurrent = setCurrent + " at "
					+ ((JComboBox<?>) sCAI.next()).getSelectedItem();
			setCurrent = setCurrent + " to "
					+ ((JComboBox<?>) sCAI.next()).getSelectedItem() + ",";
			
			setCurrent = setCurrent + " V Range 10V,";
			setCurrent = setCurrent + " I Range 10mA ";
			
			setCurrent = setCurrent + "\n";
			
			if(setVoltageDataLines.size() <= numberOfLines){
				setVoltageDataLines.add(setCurrent);
			} else{
				setVoltageDataLines.set(numberOfLines, setCurrent);
			}
			
			
			
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, setVoltageDataLines.toString());
			} else {
				Main.dataLines.set(textLineNumber, setVoltageDataLines.toString());
			}
			Main.programDisplay.setText(Main.dataLines.toString());
			
			numberOfLines++;
		}
	}
	
	
	
	
	private class clearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVoltageDataLines.clear();
			numberOfLines = 0;
			
			if(Main.dataLines.size() < textLineNumber + 1){
				Main.dataLines.add(textLineNumber, setVoltageDataLines.toString());
			} else {
				Main.dataLines.set(textLineNumber, setVoltageDataLines.toString());
			}
			
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
	
	
	private static String[] getPinList(){
		if(Main.test == null)
			return Main.allPins;
		switch(Main.test){
		case "Continuity":
			return Main.continuityPins;
		default:
			return Main.allPins;
		}
	}
	
	

}
