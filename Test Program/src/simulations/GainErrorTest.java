package simulations;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

public class GainErrorTest extends Test{
	private static int normalTest = 0;
	
	public GainErrorTest(){
		testType = normalTest;
		data = new ArrayList<DataContainer>();
	}
	
	
	public void makeTable(){
		Table table = new GainErrorTable(data);
		table.toss();
		table.setLocationRelativeTo(null);
		table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.pack();
		table.setTitle("Continuity Test Results");
		table.setVisible(true);
	}
	
	
	public void findData() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(new FileReader("src/testData/gain_error.txt"));
		
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			if(next.startsWith("<" + testType +">")){
				data.add(split(next));
			}				
		}
	}
	
	
	
	
	public void parseSteps(){
		
		int i = 0;
		
		if(param.isEmpty()){
			stepOrderError.toss();
			return;
		}
		
		if(i>param.size() || !param.get(i).toString().equals("Close Relays\n")){
			stepOrderError.toss();
			return;
		}	
		
		
		
		
		i++;
		if(i>param.size() || (!param.get(i).toString().equals("Open Relays\n"))){
			stepOrderError.toss();
			return;
		}
		
		System.out.println("pass");
	}
}
