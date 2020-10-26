package StepDefinitions;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseParse {
	
	Response response;
	@Test
	@Given("api for foreign exchange")
	public void api_for_foreign_exchange() {
	    RestAssured.baseURI="https://api.ratesapi.io";
	}

	@Test
	@When("posted with correct information")
	public void posted_with_correct_information() {
	   response=RestAssured.given().get("/api/latest");
	}

	@Test
	@Then("validate the response and log it on console")
	public void validate_the_response_and_log_it_on_console() {
	    response=RestAssured.given().headers("Content-Type","application/json").log().all().get("/api/latest").
	    		then().
	    		assertThat().statusCode(200).log().all().extract().response();
	}

}
