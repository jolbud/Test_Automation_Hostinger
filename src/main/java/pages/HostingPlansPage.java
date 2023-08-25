package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HostingPlansPage {

	// Locators

	private By buttonAddToCart = By.xpath("(//button[contains(@class,'h-button h-pricing-card__add-to-cart')])[1]");
	private By titlePageChoosePeriod = By.xpath("//h1[contains(text(),'You’re almost there! Complete your order')]");

	public WebDriver driver;

	// Constructor

	public HostingPlansPage(WebDriver driver) {
		this.driver = driver;
	}

	// Functions

	public void goToHostingPlansPeriodChoosingPage() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("(//button[contains(@class,'h-button h-pricing-card__add-to-cart')])[1]")));
			driver.findElement(buttonAddToCart).click();
			String TitlePageChoosePeriod = driver.findElement(titlePageChoosePeriod).getText();
			Assert.assertEquals(TitlePageChoosePeriod, "You’re almost there! Complete your order",
					"Error! Web Hosting Choose Period page is not open, or title isn'n on the page ");
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

}
