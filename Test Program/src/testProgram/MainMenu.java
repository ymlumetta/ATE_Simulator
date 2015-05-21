package testProgram;
//import DatasheetEditor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import vectorEditor.VectorEditor;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar {

	String part;
	String test;
	
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
				new VectorEditor();
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
			String stat = Main.statusLabel.getText();
			stat = stat.substring(0, 6)
					+ ((JMenuItem) arg0.getSource()).getText()
					+ stat.substring(stat.indexOf("; Test: "));
			Main.statusLabel.setText(stat);
			part = ((JMenuItem) arg0.getSource()).getText();
		}
	}

	private class TestMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String stat = Main.statusLabel.getText();
			stat = stat.substring(0, stat.indexOf("Test:") + 6)
					+ ((JMenuItem) arg0.getSource()).getText();
			Main.statusLabel.setText(stat);
			test = ((JMenuItem) arg0.getSource()).getText();
		}
	}

	private class RunMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			switch(part){
				case "LM741":
					switch(test){
						case "Continuity":
							if(Main.dataLines.toString().equals("[Close Relays 1 3\n, Wait for 100 us\n, Set Current at ContGP 1 mA, V Range 10 V, I Range 10 mA\n, Wait for 100 us\n, Take 5 samples measuring every 5 us, store as variable Cont_Data\n, Datalog Cont_Data\n, Turn off  Current Sources\n, Wait for 100 us\n, Open Relays 1 3\n]")){
								JOptionPane.showMessageDialog(getParent(),
									"Part: LM741, Test: Continuity \n"
									+ "Results: Pass 0.687 V");
							}else{
								JOptionPane.showMessageDialog(getParent(),
										"Part: LM741, Test: Continuity \n"
										+ "Results: Fail 9.23 V");
							}
								
							break;
						case "Offset":
							
							break;
						case "Gain Bandwidth":
							
							break;
						case "Common Mode Rejection Ratio":
							
							break;
						case "Power Supply Rejection Ratio":
							
							break;
						case "Open Loop Gain":
							
							break;
						case "Input Bias Current":
							
							break;
						case "Total Harmonic Distortion":
							
							break;
					}
					break;
				case "OP07D":
					switch(test){
						case "Continuity":
							if(Main.dataLines.toString().equals("[Close Relays 1 2 3\n, Wait for 100 us\n, Set Current at ContGP 1 mA, V Range 10 V, I Range 10 mA\n, Wait for 100 us\n, Take 5 samples measuring every 5 us, store as variable Cont_Data\n, Datalog Cont_Data\n, Turn off  Current Sources\n, Wait for 100 us\n, Open Relays 1 2 3\n]")){
								JOptionPane.showMessageDialog(getParent(),
									"Part: OP07D, Test: Continuity \n"
									+ "Results: Pass 0.687 V");
							}else{
								JOptionPane.showMessageDialog(getParent(),
										"Part: OP07D, Test: Continuity \n"
										+ "Results: Fail 9.23 V");
							}
							break;
						case "Offset":
						
							break;
						case "Gain Bandwidth":
						
							break;
						case "Common Mode Rejection Ratio":
						
							break;
						case "Power Supply Rejection Ratio":
						
							break;
						case "Open Loop Gain":
						
							break;
						case "Input Bias Current":
						
							break;
						case "Total Harmonic Distortion":
						
							break;
					}
					break;
				case "MCP6541":
					
					break;
				case "TLV5616":
					
					break;
				case "ADS7822":
					
					break;
				case "PIC16F883":
					
					break;
			}
			
		}
	}
}