import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TestOne {

    private String chromeDriverPath = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    private String chromeDriver = "webdriver.chrome.driver";
    private String baseUrl = "http://www.google.com";
    Dimension dimension = new Dimension(900, 500);
    private String filesPath = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\files\\Test.html";
    WebDriver driver;

    public void settingProperties() {
        System.setProperty(chromeDriver, chromeDriverPath);
    }

    @Test
    public void googleOpenTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        driver.get(filesPath);
        driver.findElement(By.id("newPage")).click();
        driver.quit();
    }

    @Test
    public void idTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(filesPath);
        WebElement firstNameElement = driver.findElement(By.id("fname"));
        driver.quit();
    }

    @Test
    public void nameTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(filesPath);
        WebElement clickMeButton = driver.findElement(By.id("clickOnMe"));
        WebElement clickMeButton2 = ((ChromeDriver) driver).findElementById("clickOnMe"); //bad practice
        driver.quit();

    }

    @Test
    public void textTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement w3SchoolLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        w3SchoolLink.click();
        driver.navigate().back();
        WebElement weird = driver.findElement(By.partialLinkText("Weird"));
        weird.click();
        driver.quit();
    }

    @Test
    public void byClassTest() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement topSecretParagraph = driver.findElement(By.className("topSecret"));
        driver.quit();
    }

    @Test
    public void ByHtmlTag() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement firsInput = driver.findElement(By.tagName("input"));
        WebElement firsInput1 = driver.findElement(By.tagName("a"));
        WebElement firsInput2 = driver.findElement(By.tagName("label"));
        driver.quit();
    }

    @Test
    public void cssSelector() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement clickOnMeCssButton = driver.findElement(By.cssSelector("#clickOnMe"));
        WebElement clickOnMeCssButton1 = driver.findElement(By.cssSelector("a"));
        WebElement clickOnMeCssButton2 = driver.findElement(By.cssSelector(".topSecret"));
        WebElement tdFirstChild = driver.findElement(By.cssSelector("td:first-child"));
    }

    @Test
    public void ebayTestCss() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get("http://ebay.com");
        driver.manage().window().maximize();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        driver.findElement(By.cssSelector("#gh-ac")).sendKeys("samsung");
        driver.findElement(By.cssSelector("#gh-btn")).click();
        javascriptExecutor.executeScript("window.scrollBy(0,900)");
        driver.quit();
    }

    @Test
    public void xPathSimpleSelectors() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);
        WebElement clickOnMeXpathButton = driver.findElement(By.xpath("/html/body/button"));
        WebElement clickOnMeXpathButton2 = driver.findElement(By.xpath("//button"));
        WebElement linksXpath = driver.findElement(By.xpath("//a"));
        WebElement topSecret = driver.findElement(By.xpath("//p[@class='topSecret']"));
        WebElement topSecret2 = driver.findElement(By.xpath("//*[@class='topSecret']"));
        WebElement linkText = driver.findElement(By.xpath("//a[text()='Visit W3Schools.com!']"));
        driver.quit();
    }

    @Test
    public void locating() {
        settingProperties();
        driver = new ChromeDriver();
        driver.get(filesPath);

        WebElement firstLink = driver.findElement(By.tagName("a"));

        List<WebElement> links = driver.findElements(By.tagName("a")); // nie rzuca wyjątku, lista jest pusta, test przechodzi
        if (links.size() > 0) {
            System.out.println("links exists whooooo " + links.size());
        } else {
            System.out.println("NOTHING");
        }
        driver.quit();
    }
}





























