import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By userEmailLocator = By.id("email");
    private By passwordLocator = By.id("password");
    private By rememberCheckLocator = By.name("remember");
    private By loggedInMessageLocator = By.className("panel-body");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
    }

    public void with(String userEmail, String password) {
        driver.findElement(userEmailLocator).sendKeys(userEmail);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(rememberCheckLocator).click();
        driver.findElement(rememberCheckLocator).submit();
    }

    public boolean isLoggedInMessageDisplayed() {
        String loggedInMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(loggedInMessageLocator)).getText();
        if (loggedInMessage.equals("You are logged in!")){
            return true;
        }
        return false;
    }


}
