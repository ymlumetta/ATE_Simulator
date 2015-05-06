package testProgram;
//import DatasheetEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	public MainMenu() {
		this.add(new FileMenu());

		JMenu partMenu = new JMenu("Part");

		JMenu analogPartMenu = new JMenu("Analog");

		JMenuItem lm741 = new JMenuItem("LM741");
		lm741.addActionListener(new PartMenuListener());
		analogPartMenu.add(lm741);

		JMenuItem op07d = new JMenuItem("OP07D");
		op07d.addActionListener(new PartMenuListener());
		analogPartMenu.add(op07d);

		partMenu.add(analogPartMenu);

		JMenu mixedSignalPartMenu = new JMenu("Mixed Signal");

		JMenuItem mcp6541 = new JMenuItem("MCP6541");
		mcp6541.addActionListener(new PartMenuListener());
		mixedSignalPartMenu.add(mcp6541);

		JMenuItem tlv5616 = new JMenuItem("TLV5616");
		tlv5616.addActionListener(new PartMenuListener());
		mixedSignalPartMenu.add(tlv5616);

		JMenuItem ads7822 = new JMenuItem("ADS7822");
		ads7822.addActionListener(new PartMenuListener());
		mixedSignalPartMenu.add(ads7822);

		partMenu.add(mixedSignalPartMenu);

		JMenu digitalPartMenu = new JMenu("Digital");

		JMenuItem pic16f883 = new JMenuItem("PIC16F883");
		pic16f883.addActionListener(new PartMenuListener());
		digitalPartMenu.add(pic16f883);

		partMenu.add(digitalPartMenu);

		this.add(partMenu);

		JMenu testMenu = new JMenu("Test");

		JMenuItem continuity = new JMenuItem("Continuity");
		continuity.addActionListener(new TestMenuListener());
		testMenu.add(continuity);

		JMenu analogTestMenu = new JMenu("Analog");

		JMenuItem analogOffset = new JMenuItem("Offset");
		analogOffset.addActionListener(new TestMenuListener());
		analogTestMenu.add(analogOffset);

		JMenuItem gainBandwidth = new JMenuItem("Gain Bandwidth");
		gainBandwidth.addActionListener(new TestMenuListener());
		analogTestMenu.add(gainBandwidth);

		JMenuItem cmrr = new JMenuItem("Common Mode Rejection Ratio");
		cmrr.addActionListener(new TestMenuListener());
		analogTestMenu.add(cmrr);

		JMenuItem psrr = new JMenuItem("Power Supply Rejection Ratio");
		psrr.addActionListener(new TestMenuListener());
		analogTestMenu.add(psrr);

		JMenuItem gol = new JMenuItem("Open Loop Gain");
		gol.addActionListener(new TestMenuListener());
		analogTestMenu.add(gol);

		JMenuItem inputBias = new JMenuItem("Input Bias Current");
		inputBias.addActionListener(new TestMenuListener());
		analogTestMenu.add(inputBias);

		JMenuItem analogTHD = new JMenuItem("Total Harmonic Distortion");
		analogTHD.addActionListener(new TestMenuListener());
		analogTestMenu.add(analogTHD);

		testMenu.add(analogTestMenu);

		JMenu mixedSignalTestMenu = new JMenu("Mixed Signal");

		JMenuItem offsetHysteresis = new JMenuItem("Offset/Hysteresis");
		offsetHysteresis.addActionListener(new TestMenuListener());
		mixedSignalTestMenu.add(offsetHysteresis);

		JMenuItem mixedTHD = new JMenuItem("Total Harmonic Distortion");
		mixedTHD.addActionListener(new TestMenuListener());
		mixedSignalTestMenu.add(mixedTHD);

		JMenuItem gainError = new JMenuItem("Gain Error");
		gainError.addActionListener(new TestMenuListener());
		mixedSignalTestMenu.add(gainError);

		JMenuItem dnlINL = new JMenuItem(
				"Differential and Integral Nonlinearity");
		dnlINL.addActionListener(new TestMenuListener());
		mixedSignalTestMenu.add(dnlINL);

		testMenu.add(mixedSignalTestMenu);

		JMenu digitalTestMenu = new JMenu("Digital");
		testMenu.add(digitalTestMenu);

		this.add(testMenu);
		
		JMenuItem vecEdit = new JMenuItem("Vector Editor");
		vecEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Main.vecEdit.setVisible(true);
			}
		});
		this.add(vecEdit);
		
		JMenuItem dataEdit = new JMenuItem("Datasheet Editor");
		dataEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//new DatasheetEditor();
			}
		});
		this.add(dataEdit);

		JMenuItem run = new JMenuItem("Run");
		run.addActionListener(new RunMenuListener());
		this.add(run);
	}

	private class PartMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Main.setPart(((JMenuItem) arg0.getSource()).getText());
		}
	}

	private class TestMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Main.setTest(((JMenuItem) arg0.getSource()).getText());
		}
	}

	private class RunMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		}
	}
}