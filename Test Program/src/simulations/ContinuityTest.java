package simulations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import testProgram.Main;

public class ContinuityTest extends Test {
	
	private static int normalTest = 0;
//	private static int openSocket = 1;
//	private static int noWait = 6;
//	private static int longerWait = 5;
//	private static int currentDirectionWrong = 4;
	

	
	public ContinuityTest(){
		testType = normalTest;
	}
	
	
	
	
	
	public void makeTable(){
		Table table = new ContinuityTable();
		table.toss();
		table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.pack();
		table.setTitle("Continuity Test Results");
		table.setVisible(true);
	}
	
	
	
	public void findData() throws FileNotFoundException{
		@SuppressWarnings("resource")
		Scanner input = new Scanner(new FileReader("src/testData/continuity.txt"));
		
		
		while(input.hasNextLine()){
			String next = input.nextLine();
			if(next.startsWith("<" + testType +">")){
				split(next);
//				System.out.println(next);
			}
				
		}
		System.out.println("FINISHED");
	}
	
	
	
	
	public void parseSteps(){
		int i = 0;
		
		if(param.isEmpty()){
			stepOrderError.toss();
			return;
		}
		
		if(!Main.programSteps.get(i).getName().equals("Close Relays")){
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!Main.programSteps.get(i).getName().equals("Wait")){
			stepOrderError.toss();
			return;
		}
		
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Wait")){
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Measure Voltage")){//measure voltage source
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Datalog")){//datalog
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Wait")){
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Measure Voltage")){//measure voltage source
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Datalog")){//datalog
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		i++;		
		if(!(Main.programSteps.get(i).getName().equals("Set Current") || Main.programSteps.get(i).getName().equals("Set Voltage"))){//set current source
			stepOrderError.toss();
			return;
		}
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Wait")){
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Measure Voltage")){//measure voltage source
			stepOrderError.toss();
			return;
		}
		
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Datalog")){//datalog
			stepOrderError.toss();
			return;
		}
		
		i++;
		if(!Main.programSteps.get(i).getName().equals("Turn Off Resources")){//turn off equipment
			stepOrderError.toss();
			return;
		}
		
		i++;
		
		if(!Main.programSteps.get(i).getName().equals("Open Relays")){
			stepOrderError.toss();
			return;
		}
		
		i++;
		if(!(i==Main.programSteps.size())){
			tooManyStepsError.toss();
			return;
		}
		
		System.out.println("pass");
		Error pass = new Error("Continuity test steps are correct!");
		pass.toss();
	}
	
	
	//don't look too closely at this.  If you follow the format in the text files, this will split the data 
	//into the pin, the test measurements, and the pass/fail status.
	//I have not left room for user error, so please follow the format in the text files.
	
	private DataContainer split(String input){
		
		input = input.trim();
		ArrayList<String> status = new ArrayList<String>();
		ArrayList<String> measurements = new ArrayList<String>();
		String pin = "---";
		
		String[] part = input.split(":");
		
		//Grabbing the pin
		pin = part[0].split(" ")[1];
		
		//grabbing the other two parts from part[1]
		String[] data = part[1].split("&");
		for(String list : data){
			list = list.replace("[","");
			list = list.replace("]","");
			list = list.trim();
			String[] cleanData = list.split(",");
			measurements.add(cleanData[0]);
			status.add(cleanData[1]);
		}
		
		System.out.println("");
		return new DataContainer(measurements, status, pin);
	}
	
	
	
	
	
}
