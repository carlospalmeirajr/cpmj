package cpmj.Utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

	public static boolean driverStatus = false;
	public static WebDriver driver = WebDriverFactory.getDriver();

	public static int tempo = Integer.parseInt(PropertiesLoaderImpl.getValor("tempo"));

	public static WebElement getWebElement(By by) {
		WebElement webElement = driver.findElement(by);
		return webElement;
	}

	public static List<WebElement> getWebElements(By by) {
		List<WebElement> webElements = driver.findElements(by);
		return webElements;
	}

	public static String getTitle() {
		return driver.getTitle();
	}

	@SuppressWarnings("deprecation")
	public static void ImplicitWait() {

		driver.manage().timeouts().implicitlyWait(tempo, TimeUnit.SECONDS);

	}

	public static void switchFrame(String frame) {

		objExplicitWait()
				.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(driver.findElement(By.xpath(frame))));

	}

	public static void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	public static WebDriverWait objExplicitWait() {

		@SuppressWarnings("deprecation")
		WebDriverWait explicitWait = new WebDriverWait(driver, tempo);

		return explicitWait;
	}

	public static void ValidateWebElementPresence(By by) {

		objExplicitWait().until(ExpectedConditions.presenceOfElementLocated(by));

	}

	public static void ValidateWebElementVisible(By by) {

		objExplicitWait().until(ExpectedConditions.visibilityOfElementLocated(by));

	}

	public static void selectWebList(By by, String val, String selectBy) {
		WebElement wb = driver.findElement(by);
		Select sel = new Select(wb);

		switch (selectBy) {
		case "selectByVisibleText":
			sel.selectByVisibleText(val);
			break;
		case "selectbyIndex":
			sel.selectByIndex(Integer.parseInt(val));
			break;

		case "SelectByvalue":// or 2+3
			sel.selectByValue(val);
			break;

		default:

		}

	}

	public static void robotSendKeys(int keyCode) throws Throwable {

		Robot robot = new Robot();
		robot.keyPress(keyCode);
		robot.keyRelease(keyCode);

	}

	public static void selectItemWebTable(By by, int columnfirst, int columnSecond, String firstvalue,
			String secondvalue, String selectValue) {
		WebElement table = driver.findElement(by);
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement eachRow : rows) {
			List<WebElement> columns = eachRow.findElements(By.tagName("td"));

			if ((columns.get(columnfirst).findElement(By.tagName("a")).getText()).contains(firstvalue)
					&& (columns.get(columnSecond).findElement(By.tagName("a")).getText()).contains(secondvalue)) {

				WebElement wb = columns.get(6).findElement(By.tagName("select"));
				Select sel = new Select(wb);
				sel.selectByVisibleText(selectValue);
				break;

			}
		}

	}

	public static void robotUploadFile(String filePath) throws Throwable {

		StringSelection stringSelection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_ENTER);

	}

	public static void clickWebElement(By by) {
		ValidateWebElementVisible(by);
		getWebElement(by).click();

	}

	public static void setValue(By by, String value) {

		ValidateWebElementPresence(by);
		if (value != null)
			getWebElement(by).sendKeys(value);

	}

	public static boolean validateWebElementDisplay(By by) {
		boolean isDisplayed = false;
		try {
			isDisplayed = getWebElement(by).isDisplayed();
		} catch (Exception e) {

			e.printStackTrace();
		}

		return isDisplayed;

	}

	public static int validateWebElementCount(By by) {

		return getWebElements(by).size();

	}

	public static void wait(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public static void closeDriver() {
		driver.close();
	}

}
