package vectorEditor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import testProgram.FileMenu;
import testProgram.Main;

@SuppressWarnings("serial")
public class VectorEditorMenu extends JMenuBar {

	public VectorEditorMenu() {
		add(new FileMenu());
		
		JMenuItem addSteps = new JMenuItem("Add Steps");
		addSteps.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*((VectorTableModel) ((JTable) ((JViewport) ((JScrollPane) ((JTabbedPane) ((JPanel) ((JLayeredPane) ((VectorEditorMenu) ((JMenuItem) e.getSource()).getParent()).getParent()).getComponent(0)).getComponent(0)).getComponentAt(
					((JTabbedPane) ((JPanel) ((JLayeredPane) ((VectorEditorMenu) ((JMenuItem) e.getSource()).getParent()).getParent()).getComponent(0)).getComponent(0)).getSelectedIndex())).getComponent(0)).getComponent(0)).getModel()).addRows(
							Integer.parseInt(JOptionPane.showInputDialog("How many steps?", 1)));*/
				if(Main.vecEdit.sheets.getTabCount() == 1)
				{
					JOptionPane.showMessageDialog(getParent(), "Please add a sheet first.");
					return;
				}
				else
				{
					VectorTableModel vtm = Main.vecEdit.getTableModel(Main.vecEdit.sheets.getSelectedIndex());
					vtm.addRows(Integer.parseInt(JOptionPane.showInputDialog("How many steps?", 1)));
				}
			}
		});
		add(addSteps);
		
		JMenuItem addPin = new JMenuItem("Add Pin");
		addPin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!(Main.statusLabel.getText().indexOf(';') > 6))
				{
					JOptionPane.showMessageDialog(getParent(), "Please select a part before assigning pins.");
					return;
				}
				else if(Main.vecEdit.sheets.getTabCount() == 1)
				{
					JOptionPane.showMessageDialog(getParent(), "Please add a sheet first.");
					return;
				}
				else
				{
					VectorTableModel vtm = Main.vecEdit.getTableModel(Main.vecEdit.sheets.getSelectedIndex());
					Object[] selectValues;
					switch(Main.statusLabel.getText().substring(Main.statusLabel.getText().indexOf("Part:") + 6, Main.statusLabel.getText().indexOf(';')))
					{
					case "ADS7822":
						selectValues = new Object[] { "Pin1" };
						break;
					case "PIC16F883":
						selectValues = new Object[] {"RA0", "RA1", "RA2", "RA3", "RA4", "RA5", "RA6", "RA7", "RB0", "RB1", "RB2", "RB3", "RB4", "RB5", "RB6", "RB7", "RC0", "RC1", "RC2", "RC3", "RC4", "RC5", "RC6", "RC7", "RE3"};
						break;
					default:
						selectValues = new Object[] {};
					}
					vtm.addColumn((String) JOptionPane.showInputDialog(getParent(), "Which pin should be added?", "Add Pin", JOptionPane.PLAIN_MESSAGE, null, selectValues, null));
				}
			}
		});
		add(addPin);
	}

}
