package simulations;

public class OffsetTest extends Test{

	
	public OffsetTest(){
		this.url = "http://granthudson.github.io/data/comparator/vos.html";
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
