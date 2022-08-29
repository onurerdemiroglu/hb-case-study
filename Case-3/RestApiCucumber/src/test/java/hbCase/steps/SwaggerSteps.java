package hbCase.steps;

import hbCase.utils.ConfigReader;
import hbCase.utils.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;

public class SwaggerSteps {
    String baseUrl = ConfigReader.get("baseUrl");
    Response response;

    @Given("I send post request for client library")
    public void PostRequestForCreatePost() {
        String requestUrl = String.format("%s/java", baseUrl);

        String requestBody = "{\n" +
                "  \"spec\": {},\n" +
                "  \"options\": {\n" +
                "    \"additionalProp1\": \"Hepsiburada\",\n" +
                "    \"additionalProp2\": \"Onur\",\n" +
                "    \"additionalProp3\": \"ERDEMIROGLU\"\n" +
                "  },\n" +
                "  \"swaggerUrl\": \"http://petstore.swagger.io/v2/swagger.json\",\n" +
                "  \"authorizationValue\": {\n" +
                "    \"value\": \"string\",\n" +
                "    \"type\": \"string\",\n" +
                "    \"keyName\": \"string\"\n" +
                "  },\n" +
                "  \"securityDefinition\": {\n" +
                "    \"type\": \"string\",\n" +
                "    \"description\": \"string\"\n" +
                "  }\n" +
                "}";

        response = Helper.postRequest(requestUrl,requestBody);
    }
    @Given("I send get request for a client library")
    public void getRequestForAClientLibrary() {
        String requestUrl = String.format("%s/java", baseUrl);

        response = Helper.getRequest(requestUrl);
    }

    @Then("I verify status code is 200")
    public void assertStatusCodeForOK() {
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            System.out.println("Test Passed. (Status Code: " + statusCode + ")");
        } else {
            System.out.println("Test Failed. (Status Code: " + statusCode + ")");
        }

        Assert.assertEquals(response.statusCode(), HttpStatus.SC_OK);
    }


}
