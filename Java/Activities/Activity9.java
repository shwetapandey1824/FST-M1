package hello;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		
		myList.add("Shally");
		myList.add("Noel");
		myList.add("Carol");
		myList.add("Nick");
		myList.add("John");
		
		for(String name : myList) {
			System.out.print(name+" ");
		}
		
		System.out.println();
		System.out.println("Third name in List is : " + myList.get(2));
		
		myList.contains("Noel");
		
		System.out.println("The size of List is: " + myList.size());
		
		myList.remove("Nick");
		System.out.println("List after name one namehas removed: "+ myList);
				
		
	}
	

}
