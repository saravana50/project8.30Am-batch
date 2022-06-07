package test.project8.Am_batch;


import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public  class Baseclass {
public static	WebDriver driver;
	
	public static WebDriver LaunchBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		return driver;
}
    public static WebDriver launchbrowser(String browserName) {
    	
    // if(browserName.equalsIgnoreCase("chrome")) {
    //	 WebDriverManager.chromedriver().setup();
    //	 driver=new ChromeDriver();
    // }
   //  else if(browserName.equalsIgnoreCase("firefox")) {
   // 	 WebDriverManager.firefoxdriver().setup();
   // 	 driver=new FirefoxDriver();
   //  }
    // else if(browserName.equalsIgnoreCase("edge")) {
    //	 WebDriverManager.edgedriver().setup();
    	// driver=new EdgeDriver();
    // }
   //  else {
    //	 System.out.println("invalid Browser");
    // }
    	
    	
    	
    	
	//return driver;
    	switch (browserName) {
    	case "chrome":
    	WebDriverManager.chromedriver().setup();
    	driver=new ChromeDriver();
    	break;
    	
    	case "firefox":
    	WebDriverManager.firefoxdriver().setup();
    	driver=new FirefoxDriver();
    	break;
    	
    	case"edge":
    	WebDriverManager.edgedriver().setup();
    	driver=new EdgeDriver();
    	break;
    	}
		return driver;
}
    
    
    //urlLaunch
	public static void launchUrl(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	//wait	
	}
	public static void implicityWait(int i) {
     driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	//current Url
    public static String getcurrentUrl() {
    String CurrentUrl = driver.getCurrentUrl();
    return CurrentUrl;
    }   
    //Get Title
    public static String getTitle() {
    String title = driver.getTitle();
	return title;
	}
    //Quit
    public static void quit() {
    driver.quit();
	}
    //Click
    public static void click(WebElement e) {
    e.click();
	}
    //Get Text
    public static String getText(WebElement e) {
    String text = e.getText();
	return text;
	}
    //Set Tag Name
    public static String getTagName(WebElement e) {
    String tagName = e.getTagName();
	return tagName;
	}
    //Get attribute 
    public static String getAttribute(WebElement e) {
    String attribute = e.getAttribute("value");
	return attribute;
	}
    ///SendKeys
    public static String sendKeys(WebElement e,String User) {
    e.sendKeys(User);
	return User;
	}
    //isSelected
    public static String isSelected(WebElement e) {
	e.isSelected();
	return null;
    }
    //Clear
    public static String clear(WebElement e) {
    e.click();
	return null;
	}
  //Actions
    //doubleclick
    public static void doubleClick (WebElement e) {
    Actions a=new Actions(driver);
    a.doubleClick().perform();
	}
    //clickandhold
    public static void clickAndHold(WebElement e) {
    Actions a=new Actions(driver);
    a.clickAndHold().perform();
	}
    //draganddrop
    public static void dragAndDrop(WebElement src,WebElement des) {
    Actions a=new Actions(driver);
    a.dragAndDrop(src, des).perform();
	}
    //movetoelements
    public static void moveToElement (WebElement e,WebElement tag) {
    Actions a=new Actions(driver);
    a.moveToElement(tag).perform();
	}
    
    //Select
    //SelectByIndex
    public static void selectByIndex(WebElement e,int index) {
    Select s=new Select(e);
    s.selectByIndex(1);
    }
    
    //DeselectByIndex
    public static void deSelectByValue(WebElement e,int index) {
    Select s=new Select(e);
    s.deselectByIndex(3);
	}
    

    //selectbyvisibletext
    public static void selectByVisibleText(WebElement e,String text ) {
    Select s=new Select(e);
    s.selectByVisibleText(getTitle());
	}
    
    //DeselectByVisibleText
    public static void DeSelectByVisibleText(WebElement e,String Text) {
    Select s=new Select(e);
    s.deselectByVisibleText(Text);
    
	}
    
    //SelectByValue
    public static void SelectByValue(WebElement e,String Value) {
     Select s=new Select(e);
     s.selectByValue(Value);
	}
     //deSelectByvalue
    public static void deSelectByValue(WebElement e,String value) {
    Select s=new Select (e);
    s.deselectByValue(value);
	}
    //getoption
    public static void getOptions(WebElement e,List options) {
    Select s=new Select(e);
    s.getOptions();
	}
    //deselect all
    public static void deSelectAll(WebElement e) {
    Select s=new Select(e);
    s.deselectAll();
	}
    public static WebElement login(WebElement login) {
		return login;
    	
	}
    //findElements
    public static  WebElement findElements(String LocatorName, String LocatorValue) {
    	
    	WebElement Value=null;
    	if(LocatorName.equals("id")) {
    		Value=driver.findElement(By.id(LocatorValue));
    		
    	}else if(LocatorName.equals("name")) {
    		Value=driver.findElement(By.name(LocatorValue));
    	}else if(LocatorName.equals("xpath")) {
    		Value=driver.findElement(By.xpath(LocatorValue));
    	}
		return Value;
    }
    
    
    //screenshot
    public static void ScreenShot(String name) throws IOException {
    TakesScreenshot tk=(TakesScreenshot)driver;
    File Src=tk.getScreenshotAs(OutputType.FILE);
    File des=new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenApril\\src\\test\\resources\\"+name+".png");
    FileUtils.copyFile(Src, des);
    }
    
    public static void jsSendKeys(WebElement e,String name) {
    JavascriptExecutor js=(JavascriptExecutor)driver;
    js.executeScript("arguments(0).setAttribute('value','"+name+"')", e);
	}
    
    public static String jsgetAttributes(WebElement e) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	Object atUser= js.executeScript("return arguments(0).getAttribute(value)", e);
    	String at = atUser.toString();
		return at;

	}
    
    
    
    
    	//Excel value
		public static  String getExcelData(String name,String sheetNam,int rowNo,int cellNo) throws IOException {
			
			File local=new File("C:\\Users\\LENOVO\\eclipse-workspace\\MavenApril\\src\\test\\resources\\Book1.xlsx");
					
			        FileInputStream fi=new FileInputStream(local);
					
					Workbook w=new XSSFWorkbook(fi);
					
					Sheet s = w.getSheet("Sheet1");
					
					Row r= s.getRow(3);
					
					Cell cell = r.getCell(2);
					
					int Type = cell.getCellType();
					String value=null;
					
					if(Type==1) {
						 value = cell.getStringCellValue();			
					}
					else {
						if(DateUtil.isCellDateFormatted(cell)){
							
							value =new SimpleDateFormat("DD-MMM-YYYY").format(cell.getDateCellValue());
						}
						else {
							 value = String.valueOf((long)cell.getNumericCellValue());
						}
					}
					return value;
					
					
					
					
					
					
					
		
	}
    
    
    
}
    
    
    
    
    
    
    
 
	
	















