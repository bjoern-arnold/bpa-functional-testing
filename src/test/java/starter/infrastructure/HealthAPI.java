package starter.infrastructure;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
public class HealthAPI {
	private static final String BPA_END_POINT_URL_PATTERN = "https://%s-bpa.dev.ssi.bosch.tech/health";
	private static final String ACAPY_END_POINT_URL_PATTERN = "https://%s-bpa-acapy.dev.ssi.bosch.tech";
	private static final String TAILS_END_POINT_URL_PATTERN = "https://%s.dev.ssi.bosch.tech/health";
	
    @Step("Check BPA health endpoint")
    public void checkBPAHealthEndpoint(String instanceName) {
        String endpointUrl = String.format(BPA_END_POINT_URL_PATTERN, instanceName);
        SerenityRest
        .when()
        .get(endpointUrl);
    }
    
    @Step("Check ACApy health endpoint")
    public void checkACApyHealthEndpoint(String instanceName) {
        String endpointUrl = String.format(ACAPY_END_POINT_URL_PATTERN, instanceName);
    	SerenityRest
        .when()
        .get(endpointUrl);
    }

    @Step("Check Tails health endpoint")
    public void checkTailsHealthEndpoint(String instanceName) {
        String endpointUrl = String.format(TAILS_END_POINT_URL_PATTERN, instanceName);
        SerenityRest
        .when()
        .get(endpointUrl);
    }
}
