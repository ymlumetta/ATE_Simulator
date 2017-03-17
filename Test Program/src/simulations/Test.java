package simulations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;

//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import testProgram.Main;

public class Test {
	
	protected int testType;
	ArrayList<String> param = Main.dataLines;
	Error stepOrderError = new Error("Incorrect Step Order");
	Error tooManyStepsError = new Error("Too Many Steps!");
	Error fileNotFound = new Error("File not found!");
	
	private Random randomGenerator;	
	
	protected ArrayList<DataContainer> data;
	
	public Test(){
		randomGenerator = new Random();
	}
	

	
	
	public void run(){
//		parseSteps();
		try {
			findData();
		} catch (FileNotFoundException e) {
			fileNotFound.toss();
		}
		makeTable();
	}
	
	
	
	
	
	public void parseSteps(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void findData() throws FileNotFoundException{
		
     
    }
	
	
	
	
	@SuppressWarnings("unused")
	private int getItemFromList(ArrayList<Integer> list){
		int index = randomGenerator.nextInt(list.size());
        int item = list.get(index);
        return item;
	}
	
	
	
	
	public void makeTable(){
		Table table = new Table();
		table.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		table.pack();
		table.setVisible(true);
	}
	
	
	
	
	//don't look too closely at this.  If you follow the format in the text files, this will split the data 
		//into the pin, the test measurements, and the pass/fail status.
		//I have not left room for user error, so please follow the format in the text files.
		
		protected DataContainer split(String input){
			
			input = input.trim();
			ArrayList<String> status = new ArrayList<String>();
			ArrayList<String> measurements = new ArrayList<String>();
			String pin = "---";
			
			String[] part = input.split(":");
			
			//Grabbing the pin
			pin = part[0].split(" ")[1];
			
			//grabbing the other two parts from part[1]
			String[] data = part[1].split("&");
			
			//very messy, do not touch
			for(String list : data){
				list = list.replace("[","");
				list = list.replace("]","");
				list = list.trim();
				String[] cleanData = list.split(",");
				measurements.add(cleanData[0]);
				status.add(cleanData[1]);
			}
			return new DataContainer(measurements, status, pin);
		}
		
	
}
