package com.stepDefinition;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class MyStepdefs {

    RequestSpecification request;
    Response response;

    @Given("User sets the base API Request {string}")
    public void user_sets_the_base_api_request(String string) {
        // Write code here that turns the phrase above into concrete actions
        RestAssured.baseURI = string;
    }

    @Given("User authenticates the API request with {string}")
    public void user_authenticates_the_api_request_with(String string) {
        // Write code here that turns the phrase above into concrete actions
        request = given().auth().oauth2(string);
    }
    @When("User sends the API request to get all the repositories")
    public void user_sends_the_api_request_to_get_all_the_repositories() {
        // Write code here that turns the phrase above into concrete actions
        String path = "/user/repos";
        response=request.get(path).then().extract().response();
    }
    @Then("User validates the response status is {string}")
    public void user_validates_the_response_status_is(String string) {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertEquals(response.getStatusCode(),200);
    }

}

