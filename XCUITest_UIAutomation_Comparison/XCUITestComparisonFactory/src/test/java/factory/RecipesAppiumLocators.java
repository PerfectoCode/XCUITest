
package factory;

import org.openqa.selenium.By;

/**
 * @author Lee Shoham
 * @date Jul 27, 2017
 */
public class RecipesAppiumLocators implements Locators {

	public By getAddBtnBy() {
		return By.xpath("//UIANavigationBar[1]/UIAButton[@name='Add']");
	}

	public By getSaveBtnBy() {
		return By.xpath("//UIANavigationBar//*[@label='Save']");
	}

	public By getRecipeNameInputBy() {
		return By.xpath("//UIATextField[1]");
	}

	public By getEditRecipeBtnBy() {
		return By.xpath("//UIANavigationBar//*[@label='Edit']");
	}

	public By getChooseCategoryBy() {
		return By.xpath("//UIAButton[@label='More Info']");
	}

	public By getDessertCategoryBy() {
		return By.xpath("//*[@label='Dessert']");
	}

	public By getDoneBtnBy() {
		return By.xpath("//*[@label='Done']");
	}

	public By getBackBy() {
		return By.xpath("//*[@label='Back']");
	}

	public By getAddedRecipeOnListBy() {
		return By.xpath("//*[@label='A New Recipe']");
	}

	public By getDeleteRecipeByPositionBy() {
		return By.xpath("(//*[contains(@label,'Delete')])[1]");
	}

	public By getDeleteBtnBy() {
		return By.xpath("//*[@label='Delete']");
	}

}
