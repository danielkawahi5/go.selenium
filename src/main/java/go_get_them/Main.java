package go_get_them;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main extends BaseDriver {

    public static String path = "D:\\IdeaProjects\\go.selenium\\src\\main\\resources\\chromeDriver\\chromedriver.exe";

    public static String driver = "webdriver.chrome.driver";
    public static WebDriver webDiver;
    public static String baseUrl = "http://www.google.com";

    public static void main(String[] args) {
        System.setProperty(driver, path);
        webDiver = new ChromeDriver();
        webDiver.get(baseUrl);

        System.out.println(webDiver.getTitle());
        System.out.println(webDiver.getCurrentUrl());

        webDiver.get("http://www.yahoo.com");
        webDiver.navigate().back();
        webDiver.close();
        System.exit(0);

    }
}
