package com.ibm.training.GitHub_RestAssured_Project;

import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class GitHub_RestAssured_Project {
	RequestSpecification requestSpec;
	//ResponseSpecification responseSpec;
	String SSH_Key;
	int Id;
	 @BeforeClass
	  public void Setup() {
		 
		 requestSpec = new RequestSpecBuilder()
					// Set content type
					.setContentType(ContentType.JSON)
					.addHeader("Authorization","token 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")
					// Set base URL
					.setBaseUri("https://api.github.com")
					// Build request specification
					.build();
	
	  }
	 
	
	@Test(priority=1)
	  public void sshKeyPost_Request() {
		String Reque_Body= "{\"title\": \"TestAPIKey\",\"key\":\"ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABgQDD2aWqf3mqHT9rfHpjOQ5cPTTOyZuOWfywDJOJdTqCOABCwxcduIj2SEE8ZKUZMutwU96qClKXIeDMCMh+Iuq6o9oVnjSDYDdO1ZzzpCCJIjiLv1m98qtXgeZHyf0Z+JBw+716rh7QrqTSVR+e1iKWOBvqFHp7uFys/58+8QQaJFyQgdwKIivVQCjFppAQroiQFTbxYhz28xBHFnkF9e5SLhevJc1rED8j+rh8DHVJGcifND3zDmBwd+SQLw3tv6kBdt+llvfaHF6J+UvlCr1GKLOyL3qXplB5RX7iUHtb4pzVj+1BjrBWU9TIrpRTzrIaoB4zYy4kBOBUk6S5UNaoyXNiFTPDJBRLxhBN/Yb3FCjY7B45MM1fFKiEJTVQXujK0PYv6jwj4KHRN5EV0/hIt/2GBYJycblEbOTr5SSdn4baJtE8Casd/tY3Kaalal8cPnrMCkj+Q1FAUdIabUAl0gIR2QxX7xW3kmgnHCCNK30QDw3JQlIsilvuCY57gy8= ibmadmin@NBSB05221W-TP\"}";
		Response response = given().spec(requestSpec) // Use requestSpec
		        .body(Reque_Body).when().post("/user/keys");
		SSH_Key = response.then().extract().asPrettyString();
		Id = response.then().extract().path("id");
		System.out.println(SSH_Key);
		//Id= Integer.parseInt(Id);
		
		System.out.println(Id);
		
		response.then().statusCode(201);
	  }

	@Test(priority=2,enabled=false)
	  public void sshKeyGET_Request() {
		Response response = given().spec(requestSpec) // Use requestSpec
		        .when().get("/user/keys");
		Reporter.log(response.asString());
		response.then().statusCode(200);
		
	  }
	
	@Test(priority=3,enabled=false)
	  public void sshKeyDELETE_Request() {
		
		Response response = given().spec(requestSpec) // Use requestSpec
		        .when().pathParam("KeyId",Id).delete("/user/keys/{KeyId}");
		Reporter.log(response.asString());
		response.then().statusCode(204);
		
	  }
	 

	@AfterClass
	  public void afterClass() {
	  }

}
