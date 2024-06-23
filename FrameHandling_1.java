package task_21_java;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling_1 {

	public static void main(String[] args) throws Exception {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
//		Maximizing the window
		driver.manage().window().maximize();
//		Opening the iframe URL
		driver.get("https://the-internet.herokuapp.com/iframe");
		
//		Switching to the iframe using XPath
		WebElement frame = driver.findElement(By.xpath("//*[@title='Rich Text Area']"));
		driver.switchTo().frame(frame);
		
//		Locating the "p" tag inside iframe and writing the text "Hello People"
		WebElement element = driver.findElement(By.tagName("p"));
		element.sendKeys("Hello People");
		Thread.sleep(4000);
		
//		Closing the browser instance
		driver.close();
		

	}

}
