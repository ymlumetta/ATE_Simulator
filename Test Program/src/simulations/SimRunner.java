package simulations;


public class SimRunner {
	
	public SimRunner(){
		
	}
	
	
	public void runSim(String test, String part){
		
		switch(test){
		case "Continuity": 
			Test continuity = new ContinuityTest();
			continuity.run();
			break;
		case "Offset":
			Test offset = new OffsetTest();
			offset.run();
			break;
		case "Gain Error":
			Test gainError = new GainErrorTest();
			gainError.run();
			break;
		case "Differential and Integral Nonlinearity":
			Test lin = new LinearityTest();
			lin.run();
			break;
		case "Total Harmonic Distortion":
			Test thd = new THDTest();
			thd.run();
			break;
		case "":
			System.out.println("no test specified");
			break;
		default:
			System.out.println("input is not implemented yet");
			break;
		}
		
	}
	
	
	
	
	

	
}
