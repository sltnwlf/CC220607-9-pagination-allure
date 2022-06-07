import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PaginationPage {

    WebDriver driver;
    private final String url = "https://demo.seleniumeasy.com/table-pagination-demo.html";
    private final By nextLink = By.xpath("//*[@id=\"myPager\"]/li[5]/a");
    private final By visibleTableRow = By.xpath("//*[@style=\"display: table-row;\"]");

    public PaginationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate() {
        driver.navigate().to(url);
    }

    public int numberOfRows() {
        int num = 0;

        List<WebElement> rows = driver.findElements(visibleTableRow);
        num = rows.size();

        return num;
    }

    public boolean isLastPage() {
        String attr = driver.findElement(nextLink).getAttribute("style");
        return attr.equals("display: none;");
    }

    public void clickNext() {
        if (!isLastPage()) {
            driver.findElement(nextLink).click();
        }
    }

}
