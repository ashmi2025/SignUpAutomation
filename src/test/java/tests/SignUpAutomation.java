package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AgencyDetails;
import pages.HomePage;
import pages.PersonalDetails;
import pages.ProfessionalExperience;
import pages.TermsPage;
import pages.VerificationPreferences;
import utils.MailOTP;

public class SignUpAutomation extends BaseTest {

    @Test(priority = 1)
    public void JoinUsBtn() {

        HomePage homepage = new HomePage(driver);
        homepage.clickJoinUs();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("/register"));

        Assert.assertTrue(driver.getCurrentUrl().contains("/register"));
    }

    @Test(priority = 2, dependsOnMethods = "JoinUsBtn")
    public void termsandcontinue() {

        TermsPage termspage = new TermsPage(driver);
        termspage.clickcheckbox();
        termspage.clickcontinue();
        
        
        Assert.assertTrue(termspage.isPersonalDetailsPageDisplayed());
    }
    

    @Test (priority = 3, dependsOnMethods = "termsandcontinue")
    public void detail() throws InterruptedException {
    	//unique
    	long timestamp = System.currentTimeMillis();
    	String uniqueEmail = "bhandariashmi828+agency" + timestamp + "@gmail.com";
    	String uniquePhone = "97" + String.valueOf(timestamp).substring(5);
    	
    	 PersonalDetails Personaldetail = new PersonalDetails(driver);
    	 Personaldetail.firstname("Ashmi");
    	 Personaldetail.lastname("Bhandari");
    	 Personaldetail.emailaddress(uniqueEmail);
    	 Personaldetail.phonenumber(uniquePhone);
    	 Personaldetail.password("Elbis12345@");
    	 Personaldetail.confirmpassword("Elbis12345@");
    	 Personaldetail.nextbutton();
    	 
    	 Assert.assertTrue(Personaldetail.isotpPageDisplayed());
    	 
    	 Thread.sleep(5000);	
    	
    	 String email = "bhandariashmi828@gmail.com";
    	 String appPassword = "zlff kgqf xgen augw";

    	 String otp = MailOTP.getOTP(email, appPassword);

    	 System.out.println("OTP received: " + otp);

    	 if (otp == null) {
    	     Assert.fail("OTP could not be retrieved from Gmail.");
    	 }

    	 Personaldetail.enterOTP(otp);
    	 Personaldetail.clickVerifyCode();
    	 
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    	 wait.until(ExpectedConditions.urlContains("step=details"));

    	 Assert.assertTrue(
    	     driver.getCurrentUrl().contains("step=details"),("Agency Details page was not displayed after OTP verification"));
    	 
    	 Thread.sleep(5000);
    }
    
    @Test (priority = 4, dependsOnMethods = "detail")
    public void agencyDetails() throws InterruptedException {

        AgencyDetails agency = new AgencyDetails(driver);
        agency.agencyName("Vrit Technologies");
        agency.enterRole("QA Enginner");
        agency.agencyemail("ashmivrit9+tech@gmail.com");
        agency.enterWebsite("www.authorized-partner.vercel.app");
        agency.enterAddress("Tinkune, Kathmandu");
        agency.selectRegion();
        agency.clickNext();
        
                
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.urlContains("experience"));

        Assert.assertTrue(
            driver.getCurrentUrl().contains("experience"),
            "Professional Experience page was not displayed.");
        
        Thread.sleep(5000);
    }
    
    @Test (priority = 5, dependsOnMethods = "agencyDetails")
    public void professionalExperience() throws InterruptedException {

        ProfessionalExperience experience = new ProfessionalExperience(driver);
        experience.selectYearsOfExperience("1 year");
        experience.enterNumberOfStudents("50");
        experience.enterFocusArea("Undergraduate admissions to Australia");
        experience.enterSuccessMetrics("40%");

        experience.selectCareerCounseling();

        experience.clickNext();

        // Verify that the next page (Services Offered) is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        wait.until(ExpectedConditions.urlContains("step=verification"));

        Assert.assertTrue(driver.getCurrentUrl().contains("step=verification"), "Verification page was not displayed after Professional Experience.");

        Thread.sleep(5000);
    }
    
    @Test (priority = 6, dependsOnMethods = "professionalExperience")
    public void verificationPreferences() throws InterruptedException {

        VerificationPreferences verification = new VerificationPreferences(driver);

        verification.enterBusinessRegistrationNumber("Abc123456");
        verification.selectPreferredCountry("Australia");
        verification.selectUniversities();
        verification.enterCertificationDetails("scholarship");

        String uploadDoc1 = System.getProperty("user.dir") + "/src/test/resources/testdata/virttask.png";
        verification.uploadFirstDocument(uploadDoc1);

        Thread.sleep(2000);

        verification.clickSubmit();
        
        Assert.assertTrue(
        	    verification.isProfilePageDisplayed(), "Profile page was not displayed after submission.");

        Thread.sleep(5000);
        
    }
    
}
