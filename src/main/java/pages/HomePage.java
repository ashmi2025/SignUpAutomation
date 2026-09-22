package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	protected WebDriver driver;
	private WebDriverWait wait;
	
	private By JoinUsBtn = By.xpath("//button[text()='Join Us Now']");
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	public void clickJoinUs() {
		     wait.until(ExpectedConditions.elementToBeClickable(JoinUsBtn)).click();
	}
	

}
