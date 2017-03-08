package simulations;

import java.io.IOException;

import javax.swing.JFrame;

import testProgram.Main;

public class ContinuityTest extends Test {
	
	private static int normalTest = 0;
//	private static int openSocket = 1;
//	private static int noWait = 6;
//	private static int longerWait = 5;
//	private static int currentDirectionWrong = 4;
	
	public ContinuityTest(){
		this.url = "http://granthudson.github.io/data/comparator/continuity.html";
	}
	
	
	
	
	
	public void makeTable(){
		Table table = new ContinuityTable();
		table.toss();
		table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.pack();
		table.setTitle("Continuity Test Results");
		table.setVisible(true);
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
	
	
	
	
	
	
}
