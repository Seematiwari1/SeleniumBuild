package Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Magento {

	@Test(priority=1)
	public void register() {
	    WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://Magento.com");
		
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("register")).click();
		driver.findElement(By.id("firstname")).sendKeys("Seema");
		driver.findElement(By.id("lastname")).sendKeys("Tiwari");
		driver.findElement(By.id("email_address")).sendKeys("test@gmail.com");
		driver.findElement(By.id("self_defined_company")).sendKeys("yes M system");
		
	Select cp=new Select (driver.findElement(By.id("company_type")));
//    cp.selectByIndex(2);
	cp.selectByValue("development");	
Select role=new Select (driver.findElement(By.id("individual_role")));	
	
		role.selectByValue("technical/developer");	
		
		Select country=new Select (driver.findElement(By.id("country")));
		country.selectByValue("US");	
		
	
		driver.findElement(By.id("password")).sendKeys("welcome@123");
		driver.findElement(By.id("password-confirmation")).sendKeys("welcome@123");
		
driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"recaptcha-f979c2ff515d921c34af9bd2aee8ef076b719d03\"]/div/div/iframe")));
		driver.findElement(By.className("recaptcha-checkbox-border")).click();
		driver.switchTo().defaultContent();
		
	if(!driver.findElement(By.id("agree_terms")).isSelected())
	{
		driver.findElement(By.id("agree_terms")).click();
	}
	
	driver.quit();
		}
	

	@Test(priority=2,enabled=false)
	public void Login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://Magento.com");
		driver.findElement(By.partialLinkText("Sign in")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("test@gmail.com");
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("pass")).sendKeys("welcome");
		driver.findElement(By.id("send2")).click();
		
		Thread.sleep(5000);
		String error = driver.findElement(By.xpath("//*[@id=\"//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")).getText();
		System.out.println(error);
		driver.close();
		driver.quit();
		
		
	}
	
	
	}
