package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import testProgram.Main;

@SuppressWarnings("serial")
public class OpenRelaysPanel extends JPanel {
	
	int textLineNumber;
	ArrayList<JCheckBox> openRelaysArray = new ArrayList<JCheckBox>();
	
	public OpenRelaysPanel(int lineNumber) {
		JCheckBox RO1 = new JCheckBox("Relay 1");
		openRelaysArray.add(RO1);
		this.add(RO1);
		RO1.addActionListener(new openRelaysListener());
		JCheckBox RO2 = new JCheckBox("Relay 2");
		openRelaysArray.add(RO2);
		this.add(RO2);
		RO2.addActionListener(new openRelaysListener());
		JCheckBox RO3 = new JCheckBox("Relay 3");
		openRelaysArray.add(RO3);
		this.add(RO3);
		RO3.addActionListener(new openRelaysListener());
		textLineNumber = lineNumber;
	}
	
	public OpenRelaysPanel(ArrayList<String> relays) {
		JCheckBox RO1 = new JCheckBox("Relay 1");
		RO1.setSelected(new Boolean(relays.get(0)));
		openRelaysArray.add(RO1);
		this.add(RO1);
		RO1.addActionListener(new openRelaysListener());
		JCheckBox RO2 = new JCheckBox("Relay 2");
		RO2.setSelected(new Boolean(relays.get(1)));
		openRelaysArray.add(RO2);
		this.add(RO2);
		RO2.addActionListener(new openRelaysListener());
		JCheckBox RO3 = new JCheckBox("Relay 3");
		RO3.setSelected(new Boolean(relays.get(2)));
		openRelaysArray.add(RO3);
		this.add(RO3);
		RO3.addActionListener(new openRelaysListener());
		textLineNumber = Main.programSteps.getTabCount() - 1;
		RO3.doClick();
		RO3.doClick();
	}

	private class openRelaysListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String openRelays = "Open Relays";
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
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, openRelays);
			} else {
				Main.dataLines.set(textLineNumber, openRelays);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
