package activities;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.response.Response;


import java.util.HashMap;
import java.util.Map;

public class Activity1 {
  @Test(priority=1)
  public void postMethod1() {
	  Map<String,Object> reqBody = new HashMap<>();
	  		reqBody.put("id", 5353531);
	  		reqBody.put("name", "Jacob");
	  		reqBody.put("status","alive");
			  
	  Response response= given().
	  			baseUri("https://petstore.swagger.io/v2/pet").	//set baseURI
	  			header("Content-Type","application/json").		//set header
	  			body(reqBody).											//Add request body					
	  		when().post();
	  	//Assertions
	  response.then().body("id", equalTo(5353531));
	  response.then().body("name", equalTo("Jacob"));
	  response.then().body("status", equalTo("alive"));
  }
  
  @Test(priority =2)
  public void getMethod1() {
	  		Response response = given().
	  			baseUri("https://petstore.swagger.io/v2/pet/").		//set baseuri
	  			header("Content-Type","application/json").			//set header
	  			pathParam("petId", 5353531).			//set path parameter
	  		when().
	  			get("/{petId}");		// Send GET request
	  	//Assertions
	  		 response.then().body("id", equalTo(5353531));
	  		  response.then().body("name", equalTo("Jacob"));
	  		  response.then().body("status", equalTo("alive"));
	  	  }
	
  @Test(priority=3)
  public void DeletePet() {
	  Response response = given().
			  				baseUri("https://petstore.swagger.io/v2/pet/").		//set baseuri
			  				header("Content-Type","application/json").			//set header
			  				when().
			  				pathParam("petId", 5353531).			//set path parameter
			  				delete("/{petId}");		// Send DELETE request
	  			response.then().body("code", equalTo(200));
	  			 response.then().body("message", equalTo("5353531"));
  }
	
	
}
