import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ProgramStepPanel extends JPanel {

	public ProgramStepPanel() {
		// TODO Auto-generated constructor stub
		JComboBox<String> stepType = new JComboBox<String>(new String[] {" ", "Open Relays", "Close Relays" , "Set Voltage", "Set Current","Wait", "Measure Voltage", "Measure Current", "Datalog" , "Turn Off Resources"});
		stepType.addActionListener(new stepTypeListener());
		this.add(stepType);
	}

private class stepTypeListener implements ActionListener {
	@SuppressWarnings("unchecked")
	public void actionPerformed (ActionEvent e) {
		if(((JComboBox<String>) e.getSource()).getParent().getComponentCount() > 1)
			((JComboBox<String>) e.getSource()).getParent().remove(1);
		
		JPanel stepTypePanel = new JPanel();
		
		switch((String) ((JComboBox<String>) e.getSource()).getSelectedItem()) {
			case "Open Relays":
				JCheckBox RO1 = new JCheckBox("Relay 1");
				stepTypePanel.add(RO1);
				JCheckBox RO2 = new JCheckBox("Relay 2");
				stepTypePanel.add(RO2);
				JCheckBox RO3 = new JCheckBox("Relay 3");
				stepTypePanel.add(RO3);
				break;
			case "Close Relays":
				JCheckBox RC1 = new JCheckBox("Relay 1");
				stepTypePanel.add(RC1);
				JCheckBox RC2 = new JCheckBox("Relay 2");
				stepTypePanel.add(RC2);
				JCheckBox RC3 = new JCheckBox("Relay 3");
				stepTypePanel.add(RC3);
				break;
			case "Set Voltage":
				JTextField Voltage = new JTextField();
				stepTypePanel.add(Voltage);
				JComboBox<String> voltageRangeV = new JComboBox<String>(new String[] {"100 V", "30 V", "10 V" , "1 V", "500 mV"});
				stepTypePanel.add(voltageRangeV);
				JComboBox<String> currentRangeV = new JComboBox<String>(new String[] {"1 mA", "10 mA", "100 mA" , "1 A", "5 A"});
				stepTypePanel.add(currentRangeV);
				break;
			case "Set Current":
				JTextField Current = new JTextField();
				stepTypePanel.add(Current);
				JComboBox<String> voltageRangeC = new JComboBox<String>(new String[] {"100 V", "30 V", "10 V" , "1 V", "500 mV"});
				stepTypePanel.add(voltageRangeC);
				JComboBox<String> currentRangeC = new JComboBox<String>(new String[] {"1 mA", "10 mA", "100 mA" , "1 A", "5 A"});
				stepTypePanel.add(currentRangeC);
				break;
			case "Wait":
				JTextField Wait = new JTextField();
				stepTypePanel.add(Wait);
				break;
			case "Measure Voltage":
				JTextField numberOfSamplesV = new JTextField();
				stepTypePanel.add(numberOfSamplesV);
				JTextField timeBetweenSamplesV = new JTextField();
				stepTypePanel.add(timeBetweenSamplesV);
				JTextField variableNameV = new JTextField();
				stepTypePanel.add(variableNameV);
				break;
			case "Measure Current":
				JTextField numberOfSamplesC = new JTextField();
				stepTypePanel.add(numberOfSamplesC);
				JTextField timeBetweenSamplesC = new JTextField();
				stepTypePanel.add(timeBetweenSamplesC);
				JTextField variableNameC = new JTextField();
				stepTypePanel.add(variableNameC);
				break;
			case "Datalog":
				JTextField whatVariable = new JTextField();
				stepTypePanel.add(whatVariable);
				break;
			case "Turn Off Resources":
				JCheckBox cS = new JCheckBox("Current Source");
				stepTypePanel.add(cS);
				JCheckBox vS = new JCheckBox("Voltage Source");
				stepTypePanel.add(vS);
				break;
			default:
				break;
		}
		((JComboBox<String>) e.getSource()).getParent().add(stepTypePanel);
	}
}

}