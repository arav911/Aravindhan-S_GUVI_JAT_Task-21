package task_21_java;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameHandling_2 {

	public static void main(String[] args) throws Exception {
//		Setting up the Chrome Driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
//		Opening the nested frames URL
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		
//		Switching to the top frame
		driver.switchTo().frame("frame-top");
		
//		Verifying that there are three frames on this page
		List<WebElement> frames = driver.findElements(By.tagName("frame"));
		if(frames.size() == 3)
			System.out.println("Frames size verified successfully");
		else
			System.out.println("Frames size not matching as expected");
		
//		Switching to the left frame
		driver.switchTo().frame("frame-left");
//		Verifying that the left frame has a text "LEFT"
		String leftFrame = driver.findElement(By.tagName("body")).getText().trim();
		if(leftFrame.equals("LEFT"))
			System.out.println("LEFT Frame text verified successfully");
		else
			System.out.println("LEFT Frame text not matching as expected");
		
//		Switching back to the top frame
		driver.switchTo().parentFrame();
//		Switching to the middle frame
		driver.switchTo().frame("frame-middle");
//		Verifying that the middle frame has a text "MIDDLE"
		String middleFrame = driver.findElement(By.tagName("body")).getText().trim();
		if(middleFrame.equals("MIDDLE"))
			System.out.println("MIDDLE Frame text verified successfully");
		else
			System.out.println("MIDDLE Frame text not matching as expected");
		
//		Switching back to the top frame
		driver.switchTo().parentFrame();
//		Switching to the right frame
		driver.switchTo().frame("frame-right");
//		Verifying that the right frame has a text "RIGHT"
		String rightFrame = driver.findElement(By.tagName("body")).getText().trim();
		if(rightFrame.equals("RIGHT"))
			System.out.println("RIGHT Frame text verified successfully");
		else
			System.out.println("RIGHT Frame text not matching as expected");
		
//		Switching back to the top frame		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();
//		Switching to the bottom frame
		driver.switchTo().frame("frame-bottom");
//		Verifying that the bottom frame has a text "BOTTOM"
		String bottomFrame = driver.findElement(By.tagName("body")).getText().trim();
		if(bottomFrame.equals("BOTTOM"))
			System.out.println("BOTTOM Frame text verified successfully");
		else
			System.out.println("BOTTOM Frame text not matching as expected");

//		Switching back to the top frame
		driver.switchTo().parentFrame();
		
//		Verifying that the page title is "Frames"
		String title = driver.getTitle();
		if(title.equals("Frames"))
			System.out.println("Page Title verified successfully");
		else
			System.out.println("Page Title not matching as expected");

	}

}
