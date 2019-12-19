import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;
import java.sql.Driver;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

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

    @Test
    public void checkBoxTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        //WebElement checkBox = driver.findElement(By.xpath("/html/body/label[2]/input"));
        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkBox.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        checkBox.click();
        driver.quit();
    }

    @Test
    public void radioButtonTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        radioButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
        System.exit(0);
    }

    @Test
    public void testForBlablaaa() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement checkBox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        WebElement radioButton = driver.findElement(By.xpath("//input[@value='male']"));
        radioButton.click();

        driver.quit();
    }

    @Test
    public void hidden() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement hidden = driver.findElement(By.className("topSecret")); //nope
        System.out.println(hidden.getAttribute("value")); //nope
        System.out.println(hidden.getAttribute("textContent")); //good
        driver.quit();
    }

    @Test
    public void imageTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement image = driver.findElement(By.id("smileImage"));
        System.out.println(image.getAttribute("naturalHeight"));
        System.out.println(image.getSize().getHeight());
        driver.quit();

    }

    @Test
    public void isEditable() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement input = driver.findElement(By.name("fname"));
        if (input.isEnabled()) {
            System.out.println("is enabled");
            input.sendKeys("Helouu");
        } else {
            System.out.println("is disabled");
        }
        driver.quit();
    }

    @Test
    public void isCheckBoxChecked() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        if (checkbox.isSelected()) {
            System.out.println("isSelected");
            checkbox.click();
            System.out.println("checkbox unselected");
        } else {
            System.out.println("is not selected");
        }
        driver.quit();
    }

    @Test
    public void canSee(){
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement topSecretElement = driver.findElement(By.className("topSecret"));
        if (topSecretElement.isDisplayed()) {
            System.out.println("is displayed");
            System.out.println(topSecretElement.getText());
        } else {
            System.out.println("is not displayed");
            System.out.println(topSecretElement.getAttribute("textContent"));
        }
        driver.quit();
    }

    public boolean checkIfElementExist(By locator, WebDriver driver) {
        if (driver.findElements(locator).size() > 0) {
            System.out.println("Element exist on page");
            return true;
        }
        System.out.println("No element");
        return false;
    }

    public void checkIfElementExist(WebDriver driver, By locator) {
        try {
            driver.findElements(locator);
            System.out.println("element exist");
        } catch (NoSuchElementException nsee) {
            System.out.println("element does not exist");
        }
    }

    @Test
    public void doesItExist() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        checkIfElementExist(By.tagName("a"), driver);
        checkIfElementExist(By.tagName("ade"), driver);

        checkIfElementExist(driver, By.tagName("a"));
        checkIfElementExist(driver, By.tagName("jsdf"));

        driver.quit();
    }

    @Test
    public void switching() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        String currentWindowName = driver.getWindowHandle();

        WebElement newPageButton = driver.findElement(By.id("newPage"));
        newPageButton.click();

        switchToNewWindow(driver, currentWindowName);

        System.out.println("Title " + driver.getTitle());
        System.out.println("Current URL " + driver.getCurrentUrl());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    private void switchToNewWindow(WebDriver driver, String currentWindowName) {
        System.out.println("current window name " + currentWindowName);
        Set<String> windows = driver.getWindowHandles();
        System.out.println("count of windows " + windows.size());
        for (String window : windows) {
            if (!window.equals(currentWindowName)) {
                driver.switchTo().window(window);
            }
        }
    }
}
