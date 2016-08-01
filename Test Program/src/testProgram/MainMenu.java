package testProgram;
//import DatasheetEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import simulations.SimRunner;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {


	public MainMenu() {
		this.add(new FileMenu());
		
		JMenu testMenu = new JMenu("Test");

		JMenu analogPartMenu = new JMenu("Analog");
		testMenu.add(analogPartMenu);

		JMenu lm741 = new JMenu("LM741 (Op Amp)");
		lm741.setName("LM741");
		analogPartMenu.add(lm741);

		JMenu op07d = new JMenu("OP07D (Op Amp)");
		op07d.setName("OP07D");
		analogPartMenu.add(op07d);

		JMenu mixedSignalPartMenu = new JMenu("Mixed Signal");
		testMenu.add(mixedSignalPartMenu);

		JMenu mcp6541 = new JMenu("MCP6541 (Comparator)");
		mcp6541.setName("MCP6541");
		mixedSignalPartMenu.add(mcp6541);

		JMenu tlv5616 = new JMenu("TLV5616 (DAC)");
		tlv5616.setName("TLV5616");
		mixedSignalPartMenu.add(tlv5616);
		
		analogPartMenu.add(lm741);
		
		
		

		JMenuItem continuity = new JMenuItem("Continuity");
		continuity.addActionListener(new TestMenuListener());
		lm741.add(continuity);
		
		JMenuItem continuity2 = new JMenuItem("Continuity");
		continuity2.addActionListener(new TestMenuListener());
		op07d.add(continuity2);

//		JMenuItem analogOffset = new JMenuItem("Offset");
//		analogOffset.addActionListener(new TestMenuListener());

//		JMenuItem gainBandwidth = new JMenuItem("Gain Bandwidth");
//		gainBandwidth.addActionListener(new TestMenuListener());

//		JMenuItem cmrr = new JMenuItem("Common Mode Rejection Ratio");
//		cmrr.addActionListener(new TestMenuListener());

//		JMenuItem psrr = new JMenuItem("Power Supply Rejection Ratio");
//		psrr.addActionListener(new TestMenuListener());

//		JMenuItem gol = new JMenuItem("Open Loop Gain");
//		gol.addActionListener(new TestMenuListener());

		JMenuItem inputBias = new JMenuItem("Input Bias Current");
		inputBias.addActionListener(new TestMenuListener());

		JMenuItem analogTHD = new JMenuItem("Total Harmonic Distortion");
		analogTHD.addActionListener(new TestMenuListener());
		lm741.add(analogTHD);
		
		JMenuItem analogTHD2 = new JMenuItem("Total Harmonic Distortion");
		analogTHD2.addActionListener(new TestMenuListener());
		op07d.add(analogTHD2);

		JMenuItem offsetHysteresis = new JMenuItem("Offset/Hysteresis");
		offsetHysteresis.addActionListener(new TestMenuListener());
		mcp6541.add(offsetHysteresis);

//		JMenuItem mixedTHD = new JMenuItem("Total Harmonic Distortion");
//		mixedTHD.addActionListener(new TestMenuListener());

		JMenuItem gainError = new JMenuItem("Gain Error");
		gainError.addActionListener(new TestMenuListener());
		tlv5616.add(gainError);

		JMenuItem dnlINL = new JMenuItem("Differential and Integral Nonlinearity");
		dnlINL.addActionListener(new TestMenuListener());
		tlv5616.add(dnlINL);

		
		
//		JMenu digitalTestMenu = new JMenu("Digital");		
		
		this.add(testMenu);
		
		
		//TODO  add this back in for the vector editor
//		JMenuItem vecEdit = new JMenuItem("Vector Editor");
//		vecEdit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				new VectorEditor();
//			}
//		});
//		this.add(vecEdit);
		
		//TODO:  add this back for datasheet editor
//		JMenuItem dataEdit = new JMenuItem("Datasheet Editor");
//		dataEdit.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent arg0) {
//				//new DatasheetEditor();
//			}
//		});
//		this.add(dataEdit);

		JMenuItem run = new JMenuItem("Run");
		run.addActionListener(new RunMenuListener());
		this.add(run);
	}
	

	private class TestMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String stat = Main.statusLabel.getText();
			stat = stat.substring(0, stat.indexOf("Test:") + 6)
					+ ((JMenuItem) arg0.getSource()).getText();			
			Main.statusLabel.setText(stat);
			
			
			JMenuItem eventFrom = (JMenuItem)arg0.getSource();
			JPopupMenu fromParent = (JPopupMenu)eventFrom.getParent();
			JMenu foo = (JMenu)fromParent.getInvoker();
			
			
			stat = stat.substring(0, 6)
					+ foo.getName()
					+ stat.substring(stat.indexOf("; Test: "));
			
			Main.statusLabel.setText(stat);
		}
	}

	private class RunMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			String stat = Main.statusLabel.getText();
			String test = stat.substring(stat.indexOf("Test:")+6);
			String part = stat.substring(6, stat.indexOf(";"));
			
			SimRunner runner = new SimRunner();
	
			runner.runSim(test, part);
		}
	}
}