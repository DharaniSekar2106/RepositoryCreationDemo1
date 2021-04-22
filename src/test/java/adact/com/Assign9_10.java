package adact.com;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assign9_10 extends ExcelInteg {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\Day_9_Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://adactinhotelapp.com/");
		driver.findElement(By.id("username")).sendKeys(getData(1,0));;//username
		driver.findElement(By.id("password")).sendKeys(getData(1,1));;//password
		driver.findElement(By.id("login")).click();;//login
		
		WebElement ddLocation = driver.findElement(By.id("location"));
		Select sel = new Select(ddLocation);
		sel.selectByVisibleText(getData(1,2));
		
		WebElement ddHotel = driver.findElement(By.id("hotels"));
		Select sel1 = new Select(ddHotel);
		sel1.selectByVisibleText(getData(1,3));
		Thread.sleep(3000);
		WebElement ddRoom = driver.findElement(By.id("room_type"));
		Select sel2 = new Select(ddRoom);
		sel2.selectByValue(getData(1,4));
		Thread.sleep(3000);
		WebElement ddNoRooms = driver.findElement(By.id("room_nos"));
		Select sel3 = new Select(ddNoRooms);
		sel3.selectByValue(getData(1,5));

		driver.findElement(By.id("datepick_in")).sendKeys("04/19/2021");//check-in-date
		driver.findElement(By.id("datepick_out")).sendKeys("04/20/2021");//check-out-date
		Thread.sleep(3000);
		
		WebElement ddAdultsPerRoom = driver.findElement(By.id("adult_room"));
		Select sel4 = new Select(ddAdultsPerRoom);
		sel4.selectByValue(getData(1,6));
		Thread.sleep(3000);
		
		WebElement ddChildPerRoom = driver.findElement(By.id("child_room"));
		Select sel5 = new Select(ddChildPerRoom);
		sel5.selectByValue(getData(1,7));
		Thread.sleep(3000);
		
		driver.findElement(By.id("Submit")).click();  //search button
  		Thread.sleep(3000);
  		
  		driver.findElement(By.id("radiobutton_0")).click();;  //radio-button
  		driver.findElement(By.id("continue")).click();;  //continue button
  		
  		driver.findElement(By.id("first_name")).sendKeys(getData(1,8));;  //firstname
  		driver.findElement(By.id("last_name")).sendKeys(getData(1,9));;  //lastname
  		driver.findElement(By.id("address")).sendKeys(getData(1,10));; // billing address
  		driver.findElement(By.id("cc_num")).sendKeys(getData(1,11));;  //credit card no
  		
  		WebElement ddCreditCardType = driver.findElement(By.id("cc_type"));
  		Select sel6 = new Select(ddCreditCardType);
  		sel6.selectByValue(getData(1,12));
  		
  		WebElement expiryMonth = driver.findElement(By.id("cc_exp_month"));
  		Select sel7 = new Select(expiryMonth);
  		sel7.selectByValue(getData(1,13));
  		
  		WebElement expiryYear = driver.findElement(By.id("cc_exp_year"));
  		Select sel8 = new Select(expiryYear);
  		sel8.selectByValue(getData(1,14));
  		
  		driver.findElement(By.id("cc_cvv")).sendKeys(getData(1,15));;  //cvv no
  		driver.findElement(By.id("book_now")).click();  //book now button
  		Thread.sleep(5000);
  
  		WebElement order = driver.findElement(By.name("order_no"));
  		Thread.sleep(5000);
  		//String attribute = order.getAttribute("value");
  		//System.out.println("the order no is "+attribute);
}}
