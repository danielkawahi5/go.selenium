import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {

    WebDriver driver;
    private String path = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";
    private String chromeDriver = "webdriver.chrome.driver";
    private String baseUrl = "http://www.google.com";
    Dimension dimension;
    private String filesPath = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\files";

    @Test
    public void googleOpenTest() {
        System.setProperty(chromeDriver, path);
        dimension = new Dimension(900, 500);
        driver = new ChromeDriver();
        driver.manage().window().setSize(dimension);
        driver.get(baseUrl);

        driver.close();
        System.exit(0);
    }

}
