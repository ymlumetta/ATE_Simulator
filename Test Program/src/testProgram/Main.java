package testProgram;
import javax.swing.*;

import programSteps.ProgramStepPanel;
import vectorEditor.VectorEditor;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Main {

	public static JFrame mainWindow = new JFrame("ATE Simulator");
	public static JLabel statusLabel = new JLabel();
	public static JTextPane programDisplay = new JTextPane();
	public static JTabbedPane programSteps = new JTabbedPane();
	public static VectorEditor vecEdit = new VectorEditor();
	public static ArrayList<String> dataLines = new ArrayList<String>();
	
	public static void main(String[] args) {
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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

		GridBagConstraints programStepsConstraints = new GridBagConstraints();
		programStepsConstraints.gridx = 1;
		programStepsConstraints.gridy = 2;
		programStepsConstraints.weightx = 1.0;
		programStepsConstraints.weighty = 1.0;
		programStepsConstraints.fill = GridBagConstraints.BOTH;

		JButton newTabTab = new JButton("+");
		newTabTab.setToolTipText("Create a new tab");
		newTabTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				programSteps.insertTab(null, null, new ProgramStepPanel(programSteps.getTabCount() - 1), null, programSteps.getTabCount() - 1);
				
				JPanel titlePanel = new JPanel();
				JTextField titleText = new JTextField("Step " + (programSteps.getTabCount() - 1));
				titleText.setEditable(false);
				JButton titleButton = new JButton("x");
				titleButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(dataLines.size() > programSteps.indexOfComponent(titleButton.getParent()))
							dataLines.remove(programSteps.indexOfTabComponent(titleButton.getParent()));
						programSteps.remove(programSteps.indexOfTabComponent(titleButton.getParent()));
					}
				});
				titlePanel.add(titleText);
				titlePanel.add(titleButton);
				
				programSteps.setTabComponentAt(programSteps.getTabCount() - 2, titlePanel);
				programSteps.setSelectedIndex(programSteps.getTabCount() - 2);
			}
		});
		programSteps.addTab(null, null);
		programSteps.setTabComponentAt(0, newTabTab);

		mainPane.add(statusLabel, statusLabelConstraints);
		mainPane.add(programDisplay, programDisplayConstraints);
		mainPane.add(programSteps, programStepsConstraints);

		mainWindow.pack();
		mainWindow.setVisible(true);
	}
	
	public static String getPart()
	{
		if(statusLabel.getText().indexOf(';') > 6)
			return statusLabel.getText().substring(statusLabel.getText().indexOf("Part:") + 6, statusLabel.getText().indexOf(';'));
		else
			return "";
	}
	
	public static String getTest()
	{
		return statusLabel.getText().substring(statusLabel.getText().indexOf("Test:") + 6);
	}
	
	public static void setPart(String part)
	{
		String status;
		status = statusLabel.getText().substring(0, statusLabel.getText().indexOf("Part:") + 6);
		status = status.concat(part);
		status = status.concat(statusLabel.getText().substring(statusLabel.getText().indexOf(';')));
		statusLabel.setText(status);
	}
	
	public static void setTest(String test)
	{
		String status;
		status = statusLabel.getText().substring(0, statusLabel.getText().indexOf("Test:") + 6);
		status = status.concat(test);
		statusLabel.setText(status);
	}
}
