import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Main {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.gecko.driver", "E:\\apps\\Programming\\Selenium\\geckodriver-v0.34.0-win32\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();


        driver.get("https://www.avito.ru/avito-care/eco-impact#login?next=authCallbackEcoImpact");
        WebElement loginForm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[1]/form/div/div[1]/label/div/div/input"));
        WebElement passwordForm = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[1]/form/div/label/div/div/input"));
        WebElement logIn = driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[1]/form/button"));
        loginForm.sendKeys("LOGIN");
        passwordForm.sendKeys("PASSWORD");
        logIn.click();

        WebElement counter1 = driver.findElement(By.xpath("//div[@class=\"desktop-impact-item-eeQO3\"][2]"));
        WebElement counter2 = driver.findElement(By.xpath("//div[@class=\"desktop-impact-item-eeQO3\"][4]"));
        WebElement counter3 = driver.findElement(By.xpath("//div[@class=\"desktop-impact-item-eeQO3\"][6]"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.invisibilityOf(logIn));
        wait.until(ExpectedConditions.visibilityOf(counter1));

        File result = counter1.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(result, new File("E:\\apps\\Programming\\IntelliJ IDEA Community\\IntelliJ IDEA Community Edition 2023.2.2\\IdeaProjects\\SeleniumWebTest\\output\\1.png"));
        result = counter2.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(result, new File("E:\\apps\\Programming\\IntelliJ IDEA Community\\IntelliJ IDEA Community Edition 2023.2.2\\IdeaProjects\\SeleniumWebTest\\output\\2.png"));
        result = counter3.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(result, new File("E:\\apps\\Programming\\IntelliJ IDEA Community\\IntelliJ IDEA Community Edition 2023.2.2\\IdeaProjects\\SeleniumWebTest\\output\\3.png"));


        driver.quit();
    }
}
