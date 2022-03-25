
package Mini_Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MiniAssignmentScenarios {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\webdrivers");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //scenario 1
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(3000);
        By frames = By.xpath("//a[@href='/frames']");
        driver.findElement(frames).click();
        Thread.sleep(3000);
        By Nestedframes = By.xpath("//a[text()='Nested Frames']");
        driver.findElement(Nestedframes).click();
        Thread.sleep(3000);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement l = driver.findElement(By.cssSelector("body"));
        System.out.println(l.getText());

        //scenario 2
        driver.get("https://jqueryui.com/droppable/");
        WebElement frame = driver.findElement(By.xpath("//*[@id=\"content\"]/iframe"));
        driver.switchTo().frame(frame);
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));
        Actions action = new Actions(driver);
        action.dragAndDrop(drag, drop).perform();

        //scenario 3
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        By javascript = By.xpath("//a[@href='/javascript_alerts']");
        driver.findElement(javascript).click();
        Thread.sleep(2000);
        By jspromt = By.xpath("//button[@onclick='jsPrompt()']");
        driver.findElement(jspromt).click();
        System.out.println("Getting the text of the alert:");
        System.out.println(driver.switchTo().alert().getText());//driver.switchTo().alert().getText();
        System.out.println("Passing the keys to the alert:");
        driver.switchTo().alert().sendKeys("Test");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();
        String expected = "You entered: Test";
        if (expected.equals(result) == true) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        //Scenario4
        driver.get("https://www.goibibo.com/");
        driver.manage().window().maximize();
        By sel = By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/ul/li[2]/span[2]");
        driver.findElement(sel).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div/p")).click();
        WebElement from = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/div/input"));
        from.sendKeys("New York");
        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/ul/li[1]/div/div[1]/div/p[1]/span[1]")).click();
        from = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[2]/div/div[2]/div/input"));
        from.sendKeys("Seattle");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[@class='sc-bBHHxi cTvqKV' and contains(text(),'Seattle/Tacoma Intl-WA')]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[4]/div[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();
        driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div[2]/div[2]/div/div/div[2]/div[2]/div[3]/div[2]/div[6]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[4]/div[2]/div[3]/span[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[1]/div[5]/div[2]/div[3]/a[2]")).click();
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div[3]/span")).click();
    }
}


