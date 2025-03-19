package liveProject;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
	//set the headers
	Map<String, String> headers = new HashMap<>();
	
	//Create the contract(Pact)
	@Pact(consumer = "UserConsumer", provider = "UserProvider")
	public RequestResponsePact createPact(PactDslWithProvider builder) {
		
		//set the headers
		headers.put("Content-Type", "application/json");
				
		//The request and response body
				DslPart reqResBody = new PactDslJsonBody()
                   .numberType("id", 123)
                   .stringType("firstName", "Vijaya")
                   .stringType("lastName", "Shree")
                   .stringType("email", "Vijaya@mail.com");
				
							
		//Create the Pact
				return builder.given("POST Request")
						.uponReceiving("A request to create a user")
						.method("POST")
						.path("/api/users")
						 .headers(headers)
						 .body(reqResBody)
						 .willRespondWith()
						 .status(201)
						 .body(reqResBody)
						 .toPact();
	}

	private void stringType(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	//Consumer test with mock Provider
	@Test
	@PactTestFor(providerName = "UserProvider", port = "8282")
	public void postRequestTest() {
		
		// Create request body
		Map<String, Object> reqBody = new HashMap<>();
		reqBody.put("id", 123);
		reqBody.put("firstName", "Vijaya");
		reqBody.put("lastName", "Shree");
		reqBody.put("email", "Vijaya@mail.com");
		
		//Send request, get response, add assertions
		given().baseUri("http://localhost:8282/api/users").headers(headers).body(reqBody)
		.when().post()
		.then().statusCode(201).body("email", equalTo("Vijaya@mail.com")).log().all();
}
}