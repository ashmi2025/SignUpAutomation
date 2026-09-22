package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AgencyDetails {
	
	protected WebDriver driver;
	private WebDriverWait wait;

    private By agencyNameTextbox = By.name("agency_name");
    private By roleInAgency = By.name("role_in_agency");
    private By agencyEmail = By.name("agency_email");
    private By website = By.name("agency_website");
    private By address = By.name("agency_address");
    private By region = By.xpath("//button[@role='combobox']");
    private By nepal = By.xpath("//span[normalize-space()='Nepal']");
    private By nextButton = By.xpath("//button[normalize-space()='Next']");
    private By professionalExperienceHeading =By.xpath("//*[normalize-space()='3. Professional Experience']");

    public AgencyDetails(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void agencyName(String agencyName) {
        wait.until(ExpectedConditions.elementToBeClickable(agencyNameTextbox)).sendKeys(agencyName);
    }
    
    public void enterRole(String role) {
    	 wait.until(ExpectedConditions.elementToBeClickable(roleInAgency)).sendKeys(role);
            }
    
    public void agencyemail(String email) {
    	 wait.until(ExpectedConditions.elementToBeClickable(agencyEmail)).sendKeys(email);
    }

    public void enterWebsite(String websiteText) {
    	 wait.until(ExpectedConditions.elementToBeClickable(website)).sendKeys(websiteText);
    }

    public void enterAddress(String addressText) {
    	wait.until(ExpectedConditions.elementToBeClickable(address)).sendKeys(addressText);
    }

    public void selectRegion() {
    	 wait.until(ExpectedConditions.elementToBeClickable(region)).click();
    	 wait.until(ExpectedConditions.elementToBeClickable(nepal)).click();
    }

    public void clickNext() {
    	 wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }
    
    public boolean isProfessionalExperiencePageDisplayed() {

    	return wait.until(ExpectedConditions.visibilityOfElementLocated(professionalExperienceHeading)).isDisplayed();

    }
}