package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import testProgram.Main;

@SuppressWarnings("serial")
public class CloseRelaysPanel extends JPanel {

	int textLineNumber;
	ArrayList<JCheckBox> closeRelaysArray = new ArrayList<JCheckBox>();
	
	public CloseRelaysPanel(int lineNumber) {
		JCheckBox RC1 = new JCheckBox("Relay 1");
		closeRelaysArray.add(RC1);
		this.add(RC1);
		RC1.addActionListener(new closeRelaysListener());
		JCheckBox RC2 = new JCheckBox("Relay 2");
		closeRelaysArray.add(RC2);
		this.add(RC2);
		RC2.addActionListener(new closeRelaysListener());
		JCheckBox RC3 = new JCheckBox("Relay 3");
		closeRelaysArray.add(RC3);
		this.add(RC3);
		RC3.addActionListener(new closeRelaysListener());
		textLineNumber = lineNumber;
	}
	
	public CloseRelaysPanel(ArrayList<String> relays) {
		JCheckBox RC1 = new JCheckBox("Relay 1");
		RC1.setSelected(new Boolean(relays.get(0)));
		closeRelaysArray.add(RC1);
		this.add(RC1);
		RC1.addActionListener(new closeRelaysListener());
		JCheckBox RC2 = new JCheckBox("Relay 2");
		RC2.setSelected(new Boolean(relays.get(1)));
		closeRelaysArray.add(RC2);
		this.add(RC2);
		RC2.addActionListener(new closeRelaysListener());
		JCheckBox RC3 = new JCheckBox("Relay 3");
		RC3.setSelected(new Boolean(relays.get(2)));
		closeRelaysArray.add(RC3);
		this.add(RC3);
		RC3.addActionListener(new closeRelaysListener());
		textLineNumber = Main.programSteps.getTabCount() - 1;
		RC3.doClick();
		RC3.doClick();
	}

	private class closeRelaysListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String closeRelays = "Close Relays";
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
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, closeRelays);
			} else {
				Main.dataLines.set(textLineNumber, closeRelays);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
