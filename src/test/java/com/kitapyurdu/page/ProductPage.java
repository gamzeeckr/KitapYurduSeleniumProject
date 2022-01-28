package com.kitapyurdu.page;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.Random;

public class ProductPage extends BaseTest {

    Methods methods;
    Logger logger= LogManager.getLogger(ProductPage.class);

    public ProductPage(){

        methods=new Methods();
    }

    public void scroll(){

        logger.info("Sayfadaki 7. ürüne scroll edilir.");
        methods.waitBySecond(3);
        methods.scrollWithAction(By.xpath("//div[@class='product-cr'][7]"));
        methods.waitBySecond(3);

    }
/**
 * 7. ürüne scroll edildiği için 6 ve 9 arası ürünler favorilere ekletildi.
 */

    public void addProductToFavorites() {

        logger.info("Sayfadaki ürünler listeye atılır.");
        List<WebElement> productList  = driver.findElements(By.className("product-cr"));
        methods.waitBySecond(3);

        for (int i = 6; i < productList.size(); i++) {

            WebElement element = productList.get(i)
                    .findElement(By.className("grid_2"))
                    .findElement(By.className("hover-menu"))
                    .findElement(By.className("add-to-favorites"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element);

            methods.isElementVisible(By.id("//div[@role='alert']"));
            logger.info("Ürün favorilerime eklendi.");

            if (i == 9) {
                break;
            }

        }

        logger.info("4 ürün favorilerime ekletildi.");

    }


    public void goToHome(){
        methods.click(By.xpath("//div[@class='logo-text']"));
        methods.waitBySecond(5);

        logger.info("Anasayfaya gidildi.");
    }

    public void goToPointCatalog(){
        methods.click(By.xpath("//div[@class='lvl1catalog']"));
        methods.waitBySecond(5);

        logger.info("Puan katoloğuna gidildi.");
    }

    public void goToTurkishClassics(){

        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        logger.info("Türk klasikleri sayfasına gidildi.");
        methods.waitBySecond(5);

        methods.selectByText(By.xpath("//div[@class='sort']//select"),"Yüksek Oylama");
        logger.info("Ürünler 'Yüksek Oylamaya' göre filtrelendi.");
        methods.waitBySecond(5);
    }

    /**
     * Mause hover olan metotlarda test anında mause a dokunulduğunda attribute ü bulamadığı için fail oluyor
     **/
    public void goToHobby() {

        methods.mouseHolder(By.xpath("//div[@class='lvl2 js-bookCr']/ul/li/span[text()='Tüm Kitaplar']"));
        methods.waitBySecond(5);
        methods.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        methods.waitBySecond(5);

        logger.info("Tüm kitaplar>Hobi sayfasına gidildi.");
    }

    public void addProductToCart(){

        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='cover']"));
        Random rnd = new Random();
        int i = rnd.nextInt(productList.size());
        productList.get(i).click();
        methods.waitBySecond(3);
        methods.click(By.id("button-cart"));
        methods.waitBySecond(3);

        logger.info("Ürün seçimi yapıldı ve sepete eklendi.");

    }


    public void goToFavorite(){

        methods.mouseHolder(By.xpath("//div[@class='menu top my-list']//a[@class='common-sprite']"));
        methods.waitBySecond(3);
        methods.click(By.xpath("//div[@class='menu top my-list']//div//a[contains(text(),'Favorilerim')]"));
        methods.waitBySecond(3);

        logger.info("Listelerim>Favorilerim sayfasına gidildi.");
    }

    public void deleteProduct(){
        methods.mouseHolder(By.xpath("//div[@class='product-cr'][3]"));
        methods.waitBySecond(3);
        methods.click(By.xpath("//div[@class='product-cr'][3]//a[@data-title='Favorilerimden Sil']"));
        methods.waitBySecond(3);

        logger.info("Ürün silindi.");

    }

    public void gotoCart(){
        methods.click(By.xpath("//div[@class='heading']"));
        methods.waitBySecond(3);
        methods.click(By.id("js-cart"));
        methods.waitBySecond(3);

        logger.info("Sepetim sayfasına gidildi.");
    }

    public void increaseCountProduct(){
        WebElement element= methods.findElement(By.xpath("//input[@name='quantity']"));
        element.clear();
        methods.waitBySecond(3);
        methods.sendKeys(By.xpath("//input[@name='quantity']"),"2");
        methods.waitBySecond(3);

        logger.info("Ürün adeti artırıldı.");
    }

    public void buyTheProduct(){
        //satın al butonu
        methods.click(By.xpath("//div[@class='cart-info']//td[@class='to-wishlist']"));
        methods.waitBySecond(3);

        //yeni bir adres eklemek istiyorum seçeneği
        methods.click(By.xpath("//div[@id='shipping-tabs']//a[@href='#tab-shipping-new-adress']"));
        methods.waitBySecond(3);

        //kişisel bilgiler
        methods.sendKeys(By.id("address-firstname-companyname"),"Gamze");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("address-lastname-title"),"Çakır");
        methods.waitBySecond(3);
        methods.selectByText(By.id("address-country-id"),"Türkiye");
        methods.waitBySecond(3);
        methods.selectByText(By.id("address-zone-id"),"Kocaeli");
        methods.waitBySecond(3);
        methods.selectByText(By.id("address-county-id"),"GEBZE");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("district"),"BEYLİKBAĞI MAH");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("address-address-text"),"test cad. test sk. No:1");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("address-mobile-telephone"),"5555555555");
        methods.waitBySecond(3);

        logger.info("Ürün satın alma işlemlerinden yeni adres bilgileri girildi.");

        //devam butonu
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(3);
        //devam butonu
        methods.click(By.id("button-checkout-continue"));



    }

    public void creditCard(){
        methods.sendKeys(By.id("credit-card-owner"),"Gamze Çakır");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("credit_card_number_1"),"4111");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("credit_card_number_2"),"1111");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("credit_card_number_3"),"1111");
        methods.waitBySecond(3);
        methods.sendKeys(By.id("credit_card_number_4"),"1129");
        methods.waitBySecond(3);

        methods.selectByText(By.id("credit-card-expire-date-month"),"03");
        methods.waitBySecond(3);
        methods.selectByText(By.id("credit-card-expire-date-year"),"2027");
        methods.waitBySecond(3);

        methods.sendKeys(By.id("credit-card-security-code"),"555");
        methods.waitBySecond(3);

        methods.click(By.id("credit-card-is-3ds"));
        methods.waitBySecond(3);
        methods.click(By.id("creditCardRegister"));
        methods.waitBySecond(3);

        logger.info("Ürün satın alma işlemlerinden kredi kartı bilgileri girildi.");

        //devam et butonu
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySecond(3);

        //satış sözleşmesini kabul ediyorum checkboxı
        methods.click(By.xpath("//form[@id='terms-and-conditions-form']/div/input"));
        methods.waitBySecond(3);

        //siparişi onayla butonu
        methods.click(By.xpath("//input[@class='button']"));
        methods.waitBySecond(3);

        logger.info("Kart bilgileriniz doğrulanamadı, lütfen tekrar deneyiniz.");

    }

    public void backToHomePageAndLogout(){
        methods.click(By.xpath("//a[@class='checkout-logo']"));
        methods.waitBySecond(3);
        methods.mouseHolder(By.xpath("//a[@class='common-sprite']//b"));
        methods.waitBySecond(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/logout']"));
        methods.waitBySecond(3);

        logger.info("Logout olundu.");
    }

}
