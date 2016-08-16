package simulations;

import javax.swing.JFrame;

import testProgram.Main;

public class ContinuityTest extends Test {
	
//	private int waitTime;
	
	public ContinuityTest(){
		this.url = "http://granthudson.github.io/data/comparator/continuity.html";
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
	
	
	
	
	
	public void makeTable(){
		Table table = new ContinuityTable();
		table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.setSize(600,200);
		table.setVisible(true);
	}
}
