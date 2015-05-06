package vectorEditor;
import java.util.ArrayList;

public class Row {
	public int step = 0;
	public boolean capture = false;
	public String function = "";
	public ArrayList<Integer> vector = null;
	
	public Row() {
		vector = new ArrayList<Integer>();
	}
	
	public Row(int i) {
		step = i;
		vector = new ArrayList<Integer>();
	}
	
	public Integer get(int i) {
		if((i-2) > vector.size())
			return null;
		return vector.get(i-3);
	}
}