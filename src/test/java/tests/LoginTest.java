package tests;

import org.testng.annotations.Test;

import baseTest.baseTest;
import data.data;
import pages.pages;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest extends baseTest {
	pages lp;
	data d;
  public LoginTest() throws IOException {
		super();
		
		
		
	}
@Test
  public void Correctlogin() {
	lp.Login(d.email, d.correctPassword);
	Assert.assertTrue(lp.profile.isDisplayed());
	}
@Test
public void loginwithoutPassword() throws InterruptedException {
	lp.Login(d.email, "");
	Thread.sleep(5000);
	String actualErr = lp.errMsg.getText();
	Assert.assertEquals(d.noPasswordErr, actualErr);
	
	}
@Test
public void loginwithwrongPassword() throws InterruptedException {
	lp.Login(d.email, d.wrongpassword);
	Thread.sleep(5000);
	String actualError = lp.errMsg.getText();
	Assert.assertEquals(d.wrongPasswordErr, actualError);
	}

  @BeforeMethod
  public void beforeMethod() throws IOException {
	  openBrowser();
	  openUrl();
	  d = new data();
	  lp = new pages();
	  lp.signIn.click();
  }

  @AfterMethod
  public void afterMethod() {
	  closeBrowser();
  }

}
