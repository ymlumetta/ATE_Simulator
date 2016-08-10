package testProgram;
import javax.swing.*;

import programSteps.ProgramStepPanel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

	public static JFrame mainWindow = new JFrame("ATE Simulator");
	public static JLabel statusLabel = new JLabel();
	public static JTextPane programDisplay = new JTextPane();
	public static ArrayList<String> dataLines = new ArrayList<String>();
	public static ArrayList<ProgramStepPanel> programSteps = new ArrayList<ProgramStepPanel>();
	
	public static String test;
	public static String part;
	
	public static void main(String[] args) {
		
		
		
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		mainWindow.setLocationRelativeTo(null);
		Container mainPane = mainWindow.getContentPane();
		GridBagLayout mainPaneLayout = new GridBagLayout();
		mainPane.setLayout(mainPaneLayout);

		mainWindow.setJMenuBar(new MainMenu());

		GridBagConstraints statusLabelConstraints = new GridBagConstraints();
		statusLabelConstraints.gridx = 0;
		statusLabelConstraints.gridy = 1;
		statusLabelConstraints.weightx = 1.0;
		statusLabelConstraints.weighty = 0.0;
		statusLabelConstraints.gridwidth = GridBagConstraints.REMAINDER;
		statusLabelConstraints.fill = GridBagConstraints.HORIZONTAL;
		statusLabel.setText("Part: ; Test: ");

		GridBagConstraints programDisplayConstraints = new GridBagConstraints();
		programDisplayConstraints.gridx = 0;
		programDisplayConstraints.gridy = 2;
		programDisplayConstraints.weighty = 1.0;
		programDisplayConstraints.fill = GridBagConstraints.BOTH;
		programDisplay.setMinimumSize(new Dimension(400, 768));
		programDisplay.setPreferredSize(new Dimension(400, 768));
		programDisplay.setEditable(false);

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
				programSteps.add(new ProgramStepPanel(programSteps.size()));
				programStepTabs.insertTab(
						"Step " + programStepTabs.getTabCount(), null,
						programSteps.get(programStepTabs.getTabCount() - 1),
						null, programStepTabs.getTabCount() - 1);
				programStepTabs.setSelectedIndex(programStepTabs.getTabCount() - 2);
			}
		});
		programStepTabs.addTab(null, null);
		programStepTabs.setTabComponentAt(0, newTabTab);

		mainPane.add(statusLabel, statusLabelConstraints);
		mainPane.add(programDisplay, programDisplayConstraints);
		mainPane.add(programStepTabs, programStepTabsConstraints);

		mainWindow.pack();
		mainWindow.setVisible(true);
	}

}
