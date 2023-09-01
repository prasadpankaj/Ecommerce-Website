import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ecommerceframework {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//String[] item = {"ADIDAS ORIGINAL"};
		driver.get("https://rahulshettyacademy.com/client/");
		driver.findElement(By.id("userEmail")).sendKeys("kohli@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Pk@180520");
		driver.findElement(By.id("login")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		List<WebElement> product = driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = product.stream().filter(a-> 
		a.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		//System.out.println(prod);
		prod.findElement(By.cssSelector("button[style='float: right;']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[routerlink='/dashboard/cart']")).click();
		Thread.sleep(2000);
		String cart=driver.findElement(By.cssSelector(".cartSection h3")).getText();
		System.out.println(cart);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		Thread.sleep(2000);
		
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.xpath("(//a)[2]")).click();
		Thread.sleep(2000);
		
	    System.out.println(driver.findElement(By.cssSelector("td[align='center'] h1")).getText());
		
		
		
		
		
		
	}

}
