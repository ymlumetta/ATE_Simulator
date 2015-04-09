package vectorEditor;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class VectorEditor extends JFrame {

	public VectorEditor() throws HeadlessException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Vector Editor");

		Container vecEditPane = getContentPane();

		setJMenuBar(new VectorEditorMenu());

		JTabbedPane sheets = new JTabbedPane();
		JButton newTabTab = new JButton("+");
		newTabTab.setToolTipText("Create a new sheet");
		newTabTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//VectorTable table = new VectorTable();
				sheets.insertTab("Sheet " + sheets.getTabCount(), null,
						new JScrollPane(new JTable(new VectorTable())), null, sheets.getTabCount() - 1);
				sheets.setSelectedIndex(sheets.getTabCount() - 2);
			}
		});
		sheets.addTab(null, null);
		sheets.setTabComponentAt(0, newTabTab);
		vecEditPane.add(sheets);

		pack();
		setVisible(true);
	}

}
