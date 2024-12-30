package activities;

//Abstract class
abstract class Book{
	//Variable to hold book's title
	String title;
	
	//Abstract method to set the title
	public abstract void setTitle(String title);
		
	//concrete method to return the title of book
	public String getTitle() {
		return this.title;
		
		}
	}

class MyBook extends Book{
	//Implement to set the title
	public void setTitle(String title) {
		this.title = title;
	}
}

public class Activity5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyBook bookObj = new MyBook();
		bookObj.setTitle("The Alchemist");
		System.out.println(bookObj.getTitle());
	}
	
	
	

}
