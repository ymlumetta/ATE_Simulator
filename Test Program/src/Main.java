import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mainWindow = new JFrame("ATE Simulator");
		mainWindow.setSize(1024, 768);
		GridBagLayout mainWindowManager = new GridBagLayout();
		ArrayList<String> dataLines = new ArrayList<String>();
		JTabbedPane programStepTabs = new JTabbedPane();
		ArrayList<ProgramStepPanel> programSteps = new ArrayList<ProgramStepPanel>();
		
		mainWindow.setLayout(mainWindowManager);
		
		JTextPane programDisplay = new JTextPane();
		GridBagConstraints programDisplayConstraints = new GridBagConstraints();
		programDisplayConstraints.gridx = 0;
		programDisplayConstraints.gridy = 0;
		programDisplayConstraints.fill = GridBagConstraints.BOTH;
		mainWindowManager.setConstraints(programDisplay, programDisplayConstraints);
		programDisplay.setEditable(false);
		
		GridBagConstraints programStepTabsConstraints = new GridBagConstraints();
		programStepTabsConstraints.gridx = 1;
		programStepTabsConstraints.gridy = 0;
		programStepTabsConstraints.fill = GridBagConstraints.BOTH;
		mainWindowManager.setConstraints(programStepTabs, programStepTabsConstraints);
		
		JButton newTabButton = new JButton("+");
		GridBagConstraints newTabButtonConstraints = new GridBagConstraints();
		newTabButtonConstraints.gridx = 2;
		newTabButtonConstraints.gridy = 0;
		newTabButtonConstraints.weightx = 0.0;
		newTabButtonConstraints.weighty = 0.0;
		mainWindowManager.setConstraints(newTabButton, newTabButtonConstraints);
		newTabButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programSteps.add(new ProgramStepPanel());
				programStepTabs.add("Step " + programStepTabs.getTabCount(), programSteps.get(programStepTabs.getTabCount()));
			}
		});
		
		mainWindow.add(programDisplay);
		mainWindow.add(programStepTabs);
		mainWindow.add(newTabButton);
		
		mainWindow.setVisible(true);
	}

}
