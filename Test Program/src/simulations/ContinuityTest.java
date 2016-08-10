package simulations;

public class ContinuityTest extends Test {
	
	private int waitTime;
	
	public ContinuityTest(){
		this.url = "http://granthudson.github.io/data/comparator/continuity.html";
	}
	
	
	
	public void parseSteps(){
		
		int i = 0;
		
		if(param.isEmpty()){
			stepsError.toss();
			return;
		}
		
		if(i>param.size() || !param.get(i).toString().equals("Close Relays\n")){
			stepsError.toss();
			return;
		}	
		
		
		i++;		
		if(i>param.size() || (!param.get(i).toString().substring(0, 4).equals("Wait"))){
			stepsError.toss();
			return;
		}
		
		
		i++;		
		if(i>param.size() || (!param.get(i).toString().substring(0, 11).equals("Set Current"))){//set current source
			stepsError.toss();
			return;
		}
		
		
		i++;
		if(i>param.size() || (!param.get(i).toString().substring(0,4).equals("Wait"))){
			stepsError.toss();
			return;
		}
		
		
		i++;
		if(i>param.size() || (!param.get(i).toString().substring(0, 4).equals("Take"))){//measure voltage source
			stepsError.toss();
			return;
		}
		
		
		i++;
		if(i>param.size() || (!param.get(i).toString().substring(0, 7).equals("Datalog"))){//datalog
			stepsError.toss();
			return;
		}
		
		i++;
		if(i>param.size() || (!param.get(i).toString().equals("Turn Off Resources\n"))){//turn off equipment
			stepsError.toss();
			return;
		}
		
		i++;
		if(i>param.size() || (!param.get(i).toString().equals("Open Relays\n"))){
			stepsError.toss();
			return;
		}
		
		System.out.println("pass");
	}
}
