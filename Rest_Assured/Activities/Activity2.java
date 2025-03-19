package activities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;

public class Activity2 {
	@Test(priority=1)
	  public void addNewUserFromFile() throws IOException {
		//Import JSON file
	FileInputStream inputJson= new FileInputStream("src\\test\\java\\activities\\userInfo.json");
	
		Response response = given()
								.baseUri("https://petstore.swagger.io/v2/user")
								.header("Content-Type","application/json")
								.body(inputJson)					//provide body 
							.when().post();		//send POST request
			inputJson.close();
					//Assertion
				response.then().body("code", equalTo(200));
				response.then().body("message",equalTo("1991"));
}
	@Test(priority=2)
	public void getAddedUserInfo() {
		//Import JSON file to write to
			File outputJSON = new File("src\\test\\java\\activities\\userGETResponse.json");
		Response response = given()
							  .baseUri("https://petstore.swagger.io/v2/user")
							  .header("Content-Type","application/json")
							  .pathParam("username", "sheril")
							.when()
								.get("/{username}");
		
			//Get response body
		String body= response.getBody().asPrettyString();
		
		try{
			//create JSON file
				outputJSON.createNewFile();
			//write response body into JSON file
				FileWriter writer = new FileWriter(outputJSON.getPath());
					writer.write(body);
					writer.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		//Assertions
		response.then().body("id", equalTo(1991));
		response.then().body("username",equalTo("sheril"));
		response.then().body("firstName", equalTo("shery"));
		response.then().body("lastName",equalTo("Keyos"));
		response.then().body("email", equalTo("shery123@mail.com"));
		response.then().body("password",equalTo("password123"));
		response.then().body("phone", equalTo("9876543210"));
			
		
	}
	
	@Test(priority=3)
	public void deleteUser() {
			Response response= given().
									baseUri("https://petstore.swagger.io/v2/user").
									header("Content-Type","application/json").
									pathParam("username","sheril").
								when().
									delete("/{username}");
			//Assertions
				response.then().body("code", equalTo(200))	;
				response.then().body("message", equalTo("sheril"));
		
	}
	
	
	
	
	
	
	
	
	
	
  
}
