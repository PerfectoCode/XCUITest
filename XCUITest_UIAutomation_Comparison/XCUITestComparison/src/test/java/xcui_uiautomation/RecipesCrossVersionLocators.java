package xcui_uiautomation;

import org.openqa.selenium.By;

/**
 * @author Lee Shoham
 * @date Jul 25, 2017
 */
public abstract class RecipesCrossVersionLocators {
	
	public final static By addBtn = By.xpath("//*[@label='Add']");
	public final static By recipeNameInput = By.xpath("//*[@value='Recipe Name']");
	public final static By saveBtn = By.xpath("//*[@label='Save']");
	public final static By editRecipeBtn = By.xpath("//*[@label='Edit']");
	public final static By chooseCategory = By.xpath("//*[@label='More Info']");
	public final static By dessertCategory = By.xpath("//*[@label='Dessert']");
	public final static By doneBtn = By.xpath("//*[@label='Done']");
	public final static By back = By.xpath("//*[@label='Back']");
	public final static By addedRecipeOnList = By.xpath("//*[@label='A New Recipe']");
	public final static By deleteRecipeByPosition = By.xpath("(//*[contains(@label,'Delete')])[1]");
	public final static By deleteBtn = By.xpath("//*[@label='Delete']");

}
