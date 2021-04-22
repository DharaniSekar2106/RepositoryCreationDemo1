package adact.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookData extends ExcelInteg {
	public static void main(String[] args) throws IOException,Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\Day_9_Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(getData(1,0));	
		driver.findElement(By.id("pass")).sendKeys(getData(1,1));	
		driver.findElement(By.name("login")).click();
		String title = driver.getTitle();
		System.out.println(title);
		String text = driver.findElement(By.className("_9ay7")).getText();
		System.out.println(text);
}
}
