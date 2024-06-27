import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class MainPage {
    WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public  void navigateToMainPAge(){
        driver.get("https://www.endava.com");
    }
    public void acceptCookieConsent() {
        try {
            WebElement acceptButton = driver.findElement(By.id("onetrust-accept-btn-handler"));
            acceptButton.click();
        } catch (NoSuchElementException e) {
            // Cookie consent button not found, continue
        }
    }
    public void navigateToInvestorsPage() {
        WebElement menuOpen = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[3]/span[1]/*[name()='svg'][1]"));
        menuOpen.click();
        WebElement investorsMenu = driver.findElement(By.xpath("//a[@class='accordion-header'][normalize-space()='Investors']"));
        investorsMenu.click();
    }
}
