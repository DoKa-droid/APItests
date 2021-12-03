import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class MainClass {

    @Test
    public void SubTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate-\\Documents\\ui_tests\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select prototype = new Select(driver.findElement(By.id("selectBuild")));
        prototype.selectByVisibleText("Prototype");
        prototype.selectByIndex(0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@name='number1']")).click();
        driver.findElement(By.xpath("//input[@name='number1']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@name='number2']")).click();
        driver.findElement(By.xpath("//input[@name='number2']")).sendKeys("3");
        Select act = new Select(driver.findElement(By.id("selectOperationDropdown")));
        act.selectByVisibleText("Add");
        act.selectByIndex(1);
        driver.findElement(By.id("calculateButton")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals("-1",
                driver.findElement(By.xpath("//input[@id='numberAnswerField']")).getAttribute("value"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    };

    @Test
    public void ConcatTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate-\\Documents\\ui_tests\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select prototype = new Select(driver.findElement(By.id("selectBuild")));
        prototype.selectByVisibleText("Prototype");
        prototype.selectByIndex(0);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@name='number1']")).click();
        driver.findElement(By.xpath("//input[@name='number1']")).sendKeys("gs");
        driver.findElement(By.xpath("//input[@name='number2']")).click();
        driver.findElement(By.xpath("//input[@name='number2']")).sendKeys("bu");
        Select act = new Select(driver.findElement(By.id("selectOperationDropdown")));
        act.selectByVisibleText("Add");
        act.selectByIndex(4);
        driver.findElement(By.id("calculateButton")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals("gsbu",
                driver.findElement(By.xpath("//input[@id='numberAnswerField']")).getAttribute("value"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    };

    @Test
    public void DiceTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kate-\\Documents\\ui_tests\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://testsheepnz.github.io/random-number.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Select build = new Select(driver.findElement(By.id("buildNumber")));
        build.selectByIndex(0);
        build.selectByValue("0");
        driver.findElement(By.xpath("//input[@id='rollDiceButton']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//input[@name='numberGuess']")).click();
        driver.findElement(By.xpath("//input[@name='numberGuess']")).sendKeys("string");
        driver.findElement(By.xpath("//input[@id='submitButton']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        Assert.assertEquals("string: Not a number!",
                driver.findElement(By.cssSelector("#feedbackLabel > font > b > i")).getText());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.quit();
    }
}
