import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class BalanceSheetTest {
    private WebDriver driver;
    private MainPage mainPage;
    private InvestorsPage investorsPage;
    private ArticlePage articlePage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        mainPage = new MainPage(driver);
        investorsPage = new InvestorsPage(driver);
        articlePage=new ArticlePage(driver);
    }
    @AfterEach
    public void close(){
        driver.quit();
    }

    @Test
    public void testTotalAssetsNonCurrent_December31_23(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalNonCurrentAsset = articlePage.calculateTotalAssets(4,11,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[2]");
        System.out.println("Final total  Assets-Non-Current December31 2023:"+ totalNonCurrentAsset);
        assertEquals(423140, totalNonCurrentAsset);
    }
    @Test
    public void testTotalAssetsCurrent_December31_23(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalCurrentAssest = articlePage.calculateTotalAssets(13,17,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[2]");
        System.out.println("Final total  Assets-Current December31 2023:"+ totalCurrentAssest);
        assertEquals(371433, totalCurrentAssest);
    }
    @Test
    public void testTotalAssetsNonCurrent_June30(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalNonCurrentAssest = articlePage.calculateTotalAssets(4,11,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[4]");
        System.out.println("Final total Assets-Non-Current June30 2023:"+ totalNonCurrentAssest);
        assertEquals(423456, totalNonCurrentAssest);
    }
    @Test
    public void testTotalAssetsCurrent_June30(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalCurrentAssest = articlePage.calculateTotalAssets(13,17,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[4]");
        System.out.println("Final total  Assets-Current June30 2023:"+ totalCurrentAssest);
        assertEquals(346667, totalCurrentAssest);
    }
    @Test
    public void testTotalAssestsNonCurrent_December31_22(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalNonCurrentAssest = articlePage.calculateTotalAssets(0,6,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[6]");
        System.out.println("Final total  Assets-Non-Current December31 2022 :"+ totalNonCurrentAssest);
        assertEquals(346484, totalNonCurrentAssest);
    }
    @Test
    public void testTotalAssetsCurrent_December31_22(){
        mainPage.navigateToMainPAge();
        mainPage.acceptCookieConsent();
        mainPage.navigateToInvestorsPage();
        investorsPage.clickOnEarningReleaseHTML();
        investorsPage.clickOnAcceptAllCookies();
        articlePage.validateTabelExist();
        int totalCurrentAssest = articlePage.calculateTotalAssets(7,11,"//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]/tbody[1]/tr/td[6]");
        System.out.println("Final total  Assets-Current December31 2022:"+ totalCurrentAssest);
        assertEquals(361642, totalCurrentAssest);
    }

}