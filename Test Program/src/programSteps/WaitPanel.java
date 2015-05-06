package programSteps;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import testProgram.Main;

@SuppressWarnings("serial")
public class WaitPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> waitArray = new ArrayList<Object>();
	
	public WaitPanel(int lineNumber) {
		JComboBox<String> Wait = new JComboBox<String>(new String[] {
				"10 us", "100 us", "1000 us", "10000 us" });
		waitArray.add(Wait);
		this.add(Wait);
		Wait.addActionListener(new waitActionListener());
		textLineNumber = lineNumber;
	}
	
	public WaitPanel(ArrayList<String> wait) {
		textLineNumber = Main.programSteps.getTabCount() - 1;
		JComboBox<String> Wait = new JComboBox<String>(new String[] {
				"10 us", "100 us", "1000 us", "10000 us" });
		waitArray.add(Wait);
		this.add(Wait);
		Wait.addActionListener(new waitActionListener());
		Wait.setSelectedItem((Object) wait.get(0));
	}
	
	private class waitActionListener implements ActionListener {
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			String wait = "Wait for ";
			Iterator<Object> wAI = waitArray.iterator();
			wait = wait + ((JComboBox<String>) wAI.next()).getSelectedItem();
			wait = wait + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, wait);
			} else {
				Main.dataLines.set(textLineNumber, wait);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
