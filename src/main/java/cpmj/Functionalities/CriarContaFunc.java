package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.CriarContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;

public class CriarContaFunc {

	public static void createUser() {
		
		String firstName = "Teste";
		String lastName = "Automatizado";
		String password = "123456";
		String address = "Rua Teste Automaizado, " + System.currentTimeMillis();
		String city = "Cidade Teste Automatizado";
		String state = "Alabama";
		String postalCode = "12345";
		String mobilePhone = "+5511954123456";
		
		LoginFunc.registerToApplication();
		
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountFirstNameId()), firstName);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountLastNameId()), lastName);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountPasswordId()), password);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountAddressLine1Id()), address);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountAddressCityId()), city);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.selectWebList(By.id(CriarContaPage.getCreateAccountAddressStateId()), state, "selectByVisibleText");
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountAddressPostCodeId()), postalCode);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.setValue(By.id(CriarContaPage.getCreateAccountAddressMobilePhoneId()), mobilePhone);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.clickWebElement(By.id(CriarContaPage.getCreateAccountBtnRegisterId()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		
		
	}
	
}
