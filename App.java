package atmecs.com.atmecs.flightBooking;

import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class App {

	WebDriver driver;


	@BeforeTest
	public void browserInit() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\David.Easterraj\\Downloads\\My projects\\Workplace\\task1\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();

	
		driver.get("https://www.makemytrip.com/flights/");
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

	}

	@Test
	public void ticket() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		ReadExcel read = new ReadExcel(
				"C:\\Users\\David.Easterraj\\Downloads\\My projects\\Eclipse versions\\eclipse\\com.atmecs.flightBooking\\resources\\testdata\\TestData.xlsx");
		

		driver.findElement(By.xpath(("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser ']"))).click();

		WebElement email = driver.findElement(By.xpath(("//input[@id='username']")));
		email.click();
		String email1=read.getData(0, 0, 2);
		email.sendKeys(email1);

		WebElement password = driver.findElement(By.xpath(("//input[@id='password']")));
		password.click();
		String password1=read.getData(0,0,3);
		password.sendKeys(password1);

		driver.findElement(By.xpath(("//button[@class='capText font16']"))).click();
		Thread.sleep(3000);

		driver.findElement(By.xpath(("//span[text()='From']"))).click();

		driver.findElement(By.xpath(("(//p[@class='font14 appendBottom5 blackText'])[6]"))).click();

		driver.findElement(By.xpath(("(//p[text()='Bangkok, Thailand'])[1]"))).click();

		driver.findElement(By.xpath("//div[@aria-label='Fri Sep 06 2019']")).click();

		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(3000);

        driver.findElement(By.xpath(("//a[@class='primaryBtn font24 latoBlack widgetSearchBtn ']"))).click();

		String parentHandle = driver.getWindowHandle(); // get the current window handle
		driver.findElement(By.xpath("(//button[@class='fli_primary_btn text-uppercase'])[1]")).click();
	
        for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
		Thread.sleep(3000);

		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(3000);
	
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		System.out.println("continue clicked");
          Thread.sleep(5000);

		// page4
		driver.findElement(By.xpath("//a[text()='+ ADD ADULT']")).click();
		Thread.sleep(5000);
		
		WebElement firstname = driver.findElement(By.xpath("//input[@class='tvlrInput err-border']"));
		String firstname1=read.getData(0, 0, 0);
;		firstname.sendKeys(firstname1);

		WebElement lastname = driver.findElement(By.xpath("(//input[@class='tvlrInput '])[1]"));
		String lastname1=read.getData(0, 0, 1);
		lastname.sendKeys(lastname1);



		driver.findElement(By.xpath("//label[@tabindex='0']")).click();

		Select nationalitydrop = new Select(
				driver.findElement(By.xpath("(//div[@class='css-1hwfws3 dropdown__value-container'])[1]")));

		nationalitydrop.selectByVisibleText("INDIAN");

		driver.findElement(By.xpath("//input[@placeholder='Email'] ")).click();

		driver.findElement(By.xpath(("//button[@class='ack-cta btn fli_primary_btn text-uppercase']"))).click();

		Select dob1 = new Select(
				driver.findElement(By.xpath("(//div[@class='css-1hwfws3 dropdown__value-container'])[2]")));
		dob1.selectByVisibleText("26");

		Select dob2 = new Select(
				driver.findElement(By.xpath("(//div[@class='css-1hwfws3 dropdown__value-container'])[3]")));
		dob2.selectByVisibleText("JUL");

		Select dob3 = new Select(
				driver.findElement(By.xpath("(//div[@class='css-1hwfws3 dropdown__value-container'])[4]")));
		dob3.selectByVisibleText("1995");

		WebElement check = driver.findElement(By.xpath("(//span[@class='check'])[7] "));
		
		if (!check.isSelected()) {
			check.click();
		}

		driver.findElement(By.xpath(("//button[text()='Continue']"))).click();

	}
}
}

