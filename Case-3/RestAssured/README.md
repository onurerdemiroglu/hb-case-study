# Hepsiburada - Test Otomasyonu [API]
 
- JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız. <br>
 ```Örnek url: http://generator.swagger.io``` 
- Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı, değilse başarısız olarak rapor edilmelidir.
  
 ## 👨🏿‍💻 Generates a client library
 
 ```java 
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
                    time(lessThan(3000L)).
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
```

 ## 👨🏿‍💻 Returns options for a client library
 
 ```java 
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
                    time(lessThan(3000L)).
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
```
