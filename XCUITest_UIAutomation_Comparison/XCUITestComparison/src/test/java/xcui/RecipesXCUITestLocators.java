package xcui;

import org.openqa.selenium.By;

/**
 * @author Lee Shoham
 * @date Jul 25, 2017
 */
public abstract class RecipesXCUITestLocators {
	
	public final static By addBtn = By.xpath("//XCUIElementTypeButton[@label='Add']");
	public final static By recipeNameInput = By.xpath("//XCUIElementTypeTextField[1]");
	public final static By saveBtn = By.xpath("//XCUIElementTypeButton[@label='Save']");
	public final static By editRecipeBtn = By.xpath("//XCUIElementTypeButton[@label='Edit']");
	public final static By chooseCategory = By.xpath("//XCUIElementTypeButton[@label='More Info']");
	public final static By dessertCategory = By.xpath("//XCUIElementTypeStaticText[@label='Dessert']");
	public final static By doneBtn = By.xpath("//XCUIElementTypeButton[@label='Done']");
	public final static By back = By.xpath("//*[@label='Back']");
	public final static By addedRecipeOnList = By.xpath("//*[@label='A New Recipe']");
	public final static By deleteRecipeByPosition = By.xpath("(//*[contains(@label,'Delete')])[1]");
	public final static By deleteBtn = By.xpath("//*[@label='Delete']");

}
