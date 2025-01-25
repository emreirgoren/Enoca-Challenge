# Enoca-Challenge

1- SAP Commerce (Hybris) nedir? Hangi amaçlarla kullanılır? Kullandığı teknolojiler nelerdir? Kısaca açıklayınız.

- Hybris farklı işlevlerin tek bir çatı altında toplanmıs bir e-ticaret platformudur. Bu sayede farklı işlevlerin entegre edilmesi gerektiginde olusan maliyeti ve süreci azaltmak için kullanılır.

2- Birbirinden bağımsız iki platformun birbiriyle haberleşmesi nasıl sağlanabilir? Örneğin, X platformu Java ile yazılmış olsun, Y platform u C# ile. Bu iki platformun bir biri ile iletişim halinde request-response ilişkisi kurması gerekiyor. Bu yapıyı nasıl sağlarız? Bu iletişim sırasında güvenlik nasıl sağlanır?

- Api tabanlı iletişim protokolleri ile haberleşme sağlanır. GET,PUT,POST,DELETE. Platformlar bu iletişi saglarken json ve ya xml tabanlı dosya sistemi kullanarak koddan bağımsız bir şekilde iletişim kurabilir. İletişim sırasında güvenlik için jwtToken, authentication mekanizmaları kullanılabilir. Gateway oluşturularak sistem içinde hangi apilere ulaşabiliriz gibi kısıtlamalar getirebiliriz.

3- SOLR Nedir? Kullanım alanlarını araştırınız. Kurumsal bir projede kullanılabilecek iki farklı kullanım alanı örneği veriniz.

- Elasticsearch gibi bir arama platformudur. Büyük veri tabanlarında response time azaltmaya yönelik çalışır. Bu sayende veri tabanından istenilen veriye daha kısa sürede ulaşmamızı sağlar. Ornek olarak trendyol, n11 gibi sitelerde cok fazla ürün bulunduğu için ürün aramada kullanılabilir. Log mekanizmalarında oluşan loglardan spesifik bir log aramada kullanılabilir. Graylog, zipkin gibi log mekanizmalarında kullanılabilir.

4- Aşağıdaki algoritma için uygun çözümü üretin.
● Java'da 100 adet random sayıya sahip bir liste oluşturun.
● Daha sonra bu listenin bir kopyasını oluşturun.
● 0 ile 100 arasında rastgele bir sayı üretin.
● Kopya listedeki bu random sayının olduğu indisteski değeri silin.
● Şimdi elinizde iki adet liste var ve kopya listede orjinal listeye göre bir eleman eksik.
● Hangi elemanın eksik olduğunu bulan bir metot oluşturun.

<p align="center">
    <img src ="/screenshot/challenge4Screenshot.png">
</p>
