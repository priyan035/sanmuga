package testng_practice;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNg_Practice {
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	public void setProperty() {
		
		
		WebDriverManager.chromedriver().setup();
		
		
	}
	@BeforeTest
	public void browserLaunch() throws InterruptedException {
		
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		
	}
	@BeforeClass
	public  void urlLaunch() {
		driver.get("https://www.saucedemo.com/");
	
		
		
	}
	@BeforeMethod
      public void login() {
    	  
    	  
    	  driver.findElement(By.xpath("//input[@name='user-name']")).sendKeys("standard_user");
    	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("secret_sauce");
    	  driver.findElement(By.xpath("//input[@type='submit']")).click();
		

	}
	@Test()
	public void addtocart() {
		
            driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/button")).click();
            
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
		
	}
	@AfterMethod
	public void openMenu() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        Thread.sleep(3000);
	}
	@AfterClass
	public void logout() {
           
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		
	}
	@AfterTest
	public void deletequicks() {
		
		
		driver.manage().deleteAllCookies();

	}
	@AfterSuite
	public void quit() {
		
		driver.quit();
		System.out.println("Finish");
		

	}
	
	
	
	
	
	
	
	
	
	
	
	

}
