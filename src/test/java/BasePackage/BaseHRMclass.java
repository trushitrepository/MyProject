package BasePackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.TimeUtils;

public class BaseHRMclass {

	
	public static Properties prop= new Properties();
	public static WebDriver driver;
	
	//Step 1 
	public BaseHRMclass() {
		
                try {		
		FileInputStream file= new FileInputStream("C:\\Users\\Meet\\eclipse-workspace\\HRM07\\src\\test\\java\\EnvironmentVariables\\config.properties");     // to read properties of config.properties file in this constructor
                prop.load(file); }
                
                catch(FileNotFoundException e) {
                	e.printStackTrace();
        }
                catch(IOException a) {
                	a.printStackTrace();
                }
                
      //Step 2
	}
	
    public static void initiate() {
    String browsername=prop.getProperty("browser");
    
    if (browsername.equals("Chrome")) {
    	
    	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    	driver=new ChromeDriver();
    }
    	else if(browsername.equals("Firefox")) {
        System.setProperty("webdriver.gecko.driver","geckodriver.exe");
        driver=new FirefoxDriver();
    	}
    
    driver.manage().window().maximize();
    driver.manage().timeouts().pageLoadTimeout(TimeUtils.timepage, TimeUnit.SECONDS);
    driver.get(prop.getProperty("url"));
    }
    
    public static void screenshots(String Filename) {
    	
    	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	
    	try {
			FileUtils.copyDirectory(file, new File("C:\\Users\\Meet\\eclipse-workspace\\HRM07\\src\\test\\java\\screenshots\\Screenshots" +Filename+".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    }            
	
	

