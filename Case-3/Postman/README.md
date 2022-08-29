# Hepsiburada - Test Otomasyonu [API]
 
- JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız. <br>
 ```Örnek url: http://generator.swagger.io``` 
- Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı, değilse başarısız olarak rapor edilmelidir.

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
 
pm.test("Status code is 200", function () { 
  if (pm.response.code=="200") {      
    console.log("Test passed.")
  }else{
      console.log("Test failed. Actual Status Code: "+pm.response.code)
  }
  pm.response.to.have.status(200)   
}); 
```

![Generatesclientlibrary](https://user-images.githubusercontent.com/35347777/187151601-69a72184-00d9-42a3-a704-9627c2afb6bf.png)
 
 
## [GET] Returns options for a client library
  
#### Tests:
```javascript 
const response = pm.response; 
const actualResponse = response.json(); 
 
pm.test("Status code is 200", function () { 
  if (pm.response.code=="200") {      
    console.log("Test passed.")
  }else{
      console.log("Test failed. Actual Status Code: "+pm.response.code)
  }
  pm.response.to.have.status(200)   
}); 
```

![returnclientlibrary](https://user-images.githubusercontent.com/35347777/187151606-c89b7b09-bb2a-4c4f-8f0d-739cc648914c.png)
 
##  ![postman monitoring](https://user-images.githubusercontent.com/35347777/147594384-6d3a8248-fb31-450f-8f8c-e7a786057fcb.png) Postman Monitör

<details>
  <summary> <i>Monitörü görüntülemek için tıklayın.</i></summary>
   
![postman-monitor](https://user-images.githubusercontent.com/35347777/187251202-db14b71d-3a7c-4499-a164-ded1d3ac884b.png)

</details>

  
##  ![newmanreportermain5](https://user-images.githubusercontent.com/35347777/187075230-5281912b-d654-42ac-8ab1-5963658813f2.png) Newman Raporu

Daha detaylı incelemek için [**buraya**](https://onurerdemiroglu.com.tr/hb/case3/newman/GSwaggerDashboard.html) tıklayınız.

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>
  
 ![newmanswagger](https://user-images.githubusercontent.com/35347777/187150561-97a800fa-6eb4-4474-8c84-01e73df3a006.png)
