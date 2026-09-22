package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TermsPage {

	protected WebDriver driver;
	private WebDriverWait wait;
	
	private By termsandcondition = By.id("remember");
	private By continuebtn = By.xpath("//button[text()='Continue']");
	private By personalDetailsHeading = By.xpath("//*[text()='Provide your personal details.']");
	
	public TermsPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
		public void clickcheckbox() {
			 wait.until(ExpectedConditions.elementToBeClickable(termsandcondition)).click();
			
	}
		public void clickcontinue() {
			 wait.until(ExpectedConditions.elementToBeClickable(continuebtn)).click();
		}
		
		public boolean isPersonalDetailsPageDisplayed() {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(personalDetailsHeading)).isDisplayed();
		
}}
