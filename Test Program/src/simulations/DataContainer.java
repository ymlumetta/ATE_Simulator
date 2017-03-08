package simulations;

import java.util.ArrayList;

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
}
