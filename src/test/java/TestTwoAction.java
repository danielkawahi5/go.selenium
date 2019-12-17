import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TestTwoAction {

    private String chromeDriverPath = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    private String chromeDriver = "webdriver.chrome.driver";
    private String filesPath = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\files\\Test.html";
    WebDriver driver;

    public void settingProperties() {
        System.setProperty(chromeDriver, chromeDriverPath);
    }


    @Test
    public void click(){
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement clickOnButton = driver.findElement(By.id("clickOnMe"));
        clickOnButton.click();
        driver.quit();
    }

    @Test
    public void sendKeys() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement input = driver.findElement(By.id("fname"));
        input.sendKeys("John Wick is a pencil killer");
        input.clear();
        input.sendKeys("Whoop Whooop");
        driver.quit();
    }

    @Test
    public void alertHandling() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement click = driver.findElement(By.id("clickOnMe"));
        click.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //alert.dismiss();
        WebElement firstNameInput = driver.findElement(By.id("fname"));
        firstNameInput.sendKeys("Ep ep EP ep EEEEP eppp");
        driver.quit();
    }

    @Test
    public void selectTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        Select carSelect = new Select(driver.findElement(By.tagName("select")));
        //carSelect.selectByIndex(2);
        carSelect.selectByValue("audi");
        driver.quit();
    }

    @Test
    public void retrievingTextFromAnElement() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        //WebElement firstNameInput = driver.findElement(By.id("fname"));
        //firstNameInput.sendKeys("Daniel");
        //System.out.println("Keys " + firstNameInput.getText()); // does not work
        //System.out.println("Keys " + firstNameInput.getAttribute("value"));

        List<WebElement> labels = driver.findElements(By.tagName("label"));
        System.out.println("label is : " + labels.size());
        driver.quit();


    }

}
