import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class PhpTravels{
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webDriver.chrome.driver","C:\\Users\\webdrivers");
        WebDriver driver = new ChromeDriver();
        ChromeBrowser(driver);
    }
    public static void ChromeBrowser(WebDriver driver) throws InterruptedException
    {
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        String tilePage = driver.getTitle();
        System.out.println((tilePage));
        if(driver.findElement(By.xpath("//*[text()='PHPTRAVELS']")).getText().equals("PHPTRAVELS")) {
            System.out.println("PASS");// to check PHPTRAVELS is there
        }
        else
                System.out.println("FAIL");
            String previous = driver.getWindowHandle();
            driver.findElement(By.xpath("//nav[contains@class,'clearfix')]//a[text()='Login']")).click();
            Thread.sleep(6000);
            String n = driver.getTitle();
            System.out.println(n);
            driver.switchTo().window(previous);
            System.out.println(driver.getCurrentUrl());
            driver.findElement(By.xpath("//nav[contains@class,'clearfix')]//a[text()='Login']")).click();
            driver.navigate().back();
            driver.navigate().refresh();
            Thread.sleep(3000);
            driver.quit();
        }

    }
}

