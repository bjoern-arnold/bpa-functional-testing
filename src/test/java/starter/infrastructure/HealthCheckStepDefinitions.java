package starter.infrastructure;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import starter.util.HttpStatusCode;

public class HealthCheckStepDefinitions {
	
    @Steps
    HealthAPI healthAPI;

    private String instanceName;

    @Given("instance name is {word}")
    public void getInstance(String instanceName) {
        this.instanceName = instanceName;
    	System.out.println("Instance " + instanceName);
    }

    @When("I open the BPA health end point")
    public void checkBPAHealthEndpoint() {
        healthAPI.checkBPAHealthEndpoint(this.instanceName);
    }

    @When("I open the ACApy health end point")
    public void checkACApyHealthEndpoint() {
        healthAPI.checkACApyHealthEndpoint(this.instanceName);
    }

    @When("I open the Tails health end point")
    public void checkTailsHealthEndpoint() {
        healthAPI.checkTailsHealthEndpoint(this.instanceName);
    }

    @Then("the status should be {string}")
    public void checkStatus(String status) {
    	restAssuredThat(response -> response.statusCode(HttpStatusCode.valueOf(status).getValue()));
    }
}
