package Tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;


public class GeneratorTests {
    String baseUrl = ConfigReader.get("baseUrl");

    @Test
    @Owner("Onur ERDEMIROGLU")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Get Client - Verify that Status code is 200")
    public void getClients() {
        String requestUrl = String.format("%s/java", baseUrl);

        Response response =
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                when().
                        get(requestUrl).
                then(). 
                        extract().
                        response();

        int statusCode = response.statusCode();

        if (statusCode == 200) {
            System.out.println("Test Passed. (Status Code: " + statusCode + ")");
        } else {
            System.out.println("Test Failed. (Status Code: " + statusCode + ")");
        }

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }

    @Test
    @Owner("Onur ERDEMIROGLU")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Post Client - Verify that Status code is 200")
    public void postClients() {
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

        Response response =
                given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        body(requestBody).
                when().
                        post(requestUrl).
                then(). 
                        extract().
                        response();

        int statusCode = response.statusCode();

        if (statusCode == 200) {
            System.out.println("Test Passed. (Status Code: " + statusCode + ")");
        } else {
            System.out.println("Test Failed. (Status Code: " + statusCode + ")");
        }

        Assert.assertEquals(statusCode, HttpStatus.SC_OK);
    }
}
