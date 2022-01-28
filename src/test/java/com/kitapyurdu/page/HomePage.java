package com.kitapyurdu.page;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends BaseTest {

    Methods methods;
    Logger logger= LogManager.getLogger(HomePage.class);

    public HomePage(){
        methods=new Methods();
    }

    public void home(){

        methods.waitBySecond(3);
        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySecond(3);

        logger.info("Anasayfaya girildikten sonra login işlemi yapıldı.");

    }

}
