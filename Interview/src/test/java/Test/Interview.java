package Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Interview {

static WebDriver driver = new ChromeDriver();
	
	public static void Childswitch() {
		
		Set <String> window = driver.getWindowHandles();
		Iterator <String> it = window.iterator();
		String Parent = it.next();
		String child = it.next();
		driver.switchTo().window(child);
	
	} 
	
	public static void Parentswitch() {
		
		Set <String> window = driver.getWindowHandles();
		Iterator <String> it = window.iterator();
		String Parent = it.next();
		driver.switchTo().window(Parent);
	}
	
	@Test
	public static void mainmethod() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.Driver","C:\\web driver\\chromedriver.exe");
		
		driver.manage().window().maximize();
		driver.get("https://auth.dev.vntech.io");
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Cookies 
		driver.findElement(By.xpath("//button[text()='Accept All']")).click();  
				
		//Sign Up the page
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		
		//Continue with Google Account
				driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb oXtfBe-l4eHX']")).click();
				
				Childswitch();
			
				//Enter mail id
				driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("gowtham248999");
				
				
				//next 
				driver.findElement(By.xpath("//span[text()='Next']")).click();
				
				//driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
				//Enter mail password 
				driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("testpassword");
				
				//next button
				driver.findElement(By.xpath("//span[text()='Next']"));
			
		
		//Confirm the account
		driver.findElement(By.xpath("//div[text()='Confirm']")).click();
		
		/*****Login Again into Web************/
		
		Thread.sleep(1000);
		
		driver.switchTo().newWindow(WindowType.WINDOW);
	
		//Continue with Google Account
		driver.findElement(By.xpath("//div[@class='nsm7Bb-HzV7m-LgbsSe-bN97Pc-sM5MNb oXtfBe-l4eHX']")).click();
		
		Childswitch();
		
		//Enter mail id
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("gowthamr");
		
		
		//next 
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		//Enter mail password 
		driver.findElement(By.xpath("//input[@name='Passwd']")).sendKeys("ddgkmail");
		
		//next button
		driver.findElement(By.xpath("//span[text()='Next']"));
		
		//Driver need to switch again into Viral Nation 
	    Parentswitch();
	    
        // Output 1- Check by using page title
	    String ActulPageTitle = driver.getTitle();
		String ExpectPageTitle = "Viral Nation";         // Just for knowledge purpose
		if(ActulPageTitle.equals("Viral Nation") == true)
		{
			System.out.print("Page Launched successfully");
		}
		else {
			System.out.print("Page not launch");
		}
		
		//Output -2 Check by using page URL
		System.out.println("Current page URL " +driver.getCurrentUrl());
		
		//Output - 3 Check by using screen shot
		File snip = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(snip, new File ("D:\\RBC.viralnationpage.png"));
		
		driver.quit();
	}


}
