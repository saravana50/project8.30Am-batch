package org.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class login extends test.project8.Am_batch.Baseclass{
		

	//private  WebElement getTextUserName() {
		//WebElement textuserName = driver.findElement(By.id("text"));
		//return textuserName;
		
	//}
	public login() {
    PageFactory.initElements(driver, this);
	}
	
	@CacheLookup
	@FindBys({@FindBy(xpath="(//input[@type='text'])[2]")})
		private List<WebElement> textuserName;
	
	@FindAll({@FindBy(xpath="//input[@type='password']"),@FindBy(xpath="(//input[@autocomplete='off'])[3]")})
		private WebElement textpasssword;
	@FindBy(xpath="(//button[@type='submit'])[2]")
		private WebElement login;
		
		
		public List<WebElement> getTextuserName() {
			return textuserName;
		}
		public WebElement getTextpasssword() {
			return textpasssword;
		}
		public WebElement getLogin() {
			return login;
		}
		
		public void getLogin(String user,String pass) {
			sendKeys(getTextuserName().get(0),user);
			   sendKeys(getTextpasssword(),pass);
			  login(getLogin()); 
		}
		
		}
