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

		MainMenu mainMenu = new MainMenu();
		GridBagConstraints mainMenuConstraints = new GridBagConstraints();
		mainMenuConstraints.gridx = 0;
		mainMenuConstraints.gridy = 0;
		mainMenuConstraints.weightx = 1.0;
		mainMenuConstraints.weighty = 0.0;
		mainMenuConstraints.gridwidth = GridBagConstraints.REMAINDER;
		mainMenuConstraints.fill = GridBagConstraints.HORIZONTAL;

		JLabel statusLabel = new JLabel();
		GridBagConstraints statusLabelConstraints = new GridBagConstraints();
		statusLabelConstraints.gridx = 0;
		statusLabelConstraints.gridy = 1;
		statusLabelConstraints.weightx = 1.0;
		statusLabelConstraints.weighty = 0.0;
		statusLabelConstraints.gridwidth = GridBagConstraints.REMAINDER;
		statusLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
		statusLabel.setText("Part: ; Test: ");

		JTextPane programDisplay = new JTextPane();
		GridBagConstraints programDisplayConstraints = new GridBagConstraints();
		programDisplayConstraints.gridx = 0;
		programDisplayConstraints.gridy = 2;
		programDisplayConstraints.weighty = 1.0;
		programDisplayConstraints.fill = GridBagConstraints.BOTH;
		programDisplay.setMinimumSize(new Dimension(400, 768));
		programDisplay.setPreferredSize(new Dimension(400, 768));
		programDisplay.setEditable(false);

		ArrayList<String> dataLines = new ArrayList<String>();
		ArrayList<ProgramStepPanel> programSteps = new ArrayList<ProgramStepPanel>();
		JTabbedPane programStepTabs = new JTabbedPane();
		GridBagConstraints programStepTabsConstraints = new GridBagConstraints();
		programStepTabsConstraints.gridx = 1;
		programStepTabsConstraints.gridy = 2;
		programStepTabsConstraints.weightx = 1.0;
		programStepTabsConstraints.weighty = 1.0;
		programStepTabsConstraints.fill = GridBagConstraints.BOTH;

		JButton newTabTab = new JButton("+");
		newTabTab.setToolTipText("Create a new tab");
		newTabTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programSteps.add(new ProgramStepPanel(programSteps.size(),
						programDisplay, dataLines));
				programStepTabs.insertTab(
						"Step " + programStepTabs.getTabCount(), null,
						programSteps.get(programStepTabs.getTabCount() - 1),
						null, programStepTabs.getTabCount() - 1);
			}
		});
		programStepTabs.addTab(null, null);
		programStepTabs.setTabComponentAt(0, newTabTab);

		mainPane.add(mainMenu, mainMenuConstraints);
		mainPane.add(statusLabel, statusLabelConstraints);
		mainPane.add(programDisplay, programDisplayConstraints);
		mainPane.add(programStepTabs, programStepTabsConstraints);

		// mainWindow.setSize(1024, 768);
		mainWindow.pack();
		mainWindow.setVisible(true);
	}

}
