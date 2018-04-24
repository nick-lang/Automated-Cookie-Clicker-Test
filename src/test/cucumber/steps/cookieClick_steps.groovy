import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.*

import static cucumber.api.groovy.EN.*

this.metaClass.mixin(cucumber.api.groovy.Hooks)

//Must be shared variables. There might be a better way to do this?
WebDriver driver
Integer startingCookies

Before() {
    System.setProperty("webdriver.chrome.driver", "build/libs/chromedriver.exe")
    driver = new ChromeDriver()
    driver.manage().timeouts().implicitlyWait(2 as long, java.util.concurrent.TimeUnit.SECONDS)
    WebDriverWait wait = new WebDriverWait(driver, 10)
}

After() {
    driver.close()
}

Given(~/^I am on the Cookie Clicker website$/) { ->
    driver.get("http://orteil.dashnet.org/cookieclicker/")
}

When(~/^I click on the cookie$/) { ->
    //There are better ways to wait than use thread sleep
    startingCookies = getCookies(driver)
    //println(startingCookies)

    def bigCookie = driver.findElement(By.id("bigCookie"))
    bigCookie.click()
}

Then(~/^The number of cookies I have should increase$/) { ->
    Integer cookiesBaked = startingCookies

    wait.until(new ExpectedCondition<Boolean>() {
        Boolean equals(){
            return true
        }
        Boolean apply() {
            cookiesBaked = getCookies(driver)
            if (cookiesBaked > startingCookies)
                return true
            else
                return false
        }
    })

//    long startTime = System.currentTimeMillis()
//    while (cookiesBaked <= startingCookies && (System.currentTimeMillis() - startTime) < 10000) {
//        cookiesBaked = getCookies(driver)
//    }

    assert (cookiesBaked > startingCookies)
}

def getCookies(WebDriver driver) {
    driver.findElement(By.id("cookies")).getText().tokenize(" ")[0].toInteger()
}