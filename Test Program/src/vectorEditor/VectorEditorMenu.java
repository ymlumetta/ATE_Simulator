package vectorEditor;
import javax.swing.JMenuBar;

import testProgram.FileMenu;

@SuppressWarnings("serial")
public class VectorEditorMenu extends JMenuBar {

	public VectorEditorMenu() {
		this.add(new FileMenu());
	}

}
