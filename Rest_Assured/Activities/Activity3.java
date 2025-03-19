package activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import java.util.HashMap;
import java.util.Map;


public class Activity3 {
		//Declare request specification
		RequestSpecification requestSpec;
		
		//Declare response specification
		ResponseSpecification responseSpec;
		
		@BeforeClass
		public void setup() {
			requestSpec = new RequestSpecBuilder()
					// Set content type
						  .addHeader("Content-Type","application/json")
					// Set base URL
						  .setBaseUri("https://petstore.swagger.io/v2/pet")
					// Build request specification
						  .build();
		
			responseSpec = new ResponseSpecBuilder().
								expectStatusCode(200).
								expectHeader("Content-Type","application/json").
								expectBody("status",equalTo("alive")).
								expectResponseTime(lessThanOrEqualTo(3000L)).
								build();

	}
		
		@DataProvider(name="petInfo")
		public Object[][] petInfoData(){
			//setting parameters to pass to test cases
			Object[][] testData = new Object[][]{
			{2345,"Jimmy", "alive"},
			{7899, "Tommy", "alive"} 
		} ;
			return testData;
		}
					
		@Test(priority=1, dataProvider="petInfo")
		public void addNewPets(int petId, String petName, String petStatus){
			// Test case using a DataProvider
			Map<String, Object> reqBody = new HashMap<>();
			reqBody.put("id", petId);
			reqBody.put("name", petName);
			reqBody.put("status", petStatus);
			
				given().
					spec(requestSpec).	// Use requestSpec
					body(reqBody).		// Send request body
				when().
					post().				// Send POST request
				then().	
					spec(responseSpec).			// Assertions using responseSpec
					body("name", equalTo(petName));	// Additional Assertion	
		}
		
		@Test(priority=2, dataProvider= "petInfo")
		public void getAddedPetsInfo(int petId, String petName, String petStatus){
				given().
					spec(requestSpec).
					pathParam("petId", petId).
				when().
					get("/{petId}").
				then().
					spec(responseSpec).
					body("name", equalTo(petName)).
					log().all();		
				
		}
		
		
		@Test(priority=3, dataProvider="petInfo")
		public void deleteAddedPets(int petId, String petName, String petStatus){
						given().
							spec(requestSpec).
							pathParam("petId", petId).
						when().
							delete("/{petId}").
						then().
							body("code",equalTo(200)).
							body("message",equalTo( ""+petId));
				
		}
}
