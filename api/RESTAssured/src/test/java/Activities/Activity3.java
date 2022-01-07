package Activities;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.equalTo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class Activity3 {
	
	RequestSpecification requestSpec;
	ResponseSpecification responseSpec;
	@BeforeClass
	public void Setup()
	{
		 requestSpec = new RequestSpecBuilder()
				// Set content type
				.setContentType(ContentType.JSON)
				// Set base URL
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				// Build request specification
				.build();
		 
		  responseSpec = new  ResponseSpecBuilder()
				// Check status code in response
				.expectStatusCode(200)
				// Check response content type
				.expectContentType("application/json")//.expectBody("status", equalTo("Alive"))
				.expectBody("status", equalTo("alive"))
				// Check size of the array in a JSON response
				//.expectBody("Status",equalTo("Alive"))
				// Build response specification
				.build();
	}
	
	@Test
  public void postRequest() {
	  
	  String Pet1 = "{\"id\": 77232, \"name\": \"Riley\", \"status\": \"alive\"}";
	  Response response = given().spec(requestSpec) // Use requestSpec
		        .body(Pet1).when().post();
	  
	  response.then().spec(responseSpec);
	  
	  String Pet2 = "{\"id\": 77233, \"name\": \"Hansel\", \"status\": \"alive\"}";
	  Response response1 = given().spec(requestSpec) // Use requestSpec
		        .body(Pet2).when().post();
	  
	  response.then().spec(responseSpec);
  }
  @Test
  public void getRequest() {
	 // https://petstore.swagger.io/v2/user/{username}
	  Response response1 = given().spec(requestSpec) // Use requestSpec
		        .when().get("https://petstore.swagger.io/v2/user/{username}");
	  
	      
  }
  @Test
  public void deleteRequest() {
  }
  
  
}
