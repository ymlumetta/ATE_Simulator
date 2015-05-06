package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import testProgram.Main;

@SuppressWarnings("serial")
public class TurnOffResourcesPanel extends JPanel {

	int textLineNumber;
	ArrayList<JCheckBox> turnOffResourcesArray = new ArrayList<JCheckBox>();
	
	public TurnOffResourcesPanel(int lineNumber) {
		JCheckBox cS = new JCheckBox("Current Sources");
		this.add(cS);
		turnOffResourcesArray.add(cS);
		cS.addActionListener(new TurnOffResourcesListener());
		JCheckBox vS = new JCheckBox("Voltage Sources");
		this.add(vS);
		turnOffResourcesArray.add(vS);
		vS.addActionListener(new TurnOffResourcesListener());
		textLineNumber = lineNumber;
	}
	
	public TurnOffResourcesPanel(ArrayList<String> resources) {
		JCheckBox cS = new JCheckBox("Current Sources");
		cS.setSelected(new Boolean(resources.get(0)));
		this.add(cS);
		turnOffResourcesArray.add(cS);
		cS.addActionListener(new TurnOffResourcesListener());
		JCheckBox vS = new JCheckBox("Voltage Sources");
		vS.setSelected(new Boolean(resources.get(1)));
		this.add(vS);
		turnOffResourcesArray.add(vS);
		vS.addActionListener(new TurnOffResourcesListener());
		textLineNumber = Main.programSteps.getTabCount() - 1;
		vS.doClick();
		vS.doClick();
	}
	
	private class TurnOffResourcesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String turnOffResources = "Turn off ";
			Iterator<JCheckBox> tORAI = turnOffResourcesArray.iterator();
			if (tORAI.next().isSelected()) {
				turnOffResources = turnOffResources + " Voltage Sources ";
			}
			if (tORAI.next().isSelected()) {
				turnOffResources = turnOffResources + " Current Sources";
			}
			turnOffResources = turnOffResources + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, turnOffResources);
			} else {
				Main.dataLines.set(textLineNumber, turnOffResources);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
