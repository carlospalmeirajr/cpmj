package cpmj.Functionalities;

import org.openqa.selenium.By;

import cpmj.Pages.HomePage;
import cpmj.Utils.SeleniumUtils;

public class HomeFunc {

	public static void clickSignIn_HomePage(){		
		SeleniumUtils.clickWebElement(By.className(HomePage.getHomePageSigninClassname()));
	}
	
}
