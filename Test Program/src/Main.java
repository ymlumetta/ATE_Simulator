import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		JFrame mainWindow = new JFrame("ATE Simulator");
		mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container mainPane = mainWindow.getContentPane();
		GridBagLayout mainPaneLayout = new GridBagLayout();
		mainPane.setLayout(mainPaneLayout);
		
		ArrayList<String> dataLines = new ArrayList<String>();
		JTabbedPane programStepTabs = new JTabbedPane();
		ArrayList<ProgramStepPanel> programSteps = new ArrayList<ProgramStepPanel>();
		
		JTextPane programDisplay = new JTextPane();
		GridBagConstraints programDisplayConstraints = new GridBagConstraints();
		programDisplayConstraints.gridx = 0;
		programDisplayConstraints.gridy = 0;
		programDisplayConstraints.weighty = 1.0;
		programDisplayConstraints.fill = GridBagConstraints.BOTH;
		programDisplay.setMinimumSize(new Dimension(400, 768));
		programDisplay.setPreferredSize(new Dimension(400, 768));
		programDisplay.setEditable(false);
		
		GridBagConstraints programStepTabsConstraints = new GridBagConstraints();
		programStepTabsConstraints.gridx = 1;
		programStepTabsConstraints.gridy = 0;
		programStepTabsConstraints.weightx = 1.0;
		programStepTabsConstraints.weighty = 1.0;
		programStepTabsConstraints.fill = GridBagConstraints.BOTH;
		
		JButton newTabButton = new JButton("+");
		GridBagConstraints newTabButtonConstraints = new GridBagConstraints();
		newTabButtonConstraints.gridx = 2;
		newTabButtonConstraints.gridy = 0;
		newTabButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programSteps.add(new ProgramStepPanel( programStepTabs.getTabCount() , programDisplay, dataLines));
				programStepTabs.add("Step " + programStepTabs.getTabCount(), programSteps.get(programStepTabs.getTabCount()));
			}
		});
		
		mainPane.add(programDisplay, programDisplayConstraints);
		mainPane.add(programStepTabs, programStepTabsConstraints);
		mainPane.add(newTabButton, newTabButtonConstraints);
		
		mainWindow.setSize(1024, 768);
		mainWindow.setVisible(true);
	}

}
