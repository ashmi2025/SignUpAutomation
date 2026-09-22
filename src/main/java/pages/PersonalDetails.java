package pages;


	
	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class PersonalDetails {
		
		protected WebDriver driver;
		private WebDriverWait wait;
		
		private By firstnametextbox = By.id("_r_0_-form-item");
		private By lastnametextbox = By.id("_r_1_-form-item");
		private By emailtextbox = By.id("_r_2_-form-item");
		private By phonenumbertextbox = By.id("_r_4_-form-item");
		private By passwordbox = By.name("password");
		private By confirmpasswordbox = By.name("confirmPassword");
		private By nextbtn = By.xpath("//button[text()='Next']");
		private By otppage = By.xpath("//*[text()='Email Verification code']");
		private By otp = By.cssSelector("input[data-input-otp]");
		private By verifyCode = By.xpath("//button[normalize-space()='Verify Code']");
		
		
		public PersonalDetails(WebDriver driver) {
			this.driver = driver;
			this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		}
		
		public void firstname(String firstname) {
			wait.until(ExpectedConditions.elementToBeClickable(firstnametextbox)).sendKeys(firstname);

		}
		public void lastname(String lastname) {
			wait.until(ExpectedConditions.elementToBeClickable(lastnametextbox)).sendKeys(lastname);
		}
		
		public void emailaddress(String emailaddress) {
			wait.until(ExpectedConditions.elementToBeClickable(emailtextbox)).sendKeys(emailaddress);
		}
		
		public void phonenumber(String phonenumber) {
			wait.until(ExpectedConditions.elementToBeClickable(phonenumbertextbox)).sendKeys(phonenumber);
		}
		
		public void password(String password) {
			wait.until(ExpectedConditions.elementToBeClickable(passwordbox)).sendKeys(password);
		}
		
		public void confirmpassword(String confirmpassword) {
			wait.until(ExpectedConditions.elementToBeClickable(confirmpasswordbox)).sendKeys(confirmpassword);
		
         }
		
		public void nextbutton() {
			wait.until(ExpectedConditions.elementToBeClickable(nextbtn)).click();
		}
		
		public boolean isotpPageDisplayed() {
		    return wait.until(ExpectedConditions.visibilityOfElementLocated(otppage)).isDisplayed();
		
	}
		public void enterOTP(String otpCode) {
		    driver.findElement(otp).sendKeys(otpCode);
		}
		
		public void clickVerifyCode() {
		    driver.findElement(verifyCode).click();
		}
	}
