package simulations;

public class ContinuityTest extends Test {
	
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
		if(i>param.size() || (!param.get(i).toString().equals("Open Relays\n"))){
			stepsError.toss();
			return;
		}
		
		System.out.println("pass");
	}
}
