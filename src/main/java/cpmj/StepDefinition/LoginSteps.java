package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.HomeFunc;
import cpmj.Functionalities.LoginFunc;
import cpmj.Pages.HomePage;
import cpmj.Pages.LoginPage;
import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class LoginSteps {

	@Dado("logar com o usuário")
	public void logar_com_o_usuário() {
		try {
		SeleniumUtils.clickWebElement(By.cssSelector(MinhaContaPage.getWelcomepageSignoutCss()));
		SeleniumUtils.ValidateWebElementPresence(By.className(HomePage.getHomePageSigninClassname()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		HomeFunc.clickSignIn_HomePage();
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.ValidateWebElementPresence(By.cssSelector(LoginPage.getLoginPageEmailCss()));
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		LoginFunc.loginToApplication(LoginFunc.getEmail(), "123456");
		}  catch (Exception e) {
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.driver.close();
		}
	}
	
	@Então("validar que é possivel logar com o usuário criado")
	public void validar_que_é_possivel_logar_com_o_usuário_criado() {
		try {
		boolean validacao = false;
		validacao = SeleniumUtils.validateWebElementDisplay(By.xpath(MinhaContaPage.getWelcomepageNameUserXpath()));
		Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
//		SeleniumUtils.closeDriver();
		}  catch (Exception e) {
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.driver.close();
		}
	}
}
