package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {

	// Locators

	private By buttonClaimDeal = By.xpath("//button[contains(text(),'Claim Deal')]");
	private By titlePlanPage = By.xpath("//h2[normalize-space()='Choose Your Web Hosting Plan']");

	public WebDriver driver;

	// Constructor

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Functions

	// go to page of plans

	public void chooseClaimDeal() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Claim Deal')]")));
			driver.findElement(buttonClaimDeal).click();
			String PlanPageTitle = driver.findElement(titlePlanPage).getText();
			Assert.assertEquals(PlanPageTitle, "Choose Your Web Hosting Plan",
					"Error!Plans page is not loaded, or title is missing");
		} catch (Exception e) {
			// catch error, if test is not successful in 'try' part
			Assert.fail(e.getMessage());
		}
	}

}
