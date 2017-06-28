package com.perfecto.samples;
import io.appium.java_client.ios.IOSDriver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.perfectomobile.selenium.util.EclipseConnector;


/**
 * For programming samples and updated templates refer to the Perfecto GitHub at: https://github.com/PerfectoCode
 */
public class PickerWheelSample {
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
            capabilities.setCapability("bundleId", "com.apple.mobilecal");
            capabilities.setCapability("browserName", "");
                        
            driver = new IOSDriver<WebElement>(new URL("https://" + host + "/nexperience/perfectomobile/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
		}
    }


    public static void main(String[] args) throws MalformedURLException, IOException {


        try {
              
            try{
                // sometimes the calendar application shows "what's new" view before it actually shows the calendar
            	driver.findElementByXPath("//*[@label=\"Continue\"]").click(); 
            	// in case of alert prompting to allow Calendar to access device's location
            	driver.findElementByXPath("//*[@label=\"Allow\"]").click();
            	
            }catch(Exception e){};
           
            driver.findElementByXPath("//*[@label=\"Add\"]").click();       
          
            driver.findElementByXPath("//*[@label=\"Starts\"]").click();
                   
            // locate the date picker wheel
            WebElement picker = driver.findElementByXPath("//XCUIElementTypePickerWheel[1]");
            picker.sendKeys("Jun 29");
            
            
            // locate the hours picker wheel
            picker = driver.findElementByXPath("//XCUIElementTypePickerWheel[2]");
            picker.sendKeys("11");
            
            // locate the minutes picker wheel
            picker = driver.findElementByXPath("//XCUIElementTypePickerWheel[3]");
            picker.sendKeys("10");
            
            // add the meeting to the calendar
            driver.findElementByXPath("//*[@label=\"Starts\"]").click();
            driver.findElementByXPath("//*[@value=\"Title\"]").sendKeys("meeting");         
            driver.findElementByXPath("//*[@label=\"Add\"]").click();   
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            driver.quit();
        }

        System.out.println("Run ended");
    }  
}
