import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvestorsPage {
    private WebDriver driver;

    public InvestorsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnEarningReleaseHTML() {
        String mainPage = driver.getWindowHandle();
        WebElement latestAnnouncement = driver.findElement(By.xpath("//*[@id=\"financial-results\"]/div/div[1]/div/div/div/div/div[2]/div[1]/div/div[1]/a/span[2]"));
        latestAnnouncement.click();
        // Switch to the new window handle
        for (String page : driver.getWindowHandles()) {
            if (!page.equals(mainPage)) {
                driver.switchTo().window(page);
                break;
            }
        }
    }

    public void clickOnAcceptAllCookies() {
        WebElement acceptCookies = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[2]"));
        acceptCookies.click();
    }
}

