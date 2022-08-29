# Hepsiburada - Test Otomasyonu [API]
 
- JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız. <br>
 ```Örnek url: http://generator.swagger.io``` 
- Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı, değilse başarısız olarak rapor edilmelidir.
  
 ## 👨🏿‍💻 Senaryo
 
 ```cucumber 
  Feature: Hepsiburada - Generator Swagger Integration Tests

  Scenario: Generates a client library
    Given I send post request for client library
    Then  I verify status code is 200

  Scenario: Returns options for a client library
    Given I send get request for a client library
    Then  I verify status code is 200
```

## ![allure](https://user-images.githubusercontent.com/35347777/187071905-8bad55fd-b3e4-4154-8af9-b10d313c5dd5.png) Allure

 Allure raporunu detaylı incelemek için [**buraya**](https://onurerdemiroglu.com.tr/hb/case3/RestApiCucumber/allure-report/) tıklayınız.

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>

![Generates a client library](https://user-images.githubusercontent.com/35347777/187076537-005bb16f-ac58-4ecb-803a-cfebf74e9d8d.png)

![Returns options for a client library](https://user-images.githubusercontent.com/35347777/187076538-c9a5bdc8-6bdf-4b19-913d-7f4cbc7f003d.png)

</details>
