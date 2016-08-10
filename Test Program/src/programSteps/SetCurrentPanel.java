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
public class SetCurrentPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> setCurrentArray = new ArrayList<Object>();
	ArrayList<String> setCurrentDataLines = new ArrayList<String>();
	
	public SetCurrentPanel(int lineNumber) {
		
		JComboBox<String> pinList = new JComboBox<String>(
				new String[] {"", "Vout", "Vinm", "Vinp"});
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
//		textLineNumber = lineNumber;
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
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
//			String setCurrent = "Set Current";
//			Iterator<Object> sCAI = setCurrentArray.iterator();
//			setCurrent = setCurrent + " at "
//					+ ((JTextField) sCAI.next()).getText();
//			setCurrent = setCurrent + " "
//					+ ((JTextField) sCAI.next()).getText() + " mA,";
//			setCurrent = setCurrent + " V Range "
//					+ ((JComboBox<String>) sCAI.next()).getSelectedItem() + ",";
//			setCurrent = setCurrent + " I Range "
//					+ ((JComboBox<String>) sCAI.next()).getSelectedItem();
//			setCurrent = setCurrent + "\n";
//			if (Main.dataLines.size() < textLineNumber + 1) {
//				Main.dataLines.add(textLineNumber, setCurrent);
//			} else {
//				Main.dataLines.set(textLineNumber, setCurrent);
//			}
//			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
	
	private class confirmListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			setCurrentDataLines.add("Set Current at "+e.toString()+"to");
		}
	}
	
	
	
	private class clearListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			setCurrentDataLines.clear();
		}
	}
	
	
	
}
