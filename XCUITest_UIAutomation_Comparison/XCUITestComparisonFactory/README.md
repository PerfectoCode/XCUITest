# XCUITest/UIAutomation comparison using factory

This example demonstrates one way of handling the different locators for XCUITest and UIAutomation frameworks. 
The project includes the following components:
* A test class, which instantiates a Locators object, where its type is determined during runtime using factory design pattern.
* A Locators interface that declares all the getter methods for the By objects.
* Two concrete classes that implement the Locators interface, each with the relevant set of xpaths (either XCUITest compatible or UIAutomation compatible).
* A LocatorsFactory class that will be used in the test to instantiate the relevant locators implementation class (either XCUITest or UIAutomation). 

In the testng.xml file, each test entry directs to the same test file, but specifies a different automationName parameter (XCUITest or UIAutomation) that will be used to get the right locators class from the factory.

For more information please read our documentation: 
http://developers.perfectomobile.com/display/TT/Migrating+iOS+test+scripts+to+XCUITest-based+automation+infrastructure
