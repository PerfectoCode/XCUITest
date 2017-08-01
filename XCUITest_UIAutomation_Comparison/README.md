# XCUITest/UIAutomation comparison 

In order to make your scripts suitable for XCUITest framework, it's possible some adjustments would have to be made in your locators. 
The extent of the changes would depend on the xpaths currently in use: xpaths that are built according to best practices, using unique elements' attributes (like id, name, etc.), would be compatible for both XCUITest and UIAutomation. However, xpaths the are using class names and objects types would probably need to be adjusted. 
In the situation where some xpaths need to be adjusted, the code examples here are examples of different approaches of handling that:
* If the application under test allows, convert all of the xpaths to be compliant with best practices, so they would work for both frameworks (for example: //*[@id='someId']).
* If not all locators can be converted, one option is to create separate folders for each framework.
* Another option is to create a dynamic mechanism that would fetch the relevant locators on runtime according to the automationName capability set. 

For more information please read our documentation: 
http://developers.perfectomobile.com/display/TT/Migrating+iOS+test+scripts+to+XCUITest-based+automation+infrastructure
