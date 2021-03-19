package cpmj.StepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;

import cpmj.Functionalities.CheckoutFunc;
import cpmj.Pages.CheckoutPage;
import cpmj.Utils.EvidenceFactory;
import cpmj.Utils.SeleniumUtils;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;

public class CheckoutSteps {

	@Quando("efetuar a compra do item {string} no site")
	public void efetuar_a_compra_do_item_no_site(String string) throws InterruptedException {
		try {
		CheckoutFunc.buyProduct(string);
		}  catch (Exception e) {
			EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
			SeleniumUtils.driver.close();
		}
	}

	@Então("validar que a compra foi efetuada")
	public void validar_que_a_compra_foi_efetuada() {
		try {
		boolean validacao = false;
		SeleniumUtils.clickWebElement(By.xpath(CheckoutPage.getShoppingcartpaymentButtonBackOrdersXpath()));
		validacao = SeleniumUtils.validateWebElementDisplay(By.xpath(CheckoutPage.getOrderhistoryFirstOrderXpath()));
		Assert.assertTrue("Sucesso ao validar o cadastro da conta", validacao);
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.closeDriver();
		}  catch (Exception e) {
		EvidenceFactory.captureScreenShot(SeleniumUtils.driver);
		SeleniumUtils.driver.close();
		}
	}
}
