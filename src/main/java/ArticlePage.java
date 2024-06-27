import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArticlePage {
    private WebDriver driver;

    public ArticlePage(WebDriver driver) {
        this.driver = driver;
    }

    public void validateTabelExist() {
        try {
            driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/main[1]/article[1]/div[4]/table[1]"));
        }catch(Exception e){
            System.out.println("Table does not exists");
        }
    }
    public int calculateTotalAssets(int startRow,int stopRow,String xpath) {
        List<WebElement> rows = driver.findElements(By.xpath(xpath));
        int total=0;
        for (int i=startRow; i < stopRow; i++) {
            WebElement row = rows.get(i);
            String rowText = row.getText().trim().replaceAll(",", "");
            if (!rowText.isEmpty() && rowText.matches("\\d+")) {
                total += Integer.parseInt(rowText);
            }
        }
        return total;
    }
}
