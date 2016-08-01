package simulations;

public class ContinuityTest extends Test {
	Error error = new Error("Incorrect Step Order or Not Enough Steps");
	
	public ContinuityTest(){
		this.url = "http://granthudson.github.io/data/comparator/continuity.html";
	}
	
	
	
	public void parseSteps(){
		
		int i = 0;
		
		if(param.isEmpty()){
			error.toss();
			return;
		}
		
		if(!param.get(i).toString().equals("Close Relays\n")){
			error.toss();
			return;
		}	
		
		
		
		
		i++;
		if(!param.get(i).toString().equals("Open Relays\n")){
			return;
		}
		
		System.out.println("pass");
	}
}
