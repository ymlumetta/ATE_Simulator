package programSteps;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import testProgram.Main;

@SuppressWarnings("serial")
public class MathPanel extends JPanel {

	int textLineNumber;
	ArrayList<Object> mathArray = new ArrayList<Object>();
	
	public MathPanel(int lineNumber) {
		JTextField math = new JTextField();
		math.setText("Enter Math Here");
		this.add(math);
		mathArray.add(math);
		math.getDocument().addDocumentListener(new MathListener());
		textLineNumber = lineNumber;
	}
	
	public MathPanel(ArrayList<String> equation) {
		textLineNumber = Main.programSteps.getTabCount() - 1;
		JTextField math = new JTextField();
		this.add(math);
		mathArray.add(math);
		math.getDocument().addDocumentListener(new MathListener());
		math.setText(equation.get(0));
	}
	
	private class MathListener implements DocumentListener {
		@Override
		public void changedUpdate(DocumentEvent arg0) {
		}

		@Override
		public void insertUpdate(DocumentEvent arg0) {
			Iterator<Object> mAI = mathArray.iterator();
			String math = ((JTextField) mAI.next()).getText();
			math = math + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, math);
			} else {
				Main.dataLines.set(textLineNumber, math);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}

		@Override
		public void removeUpdate(DocumentEvent arg0) {
			Iterator<Object> mAI = mathArray.iterator();
			String math = ((JTextField) mAI.next()).getText();
			math = math + "\n";
			if (Main.dataLines.size() < textLineNumber + 1) {
				Main.dataLines.add(textLineNumber, math);
			} else {
				Main.dataLines.set(textLineNumber, math);
			}
			Main.programDisplay.setText(Main.dataLines.toString());
		}
	}
}
