package com.akakce.stepDefinitons;
import com.akakce.pages.*;

import io.cucumber.java.en.*;
import io.appium.java_client.android.AndroidDriver;

public class AkakceSteps {
    private AndroidDriver driver;
    private HomePage homePage;
    private SearchPage searchPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private BasePage basePage;

    public AkakceSteps() {
        this.driver = basePage.getDriver();
        this.homePage = new HomePage(driver);
        this.searchPage = new SearchPage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.basePage = new BasePage(driver);
    }

    @Given("Kullanıcı Akakçe mobil uygulamasına girer")
    public void kullanici_akakce_mobil_uygulamasina_girer() {
        System.out.println("Akakçe uygulaması açıldı.");
    }

    @When("Kullanıcı {string} seçeneğine tıklar")
    public void kullanici_secenege_tiklar(String secenek) {
        homePage.clickByText(secenek);
    }

    @When("Kullanıcı Üye olmadan devam et seçeneğine tıklar")
    public void kullanici_uye_olmadan_devam_et() {
        homePage.continueWithoutLogin();
    }

    @And("Kullanıcı {string} aramasını yapar")
    public void kullanici_aramasini_yapar(String urun) {
        searchPage.searchProduct(urun);
    }

    @And("Kullanıcı {string} alt kategorisini seçer")
    public void kullanici_alt_kategorisini_secer(String kategori) {
        searchPage.selectCategory(kategori);
    }

    @And("Kullanıcı {string} sıralama seçeneğini seçer")
    public void kullanici_siralama_seceni_secer(String siralama) {
        productPage.sortBy(siralama);
    }

    @And("Kullanıcı {int}. ürüne tıklar")
    public void kullanici_urune_tiklar(int urunSirasi) {
        productPage.selectProduct(urunSirasi);
    }

    @Then("Kullanıcı ürünü sepete ekler ve satıcıya gider")
    public void kullanici_urunu_sepete_ekler_ve_saticiya_gider() {
        cartPage.addToCart();
        cartPage.goToSeller();
    }
}
