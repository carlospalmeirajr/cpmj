package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;

public class MinhaContaFunc {

	public static void searchItem(String item){
		
		SeleniumUtils.getWebElement(By.id(MinhaContaPage.getWelcomepageSearchId())).sendKeys(item);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.getWebElement(By.cssSelector(MinhaContaPage.getWelcomepageSearchCss())).click();
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
	}
}
