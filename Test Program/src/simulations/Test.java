package simulations;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;

import testProgram.Main;

public class Test {
	String url;
	ArrayList<String> param = Main.dataLines;
	Error stepOrderError = new Error("Incorrect Step Order");
	Error tooManyStepsError = new Error("Too Many Steps!");
	
	private Random randomGenerator;	
	
	public Test(){
		randomGenerator = new Random();
	}
	

	
	
	public void run(){
//		parseSteps();
//		findTables(url);
		makeTable();
	}
	
	
	
	
	
	public void parseSteps(){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void findTables(String url){
//        String html = url;
//        Document doc = null;
//        if(url == null) return;
//		try {
//			doc = Jsoup.connect(html).get();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//        Elements tableElements = doc.select("table");
//        Element firstTable = tableElements.get(0);
//        
//        System.out.println(firstTable);        
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
	
}
