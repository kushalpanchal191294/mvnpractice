package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseTest.baseTest;

public class pages extends baseTest {
	
	@FindBy (xpath = "//button[contains(text(),'Sign in')]")
	public static WebElement signIn;
	
	@FindBy (id = "join_neu_email_field")
	public static WebElement email;
	
	@FindBy (name = "password")
	public static WebElement passWord;
	
	@FindBy (name = "submit_attempt")
	public static WebElement button;
	
	@FindBy (id = "aria-join_neu_password_field-error")
	public static WebElement errMsg;
	
	@FindBy (xpath = "//div[contains(@class,'ge-nav-link__icon')]//img[contains(@class,'wt-circle wt-icon')]")
	public static WebElement profile;
	
	public pages() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	public void Login(String a, String b){
		email.sendKeys(a);
		passWord.sendKeys(b);
		button.click();
	}

}
