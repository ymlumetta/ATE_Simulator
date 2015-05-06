package vectorEditor;
import java.awt.Container;
import java.awt.HeadlessException;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class VectorEditor extends JFrame {

	public JTabbedPane sheets = new JTabbedPane();
	
	public VectorEditor() throws HeadlessException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Vector Editor");

		Container vecEditPane = getContentPane();

		setJMenuBar(new VectorEditorMenu());

		JButton newTabTab = new JButton("+");
		newTabTab.setToolTipText("Create a new sheet");
		newTabTab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTable table = new JTable(new VectorTableModel());
				table.setCellSelectionEnabled(true);
				sheets.insertTab(null, null, new JScrollPane(table), null, sheets.getTabCount() - 1);
				
				JPanel titlePanel = new JPanel();
				JTextField titleText = new JTextField("Sheet" + (sheets.getTabCount() - 1));
				titleText.setEditable(false);
				
				JPopupMenu titleMenu = new JPopupMenu();
				titleMenu.addFocusListener(new FocusListener() {
					@Override
					public void focusGained(FocusEvent arg0) {
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						titleMenu.setVisible(false);
					}
				});
				
				JMenuItem editTitle = new JMenuItem("Rename Sheet");
				editTitle.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						titleText.setEditable(true);
					}
				});
				titleMenu.add(editTitle);
				
				titleText.addFocusListener(new FocusListener() {
					@Override
					public void focusGained(FocusEvent arg0) {
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						titleText.setEditable(false);
					}
					
				});
				titleText.addMouseListener(new MouseListener() {
					@Override
					public void mouseClicked(MouseEvent arg0) {
						if(arg0.getButton() == MouseEvent.BUTTON3) {
							titleMenu.setLocation(arg0.getLocationOnScreen());
							titleMenu.setInvoker(titleText);
							titleMenu.setVisible(true);
						}
					}

					@Override
					public void mouseEntered(MouseEvent arg0) {
					}

					@Override
					public void mouseExited(MouseEvent arg0) {
					}

					@Override
					public void mousePressed(MouseEvent arg0) {
					}

					@Override
					public void mouseReleased(MouseEvent arg0) {
					}
				});
				/*titleText.addKeyListener(new KeyListener() {
					@Override
					public void keyPressed(KeyEvent arg0) {
					}

					@Override
					public void keyReleased(KeyEvent arg0) {
					}

					@Override
					public void keyTyped(KeyEvent arg0) {
						if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
							titleText.setEditable(false);
					}
				});*/
				
				JButton titleButton = new JButton("x");
				titleButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						sheets.remove(sheets.indexOfTabComponent(titleButton.getParent()));
					}
				});
				
				titlePanel.add(titleText);
				titlePanel.add(titleButton);
				
				sheets.setTabComponentAt(sheets.getTabCount() - 2, titlePanel);
				sheets.setSelectedIndex(sheets.getTabCount() - 2);
			}
		});
		sheets.addTab(null, null);
		sheets.setTabComponentAt(0, newTabTab);
		vecEditPane.add(sheets);

		pack();
	}
	
	public VectorTableModel getTableModel(int pane)
	{
		return (VectorTableModel) ((JTable) ((JViewport) ((JScrollPane) sheets.getComponentAt(pane)).getComponent(0)).getComponent(0)).getModel();
	}
}
