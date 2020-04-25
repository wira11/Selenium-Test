package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTestingModular {
	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
		setBrowser();
		setBrowserConfig();
		runTest();
	}

		//setBrowser
		//setBrowserConfig
		//runTest
	
	/**
	 * 25/04/2020
	 * @author Wira Pakpahan
	 */
	
		public static void setBrowser() {
			browser="Chrome";
		}

		public static void setBrowserConfig() {
			String projectLocation = System.getProperty("user.dir");
			
			if(browser.contains("Chrome")) {
				System.setProperty("webdriver.chrome.driver", projectLocation+"\\lib\\driver\\chromedriver.exe");
				driver = new ChromeDriver();              
			}
			if(browser.contains("Firefox")) {
				System.setProperty("webdriver.gecko.driver", projectLocation+"\\lib\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();              
			}

		}
		public static void runTest() {
			driver.get("https://opensource-demo.orangehrmlive.com/");

			String expectedTitle = "OrangeHRM";
			String actualTitle = "";

			// get the actual value of the title
			actualTitle = driver.getTitle();

			/*
			 * compare the actual title of the page with the expected one and print
			 * the result as "Passed" or "Failed"
			 */
			if (actualTitle.contentEquals(expectedTitle)){
				System.out.println("Test Passed!");
			} else {
				System.out.println("Test Failed");
			}

			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			driver.findElement(By.id("menu_admin_viewAdminModule")).click();

			Select userType = new Select(driver.findElement(By.id("searchSystemUser_userType")));
			//userType.selectByVisibleText("ESS");
			userType.selectByIndex(1);

		}
	}
