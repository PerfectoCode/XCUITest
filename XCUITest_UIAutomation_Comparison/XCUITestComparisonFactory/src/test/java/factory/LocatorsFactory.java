
package factory;

/**
 * @author Lee Shoham
 * @date Jul 27, 2017
 */
class LocatorsFactory {
	
	static Locators createInstance(String automationName) {
		
		if (automationName.toLowerCase().equals("xcuitest")) 
			return new RecipesCrossVersionLocators(); 
		if (automationName.toLowerCase().equals("appium"))
			return new RecipesAppiumLocators();
		
		return null;
		
	}
}
