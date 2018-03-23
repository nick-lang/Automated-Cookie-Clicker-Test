import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver

import static cucumber.api.groovy.EN.*

//This could should be placed in a before hook
System.setProperty("webdriver.chrome.driver","build/libs/chromedriver.exe")
WebDriver driver = new ChromeDriver()

Integer startingCookies



Given(~/^I am on the Cookie Clicker website$/) { ->
    driver.get("http://orteil.dashnet.org/cookieclicker/")
}

When(~/^I click on the cookie$/) { ->
    //There are better ways to wait than use thread sleep
    Thread.sleep(2000)
    startingCookies = driver.findElement(By.id("cookies")).getText().tokenize(" ")[0].toInteger()
    //println(startingCookies)

    def bigCookie = driver.findElement(By.id("bigCookie"))
    bigCookie.click()
}

Then(~/^The number of cookies I have should increase$/) { ->
    Thread.sleep(2000)
    Integer cookiesBaked = driver.findElement(By.id("cookies")).getText().tokenize(" ")[0].toInteger()
    //println(cookiesBaked)

    assert(cookiesBaked > startingCookies)
}

