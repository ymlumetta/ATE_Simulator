import java.awt.Container;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class DatasheetEditor extends JFrame {
	
	static JTable data = new JTable(new DatasheetTable());

	public DatasheetEditor() throws HeadlessException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Datasheet Editor");
		
		Container dataEditPane = getContentPane();
		
		setJMenuBar(new DatasheetEditorMenu());
		
		JScrollPane dataPane = new JScrollPane(data);
		dataEditPane.add(dataPane);
		
		pack();
		setVisible(true);
	}
}
