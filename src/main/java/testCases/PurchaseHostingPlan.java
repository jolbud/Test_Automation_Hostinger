package testCases;

import org.testng.annotations.Test;

import abstractParameters.AbstractTestParameters;
import pages.HomePage;
import pages.HostingPlansPage;
import pages.PeriodChoosingPage;

public class PurchaseHostingPlan extends AbstractTestParameters {

	@Test(enabled = true, priority = 1, groups = {
			"Smoke" }, description = "Test Nr.1 Purchase Premium Web Hosting Plan")
	public void PurchasePremiumWebHostingPlan() throws Exception {
		HomePage homePage = new HomePage(driver);
		HostingPlansPage hostingPlans = new HostingPlansPage(driver);
		PeriodChoosingPage periodChoosing = new PeriodChoosingPage(driver);
		homePage.chooseClaimDeal();
		hostingPlans.goToHostingPlansPeriodChoosingPage();
		periodChoosing.goToHostingPlansPeriodChoosingPage();
	}
}