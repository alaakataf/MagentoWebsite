package mytestcases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class signup extends parameter {
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		

	}

	@Test()
	public void myFirsrTest()throws InterruptedException {
		// find the elements
		driver.get("https://magento.softwaretestingboard.com/");
		
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


		WebElement FirstName = driver.findElement(By.id("firstname"));
		WebElement LastName = driver.findElement(By.id("lastname"));

		WebElement Email = driver.findElement(By.id("email_address"));
		WebElement Password = driver.findElement(By.id("password"));
		WebElement ConfirmPassword = driver.findElement(By.xpath("//input[@id='password-confirmation']"));

		WebElement CreateAccountButton = driver.findElement(By.xpath("(//button[@title='Create an Account'])[1]"));
		
		//WebElement CreateAccountButtonElement = driver.findElement(By.cssSelector("button[title='Create an Account'] span"));
		
        
		// interact with the elements
		FirstName.sendKeys(firstNames[randomIndex]);
		LastName.sendKeys(lastNames[randomIndex]);
		// Email.sendKeys(firstNames[randomIndex] + lastNames[randomIndex] +
		// randomEmailID + "@"+"gmail.com");
		// copy the previous line to parameter instead of here and ...
		Email.sendKeys(emailID);
		Password.sendKeys(commonPassword);
		ConfirmPassword.sendKeys(commonPassword);

		// to submit
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		CreateAccountButton.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//welcome message
		WebElement WelcomeMsg = driver.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
		String actualMessage = WelcomeMsg.getText().trim(); // Get text and remove leading/trailing spaces
		String expectedMessage = "Thank you for registering with Main Website Store.";
		assertEquals(actualMessage, expectedMessage);


	}
}
