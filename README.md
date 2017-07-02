# XCUITest

Perfecto now supports automation for iOS devices based on the XCUITest framework integrated with the latest Appium 1.6 server software. This allows your Appium automation scripts to take advantage of the following benefits:
* XCUITest's enhanced performance.
* Automating new iOS functionality, like 3D Touch or Siri injection..
* Provide the latest function updates from Appium IosDriver classes.

With the introduction of iOS 10, Apple has deprecated its legacy UI Automation framework and instructed all developers to start using the XCUITest framework, introduced in iOS 9. Perfecto’s automation solution so far relied on the UI Automation framework for extracting the native object tree. Supporting the XCUITest framework based automation infrastructure helps users ensure support for future iOS versions which may no longer include UI Automation support.

## How to use the XCUITest-based infrastructure
To prepare your Perfecto Lab and automation scripts to use the XCUITest-based automation infrastructure, you need to perform a few simple procedures:
* Enable the XCUITest-based infrastructure on your Perfecto Lab.
* Add capabilities to your Appium scripts to use the XCUITest based automation infrastructure:
<br>`capabilities.setCapability("automationName", "XCUITest");`<br>
* Strengthen your XPath locators.
* Verify that your script does not use any deprecated commands or methods.

## samples
the samples in this repo shows how to start using XCUITest with Appium automation script and Quantum.

For more information please read our documentation: 
http://developers.perfectomobile.com/display/PD/XCUITest+based+iOS+automation+infrastructure#XCUITestbasediOSautomationinfrastructure-step1
