# Monefy Automation
1. Test Scope
1.1 Test Prioritisation
1.2 Pros/Cons for automation
2. Quick Start Guide
2.1  Introduction
2.2  Pre-requisites
2.2.1 Java Setup
2.2.2 Maven Setup
2.2.3 Eclipse Setup
2.2.3.1 JRE Settings
2.2.4 TestNG Setup
2.3. Setup
3.Overview
4. List of Dependencies

## 1. Test Scope
The scope of this framework is to automate the tests for Monefy Android App. The scope would include automating tests on all screens of the App and accessing basic functionalities-
- Creating expenses
- Creating income
- Creating transfers
- Creating Account
- Updating expense, income, transfers
- Deleting expense, income, transfers

### 1.1 Test Prioritisation 
The test cases selected for automation are all high priority test cases that I believe should be automated to reduce manual effort. The medium and low priority test cases like interacting with various other elements in the app with different scenarios can be done after these as well
- Opening various screens : High
- Creating expenses : High
- Creating income : High
- Creating transfers : High
- Creating Account : High
- Updating expense, income, transfers : High
- Deleting expense, income, transfers : High
- Filter Menu : Medium
- Search : Low

### 1.2 Pros and Cons
Pros:
Once these cases are automated the QA team can focus on more complex real life scenarios which could break the app and find more functional defects. These could be used as a model to build a sanity or regression suite to ensure stability after each successive build.

Cons:
Automating some complex E2E scenarios might be tricky ad complex.

## 2. Quick Start Guide
### 2.1 Introduction
The purpose of this document is to provide steps required for setting up the framework

### 2.2 Pre-requisites
Following are the tools and their versions should be installed before setting up this automation framework:
| Tools | Version/Release |
| ------ | ------ |
| OS | WINDOWS 64-bit |
| JAVA | JDK 1.8 or later. 64-bit|
| Eclipse | Neon, Win-64-bit |
| Apache Maven | 3.6.3 |
| Appium | 1.21.0 |
| testNG | 6.9.9 |
| Selenium Version | 3.141.59|
|Android SDK Version | android-31 |

#### 2.2.1 Java Setup
a. Download JDK 1.8 from the below mentioned link: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html
b. Install the downloaded executable file.
c. Set Environment Variable JAVA_HOME
i. Consider your JDK installation folder is: C:\Program Files\Java\jdk1.8.0_05
ii. Go to Start Menu and Type Edit the system environment variables
iii. Click on Environment Variables
iv. Under System variables click on New
v. Enter the following values:
Variable name: JAVA_HOME
Variable value: <JDK_INSTALLATION _FOLDER>
vi. Click OK
vii. Under System variables select Path variable and click Edit
viii. At the end of Path variable value append %JAVA_HOME%\bin;
ix. Click OK
d. To check Java has been installed correctly, open command prompt and type â€œjava â€“versionâ€�.
#### 2.2.2 Maven Setup
Apache Maven is a software project management and comprehension tool. Based on the concept of a project object model (POM), Maven can manage a project's build, reporting and documentation from a central piece of information.
i. Download Apache Maven 3.3.9 from the below mentioned link: http://mirror.fibergrid.in/apache/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip
ii. Extract the downloaded package inside directory of your choice e.g. C:\apache-maven-3.3.9
iii. Set Environment Variable MAVEN_HOME
1. Go to Start Menu and Type Edit the system environment variables
2. Click on Environment variables
3. Under System variables click New
4. Enter the following values:
Variable name: MAVEN_HOME
Variable value: <APACHE_MAVEN _FOLDER>
5. Click OK
6. Under System variables select Path variable and click Edit
7. At the end of Path variable value append %MAVEN_HOME%\bin;
8. To check maven has been installed correctly, open command prompt and type â€œmvn â€“versionâ€�.

#### 2.2.3 Eclipse Setup
Eclipse is an integrated development environment (IDE) and is written mostly in JAVA. Its primary use is for developing Java applications. Eclipse can be downloaded from below mentioned link:
 http://www.eclipse.org/downloads/packages/release/neon/3
Extract eclipse at any folder you want in your system.
Note: There is no need to install eclipse, you just need to run eclipse.exe whenever you want to open and use eclipse.

##### 2.2.3.1 JRE Settings
1. Windows -> Preferences -> Java -> installed JRE
2. Click on Add button
3. Click on Standard VM and Click Next
4. Browse the directory of your Java Installation Folder and Select JDK folder
5. Click Finish
6. Make sure you check the Java Installation you just added (You must select JDK not JRE)
7. Click Ok

#### 2.2.4 TestNG Setup
1. Help -> Eclipse Marketplace
Write â€œtestngâ€� in find box
Install â€œTestNGâ€� for Eclipse.
Accept the License agreement and click on Finish.
2. To check TestNG has been installed correctly, open Eclipse marketplace again and search for â€œTestNGâ€�. Now it will be displayed as installed.


### Framework Setup
1. Download framework from GIT repository provided in the project's specifications.
2. Now, open Eclipse
3. Go to File -> Import -> Maven -> Existing Maven Project. Browse the downloaded project
4. Enter inside the Project Home Directory in Eclipse.
5. Now do maven clean install after right clicking on the Project root.
6. Message of Build Successful would display.
10. Click Finish

## 3. Overview
The project follows Page Object Model for automation. The structure of the project is as below along with the description :
+---.settings
+---logs							# Generated logs from test run
+---Reports
+---src
|   +---main
|   |   +---java
|   |   |   +---monefy_pageobjects	# Page Objects for different screens
|   |   |   \---monefy_utils		# Utility classes
|   |   \---resources				# MOnefy APP apk, Log4j.xml and configuration_properties
|   \---test
|       +---java					
|       |   \---monefy_tests		# Tests
|       \---resources				# TestData.xlsx
+---target
+---pom.xml							# Project POM
+---README.MD						
+---testng.xml						#TestNg Suite

Once the project is setup, tests can be run from testng file->Right Click->Run as TestnG Tests

Before running the tests please ensure
1. Appium server is running to do this :
	- Open command prompt
	- Type appium, enter
2. Create an android device in the Android Studio 
2. Android Emulator Device is up
	- Open comman promt
	- cd C:\Users\{user.dir}\AppData\Local\Android\Sdk\emulator e.g. [cd C:\Users\amaankhan\AppData\Local\Android\Sdk\emulator]
	- cd emulator -{devicename} e.g. [cd emulator -avd Pixel_5_API_30]
The reports, screenshots can be viewed in the path configured in src/main/resources/configuration.properties file
Default path is C:\monefy for reports and screenshots



## 4. List of Dependencies and Licenses
1. Appium 			| 7.0.0 | 
2. TestNg 			| 6.9.9 |
3. Extent Reports 	| 4.0.9 |
4. log4j 			| 2.14.1|
5. Selenium 		| 3.141.59 |
6. Guava 			| 21.0 |
7. Apache POI 		| 5.0.0 |