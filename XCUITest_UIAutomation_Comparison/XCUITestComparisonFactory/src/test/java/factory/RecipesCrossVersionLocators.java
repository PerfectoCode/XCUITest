package factory;

import org.openqa.selenium.By;

/**
 * @author Lee Shoham
 * @date Jul 25, 2017
 */
public class RecipesCrossVersionLocators implements Locators {
	
	private final static By addBtn = By.xpath("//*[@label='Add']");
	private final static By recipeNameInput = By.xpath("//*[@value='Recipe Name']");
	private final static By saveBtn = By.xpath("//*[@label='Save']");
	private final static By editRecipeBtn = By.xpath("//*[@label='Edit']");
	private final static By chooseCategory = By.xpath("//*[@label='More Info']");
	private final static By dessertCategory = By.xpath("//*[@label='Dessert']");
	private final static By doneBtn = By.xpath("//*[@label='Done']");
	private final static By back = By.xpath("//*[@label='Back']");
	private final static By addedRecipeOnList = By.xpath("//*[@label='A New Recipe']");
	private final static By deleteRecipeByPosition = By.xpath("(//*[contains(@label,'Delete')])[1]");
	private final static By deleteBtn = By.xpath("//*[@label='Delete']");

	public By getAddBtnBy() {
		return addBtn;
	}


	public By getSaveBtnBy() {
		return saveBtn;
	}

	public By getRecipeNameInputBy() {
		return recipeNameInput;
	}


	public By getEditRecipeBtnBy() {
		return editRecipeBtn;
	}


	public By getChooseCategoryBy() {
		return chooseCategory;
	}


	public By getDessertCategoryBy() {
		return dessertCategory;
	}


	public By getDoneBtnBy() {
		return doneBtn;
	}

	public By getBackBy() {
		return back;
	}

	public By getAddedRecipeOnListBy() {
		return addedRecipeOnList;
	}


	public By getDeleteRecipeByPositionBy() {
		return deleteRecipeByPosition;
	}

	public By getDeleteBtnBy() {
		return deleteBtn;
	}

}
