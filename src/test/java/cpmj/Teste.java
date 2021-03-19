package cpmj;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Functionalities.AdicionarCartFunc;
import cpmj.Functionalities.CriarContaFunc;
import cpmj.Functionalities.HomeFunc;
import cpmj.Functionalities.MinhaContaFunc;
import cpmj.Pages.AdicionarCartPage;
import cpmj.Pages.CheckoutPage;
import cpmj.Pages.HomePage;
import cpmj.Pages.LoginPage;
import cpmj.Utils.PropertiesLoaderImpl;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;

public class Teste {

	  @Test
	  public void testGoogleSearch() throws InterruptedException, IOException {
		  
		  //System.out.println(PropertiesLoaderImpl.getValor("tempo"));
		  
		
		  
		  
	    WebDriver driver = WebDriverFactory.driver();
	    driver.get(PropertiesLoaderImpl.getValor("url"));
		Assert.assertEquals("the page title is not matching", HomePage.getHomePageTitle(), SeleniumUtils.getTitle());		
		SeleniumUtils.ValidateWebElementPresence(By.className(HomePage.getHomePageSigninClassname()));
	    
		Assert.assertEquals("the page title is not matching", HomePage.getHomePageTitle(), SeleniumUtils.getTitle());
		HomeFunc.clickSignIn_HomePage();
		
		SeleniumUtils.ValidateWebElementPresence(By.cssSelector(LoginPage.getLoginPageEmailCss()));
		
		CriarContaFunc.createUser();
		
		//LoginFunc.registerToApplication();
		
		//LoginFunc.loginToApplication("cpmj@test.com", "12345");		
	    
		// compra a partir daqui
		
		String item = "Faded Short Sleeve T-shirts";
		
		MinhaContaFunc.searchItem(item);
		
		SeleniumUtils.ValidateWebElementVisible(By.xpath(AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", item)));
	    
		AdicionarCartFunc.clickProductImageFromSearchResult(item);
		AdicionarCartFunc.clickCheckOut();
		
		SeleniumUtils.ValidateWebElementPresence(By.cssSelector(CheckoutPage.getShoppingcartsummaryProducttextCss().replace("ProductName", item)));
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartsummaryButtonProceedXpath()));
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartaddressButtonProceedXpath()));
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingCheckAcceptTermsXpath()));
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartshippingButtonProceedXpath()));
		
		long tipoPagamento = System.currentTimeMillis()%2;
		
		if(tipoPagamento == 0) {
			SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonBankWireXpath()));
		} else {
			SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonCheckXpath()));
		}
		
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonConfirmPaymentXpath()));
		
		
	    Thread.sleep(3000);  // Let the user actually see something!
//	    EvidenceFactory.captureScreenShot(driver);
//	    WebElement searchBox = driver.findElement(By.name("q"));
//	    searchBox.sendKeys("ChromeDriver");
//	    searchBox.submit();
//	    EvidenceFactory.captureScreenShot(driver);
//	    Thread.sleep(5000);  // Let the user actually see something!
//	    driver.quit();
//	  
	  }
}
