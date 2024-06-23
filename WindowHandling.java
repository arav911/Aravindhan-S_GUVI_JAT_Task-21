package task_21_java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Opening the Window Handler URL
		driver.get("https://the-internet.herokuapp.com/windows");
		
//		Clicking the "Click Here" button to open New Window
		driver.findElement(By.linkText("Click Here")).click();
		
//		Switching to newly opened window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);
		
//		Verifying that the "New Window" is present on the page
		String actualText = driver.findElement(By.tagName("h3")).getText();
		if(actualText.equals("New Window"))
			System.out.println("\"New Window\" - Text matches successfully");
		else
			System.out.println("\"New Window\" - Text not matches");

//		Closing the new window
		driver.close();
		
//		Verifying that the original window is active
		driver.switchTo().window(parentWindow);
		if(driver.getTitle().equals("The Internet"))
			System.out.println("Original Window is active");
		else
			System.out.println("Original Window is not active");
		
//		Closing the original window instance
		driver.close();
		
	}

}
