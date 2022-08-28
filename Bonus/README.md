# Bonus 

- [X]  `Hepsiburada masaüstü sitesinde ürün detay ve tüm yorumlar sayfasında, yorumu olan ürünlerde
"Sırala" dropdown’ı gelmektedir. Bunlar içerisinde "Varsayılan" ın nasıl çalıştığı ile ilgili analiz yapınız.`
---

Ürün detay sayfasına girip, değerlendirmeler sekmesindeki sırala dropdown'undaki değişimlere göre atılan sorgular aşağıdaki gibidir.

![analiz](https://user-images.githubusercontent.com/35347777/187095255-3d0a77cd-c9c5-4cca-907c-29cd138015cb.png)
 
<table>
<tr>
    <td>Varsayılan</td>
    <td>https://user-content-gw-hermes.hepsiburada.com/queryapi/v2/ApprovedUserContents?skuList=HBV00000YCR62,HBV00000YCR63,HBV00000YCR64,HBV00000YCR65&from=0&size=10</td>
</tr>
<tr>
    <td>Puana Göre Artan</td>
    <td>https://user-content-gw-hermes.hepsiburada.com/queryapi/v2/ApprovedUserContents?skuList=HBV00000YCR62,HBV00000YCR63,HBV00000YCR64,HBV00000YCR65&from=0&size=10&sortField=star&sortDirection=asc</td>
</tr>
<tr>
    <td>Puana Göre Azalan</td>
    <td>https://user-content-gw-hermes.hepsiburada.com/queryapi/v2/ApprovedUserContents?skuList=HBV00000YCR62,HBV00000YCR63,HBV00000YCR64,HBV00000YCR65&from=0&size=10&sortField=star&sortDirection=desc</td>
</tr>
<tr>
    <td>En Faydalı Değerlendirme</td>
    <td>https://user-content-gw-hermes.hepsiburada.com/queryapi/v2/ApprovedUserContents?skuList=HBV00000YCR62,HBV00000YCR63,HBV00000YCR64,HBV00000YCR65&from=0&size=10&sortField=clap</td>
</tr>
<tr>
    <td>En Yeni Değerlendirme</td>
    <td>https://user-content-gw-hermes.hepsiburada.com/queryapi/v2/ApprovedUserContents?skuList=HBV00000YCR62,HBV00000YCR63,HBV00000YCR64,HBV00000YCR65&from=0&size=10&sortField=createdAt</td>
</tr>
</table>
 
UI olarak gelen değerlendirmelere bakıldığında **`Varsayılan`** olarak gelen değerlendirmeler **`Puana göre azalan`** ile birebir aynı gelmektedir.

Bunu netleştirmek adına postman üzerinde api compare işlemi yapabiliriz;

https://user-images.githubusercontent.com/35347777/187095923-d73a44b6-9066-4c92-b3ae-bea73dca8756.mp4 

UI ve api response verileri göz önüne alındığında **`Varsayılan`**'ın **`Puana göre azalan`** ile birebir aynı mantıkta çalıştığı rahatlıkla söylenebilir.
