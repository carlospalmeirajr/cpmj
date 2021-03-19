package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.AdicionarCartPage;
import cpmj.Utils.SeleniumUtils;

public class AdicionarCartFunc {

	public static void clickProductImageFromSearchResult(String item) throws InterruptedException {

		//AdicionarCartPage.getAddToCart_ProductImage_XPATH() = AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", item);

		String xpath =  AdicionarCartPage.getAddToCart_ProductImage_XPATH().replace("ProductName", item);
		
		SeleniumUtils.clickWebElement(By.xpath(xpath));

		SeleniumUtils.switchFrame(AdicionarCartPage.getAddToCart_Frame_ToClickAddToCart_XPATH());

		SeleniumUtils.clickWebElement(By.xpath(AdicionarCartPage.getAddtocartAddtocardbuttonXpath()));

		SeleniumUtils.switchToDefaultContent();

	}

	public static void clickCheckOut() throws InterruptedException {

		Thread.sleep(5000);
		SeleniumUtils.clickWebElement(By.xpath(AdicionarCartPage.getAddtocartProceedtocheckoutbuttonXpath()));
		
	}

}
