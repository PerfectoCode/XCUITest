package xcui;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.perfecto.reportium.WebDriverProvider;
import com.perfecto.reportium.client.ReportiumClient;
import com.perfecto.reportium.client.ReportiumClientFactory;
import com.perfecto.reportium.model.PerfectoExecutionContext;
import com.perfecto.reportium.model.Project;
import com.perfecto.reportium.test.TestContext;
import com.perfecto.reportium.test.result.TestResultFactory;

import io.appium.java_client.ios.IOSDriver;
import utils.PerfectoLabUtils;

import static xcui.RecipesXCUITestLocators.*;

/**
 * @author Lee Shoham
 * @date Jul 25, 2016
 */

public class RecipesTest implements WebDriverProvider {

	private IOSDriver<WebElement> driver;
	protected ReportiumClient reportiumClient;
	private Throwable throwable = null;

	@Test
	public void addAndDeleteRecipe() {

		reportiumClient.stepStart("Rotate device");
		driver.rotate(ScreenOrientation.LANDSCAPE);

		reportiumClient.stepStart("Adding a new recipe");
		driver.findElement(addBtn).click();
		driver.findElement(recipeNameInput).sendKeys("A New Recipe");
		driver.findElement(saveBtn).click();

		reportiumClient.stepStart("Editing new recipe");
		driver.findElement(editRecipeBtn).click();
		driver.findElement(chooseCategory).click();
		driver.findElement(dessertCategory).click();
		driver.findElement(doneBtn).click();

		reportiumClient.stepStart("Navigating back to home page");
		driver.findElement(doneBtn).click();
		driver.findElement(back).click();

		reportiumClient.stepStart("Validate the new recipe was added");
		driver.findElement(addedRecipeOnList).isDisplayed();

		reportiumClient.stepStart("Delete the added recipe");
		driver.findElement(editRecipeBtn).click();
		driver.findElement(deleteRecipeByPosition).click();
		driver.findElement(deleteBtn).click();
		driver.findElement(doneBtn).click();

		reportiumClient.stepStart("Validate the recipe was deleted");
		try {
			driver.findElement(addedRecipeOnList);
			throwable = new Exception("Recipe was not deleted successfully");
		} catch (Exception e) {
		}

	}

	@Parameters({ "mcm", "mcmUser", "mcmPassword", "browserName", "platformName", "platformVersion", "automationName" })
	@BeforeMethod
	public void beforeMethod(String mcm, String mcmUser, String mcmPassword, String browserName, String platformName,
			String platformVersion, @Optional("Appium") String automationName, ITestContext context, Method method)
			throws IOException {
		System.out.println("Run started");

		DesiredCapabilities capabilities = new DesiredCapabilities(browserName, "", Platform.ANY);

		capabilities.setCapability("user", mcmUser);
		capabilities.setCapability("password", mcmPassword);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("app", "PRIVATE:applications/Recipes.ipa");
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("autoInstrument", true);
		capabilities.setCapability("bundleId", "com.example.apple-samplecode.Recipes");
		capabilities.setCapability("automationName", automationName);

		PerfectoLabUtils.setExecutionIdCapability(capabilities, mcm);
		this.driver = new IOSDriver<WebElement>(new URL("https://" + mcm + "/nexperience/perfectomobile/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
				.withProject(new Project("Project", "1.0")).withContextTags(context.getCurrentXmlTest().getName())
				.withWebDriver(driver).build();
		reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
		reportiumClient.testStart(method.getName(), new TestContext());
	}

	@AfterMethod
	public void afterMethod(ITestContext context, ITestResult testResult) {

		if (throwable != null || testResult.getThrowable() != null) {
			reportiumClient.testStop(TestResultFactory.createFailure("something went wrong", throwable));
			System.out.println("Report url = " + reportiumClient.getReportUrl());
		} else {
			reportiumClient.testStop(TestResultFactory.createSuccess());
			System.out.println("Report url = " + reportiumClient.getReportUrl());
		}

		try {

			// Close the browser
			driver.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		driver.quit();
		System.out.println("Run ended");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.perfecto.reportium.WebDriverProvider#getWebDriver()
	 */
	public WebDriver getWebDriver() {
		// TODO Auto-generated method stub
		return null;
	}

}
