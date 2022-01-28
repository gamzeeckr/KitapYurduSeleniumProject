package com.kitapyurdu.page;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginPage extends BaseTest {

    Methods methods;
    Logger logger= LogManager.getLogger(LoginPage.class);

    public LoginPage(){

        methods=new Methods();
    }

    public void login(){

        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySecond(3);
        methods.sendKeys(By.id("login-email"),"gamze.cakir@testinium.com");
        methods.waitBySecond(5);
        methods.sendKeys(By.id("login-password"),"1q2w3e4r5t");
        methods.waitBySecond(5);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySecond(5);

        logger.info("Login sayfasında email ve password bilgileriyle üye girişi yapıldı.");


    }

    public void controlLoginAndSearch(){

        Assert.assertTrue(methods.isElementVisible(By.xpath("//a[@class='common-sprite']//b")));
        logger.info("Sayfaya login olunduğu kontrolü yapılır.");

        methods.sendKeys(By.id("search-input"),"oyuncak" + Keys.ENTER);
        logger.info("Arama kutusunda oyuncak ürünü aratılır.");

    }


}
