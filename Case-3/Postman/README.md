<h1 align="center"> <b>Postman - Integration Test</b> </h1>

> 🔗  https://www.getpostman.com/collections/19567690717fc55f99a6

## [POST] Generates a client library 
 
#### Post Data:

```json
{
    "spec": {},
    "options": {
        "additionalProp1": "Hepsiburada",
        "additionalProp2": "Onur",
        "additionalProp3": "ERDEMIROGLU"
    },
    "swaggerUrl": "http://petstore.swagger.io/v2/swagger.json",
    "authorizationValue": {
        "value": "string",
        "type": "string",
        "keyName": "string" 
    },
    "securityDefinition": {
        "type": "string",
        "description": "string"
    }
}
```
#### Tests:
```javascript 
const response = pm.response;

const actualResponse = response.json();
var size = Object.keys(actualResponse).length;  
var responsLimit = 1000; 
var responseTime = response.responseTime;   

tests["Size control"] = size == 2;   
tests["Code type control"] = typeof(actualResponse.code) === "string";
tests["Link type control"] = typeof(actualResponse.link) === "string"; 
 
pm.test("Status code is 200", function () { 
  if (pm.response.code=="200") {      
    console.log("Test passed.")
  }else{
      console.log("Test failed. Actual Status Code: "+pm.response.code)
  }
  pm.response.to.have.status(200)   
}); 
 
pm.test("Status code name has string", () => {
  pm.expect(response.to.have.status("OK"));  
});

pm.test("Response control", function () {  
  pm.expect(pm.response.to.have.jsonBody('code'));
  pm.expect(pm.response.to.have.jsonBody('link'));  
  pm.expect(response.to.be.withBody);
  pm.expect(response.to.be.json);
});   

pm.test("Response should not be error", function () { 
    pm.expect(response.to.not.be.error); 
});  

pm.test("Check response time", () => {  
  if (responseTime > responsLimit) {       
    console.log("Response time was longer than " + responsLimit + " ms " + "(" + responseTime + " ms)" + " / Response Date: " + pm.response.headers.get("Date"));
  }
  pm.expect(responseTime).to.be.below(responsLimit); 
});
```

![Generatesclientlibrary](https://user-images.githubusercontent.com/35347777/187074647-ee2a0704-ea41-4306-a254-632a458b3e75.png)
 
 
## [GET] Returns options for a client library
  
#### Tests:
```javascript 
const response = pm.response;

const actualResponse = response.json();
var size = Object.keys(actualResponse).length;  
var responsLimit = 1000; 
var responseTime = response.responseTime;   
 
pm.test("Status code is 200", function () { 
  if (pm.response.code=="200") {      
    console.log("Test passed.")
  }else{
      console.log("Test failed. Actual Status Code: "+pm.response.code)
  }
  pm.response.to.have.status(200)   
}); 
 
pm.test("Status code name has string", () => {
  pm.expect(response.to.have.status("OK"));  
}); 

pm.test("Response should not be error", function () { 
    pm.expect(response.to.not.be.error); 
});  

pm.test("Check response time", () => {  
  if (responseTime > responsLimit) {       
    console.log("Response time was longer than " + responsLimit + " ms " + "(" + responseTime + " ms)" + " / Response Date: " + pm.response.headers.get("Date"));
  }
  pm.expect(responseTime).to.be.below(responsLimit); 
});
```

![returnclientlibrary](https://user-images.githubusercontent.com/35347777/187075431-e15f7b8f-8410-4f49-a9fe-efc6dc2fe5ce.png)
 
##  ![postman monitoring](https://user-images.githubusercontent.com/35347777/147594384-6d3a8248-fb31-450f-8f8c-e7a786057fcb.png) Postman Monitör

<details>
  <summary> <i>Monitörü görüntülemek için tıklayın (24 saatlik veri)</i></summary>
   
![Postman Monitor](https://user-images.githubusercontent.com/35347777/187074841-01cf6fb6-b9be-453c-b9bb-1b6b2e29a5d5.png)

</details>

  
##  ![newmanreportermain5](https://user-images.githubusercontent.com/35347777/187075230-5281912b-d654-42ac-8ab1-5963658813f2.png) Newman Raporu

Daha detaylı incelemek için [**buraya**](https://onurerdemiroglu.com.tr/hb/case3/newman/GSwaggerDashboard.html) tıklayınız.

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>
  
 ![newmanswagger](https://user-images.githubusercontent.com/35347777/187075114-49199b62-dd09-4ca2-9a32-beb6ca9afc79.png)

 
