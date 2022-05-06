package starter.orgprofilemanagement;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

import java.util.ArrayList;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
public class WalletAPI {
	private static final String ORG_PROFILE = "{\"document\":{\"type\":\"Legal Entity\",\"altName\":\"\",\"legalName\":\"SSI Boys Ltd.\",\"identifier\":[{\"id\":\"\",\"type\":\"\"}],\"registeredSite\":{\"address\":{\"city\":\"Ludwigsburg\",\"region\":\"Baden-Württemberg\",\"country\":\"Schland\",\"zipCode\":\"71636\",\"streetAddress\":\"Grönerstr. 15/1\"}}},\"isPublic\":true,\"label\":\"SSI Boys Ltd.\",\"type\":\"ORGANIZATIONAL_PROFILE_CREDENTIAL\"}";
	
    private static String LIST_WALLET_DOCUMENTS = "https://test-bpa.dev.ssi.bosch.tech/api/wallet/document";

    @Step("List wallet documents")
    public void listWalletDocuments() {
        SerenityRest
        .given().auth().preemptive().basic("admin", "changeme")
        .when()
        .get(LIST_WALLET_DOCUMENTS);
    }
    
    @Step("Create Org Profile")
    public void createOrgProfile() {
    	SerenityRest
        .given().auth().preemptive().basic("admin", "changeme")
        .when().body(ORG_PROFILE).contentType(ContentType.JSON)
        .post(LIST_WALLET_DOCUMENTS);
    }

    public void deleteWalletDocuments() {
    	Response r = RestAssured.given().auth().preemptive().basic("admin", "changeme")
        .when()
        .get(LIST_WALLET_DOCUMENTS);
    	ArrayList<String> ids = (ArrayList<String>) r.body().jsonPath().get("id");
    	if(ids != null && !ids.isEmpty() ) {
	    	for(String id : ids) {	
		    	RestAssured.given().auth().preemptive().basic("admin", "changeme")
		        .when()
		        .delete(LIST_WALLET_DOCUMENTS + "/" + id);
	    	}
    	}
    }
}
