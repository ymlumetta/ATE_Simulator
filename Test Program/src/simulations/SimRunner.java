package simulations;



// This is called by MainMenu in the action listeners to run the simulation.

public class SimRunner {
	
	Error noTestError = new Error("Please select a test!");
	Error weirdStuffHappened = new Error("I broke; sorry!");
	
	public SimRunner(){
		
	}
	
	
	public void runSim(String test, String part){
		
		switch(test){
		case "Continuity": 
			Test continuity = new ContinuityTest();
			continuity.run();
			break;
		case "Offset/Hysteresis":
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
			noTestError.toss();
			break;
		default:
			weirdStuffHappened.toss();
			break;
		}
		
	}
	
	
	
	
	

	
}
