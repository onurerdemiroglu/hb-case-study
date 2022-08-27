ApiIntegrationTest
 
-JSON API isteğinin sonucunun(http status) kontrolünü gerçekleştiren bir entegrasyon testi yazınız.
(Örnek url: http://generator.swagger.io)
-Tarafınızdan seçilecek birer tane GET ve POST endpointleri için Http status code 200 verirse başarılı, değilse başarısız olarak rapor edilmelidir.
 

Proje Özellikleri

Rest-Assured ile Java dilinde API entegrasyon otomasyonu projesidir.
Url: http://generator.swagger.io
Seçilen Endpoint: /api/gen/clients
Projedeki İstek metodları : POST ve GET
Assertion için JUnit kütüphanesi kullanılmakta.
Proje çıktı olarak Response status code ve response bilgilerini bastırmakta.
Response Status code 200 değilse başarısız olarak "Assertion Error" vermekte.