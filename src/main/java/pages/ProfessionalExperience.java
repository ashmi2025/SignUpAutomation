package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfessionalExperience {

    protected WebDriver driver;
    private WebDriverWait wait;

    private By yearsOfExperience = By.xpath("//label[text()='Years of Experience']/following::button[@role='combobox'][1]");   
    private By numberOfStudents = By.name("number_of_students_recruited_annually");    
    private By focusArea = By.name("focus_area");           
    private By successMetrics = By.name("success_metrics");   
    private By careerCounselingCheckbox = By.xpath("//label[normalize-space()='Career Counseling']/ancestor::div[2]//button[@role='checkbox']"); 
    private By nextBtn = By.xpath("//button[@type='submit' and normalize-space()='Next']");         
    private By verificationHeading = By.xpath("//*[contains(normalize-space(),'4. Verification and Provide Business Set Preferences')]"); 

    public ProfessionalExperience(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectYearsOfExperience(String level) {
        wait.until(ExpectedConditions.elementToBeClickable(yearsOfExperience)).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='" + level + "']"))).click();
    }

    public void enterNumberOfStudents(String number) {
        wait.until(ExpectedConditions.elementToBeClickable(numberOfStudents)).sendKeys(number);
    }

    public void enterFocusArea(String area) {
        wait.until(ExpectedConditions.elementToBeClickable(focusArea)).sendKeys(area);
    }

    public void enterSuccessMetrics(String metrics) {
        wait.until(ExpectedConditions.elementToBeClickable(successMetrics)).sendKeys(metrics);
    }

    public void selectCareerCounseling() {
        wait.until(ExpectedConditions.elementToBeClickable(careerCounselingCheckbox)).click();
    }

    public void clickNext() {
        wait.until(ExpectedConditions.elementToBeClickable(nextBtn)).click();
    }

    public boolean isVerificationPageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(verificationHeading)).isDisplayed();
    }
}


