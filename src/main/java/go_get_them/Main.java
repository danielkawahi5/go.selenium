package go_get_them;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main extends BaseDriver {

    public static String path = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\executables\\drivers\\chromedriver.exe";

    public static String driver = "webdriver.chrome.driver";
    public static WebDriver webDriver;
    public static String baseUrl = "http://www.google.com";

    public static void main(String[] args) {
        System.setProperty(driver, path);
        webDriver = new ChromeDriver();
        webDriver.get(baseUrl);

        System.out.println(webDriver.getTitle());
        System.out.println(webDriver.getCurrentUrl());



        webDriver.get("https://www.guru99.com/xpath-selenium.html");
        webDriver.findElement(By.xpath("//span[contains(text(),'Home')]")).click();


        webDriver.close();
        System.exit(0);
    }
}
