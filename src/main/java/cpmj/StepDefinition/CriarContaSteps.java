package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cpmj.Functionalities.CriarContaFunc;
import cpmj.Functionalities.HomeFunc;
import cpmj.Pages.HomePage;
import cpmj.Pages.LoginPage;
import cpmj.Pages.MinhaContaPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.PropertiesLoaderImpl;
import cpmj.Utils.SeleniumUtils;
import cpmj.Utils.WebDriverFactory;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;

public class CriarContaSteps {

	@Dado("efetuar um novo cadastro")
	public void efetuar_um_novo_cadastro() {

		try {
			WebDriver driver = WebDriverFactory.driver();
			driver.get(PropertiesLoaderImpl.getValor("url"));
			SeleniumUtils.ValidateWebElementPresence(By.className(HomePage.getHomePageSigninClassname()));
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			HomeFunc.clickSignIn_HomePage();
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.ValidateWebElementPresence(By.cssSelector(LoginPage.getLoginPageEmailCss()));
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			CriarContaFunc.createUser();
		} catch (Exception e) {
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.driver.close();
		}

	}
	
	@Então("validar que o cadastro foi efetuado")
	public void validar_que_o_cadastro_foi_efetuado() {

		try {
			boolean validacao = false;
			validacao = SeleniumUtils.validateWebElementDisplay(By.xpath(MinhaContaPage.getWelcomepageNameUserXpath()));
			Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			WebDriverFactory.getDriver().close();
		}  catch (Exception e) {
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.driver.close();
		}
	}
}
