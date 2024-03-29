**Technologies:**
*   [Java](https://www.java.com/ru/) - programming language;
*   [Selenide](https://selenide.org/) - framework, based on Selenium WebDriver for working with browser;
*   [Gradle](https://gradle.org/) - build tool;
*   [jUnit5](https://junit.org/junit5/)- testing framework;
*   [Allure](http://allure.qatools.ru/) -  test report;

**!!!Important!!! - for running test from IDE need enabled annotation processing
 (Preferences -> Build, Execution, Deployment -> Compiler -> Annotation Processor -> Enable annotation processing)**

**Run tests:**
    
Gradle launch command should consist of several parts:
*   Gradle build and run local test - ```./gradlew clean test```
*   Select local browser (optional) - ```-Dbrowser=firefox``` Chrome is used by default
*   Parallel test count - ```-Dthread.count=2``` 1 is used by default

**Test report:**
*   ```./gradlew allureReport``` - generate Allure report (need run command for init allure)
*   ```./gradlew allureServe``` - generate Allure report and opens it in the default browser


