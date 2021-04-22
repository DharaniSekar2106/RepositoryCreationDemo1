package adact.com;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NaukriRegistrationDEmo extends ExcelInteg {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\Day_9_Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://my.naukri.com/account/register/basicdetails");
		driver.findElement(By.xpath("//button[contains(text(),'I am a Professional')]")).click();;//Professional
		driver.findElement(By.id("fname")).sendKeys(getData(1,0));//name
		driver.findElement(By.xpath("//input[@placeholder='Enter your active email id to receive relevant jobs']")).sendKeys(getData(1,1));;//email
		driver.findElement(By.xpath("//input[@placeholder='Minimum 6 characters']")).sendKeys(getData(1,2));;//password
		driver.findElement(By.xpath("//input[@placeholder='Where recruiter can contact you']")).sendKeys(getData(1,3));;//mobile no
		
		List<WebElement> list = driver.findElements(By.xpath("//ul[contains(@class,'droopeCont listing')]//li//div"));
		
		//List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'transcluded')]//span"));
		//List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'experience ddwn')]//div//ul//li//div//label"));
		System.out.println(list.size());

		//to select particular value from dropdown without select class
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("1"))
			{
				list.get(i).click();
				break;
			}
		}

	}

}
