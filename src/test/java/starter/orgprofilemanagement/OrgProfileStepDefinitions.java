package starter.orgprofilemanagement;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class OrgProfileStepDefinitions {
	
    @Steps
    WalletAPI walletAPI;

    @When("I list all wallet documents")
    public void listWalletDocuments() {
        walletAPI.listWalletDocuments();
    }

    @Then("I receive an empty list")
    public void iReceiveAnEmptyList() {
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(equalTo("[]")));
    }

    @Given("There does not exist a document of type {string} in the wallet")
    public void checkDocumentDoesNotExistsForType(String type) {
    	iReceiveAnEmptyList();
    }

    @When("I create a new organization profile")
    public void createOrgProfile() {
        walletAPI.createOrgProfile();
    }

    @Then("the profile information is stored in the wallet")
    public void checkOrgProfileStored() {
    	//System.out.println(SerenityRest.get().body().jsonPath().get("$[0].type").toString());
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body(not(equalTo("[]"))));
        restAssuredThat(response -> response.body("type", equalTo("ORGANIZATIONAL_PROFILE_CREDENTIAL")));
        restAssuredThat(response -> response.body("label", equalTo("SSI Boys Ltd.")));
    }
    
    @After
    public void tidyUp() {
    	walletAPI.deleteWalletDocuments();
    }
}
