package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import io.restassured.response.Response;
import java.io.IOException;
import apiServices.RequestAPI;

public class APISteps {

    public RequestAPI requester = new RequestAPI();
    public static Response response;
    public static String jsonAsString;

    @Given("^I add two numbers (.*) and (.*)$")
    public void addTwoNumbers(String param1, String param2) throws IOException{
        requester.callAddNumbers(param1, param2);

    }

    @Then("^Should return status OK and Result as (.+)$")
    public void Should_return_status_OK_and_Result_as(String result) throws Throwable {
        requester.assertResponse(result);
    }

    @Then("^Should return status (\\d+)$")
    public void Should_return_status_code(int code) throws Throwable {
        requester.assertStatusCode(code);
    }
}
