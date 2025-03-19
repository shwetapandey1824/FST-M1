package activities;

public class MyBook extends Book{

	public void setTitle(String s) {
		title=s;		
	}
	public class Main {
	    public static void main(String[] args) {
	        // Creating an object of MyBook class
	        MyBook newNovel = new MyBook();
	        
	        //set the title of the book
	        newNovel.setTitle("The Great Adventure");
	        
	        // print the title of the book
	        System.out.println("Book Title: " + newNovel.getTitle());
	    }
	}
}
