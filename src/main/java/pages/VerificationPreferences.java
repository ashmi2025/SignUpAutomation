package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerificationPreferences {

	protected WebDriver driver;
	private WebDriverWait wait;

	private By businessRegistrationNumber = By.name("business_registration_number");
	private By certificationDetails = By.name("certification_details");

	private By preferredCountriesField = By.xpath("//*[normalize-space()='Select Your Preferred Countries']");
	private By countrySearchBox = By.xpath("//input[@placeholder='Search...']");

	private By universities = By.xpath("//label[normalize-space()='Universities']/preceding-sibling::button[@role='checkbox']");
	
	private By uploadBox1 = By.xpath("(//input[@type='file'])[1]");
	private By submitButton = By.xpath("//button[normalize-space()='Submit']");
	private By profileHeading = By.xpath("//*[normalize-space()='My Profile']");


	public VerificationPreferences(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void enterBusinessRegistrationNumber(String number) {
		wait.until(ExpectedConditions.elementToBeClickable(businessRegistrationNumber)).sendKeys(number);
	}

	public void selectPreferredCountry(String country) {
		wait.until(ExpectedConditions.elementToBeClickable(preferredCountriesField)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(countrySearchBox)).sendKeys(country);
		By countryOption = By.xpath("//span[normalize-space()='" + country + "']");
		wait.until(ExpectedConditions.elementToBeClickable(countryOption)).click();
	}

	public void selectUniversities() {
		wait.until(ExpectedConditions.elementToBeClickable(universities)).click();
	}

	public void enterCertificationDetails(String details) {
		wait.until(ExpectedConditions.elementToBeClickable(certificationDetails)).sendKeys(details);
	}

	public void uploadFirstDocument(String filePath) {
	    WebElement input = wait.until(ExpectedConditions.presenceOfElementLocated(uploadBox1));
	    input.sendKeys(filePath);
	
	}

	public void clickSubmit() {
		wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
	}
	
	public boolean isProfilePageDisplayed() {
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(profileHeading)).isDisplayed();
}}