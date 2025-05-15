#### Working video demo of the framework located in root directory with name 'TubiTestWorkingDemo.mov'
# Repository Info

This repository has test automation framework for 'Tubi' App for an android device. It is designed using Java TestNG framework with Appium. Page object Model (POM) design pattern is followed.

## Folder Structure

src/main/java

   com.tubi.listeners/  --->  # Listener classes
   
   com.tubi.pages/ --->       # Page Object Models

com.tubi.resources/  --->  # Driverfactory class

src/test/java

com.tubi.tests/ --->       # Test classes

src/test/resources ---> # log4j.xml and testng.xml files

pom.xml     --->          # Maven dependencies

logs            --->      # Logs will be generated here once the test is run

test-output    ---> # Basic report and Extent report generated here once test is run


## Important Pointers
testNg.xml has parameters which needs to be configured as per your requirements.

Following parameter values needs to be configured in TestNG.xml file:

deviceName ----> Name of the testing device

udId ----> UdId of the testing device

platformVersion ----> Platform version of the testing device

appiumServerUrl ----> Appium Server url where the Appium server is running

### Please Run this framework as testNG Suite as the above parameters are required to run the test.

After running the test, extent report with name 'TubiAndroidTestsExtentReport.html' will be generated in test-output folder.

Logs will be generated in 'logs' folder with name 'AppiumLogs.log'
