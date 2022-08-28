# Hepsiburada - Test Otomasyon Projesi

Bu projede Hepsiburada tarafından verilen case oluşturulmuş olup senaryoların POM kullanılarak koşulması sağlanmıştır. 

Proje Özellikleri
--- 
- Java & Selenium frameworkü ile geliştirilmiştir. Mimaride POM(Page Object Model) kullanılmıştır.   
- Annotasyonlar ve assertionlar için JUnit kütüphanesi kullanılmıştır.
- Test sonuçlarının raporlanması adına Log4j kullanılmıştır. Adımlar logs klasöründeki log4j-application.log dosyasından adımlar izlenebilir.
- Testlerin monitoring edilebilmesi için allure report kullanılmıştır.
- Test'in fail olma durumuna karşın ekran görüntüsü kaydetmektedir. Allure report içerisinde hata adımı ve ekran görüntüsü gözlemlenebilir.
- WebDriverManager kullanılmıştır. Böylelikle her browser için farklı bir driver indirmemek ve aksini belirtmedikçe driverın son versiyonunu indirmesi için.
- ConfigReader ile resources klasörü altındaki app.properties dosyası üzerinden baseUrl, browser seçimleri yapılabilmektedir.
- JUnit kütüphanesinden Assume kullanılmıştır. (Değerlendirme sayısı 0 ise herhangi bir işlem yapmadan adımları atlaması için)

Task
---
- Kullanıcı hepsiburada.com sitesini ziyaret eder.
- Kullanıcı arama işlemi yapar (Örnek: "iphone" gibi popüler ve yorumu olan bir ürün)
- Kullanıcı arama sonucunda gelen ürün listesinden ürün seçer ve ürün detay sayfasına gider.
- Kullanıcı seçilen ürün için ürün detayda "Yorumlar" tabına gider.
- Kullanıcı gelen yorumlar içerisinde ilk yorumun “Evet” butonuna basar.
- Kullanıcı "Teşekkür Ederiz" yazısını görür.
- Kullanıcı eğer yorumlar tab’ında hiç yorum gelmiyorsa herhangi bir işlem yapmaz.

Notlar:
- Test yazılırken okunabilirlik, isimlendirmeler, kod tekrarı gibi standartlara dikkat edilmelidir.
- Testler herhangi bir platformda yazılabilir(Java-Selenium,Ruby-Capybara,Python-Robot Framework gibi)

## 👨🏿‍💻 Senaryo

```cucumber
Feature: Hepsiburada Case Study

  Background:
    Given navigate to website

  @positive
  Scenario Outline: Successful product comment approval
    Given I search for "<searchKeyword>"
    And   I click the search button
    And   I select a product from the search result and go to the detail page
    And   I go to the comments tab
    When  I click the yes button of the first comment
    Then  I should see 'Teşekkür Ederiz.' message

    Examples:
      | searchKeyword                              |
      | iPhone                                     |
      | Dünyamızı Koruyalım - Havayı Temiz Tutalım |
```

https://user-images.githubusercontent.com/35347777/187070665-32b0630b-862b-4ada-8d90-db0b828cbc27.mp4

## ![log4j](https://user-images.githubusercontent.com/35347777/187072045-4d157e04-a467-47cd-8b07-875b9b2b7887.png) Log4j 
 
<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>

![log4j](https://user-images.githubusercontent.com/35347777/187070839-81cbf7c6-765d-496c-be02-8d9d1de664ee.png)

</details>
  
## ![allure](https://user-images.githubusercontent.com/35347777/187071905-8bad55fd-b3e4-4154-8af9-b10d313c5dd5.png) Allure

 Allure raporunu detaylı incelemek için [**buraya**](https://onurerdemiroglu.com.tr/hb/case2/allure-reports/) tıklayınız.

<details>
  <summary> (<i>Raporu görüntülemek için tıklayın</i>)</summary>

![iPhoneAllure](https://user-images.githubusercontent.com/35347777/187071440-dfcfd115-3bce-4758-9e45-58f1835074a8.png)

![DunyamiziKoruyalimAllure](https://user-images.githubusercontent.com/35347777/187071438-a6b51f93-d52e-4c5d-a8e0-74509606308f.png)

</details>

