package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.AdicionarCartPage;
import cpmj.Pages.CheckoutPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;

public class CheckoutFunc {

	public static void choicePaymentMethod() {
		
		long tipoPagamento = System.currentTimeMillis()%2;
		
		if(tipoPagamento == 0) {
			SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonBankWireXpath()));
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		} else {
			SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonCheckXpath()));
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		}
		
	}
	
	public static void buyProduct(String product) throws InterruptedException {
		
		MinhaContaFunc.searchItem(product);
		
		SeleniumUtils.ValidateWebElementVisible(By.xpath(AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", product)));
	    
		AdicionarCartFunc.clickProductImageFromSearchResult(product);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		AdicionarCartFunc.clickCheckOut();
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.ValidateWebElementPresence(By.cssSelector(CheckoutPage.getShoppingcartsummaryProducttextCss().replace("ProductName", product)));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartsummaryButtonProceedXpath()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartaddressButtonProceedXpath()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingCheckAcceptTermsXpath()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingButtonProceedXpath()));
		
		choicePaymentMethod();
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonConfirmPaymentXpath()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
	}
	
	
}
