package simulations;

import java.util.ArrayList;


/**
 * Class meant to hold data pulled by the "split" function.  It holds the pin being tested, the numeric values, and 
 * whether or not those values passed the given test.
 * @author lumettym
 *
 */
public class DataContainer {
	public ArrayList<String> measurements;
	public ArrayList<String> status;
	public String pin;
	
	
	public DataContainer(){
		measurements = new ArrayList<String>();
		status = new ArrayList<String>();
		pin = "---";
	}
	
	public DataContainer(ArrayList<String> meas, ArrayList<String> st, String p){
		measurements = meas;
		status = st;
		pin = p;
	}
	
	
	public String toString(){
		String string = "Pin: " + pin + "\n" + "Data: \n";
		for(int i=0; i<measurements.size(); i++){
			string = string + measurements.get(i) + ", " + status.get(i) + "\n";
		}
		
		
		return string;
	}
}
