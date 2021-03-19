package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.LoginPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;



public class LoginFunc {

	public static String email = null;
	
	public static void loginToApplication(String userName, String password){
		if (userName!=null){
			SeleniumUtils.setValue(By.cssSelector(LoginPage.getLoginPageEmailCss()), userName);
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		}
		if (password!=null){
			SeleniumUtils.setValue(By.cssSelector(LoginPage.getLoginPagePasswordCss()), password);			
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		}
		SeleniumUtils.clickWebElement(By.id(LoginPage.getLoginPageSigninButtonId()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);

	}
	
	public static void registerToApplication() {
		
		email = System.currentTimeMillis() + "test@test.com";
		
		SeleniumUtils.setValue(By.id(LoginPage.getLoginPageCreateEmailId()), email);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);		
		SeleniumUtils.clickWebElement(By.id(LoginPage.getLoginPageRegisterButtonId()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);

	}

	public static String getEmail() {
		return email;
	}
	
}
