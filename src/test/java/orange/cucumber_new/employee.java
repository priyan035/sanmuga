package orange.cucumber_new;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class employee {
	public static void main(String[] args) throws IOException, InterruptedException {
	  File f=new File("C:\\Users\\91960\\eclipse-workspace\\cucumber_new\\Dataa\\Book1.xlsx");	
	  FileInputStream fis = new FileInputStream(f);	
	  XSSFWorkbook wb = new XSSFWorkbook(fis);	
	  XSSFSheet sheet = wb.getSheetAt(0);	
	  int pcd = sheet.getLastRowNum()-sheet.getFirstRowNum();	
	  WebDriverManager.chromedriver().setup();	
	  ChromeDriver driver = new ChromeDriver();	
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(4000, TimeUnit.SECONDS);	
	  driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click(); 
	  driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a/span")).click();
	  Thread.sleep(3000);
	 
	 for (int i = 1; i < pcd+1; i++) {		 
		    XSSFRow row = sheet.getRow(i);
		    String first = row.getCell(0).getStringCellValue();		  
		    String second = row.getCell(1).getStringCellValue();		  
		    String third = row.getCell(2).getStringCellValue();		  
		    WebElement Emp = driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/header/div[2]/nav/ul/li[3]/a"));
		    Emp.click();		  
		    Thread.sleep(3000);
		    WebElement firstn = driver.findElement(By.xpath("//input[@name='firstName']"));
			firstn.sendKeys("first");
			Thread.sleep(3000);
			WebElement second1 = driver.findElement(By.xpath("//input[@name='middleName']"));
			second1.sendKeys("second");			
			WebElement last = driver.findElement(By.xpath("//input[@name='lastName']"));			
			last.sendKeys("third");
			WebElement save = driver.findElement(By.xpath("//button[@type='submit']"));
			save.click();
		    System.out.println(first+second+third);
	}
	 
	
	
	
	
}
}