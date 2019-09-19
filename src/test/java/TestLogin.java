import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestLogin {
    WebDriver driver;
    LoginPage loginPage;

    @Before
    public void setUp() {
        this.driver = new ChromeDriver();
        this.loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        driver.get("http://blazedemo.com/login");
    }

    @Test
    public void Test() {
        loginPage.with("ranm@yopmail.com", "123456");
        assertTrue("Log in message not displayed", loginPage.isLoggedInMessageDisplayed());
    }

    @After
    public void tearUp() {
        driver.quit();
    }
}
