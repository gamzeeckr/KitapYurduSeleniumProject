package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.HomePage;
import com.kitapyurdu.page.LoginPage;
import com.kitapyurdu.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest(){
        HomePage homePage=new HomePage();
        LoginPage loginPage=new LoginPage();
        ProductPage productPage=new ProductPage();

        homePage.home();
        //login sayfasında login işlemi
        loginPage.login();
        //login sayfasında login kontrolü ve arama yapma
        loginPage.controlLoginAndSearch();
        //ürün sayfasında scroll
        productPage.scroll();
        //favorilerime ürün ekleme
        productPage.addProductToFavorites();
        //anasayfaya geçiş
        productPage.goToHome();
        //puan katoloğuna geçiş
        productPage.goToPointCatalog();
        //türk klasiklerine geçiş
        productPage.goToTurkishClassics();
        //hobi sayfasına geçiş
        productPage.goToHobby();
        //sepete ürün ekleme
        productPage.addProductToCart();
        //favorilerim sayfasına geçiş
        productPage.goToFavorite();
        //ürün sildirme
        productPage.deleteProduct();
        //sepetim sayfasına geçiş
        productPage.gotoCart();
        //sepetteki ürünün miktarını artırma
        productPage.increaseCountProduct();
        //ürün satın alma işlemlerinden adres ekleme
        productPage.buyTheProduct();
        //ürün satın alma işlemlerinden kart ekleme
        productPage.creditCard();
        //logout olma
        productPage.backToHomePageAndLogout();

    }



}
