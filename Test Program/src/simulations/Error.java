package simulations;

import javax.swing.*;

public class Error {
	public String message;
	private static JFrame errorWindow;
	
	public Error(){
		message = "Unfortunately, an error has occurred.";
		errorWindow = new JFrame("Error!");
	}
	
	public Error(String thing){
		message = thing;
		errorWindow = new JFrame("Error!");
	}
	
	//Tosses errors!
	public void toss(){
		errorWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		errorWindow.setLocationRelativeTo(null);
		
		errorWindow.setName("Error!");
		errorWindow.add(new JOptionPane(message));
		
		errorWindow.pack();
		errorWindow.setVisible(true);
	}
}
