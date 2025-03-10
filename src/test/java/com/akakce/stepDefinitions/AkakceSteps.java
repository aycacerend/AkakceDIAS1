package com.akakce.stepDefinitions;

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

    // Constructor method
    public AkakceSteps() {
        // Assuming driver is initialized elsewhere, e.g., in a test setup class.
        //this.basePage = new BasePage(driver);
        this.homePage = new HomePage(driver);
        this.searchPage = new SearchPage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
    }

    // Step definition for opening the Akakçe app
    @Given("Kullanıcı Akakçe mobil uygulamasına girer")
    public void kullanici_akakce_mobil_uygulamasina_girer() {
        // For now, we're just printing a statement. In actual tests, you'd launch the app here.
        System.out.println("Akakçe uygulaması açıldı.");
    }

    // Step definition for clicking on a given option on the homepage
    @When("Kullanıcı {string} seçeneğine tıklar")
    public void kullanici_secenege_tiklar(String secenek) {
        homePage.clickByText(secenek); // HomePage method, clicks by text
    }

    // Step definition for continuing without logging in
    @When("Kullanıcı Üye olmadan devam et seçeneğine tıklar")
    public void kullanici_uye_olmadan_devam_et() {
        homePage.continueWithoutLogin(); // HomePage method, handles the continue without login functionality
    }

    // Step definition for searching for a product
    @And("Kullanıcı {string} aramasını yapar")
    public void kullanici_aramasini_yapar(String urun) {
        searchPage.searchProduct(urun); // SearchPage method, performs search
    }

    // Step definition for selecting a category
    @And("Kullanıcı {string} alt kategorisini seçer")
    public void kullanici_alt_kategorisini_secer(String kategori) {
        searchPage.selectCategory(kategori); // SearchPage method, selects the category
    }

    // Step definition for sorting by a specific option
    @And("Kullanıcı {string} sıralama seçeneğini seçer")
    public void kullanici_siralama_seceni_secer(String siralama) {
        productPage.sortBy(siralama); // ProductPage method, sorts products
    }

    // Step definition for selecting a specific product based on index
    @And("Kullanıcı {int}. ürüne tıklar")
    public void kullanici_urune_tiklar(int urunSirasi) {
        productPage.selectProduct(urunSirasi); // ProductPage method, selects the product by its index
    }

    // Step definition for adding the product to the cart and going to the seller
    @Then("Kullanıcı ürünü sepete ekler ve satıcıya gider")
    public void kullanici_urunu_sepete_ekler_ve_saticiya_gider() {
        cartPage.addToCart();  // CartPage method, adds product to cart
        cartPage.goToSeller(); // CartPage method, navigates to the seller page
    }
}
