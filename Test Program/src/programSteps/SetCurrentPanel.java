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
public class SetCurrentPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> setCurrentArray = new ArrayList<Object>();
	ArrayList<String> setCurrentDataLines = new ArrayList<String>();
	int numberOfLines = 0;
	
	public SetCurrentPanel(int lineNumber) {
		
		JComboBox<String> pinList = new JComboBox<String>(getPinList());
		this.add(pinList);
		setCurrentArray.add(pinList);
		pinList.addActionListener(new setCurrentListener());
		
		JComboBox<String> currentOptions = new JComboBox<String>(
				new String[] {"", "1 mA", "-1 mA"});
		this.add(currentOptions);
		setCurrentArray.add(currentOptions);
		currentOptions.addActionListener(new setCurrentListener());
		
		JButton confirm = new JButton("Confirm");
		this.add(confirm);
		setCurrentArray.add(confirm);
		confirm.addActionListener(new confirmListener());
		
		JButton clear = new JButton("Clear");
		this.add(clear);
		setCurrentArray.add(clear);
		clear.addActionListener(new clearListener());
		
		
//		JTextField whereC = new JTextField();
//		whereC.setText("Where");
//		this.add(whereC);
//		setCurrentArray.add(whereC);
//		whereC.addActionListener(new setCurrentListener());
		
		
//		JTextField Current = new JTextField();
//		Current.setText("0.0");
//		this.add(Current);
//		setCurrentArray.add(Current);
//		Current.addActionListener(new setCurrentListener());
		
		
		
//		JComboBox<String> voltageRangeC = new JComboBox<String>(
//				new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
//		this.add(voltageRangeC);
//		setCurrentArray.add(voltageRangeC);
//		voltageRangeC.addActionListener(new setCurrentListener());
		
		
//		JComboBox<String> currentRangeC = new JComboBox<String>(
//				new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
//		this.add(currentRangeC);
//		setCurrentArray.add(currentRangeC);
//		currentRangeC.addActionListener(new setCurrentListener());
		
		
		textLineNumber = lineNumber;
	}
	
//	public SetCurrentPanel(ArrayList<String> setI) {
//		JTextField whereC = new JTextField();
//		whereC.setText(setI.get(0));
//		this.add(whereC);
//		setCurrentArray.add(whereC);
//		whereC.addActionListener(new setCurrentListener());
//		JTextField Current = new JTextField();
//		Current.setText(setI.get(1));
//		this.add(Current);
//		setCurrentArray.add(Current);
//		Current.addActionListener(new setCurrentListener());
//		JComboBox<String> voltageRangeC = new JComboBox<String>(
//				new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
//		voltageRangeC.setSelectedItem((Object) setI.get(2));
//		this.add(voltageRangeC);
//		setCurrentArray.add(voltageRangeC);
//		voltageRangeC.addActionListener(new setCurrentListener());
//		JComboBox<String> currentRangeC = new JComboBox<String>(
//				new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
//		currentRangeC.setSelectedItem((Object) setI.get(3));
//		this.add(currentRangeC);
//		setCurrentArray.add(currentRangeC);
//		currentRangeC.addActionListener(new setCurrentListener());
//		textLineNumber = Main.programSteps.size();
//	}
	
	private class setCurrentListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//does nothing~
		}
	}
	
	private class confirmListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String setCurrent = "Set Current";
			Iterator<Object> sCAI = setCurrentArray.iterator();
			setCurrent = setCurrent + " at "
					+ ((JComboBox<?>) sCAI.next()).getSelectedItem();
			setCurrent = setCurrent + " to "
					+ ((JComboBox<?>) sCAI.next()).getSelectedItem() + ",";
			
			setCurrent = setCurrent + " V Range 10V,";
			setCurrent = setCurrent + " I Range 10mA ";
			
			setCurrent = setCurrent + "\n";
			
			if(setCurrentDataLines.size() <= numberOfLines){
				setCurrentDataLines.add(setCurrent);
			} else{
				setCurrentDataLines.set(numberOfLines, setCurrent);
			}
			
			
			
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, setCurrentDataLines.toString());
			} else {
				Main.dataLines.set(textLineNumber, setCurrentDataLines.toString());
			}
			Main.programDisplay.setText(Main.dataLines.toString());
			
			numberOfLines++;
		}
	}
	
	
	
	private class clearListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setCurrentDataLines.clear();
			numberOfLines = 0;
			
			if(Main.dataLines.size() < textLineNumber + 1){
				Main.dataLines.add(textLineNumber, setCurrentDataLines.toString());
			} else {
				Main.dataLines.set(textLineNumber, setCurrentDataLines.toString());
			}
			
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
	
	
	
	private static String[] getPinList(){
		switch(Main.test){
		case "Continuity":
			return Main.continuityPins;
		default:
			return Main.allPins;
		}
	}
	
	
	
}
