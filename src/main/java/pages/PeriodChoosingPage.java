package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PeriodChoosingPage {
	
	// Locators

	private By planFor24Months = By.xpath("//span[normalize-space()='24 months']");
	private By inputEmail = By.xpath("(//input[@class='h-input__input'])[1]");
	private By cardHolderName = By.xpath("//input[@id='cardholdername']");
	private By cardNumber = By.xpath("//input[@placeholder='0000 0000 0000 0000']");
	private By expDate = By.xpath("//input[@placeholder='MM / YY']");
	private By codeCVC = By.xpath("//input[@placeholder='CVC code']");
	private By buttonSubmit = By.cssSelector("button#hcart-submit-payment");
	

	public WebDriver driver;

	// Constructor

	public PeriodChoosingPage(WebDriver driver) {
		this.driver = driver;
	}

	// Functions

	public void goToHostingPlansPeriodChoosingPage() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//span[normalize-space()='24 months']")));
			Thread.sleep(2000);
			driver.findElement(planFor24Months).click();
			driver.findElement(inputEmail).sendKeys("sorobe6940@mtlcz.com");
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(1050, 1450)");
			driver.findElement(cardHolderName).sendKeys("Jonas Jonaitis");
//			driver.findElement(cardNumber).sendKeys("1111111111111111");
//			driver.findElement(codeCVC).sendKeys("123");
//			driver.findElement(expDate).sendKeys("1111");
//			driver.findElement(buttonSubmit).click();
//			String TitlePaymentPage = driver.findElement(titlePageChoosePeriod).getText();
//			Assert.assertEquals(TitlePaymentPage, "Payment page",
//					"Error! Payment Period page is not open, or title isn'n on the page ");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
