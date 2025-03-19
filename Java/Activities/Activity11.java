package hello;

import java.util.HashMap;

public class Activity11 {
	public static void main(String[] args) {
		HashMap<Integer,String> colours = new HashMap<Integer,String>();
		
		colours.put(1, "Red");
		colours.put(2, "Blue");
		colours.put(3, "Pink");
		colours.put(4, "Black");
		colours.put(5, "Grey");
		
		System.out.println(colours);
		
		colours.remove(1, "Grey");
		System.out.println(colours.containsValue("Green"));
		System.out.println("MapSize is: " + colours.size());
		
		System.out.println("Map after removal of one colour:" + colours);
	}

}
