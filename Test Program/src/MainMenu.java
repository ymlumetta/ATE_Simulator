import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

@SuppressWarnings("serial")
public class MainMenu extends JMenuBar implements ActionListener {

	public MainMenu() {
		JMenu fileMenu = new JMenu("File");
		this.add(fileMenu);
		
		JMenu partMenu = new JMenu("Part");
		
		JMenu analogPartMenu = new JMenu("Analog");
		
		JMenuItem lm741 = new JMenuItem("LM741");
		lm741.addActionListener(this);
		analogPartMenu.add(lm741);
		
		JMenuItem op07d = new JMenuItem("OP07D");
		op07d.addActionListener(this);
		analogPartMenu.add(op07d);
		
		partMenu.add(analogPartMenu);
		
		JMenu mixedSignalPartMenu = new JMenu("Mixed Signal");
		
		JMenuItem mpc6541 = new JMenuItem("MPC6541");
		mpc6541.addActionListener(this);
		mixedSignalPartMenu.add(mpc6541);
		
		JMenuItem tlv5616 = new JMenuItem("TLV5616");
		tlv5616.addActionListener(this);
		mixedSignalPartMenu.add(tlv5616);
		
		JMenuItem ads7822 = new JMenuItem("ADS7822");
		ads7822.addActionListener(this);
		mixedSignalPartMenu.add(ads7822);
		
		partMenu.add(mixedSignalPartMenu);
		
		JMenu digitalPartMenu = new JMenu("Digital");
		
		JMenuItem pic16f883 = new JMenuItem("PIC16F883");
		pic16f883.addActionListener(this);
		digitalPartMenu.add(pic16f883);
		
		partMenu.add(digitalPartMenu);
		
		this.add(partMenu);
		
		JMenu testMenu = new JMenu("Test");
		
		JMenuItem continuity = new JMenuItem("Continuity");
		continuity.addActionListener(this);
		testMenu.add(continuity);
		
		JMenu analogTestMenu = new JMenu("Analog");
		
		JMenuItem analogOffset = new JMenuItem("Offset");
		analogOffset.addActionListener(this);
		analogTestMenu.add(analogOffset);
		
		JMenuItem gainBandwidth = new JMenuItem("Gain Bandwidth");
		gainBandwidth.addActionListener(this);
		analogTestMenu.add(gainBandwidth);
		
		JMenuItem cmrr = new JMenuItem("Common Mode Rejection Ratio");
		cmrr.addActionListener(this);
		analogTestMenu.add(cmrr);
		
		JMenuItem psrr = new JMenuItem("Power Supply Rejection Ratio");
		psrr.addActionListener(this);
		analogTestMenu.add(psrr);
		
		JMenuItem gol = new JMenuItem("Open Loop Gain");
		gol.addActionListener(this);
		analogTestMenu.add(gol);
		
		JMenuItem inputBias = new JMenuItem("Input Bias Current");
		inputBias.addActionListener(this);
		analogTestMenu.add(inputBias);
		
		JMenuItem analogTHD = new JMenuItem("Total Harmonic Distortion");
		analogTHD.addActionListener(this);
		analogTestMenu.add(analogTHD);
		
		testMenu.add(analogTestMenu);
		
		JMenu mixedSignalTestMenu = new JMenu("Mixed Signal");
		
		JMenuItem offsetHysteresis = new JMenuItem("Offset/Hysteresis");
		offsetHysteresis.addActionListener(this);
		mixedSignalTestMenu.add(offsetHysteresis);
		
		JMenuItem mixedTHD = new JMenuItem("Total Harmonic Distortion");
		mixedTHD.addActionListener(this);
		mixedSignalTestMenu.add(mixedTHD);
		
		JMenuItem gainError = new JMenuItem("Gain Error");
		gainError.addActionListener(this);
		mixedSignalTestMenu.add(gainError);
		
		JMenuItem dnlINL = new JMenuItem("Differential and Integral Nonlinearity");
		dnlINL.addActionListener(this);
		mixedSignalTestMenu.add(dnlINL);
		
		testMenu.add(mixedSignalTestMenu);
		
		JMenu digitalTestMenu = new JMenu("Digital");
		testMenu.add(digitalTestMenu);
		
		this.add(testMenu);
		
		JMenuItem run = new JMenuItem("Run");
		run.addActionListener(this);
		this.add(run);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}
