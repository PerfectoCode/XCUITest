package com.perfecto.samples;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


/**
 * For programming samples and updated templates refer to the Perfecto GitHub at: https://github.com/PerfectoCode
 */
public class SimpleSafariSample {
    private static DesiredCapabilities capabilities;
    static IOSDriver<WebElement> driver;

    static {
        try {
            capabilities = new DesiredCapabilities();
            /* Change these settings according to your cloud*/
            String host = "MYCLOUD.perfectomobile.com";
            capabilities.setCapability("user", "USER");
            capabilities.setCapability("password", "PASS");

            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("platformVersion", "10.*");
	    capabilities.setCapability("browserName", "safari");
            driver = new IOSDriver<WebElement>(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws MalformedURLException, IOException {


        try {
            
        	driver.navigate().to("https://www.google.com");
		Thread.sleep(2000);
			
		WebElement search = driver.findElementByXPath("//*[@id=\"lst-ib\"]");
		search.sendKeys("Perfecto");
			
		driver.findElementByXPath("//*[@class=\"sbico\"]").click();
		Thread.sleep(2000);
			
		driver.findElementByXPath("//*[text()=\"Perfecto Mobile\"]").click();

			

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }

        System.out.println("Run ended");
    }

   
}
