
	

	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;

	public class DataDriven {
		 String actualTitle;
		 String mailid="davidgnanaraj26795@gmail.com";
		 String password="rublynea@2";
		//private static   password = "davidgnanaraj26795@gmail.com";
		//private static   mailid = "rublynea@2";
		 WebDriver driver;

		//@BeforeTest
		public void initial() {
			//private static final String mailid = "davidgnanaraj26795@gmail.com";
			//private static final String password = "rublynea@2";
			System.setProperty("webdriver.chrome.driver","C:\\Users\\David.Easterraj\\Downloads\\My projects\\Workplace\\task1\\Lib\\chromedriver.exe");
			driver = new ChromeDriver();
			//String password=reader.getCellData("reader","password",2);   
	//String mailid=reader.getCellData("reader","mailid",2);
			System.out.println(mailid);
	        System.out.println(password);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.google.com/gmail/");

		    actualTitle=driver.getTitle();
		
		}

		//@Test
		public void titlecheck() {
			
			
				//driver.findElement(By.xpath("//input[@id='identifierId']")).clear();
				WebElement dr=driver.findElement(By.xpath("//input[@id='identifierId']"));
						dr.sendKeys(mailid);
				//driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
				//driver.findElement(By.xpath("//input[@name='password']")).clear();
				WebElement dr1=driver.findElement(By.xpath("//input[@name='password']"));
						dr1.sendKeys(password);
				driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
				Assert.assertEquals(actualTitle, "Gmail");
			}
		//@Test
		public void gmaillogocheck() {
			boolean flag=driver.findElement(By.xpath("//input[@id='qaEJec']")).isDisplayed();
			Assert.assertTrue(flag);
		}
		//@AfterMethod
		public void teardown() {
			driver.quit();
		}

	}

