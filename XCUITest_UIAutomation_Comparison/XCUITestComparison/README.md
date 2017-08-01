# XCUITest/UIAutomation comparison using separate folders 

This example demonstrates one way of handling the different locators for XCUITest and UIAutomation frameworks. 
The test includes 3 packages:
* uiautomation: a test class and an abstract locators class that contains static By objects, that include some xpaths that are compatible with UIAutomation framework **exclusively** and will fail on XCUITest framework (for example: //UIATextField[1]).
* xcuitest: a test class and an abstract locators class that contains static By objects, that include xpaths that are compatible with XCUITest framework **exclusively** and will fail on UIAutomation framework (for example: //XCUIElementTypeTextField[1]).
* xcuitest_uiautomation: a test class and an abstract locators class that contain static By objects, that includes xpaths that are compatible with **both** UIAutomation and XCUITest frameworks (for example: //*[@label='Add']).

The test class is the same test, only difference is the import of the relevant locators class. 

In the testng.xml file, each test entry directs to the relevant package.

For more information please read our documentation: 
http://developers.perfectomobile.com/display/TT/Migrating+iOS+test+scripts+to+XCUITest-based+automation+infrastructure
