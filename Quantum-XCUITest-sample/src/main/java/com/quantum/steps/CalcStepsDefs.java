/**
 * 
 */
package com.quantum.steps;

import com.qmetry.qaf.automation.step.QAFTestStepProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.StringUtil;
import com.quantum.utils.AppiumUtils;
import com.quantum.utils.ConfigurationUtils;
import com.quantum.utils.ConsoleUtils;
import com.quantum.utils.DeviceUtils;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.verifyText;

/**
 * @author chirag.jayswal
 *
 */
@QAFTestStepProvider
public class CalcStepsDefs {

	@When("test1")
	public void test1() {

		System.out.println(DeviceUtils.getQAFDriver().getPageSource());
		QAFWebElement elem = DeviceUtils.getQAFDriver().findElement("display");//.click();
		System.out.println("***************************"+elem.isDisplayed());
		//Thread.sleep(2000);
	}


}
