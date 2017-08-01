package factory;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
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

import bsh.Capabilities;
import io.appium.java_client.ios.IOSDriver;
import utils.PerfectoLabUtils;

/**
 * @author Lee Shoham
 * @date Jul 25, 2016
 */

public class RecipesTest implements WebDriverProvider {

	private IOSDriver<WebElement> driver;
	protected ReportiumClient reportiumClient;
	private Throwable throwable = null;
	private Locators locs = null;

	@Test
	public void addAndDeleteRecipe() {

		reportiumClient.stepStart("Rotate device");
		if (driver.getCapabilities().getCapability("automationName").toString().equalsIgnoreCase("XCUITest")) {
			driver.rotate(ScreenOrientation.LANDSCAPE);
		} else {
			Map<String, Object> params1 = new HashMap<String, Object>();
			params1.put("state", "landscape");
			driver.executeScript("mobile:handset:rotate", params1);
		}

		reportiumClient.stepStart("Adding a new recipe");
		driver.findElement(locs.getAddBtnBy()).click();
		driver.findElement(locs.getRecipeNameInputBy()).sendKeys("A New Recipe");
		driver.findElement(locs.getSaveBtnBy()).click();

		reportiumClient.stepStart("Editing new recipe");
		driver.findElement(locs.getEditRecipeBtnBy()).click();
		driver.findElement(locs.getChooseCategoryBy()).click();
		driver.findElement(locs.getDessertCategoryBy()).click();
		driver.findElement(locs.getDoneBtnBy()).click();

		reportiumClient.stepStart("Navigating back to home page");
		driver.findElement(locs.getDoneBtnBy()).click();
		driver.findElement(locs.getBackBy()).click();

		reportiumClient.stepStart("Validate the new recipe was added");
		driver.findElement(locs.getAddedRecipeOnListBy()).isDisplayed();

		reportiumClient.stepStart("Delete the added recipe");
		driver.findElement(locs.getEditRecipeBtnBy()).click();
		driver.findElement(locs.getDeleteRecipeByPositionBy()).click();
		driver.findElement(locs.getDeleteBtnBy()).click();
		driver.findElement(locs.getDoneBtnBy()).click();

		reportiumClient.stepStart("Validate the recipe was deleted");
		try {
			driver.findElement(locs.getAddedRecipeOnListBy());
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
		capabilities.setCapability("autoInstrument", true);
		capabilities.setCapability("bundleId", "com.example.apple-samplecode.Recipes");
		capabilities.setCapability("automationName", automationName);

		PerfectoLabUtils.setExecutionIdCapability(capabilities, mcm);
		this.driver = new IOSDriver<WebElement>(new URL("https://" + mcm + "/nexperience/perfectomobile/wd/hub"),
				capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		this.locs = LocatorsFactory.createInstance(automationName);

		PerfectoExecutionContext perfectoExecutionContext = new PerfectoExecutionContext.PerfectoExecutionContextBuilder()
				.withProject(new Project("Project", "1.0")).withContextTags(context.getCurrentXmlTest().getName())
				.withWebDriver(driver).build();
		reportiumClient = new ReportiumClientFactory().createPerfectoReportiumClient(perfectoExecutionContext);
		reportiumClient.testStart(method.getName(), new TestContext());
		System.out.println(capabilities.getCapability("automationName"));
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
