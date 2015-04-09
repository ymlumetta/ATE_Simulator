import javax.swing.JMenuBar;

import testProgram.FileMenu;

@SuppressWarnings("serial")
public class DatasheetEditorMenu extends JMenuBar {
	
	public DatasheetEditorMenu() {
		this.add(new FileMenu());
	}
	
}
