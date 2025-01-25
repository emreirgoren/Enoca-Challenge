# Enoca-Challenge

1- SAP Commerce (Hybris) nedir? Hangi amaçlarla kullanılır? Kullandığı teknolojiler nelerdir? Kısaca açıklayınız.

- Hybris farklı işlevlerin tek bir çatı altında toplanmıs bir e-ticaret platformudur. Bu sayede farklı işlevlerin entegre edilmesi gerektiginde olusan maliyeti ve süreci azaltmak için kullanılır.

2- Birbirinden bağımsız iki platformun birbiriyle haberleşmesi nasıl sağlanabilir? Örneğin, X platformu Java ile yazılmış olsun, Y platform u C# ile. Bu iki platformun bir biri ile iletişim halinde request-response ilişkisi kurması gerekiyor. Bu yapıyı nasıl sağlarız? Bu iletişim sırasında güvenlik nasıl sağlanır?

- Api tabanlı iletişim protokolleri ile haberleşme sağlanır. GET,PUT,POST,DELETE. Platformlar bu iletişi saglarken json ve ya xml tabanlı dosya sistemi kullanarak koddan bağımsız bir şekilde iletişim kurabilir. İletişim sırasında güvenlik için jwtToken, authentication mekanizmaları kullanılabilir. Gateway oluşturularak sistem içinde hangi apilere ulaşabiliriz gibi kısıtlamalar getirebiliriz.

3- SOLR Nedir? Kullanım alanlarını araştırınız. Kurumsal bir projede kullanılabilecek iki farklı kullanım alanı örneği veriniz.

- Elasticsearch gibi bir arama platformudur. Büyük veri tabanlarında response time azaltmaya yönelik çalışır. Bu sayende veri tabanından istenilen veriye daha kısa sürede ulaşmamızı sağlar. Ornek olarak trendyol, n11 gibi sitelerde cok fazla ürün bulunduğu için ürün aramada kullanılabilir. Log mekanizmalarında oluşan loglardan spesifik bir log aramada kullanılabilir. Graylog, zipkin gibi log mekanizmalarında kullanılabilir.

4- Aşağıdaki algoritma için uygun çözümü üretin.

- Java'da 100 adet random sayıya sahip bir liste oluşturun.

- Daha sonra bu listenin bir kopyasını oluşturun.

- 0 ile 100 arasında rastgele bir sayı üretin.

- Kopya listedeki bu random sayının olduğu indisteski değeri silin.

- Şimdi elinizde iki adet liste var ve kopya listede orjinal listeye göre bir eleman eksik.

- Hangi elemanın eksik olduğunu bulan bir metot oluşturun.

<p align="center">
    <img src ="/screenshot/challenge4Screenshot.png">
</p>


5- Product, Customer, Cart ve Order tablolarının ve bu tablolarının miras aldığı bir Base Entity'nin bulunduğu Spring Boot ile geliştirilmiş bir proje oluşturun.

Bir müşterinin bir sepeti (cart) ve birden fazla siparişi (order) olabilecek şekilde ilişkilendirme işlemini gerçekleştirin.

Sepetin ve siparişin toplam fiyat bilgisi her işlemde (sepete ekleme, çıkarma, miktar arttırıp azaltma) hesaplansın ve sepete kaydedilsin.

Bir müşteri sipariş geçtikten sonra, sipariş içerisindeki ürünlerin fiyatı daha sonradan güncellendiğinde müşteri satın aldığı anki fiyatı geçmişe yönelik olarak görebilsin.

Bunun için farklı bir tablo tutabilirsiniz. Bu tablo üzerinde ürün, fiyat, miktar gibi bilgiler tutulabilir.

Ürün üzerinde stok takibi yapılsın, bir ürünün stoğu bittikten sonra o üründen daha fazla sipariş verilemesin.

- Postman tarafında bulunan servisler [Postman Collection](https://github.com/emreirgoren/Enoca-Challenge/blob/main/enoca-challenge-5/Enoca.postman_collection.json) içerisinden inceleyebilirsiniz. Aynı zamanda [screenshot](https://github.com/emreirgoren/Enoca-Challenge/tree/main/screenshot) klasöründe apilere bakabilirsiniz.
