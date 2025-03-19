package hello;

class CustomException extends Exception {

	private String message;
	
	public CustomException(String message){
		this.message = message;
	}
	@Override
	public String getMessage() {
	    return message;
	}
}

public class Activity8{
	public static void main(String[] args) {
		try {
			Activity8.exceptionTest("The Exception has occured");
			Activity8.exceptionTest(null);
		}
		catch(CustomException custom){
			System.out.println(custom.getMessage());
		}
	}

	 static void exceptionTest(String string) throws CustomException {
	        if(string == null) {
	        	
	            throw new CustomException("String value is null");
		
	        } else {
		
	            System.out.println(string);
		
	        }
		
	}
	
}

