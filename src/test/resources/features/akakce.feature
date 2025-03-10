Feature: Akakçe Mobil Uygulamasında Laptop Satın Alma Testi

  Scenario: Kullanıcı "Laptop" aratır, filtreler ve en yüksek fiyatlı ürünü satın alır
    Given Kullanıcı Akakçe mobil uygulamasına girer
    When Kullanıcı "Üye olmadan devam et" seçeneğine tıklar
    And Kullanıcı "Laptop" aramasını yapar
    And Kullanıcı "Bilgisayar, Donanım" alt kategorisini seçer
    And Kullanıcı "En Yüksek Fiyat" sıralama seçeneğini seçer
    And Kullanıcı 10. ürüne tıklar
    Then Kullanıcı ürünü sepete ekler ve satıcıya gider
