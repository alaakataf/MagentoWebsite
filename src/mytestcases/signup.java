package mytestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class signup extends parameter {
	private static final CharSequence Welcome = null;
	WebDriver driver = new ChromeDriver();

	@BeforeTest
	public void setUp() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(priority = 1)
	public void myFirsrTest() throws InterruptedException {
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

		// WebElement CreateAccountButtonElement =
		// driver.findElement(By.cssSelector("button[title='Create an Account'] span"));

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

		// welcome message
		WebElement WelcomeMsg = driver
				.findElement(By.cssSelector("div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
		String actualMessage = WelcomeMsg.getText().trim(); // Get text and remove leading/trailing spaces
		String expectedMessage = "Thank you for registering with Main Website Store.";
		assertEquals(actualMessage, expectedMessage);

		Thread.sleep(3000);

	}

	@Test(priority = 2)
	public void logoutProcess() throws InterruptedException {
		Thread.sleep(3000);

		driver.get("https://magento.softwaretestingboard.com/customer/account/logout/\" data-post=");
		// driver.getCurrentUrl();
		// System.out.println();
		assertEquals(driver.getCurrentUrl().contains("logoutSuccess"), true);
	}

	@Test(priority = 3)
	public void loginProcess() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys(emailID);
		driver.findElement(By.id("pass")).sendKeys(commonPassword);
		driver.findElement(By.id("send2")).click();
		// driver.findElement(By.cssSelector(".panel.header")).getText();
		Thread.sleep(2000);
		// System.out.println(driver.findElement(By.cssSelector(".greet.welcome")).getText());
		String WelcomeMessage = driver.findElement(By.cssSelector(".greet.welcome")).getText();
		assertEquals(WelcomeMessage.contains("Welcome"), true);
	}

	@Test(priority = 4)
	private void AddOneRandomItem() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");

		// driver.get("https://magento.softwaretestingboard.com/");
		// driver.findElements(By.tagName("a")).size();
		// System.out.println(driver.findElements(By.tagName("a")).size());
		// WebElement footer = driver.findElement(By.cssSelector(".footer.content"));

		// int theNumberOfTagA = footer.findElements(By.tagName("a")).size();
		// System.out.println (theNumberOfTagA);
		// int theNumberOfH1Tag = driver.findElements(By.tagName("h1")).size();
		// System.out.println(theNumberOfH1Tag + " This Is The Total Number Of H1 Tag In
		// The Page");

		WebElement ItemsContainer = driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
		int numberofitems = ItemsContainer.findElements(By.tagName("li")).size();
		System.out.println(numberofitems);
		int randomItemToSelect = rand.nextInt(4);
		ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click();
		WebElement sizeContainer = driver.findElement(By.cssSelector(".swatch-attribute.size"));
		// sizeContainer.findElements(By.className("swatch-option"));
		// System.out.println
		// (sizeContainer.findElements(By.className("swatch-option")).size());
		int theSize = sizeContainer.findElements(By.className("swatch-option")).size();
		sizeContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSize)).click();
		Thread.sleep(2000);
		WebElement colorsContainer = driver.findElement(By.cssSelector(".swatch-attribute.color"));
		int theColors = colorsContainer.findElements(By.className("swatch-option")).size();
		colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
		driver.findElement(By.id("product-addtocart-button")).click();
		Thread.sleep(3000);
		
		String AcualMsg = driver.findElement(By.cssSelector(".page.messages")).getText();
		assertEquals(AcualMsg.contains("You added"), true); 

	}
}
