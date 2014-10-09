

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;


import junit.framework.TestCase;


public class Test extends TestCase {

	public static WebDriver driver;
	  private String baseUrl;
	
	  public void setUp() throws Exception 
	  {
		  
	   driver = new FirefoxDriver();
	   baseUrl="https://s3.amazonaws.com/cadstechstore/Insurance_Claim_Project/Insurance_Claim_Form_Demo/WebContent/indexu.html";  
	    //baseUrl = "file:///C:/Users/test/Desktop/New%20folder/index.html";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	  }

	  
	@org.junit.Test

	public void test() throws InterruptedException {
		
		   driver.get(baseUrl);
		   new Select(driver.findElement(By.id("ClaimSubmit"))).selectByVisibleText("Witness");
		   driver.findElement(By.id("Policy Number")).clear();
		   driver.findElement(By.id("Policy Number")).sendKeys("1234567A02");
		   driver.findElement(By.id("Fname")).clear()	;
		   driver.findElement(By.id("Fname")).sendKeys("JHON");
		   driver.findElement(By.id("Lname")).clear();
		   driver.findElement(By.id("Lname")).sendKeys("DAVID");
		   driver.findElement(By.id("Aptnumber")).clear();
		   driver.findElement(By.id("Aptnumber")).sendKeys("1400 Pennsylvania Ave");
		   driver.findElement(By.id("City")).clear();
		   driver.findElement(By.id("City")).sendKeys("Olympia");
		   new Select(driver.findElement(By.id("State"))).selectByVisibleText("Washington");
		   driver.findElement(By.id("Zipcode")).clear();
		   driver.findElement(By.id("Zipcode")).sendKeys("9801");
		   driver.findElement(By.id("Email")).clear();
		   driver.findElement(By.id("Email")).sendKeys("Jhon1.David@gmail.com");
		   driver.findElement(By.id("CEmail")).clear();
		   driver.findElement(By.id("CEmail")).sendKeys("Jhon1.David@gmail.com");
		   driver.findElement(By.id("Y")).click(); 
		   driver.findElement(By.cssSelector("input[type=\"checkbox\"]")).click();
		   driver.findElement(By.id("H")).click();
		   driver.findElement(By.id("Hp")).clear();
		   driver.findElement(By.id("Hp")).sendKeys("(800) 782-8332");
		   driver.findElement(By.id("Wp")).clear();
		   driver.findElement(By.id("Wp")).sendKeys("(877) 627-5757");
		   driver.findElement(By.id("Cp")).clear();
		   driver.findElement(By.id("Cp")).sendKeys("1-360-350-5361");
		   driver.findElement(By.id("Ap")).clear();
		   driver.findElement(By.id("Ap")).sendKeys("1-360-515-7172");
		   driver.findElement(By.id("datepicker")).click();
		   driver.findElement(By.linkText("6")).click();
		   new Select(driver.findElement(By.id("Ltime"))).selectByVisibleText("01:00");
		   driver.findElement(By.id("Ldesc")).clear();
		   driver.findElement(By.id("Ldesc")).sendKeys("I was rear ended in the parking lot");
		   driver.findElement(By.name("Laddress")).clear();
		   driver.findElement(By.name("Laddress")).sendKeys("Washington");
		   driver.findElement(By.name("Lcity")).clear();
		   driver.findElement(By.name("Lcity")).sendKeys("Olympia");
		   new Select(driver.findElement(By.id("LState"))).selectByVisibleText("Washington");
		   driver.findElement(By.name("Lzipcode")).clear();
		   driver.findElement(By.name("Lzipcode")).sendKeys("98001");
		   new Select(driver.findElement(By.id("LCountry"))).selectByVisibleText("USA");
		   Thread.sleep(2000);
		   driver.findElement(By.id("submit")).submit();
		//   driver.findElement(By.xpath("//button[@onclick='validateform()']")).click();
		   Thread.sleep(2000);
		  // System.out.println(driver.findElement(By.id("error")).getText().toString());
		  assertTrue("sucess", isAlertPresent());
	}
	private boolean isAlertPresent() 
	   {
	    
	      try 
	      {
	         
	         Alert alert=driver.switchTo().alert();
	         String almsg=alert.getText();
	         alert.accept();
	         System.out.println(almsg);
	          return true;
	   
	       } 
	      catch (NoAlertPresentException e) 
	      {
	    	  System.out.println(driver.findElement(By.id("error")).getText().toString());
	         return false;
	   
	      }
	  
	   }

	  
	@AfterClass
	  
	  public void tearDown() throws Exception 
	  {
	    driver.quit();
	  }

}
