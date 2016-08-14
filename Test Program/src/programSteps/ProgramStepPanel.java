package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ProgramStepPanel extends JPanel {
	
	int textLineNumber;
	JComboBox<String> stepType = new JComboBox<String>(new String[] { " ",
			"Open Relays", "Close Relays", "Set Voltage", "Set Current",
			"Wait", "Measure Voltage", "Measure Current", 
			"Datalog", "Turn Off Resources" }); //"Math", (add that option back in if it gets used)

	public ProgramStepPanel(int lineNumber) {
		stepType.addActionListener(new stepTypeListener());
		this.add(stepType);
		textLineNumber = lineNumber;
		this.setName("Empty Step");
	}

	public void setType(String type) {
		stepType.setSelectedItem((Object) type);
		//stepType.actionPerformed(new ActionEvent(this, 0, "Selected item changed"));
	}
	
	private void giveName(String name){
		this.setName(name);
	}
	
	private class stepTypeListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			while(((JComboBox<String>) e.getSource()).getParent()
					.getComponentCount() > 1)
				((JComboBox<String>) e.getSource()).getParent().remove(1);
			
			
			giveName(((String) ((JComboBox<String>) e.getSource())
					.getSelectedItem()));
			
			switch ((String) ((JComboBox<String>) e.getSource())
					.getSelectedItem()) {
			case "Open Relays":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new OpenRelaysPanel(textLineNumber));
				break;
			case "Close Relays":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new CloseRelaysPanel(textLineNumber));
				break;
			case "Set Voltage":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new SetVoltagePanel(textLineNumber));
				break;
			case "Set Current":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new SetCurrentPanel(textLineNumber));
				break;
			case "Wait":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new WaitPanel(textLineNumber));
				break;
			case "Measure Voltage":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new MeasureVoltagePanel(textLineNumber));
				break;
			case "Measure Current":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new MeasureCurrentPanel(textLineNumber));
				break;
			case "Datalog":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new DatalogPanel(textLineNumber));
				break;
			case "Turn Off Resources":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new TurnOffResourcesPanel(textLineNumber));
				break;
			case "Math":
				((ProgramStepPanel) ((JComboBox<String>) e.getSource()).getParent()).add(new MathPanel(textLineNumber));
				break;
			default:
				break;
			}
			((JComboBox<String>) e.getSource()).getParent().validate();
			((JComboBox<String>) e.getSource()).getParent().repaint();
		}
	}
}