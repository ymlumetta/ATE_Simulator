import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ProgramStepPanel extends JPanel {

	int textLineNumber;
	JTextPane testCode;
	ArrayList<JCheckBox> openRelaysArray = new ArrayList<JCheckBox>();
	ArrayList<JCheckBox> closeRelaysArray = new ArrayList<JCheckBox>();
	ArrayList<Object> setVoltageArray = new ArrayList<Object>();
	ArrayList<Object> setCurrentArray = new ArrayList<Object>();
	ArrayList<Object> waitArray = new ArrayList<Object>();
	ArrayList<Object> measureVoltageArray = new ArrayList<Object>();
	ArrayList<Object> measureCurrentArray = new ArrayList<Object>();
	ArrayList<Object> datalogArray = new ArrayList<Object>();
	ArrayList<Object> mathArray = new ArrayList<Object>();
	ArrayList<JCheckBox> turnOffResourcesArray = new ArrayList<JCheckBox>();
	ArrayList<String> dataString;
	String openRelays = "Open Relays";
	String closeRelays = "Close Relays";
	String setVoltage;
	String setCurrent;
	String wait;
	String measureV;
	String measureI;
	String datalog;
	String math;
	String turnOffResources;

	public ProgramStepPanel(int lineNumber, JTextPane textDisplay,
			ArrayList<String> dataLines) {
		JComboBox<String> stepType = new JComboBox<String>(new String[] { " ",
				"Open Relays", "Close Relays", "Set Voltage", "Set Current",
				"Wait", "Measure Voltage", "Measure Current", "Math",
				"Datalog", "Turn Off Resources" });
		stepType.addActionListener(new stepTypeListener());
		this.add(stepType);
		dataString = dataLines;
		textLineNumber = lineNumber;
		testCode = textDisplay;
	}

	private class stepTypeListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			if (((JComboBox<String>) e.getSource()).getParent()
					.getComponentCount() > 1)
				((JComboBox<String>) e.getSource()).getParent().remove(1);

			JPanel stepTypePanel = new JPanel();

			switch ((String) ((JComboBox<String>) e.getSource())
					.getSelectedItem()) {
			case "Open Relays":
				JCheckBox RO1 = new JCheckBox("Relay 1");
				openRelaysArray.add(RO1);
				stepTypePanel.add(RO1);
				RO1.addActionListener(new openRelaysListener());
				JCheckBox RO2 = new JCheckBox("Relay 2");
				openRelaysArray.add(RO2);
				stepTypePanel.add(RO2);
				RO2.addActionListener(new openRelaysListener());
				JCheckBox RO3 = new JCheckBox("Relay 3");
				openRelaysArray.add(RO3);
				stepTypePanel.add(RO3);
				RO3.addActionListener(new openRelaysListener());
				break;
			case "Close Relays":
				JCheckBox RC1 = new JCheckBox("Relay 1");
				closeRelaysArray.add(RC1);
				stepTypePanel.add(RC1);
				RC1.addActionListener(new closeRelaysListener());
				JCheckBox RC2 = new JCheckBox("Relay 2");
				closeRelaysArray.add(RC2);
				stepTypePanel.add(RC2);
				RC2.addActionListener(new closeRelaysListener());
				JCheckBox RC3 = new JCheckBox("Relay 3");
				closeRelaysArray.add(RC3);
				stepTypePanel.add(RC3);
				RC3.addActionListener(new closeRelaysListener());
				break;
			case "Set Voltage":
				JTextField whereV = new JTextField();
				whereV.setText("Where");
				stepTypePanel.add(whereV);
				setVoltageArray.add(whereV);
				whereV.addActionListener(new setVoltageListener());
				JTextField Voltage = new JTextField();
				Voltage.setText("0.0");
				stepTypePanel.add(Voltage);
				setVoltageArray.add(Voltage);
				Voltage.addActionListener(new setVoltageListener());
				JComboBox<String> voltageRangeV = new JComboBox<String>(
						new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
				stepTypePanel.add(voltageRangeV);
				setVoltageArray.add(voltageRangeV);
				voltageRangeV.addActionListener(new setVoltageListener());
				JComboBox<String> currentRangeV = new JComboBox<String>(
						new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
				stepTypePanel.add(currentRangeV);
				setVoltageArray.add(currentRangeV);
				currentRangeV.addActionListener(new setVoltageListener());
				break;
			case "Set Current":
				JTextField whereC = new JTextField();
				whereC.setText("Where");
				stepTypePanel.add(whereC);
				setCurrentArray.add(whereC);
				whereC.addActionListener(new setCurrentListener());
				JTextField Current = new JTextField();
				Current.setText("0.0");
				stepTypePanel.add(Current);
				setCurrentArray.add(Current);
				Current.addActionListener(new setCurrentListener());
				JComboBox<String> voltageRangeC = new JComboBox<String>(
						new String[] { "100 V", "30 V", "10 V", "1 V", "500 mV" });
				stepTypePanel.add(voltageRangeC);
				setCurrentArray.add(voltageRangeC);
				voltageRangeC.addActionListener(new setCurrentListener());
				JComboBox<String> currentRangeC = new JComboBox<String>(
						new String[] { "1 mA", "10 mA", "100 mA", "1 A", "5 A" });
				stepTypePanel.add(currentRangeC);
				setCurrentArray.add(currentRangeC);
				currentRangeC.addActionListener(new setCurrentListener());
				break;
			case "Wait":
				JComboBox<String> Wait = new JComboBox<String>(new String[] {
						"10 us", "100 us", "1000 us", "10000 us" });
				waitArray.add(Wait);
				stepTypePanel.add(Wait);
				Wait.addActionListener(new waitActionListener());
				break;
			case "Measure Voltage":
				JTextField numberOfSamplesV = new JTextField();
				numberOfSamplesV.setText("How Many Samples");
				stepTypePanel.add(numberOfSamplesV);
				measureVoltageArray.add(numberOfSamplesV);
				numberOfSamplesV.getDocument().addDocumentListener(
						new MeasureVoltageListener());
				JTextField timeBetweenSamplesV = new JTextField();
				timeBetweenSamplesV.setText("Time Between Samples");
				stepTypePanel.add(timeBetweenSamplesV);
				timeBetweenSamplesV.getDocument().addDocumentListener(
						new MeasureVoltageListener());
				measureVoltageArray.add(timeBetweenSamplesV);
				JTextField variableNameV = new JTextField();
				variableNameV.setText("Store As Variable Name");
				stepTypePanel.add(variableNameV);
				measureVoltageArray.add(variableNameV);
				variableNameV.getDocument().addDocumentListener(
						new MeasureVoltageListener());
				break;
			case "Measure Current":
				JTextField numberOfSamplesC = new JTextField();
				numberOfSamplesC.setText("How Many Samples");
				stepTypePanel.add(numberOfSamplesC);
				measureCurrentArray.add(numberOfSamplesC);
				numberOfSamplesC.getDocument().addDocumentListener(
						new MeasureCurrentListener());
				JTextField timeBetweenSamplesC = new JTextField();
				timeBetweenSamplesC.setText("Time Between Samples");
				stepTypePanel.add(timeBetweenSamplesC);
				timeBetweenSamplesC.getDocument().addDocumentListener(
						new MeasureCurrentListener());
				measureCurrentArray.add(timeBetweenSamplesC);
				JTextField variableNameC = new JTextField();
				variableNameC.setText("Store As Variable Name");
				stepTypePanel.add(variableNameC);
				measureCurrentArray.add(variableNameC);
				variableNameC.getDocument().addDocumentListener(
						new MeasureCurrentListener());
				break;
			case "Datalog":
				JTextField whatVariable = new JTextField();
				stepTypePanel.add(whatVariable);
				datalogArray.add(whatVariable);
				whatVariable.getDocument().addDocumentListener(
						new DatalogListener());
				break;
			case "Turn Off Resources":
				JCheckBox cS = new JCheckBox("Current Sources");
				stepTypePanel.add(cS);
				turnOffResourcesArray.add(cS);
				cS.addActionListener(new TurnOffResourcesListener());
				JCheckBox vS = new JCheckBox("Voltage Sources");
				stepTypePanel.add(vS);
				turnOffResourcesArray.add(vS);
				vS.addActionListener(new TurnOffResourcesListener());
				break;
			case "Math":
				JTextField math = new JTextField();
				math.setText("Enter Math Here");
				stepTypePanel.add(math);
				mathArray.add(math);
				math.getDocument().addDocumentListener(new MathListener());
				break;
			default:
				break;
			}
			((JComboBox<String>) e.getSource()).getParent().add(stepTypePanel);
			stepTypePanel.getParent().validate();
			stepTypePanel.getParent().repaint();
		}
	}

	private class openRelaysListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			openRelays = "Open Relays";
			Iterator<JCheckBox> oRAI = openRelaysArray.iterator();
			if (oRAI.next().isSelected()) {
				openRelays = openRelays + " " + "1";
			}
			if (oRAI.next().isSelected()) {
				openRelays = openRelays + " " + "2";
			}
			if (oRAI.next().isSelected()) {
				openRelays = openRelays + " " + "3";
			}
			openRelays = openRelays + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, openRelays);
			} else {
				dataString.set(textLineNumber, openRelays);
			}
			testCode.setText(dataString.toString());
		}
	}

	private class closeRelaysListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			closeRelays = "Close Relays";
			Iterator<JCheckBox> cRAI = closeRelaysArray.iterator();
			if (cRAI.next().isSelected()) {
				closeRelays = closeRelays + " " + "1";
			}
			if (cRAI.next().isSelected()) {
				closeRelays = closeRelays + " " + "2";
			}
			if (cRAI.next().isSelected()) {
				closeRelays = closeRelays + " " + "3";
			}
			closeRelays = closeRelays + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, closeRelays);
			} else {
				dataString.set(textLineNumber, closeRelays);
			}
			testCode.setText(dataString.toString());
		}
	}

	private class setVoltageListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			setVoltage = "Set Voltage";
			Iterator<Object> sVAI = setVoltageArray.iterator();
			setVoltage = setVoltage + " at "
					+ ((JTextField) sVAI.next()).getText();
			setVoltage = setVoltage + " "
					+ ((JTextField) sVAI.next()).getText() + " V,";
			setVoltage = setVoltage + " V Range "
					+ ((JComboBox) sVAI.next()).getSelectedItem() + ",";
			setVoltage = setVoltage + " I Range "
					+ ((JComboBox) sVAI.next()).getSelectedItem();
			setVoltage = setVoltage + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, setVoltage);
			} else {
				dataString.set(textLineNumber, setVoltage);
			}
			testCode.setText(dataString.toString());
		}
	}

	private class setCurrentListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			setCurrent = "Set Current";
			Iterator<Object> sCAI = setCurrentArray.iterator();
			setCurrent = setCurrent + " at "
					+ ((JTextField) sCAI.next()).getText();
			setCurrent = setCurrent + " "
					+ ((JTextField) sCAI.next()).getText() + " mA,";
			setCurrent = setCurrent + " V Range "
					+ ((JComboBox) sCAI.next()).getSelectedItem() + ",";
			setCurrent = setCurrent + " I Range "
					+ ((JComboBox) sCAI.next()).getSelectedItem();
			setCurrent = setCurrent + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, setCurrent);
			} else {
				dataString.set(textLineNumber, setCurrent);
			}
			testCode.setText(dataString.toString());
		}
	}

	private class waitActionListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			wait = "Wait for ";
			Iterator<Object> wAI = waitArray.iterator();
			wait = wait + ((JComboBox) wAI.next()).getSelectedItem();
			wait = wait + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, wait);
			} else {
				dataString.set(textLineNumber, wait);
			}
			testCode.setText(dataString.toString());
		}
	}

	private class MeasureVoltageListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mVAI = measureVoltageArray.iterator();
			measureV = "Take " + ((JTextField) mVAI.next()).getText()
					+ " samples";
			measureV = measureV + " measuring every "
					+ ((JTextField) mVAI.next()).getText() + " us,";
			measureV = measureV + " store as variable "
					+ ((JTextField) mVAI.next()).getText();
			measureV = measureV + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, measureV);
			} else {
				dataString.set(textLineNumber, measureV);
			}
			testCode.setText(dataString.toString());

		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mVAI = measureVoltageArray.iterator();
			measureV = "Take " + ((JTextField) mVAI.next()).getText()
					+ " samples";
			measureV = measureV + " measuring every "
					+ ((JTextField) mVAI.next()).getText() + " us,";
			measureV = measureV + " store as variable "
					+ ((JTextField) mVAI.next()).getText();
			measureV = measureV + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, measureV);
			} else {
				dataString.set(textLineNumber, measureV);
			}
			testCode.setText(dataString.toString());

		}

	}

	private class MeasureCurrentListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mIAI = measureCurrentArray.iterator();
			measureI = "Take " + ((JTextField) mIAI.next()).getText()
					+ " samples";
			measureI = measureI + " measuring every "
					+ ((JTextField) mIAI.next()).getText() + " us,";
			measureI = measureI + " store as variable "
					+ ((JTextField) mIAI.next()).getText();
			measureI = measureI + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, measureI);
			} else {
				dataString.set(textLineNumber, measureI);
			}
			testCode.setText(dataString.toString());

		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mIAI = measureCurrentArray.iterator();
			measureI = "Take " + ((JTextField) mIAI.next()).getText()
					+ " samples";
			measureI = measureI + " measuring every "
					+ ((JTextField) mIAI.next()).getText() + " us,";
			measureI = measureI + " store as variable "
					+ ((JTextField) mIAI.next()).getText();
			measureI = measureI + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, measureI);
			} else {
				dataString.set(textLineNumber, measureI);
			}
			testCode.setText(dataString.toString());

		}

	}

	private class DatalogListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> dAI = datalogArray.iterator();
			datalog = "Datalog " + ((JTextField) dAI.next()).getText();
			datalog = datalog + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, datalog);
			} else {
				dataString.set(textLineNumber, datalog);
			}
			testCode.setText(dataString.toString());

		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> dAI = datalogArray.iterator();
			datalog = "Datalog " + ((JTextField) dAI.next()).getText();
			datalog = datalog + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, datalog);
			} else {
				dataString.set(textLineNumber, datalog);
			}
			testCode.setText(dataString.toString());

		}

	}

	private class MathListener implements DocumentListener {

		@Override
		public void changedUpdate(DocumentEvent arg0) {

		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mAI = mathArray.iterator();
			math = ((JTextField) mAI.next()).getText();
			math = math + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, math);
			} else {
				dataString.set(textLineNumber, math);
			}
			testCode.setText(dataString.toString());

		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mAI = mathArray.iterator();
			math = ((JTextField) mAI.next()).getText();
			math = math + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, math);
			} else {
				dataString.set(textLineNumber, math);
			}
			testCode.setText(dataString.toString());

		}

	}

	private class TurnOffResourcesListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			turnOffResources = "Turn off ";
			Iterator<JCheckBox> tORAI = turnOffResourcesArray.iterator();
			if (tORAI.next().isSelected()) {
				turnOffResources = turnOffResources + " Voltage Sources ";
			}
			if (tORAI.next().isSelected()) {
				turnOffResources = turnOffResources + " Current Sources";
			}
			turnOffResources = turnOffResources + "\n";
			if (dataString.size() < textLineNumber + 1) {
				dataString.add(textLineNumber, turnOffResources);
			} else {
				dataString.set(textLineNumber, turnOffResources);
			}
			testCode.setText(dataString.toString());
		}
	}
}