package hello;

import java.util.HashSet;

public class Activity10 {
	
public static void main(String[] args) {
	HashSet<String> hs= new HashSet<>();
	
	hs.add("Shally");
	hs.add("Noel");
	hs.add("Carol");
	hs.add("Nick");
	hs.add("John");
	hs.add("Senthil");
	
	System.out.println("Set Size: " + hs.size());
	
	System.out.println(hs.contains("Noel"));
	
	hs.remove("Nick");
	hs.remove("ABC"); 	//Not available in set
	System.out.println("List after name one namehas removed: "+ hs);
}

}
