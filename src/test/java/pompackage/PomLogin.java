package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BasePackage.BaseHRMclass;

public class PomLogin extends BaseHRMclass {  // made child class of baseclass(parent)

	//we create object repository, all the elements on login page
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")    //driver.findElement(By.
	WebElement Username;
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input") WebElement Password;
	@FindBy(xpath="/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")WebElement Loginbtn;
	
	
	//initiate page elements
	public PomLogin() {
		PageFactory.initElements(driver, this); //after making child class we can use driver element  from baseclass(parent) class
	                                            //all the element (findby) initialize with the help of PageFactory.initElements(driver, this(it will convert local in to global);
	
	
	}
	public void typeusername(String name) {
		
		Username.sendKeys(name);
	}

	public void typepassword(String pass) {
		Password.sendKeys(pass);
	}

    public void clickbtn() {
    	Loginbtn.click();
    }
    public String verify() {
    	return driver.getTitle();
    	
    	
    }
}

