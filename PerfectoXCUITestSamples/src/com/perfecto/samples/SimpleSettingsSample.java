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
public class SimpleSettingsSample {
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
            capabilities.setCapability("platformName", "IOS");
            capabilities.setCapability("platformVersion", "10.*");
            capabilities.setCapability("bundleId", "com.apple.Preferences");
            capabilities.setCapability("browserName", "");
            driver = new IOSDriver<WebElement>(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws MalformedURLException, IOException {


        try {
            
            System.out.println(driver.getPageSource());     
            
            driver.findElementByXPath("//*[contains(@label,\"General\")]").click();       
          
            driver.findElementByXPath("//*[contains(@label,\"About\")]").click();
                   
            WebElement version = driver.findElementByXPath("//*[contains(@label,\"Version\")]");
     
            System.out.println("*************************** Device version: "+version.getAttribute("value"));
             
   

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }

        System.out.println("Run ended");
    }

   
}
