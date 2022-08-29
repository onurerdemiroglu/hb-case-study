package hbCase.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

public class Helper {

    public void verifyResponseKeyValues(String key, String val, Response r) {
        String keyValue = r.jsonPath().getString(key);
        Assert.assertEquals(keyValue, val);
    }

    public void verifyTrue(boolean val) {
        Assert.assertTrue(val);
    }

    public void verifyFalse(boolean val) {
        Assert.assertFalse(val);
    }

    public void verifyResponseStatusValue(Response response, int expectedCode) {
        Assert.assertEquals(response.getStatusCode(), expectedCode);
    }

    public void verifyNestedResponseKeyValues(String nestTedCompnent, String key, String val, Response r) {
        Map<String, String> nestedJSON = r.jsonPath().getMap(nestTedCompnent);
        String actual = String.valueOf(nestedJSON.get(key));
        Assert.assertEquals(actual, val);
    }

    public void verifyNestedArrayValueResponseKeyValues(String nestTedCompnent, String[] val, Response r) {
        ArrayList<Object> nestedArray = (ArrayList<Object>) r.jsonPath().getList(nestTedCompnent);

        String actual;

        for (int i = 0; i < nestedArray.size(); i++) {
            actual = (String) nestedArray.get(i);
            Assert.assertEquals(actual, val[i]);
        }
    }

    public void verifyNestedArrayMapResponseKeyValues(String nestTedCompnent, String key, String[] val, Response r) {
        ArrayList<Object> nestedArray = (ArrayList<Object>) r.jsonPath().getList(nestTedCompnent);

        String actual;
        for (int i = 0; i < nestedArray.size(); i++) {
            Map<String, String> map = (Map<String, String>) nestedArray.get(i);
            actual = String.valueOf(map.get(key));
            Assert.assertEquals(actual, val[i]);
        }
    }

    public RequestSpecification getRequestWithJSONHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/json");
        return r;
    }

    public RequestSpecification getRequestWithXMLHeaders() {
        RequestSpecification r = RestAssured.given();
        r.header("Content-Type", "application/xml");
        return r;
    }

    protected JSONObject createJSONPayload(Object pojo) {
        return new JSONObject((Map) pojo);
    }
    public static Response getRequest(String URI) {
        return given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                get(URI).
        then().
                extract().response();
    }

    public static Response postRequest(String URI, String requestBody) {
        return given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(requestBody).
        when().
                post(URI).
        then().
                extract().response();
    }

    public static Response deleteRequest(String URI, String token) {
        return given().
                headers("Authorization", "Bearer " + token).
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
        when().
                delete(URI).
        then().
                extract().response();
    }

}
