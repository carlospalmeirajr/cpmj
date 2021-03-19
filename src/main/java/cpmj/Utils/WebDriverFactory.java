package cpmj.Utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

	static WebDriver driver = null;

	public static WebDriver driver() {

		String browser = PropertiesLoaderImpl.getValor("browser");
		
		kill(browser);

		ChromeOptions optionsChrome = null;

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else if (browser.equalsIgnoreCase("headless")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//drivers//chromedriver.exe");
			optionsChrome = new ChromeOptions();
			optionsChrome.addArguments("--window-size=1400,600");
			optionsChrome.addArguments("--headless");
			driver = new ChromeDriver(optionsChrome);
		} else {
			new Exception("O Browser não foi escolhido de forma adequada");
		}

		return driver;
	}

	private static boolean kill(String browser) {
        try {
            String line = null;
            String processo = null;
            
            if (browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("headless")) {
            	processo = "taskkill /F /IM chromedriver.exe";
            } else if (browser.equalsIgnoreCase("firefox")) {
            	processo = "taskkill /F /IM geckodriver.exe";
            }
            
            Process p = Runtime.getRuntime().exec(processo);
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                if (!line.trim().equals("")) {
                    if (line.substring(1, line.indexOf("\"", 1)).equalsIgnoreCase(processo)) {
                        Runtime.getRuntime().exec("taskkill /F /IM " + line.substring(1, line.indexOf("\"", 1)));
                        return true;
                    }
                }
            }
            input.close();
        } catch (Exception err) {
            //err.printStackTrace();
        }
        return false;
    }
	
	public static WebDriver getDriver() {
	    return driver;
	}
	
}
