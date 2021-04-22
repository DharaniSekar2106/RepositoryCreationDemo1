package test.java.com;

import java.util.ArrayList;
import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClassMethods {
	public static final String String = null;
	public static final WebElement WebElement = null;
	 static  WebElement ele1 ;
	static Select sel;
	static WebDriver driver;
	static JavascriptExecutor jse;
	static WebElement ele;
	static Actions a;
	static Alert al = driver.switchTo().alert();;
	static Scanner s = new Scanner(System.in);

	public static void selectDriver()// methods-1,2,3
	{
		System.out.println("enter the driver options:");
		int int1 = s.nextInt();
		System.out.println("the chosen driver option  is" + int1);
		if (int1 == 1)
			getChromeDriver();// method-1
		else if (int1 == 2)
			getIEDriver();// method-2
		else if (int1 == 3)
			getMicrosoftEdgeDriver();// method-3
		else
			System.out.println("please include reusable methods for other drivers alos!!");
	}

	public static void getMicrosoftEdgeDriver() {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\Selenium1\\Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
}

	public static void getIEDriver() {
		System.setProperty("webdriver.ie.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\Selenium1\\Driver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
	}

	public static void getChromeDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sethu\\eclipse-workspace\\FaceBook\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	

	// method-4
	public String launchUrl(String url) {
		driver.get(url);
		return url;
	}

	// method-5
	public String currentUrl(String url) {
		return driver.getCurrentUrl();
	}

	// method-6
	public String getTitle(String title) {
		return driver.getTitle();
	}

	// method-7
	public String windowHandle(String windowHandle) {
		String windowHandle1 = driver.getWindowHandle();
		return windowHandle1;
	}

	// method-8
	public Set<String> windowHandles(String windowHandle) {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}

	// method-9
	public static void insertKeys(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	// method-10
	public static void click(WebElement ele) {
		ele.click();
	}

	// method-11
	public static void switchToParentWindow() {
		driver.switchTo().defaultContent();
	}
	//methods-12,13,14,15
	public static int switchToFramesTypes(int type) {

		java.lang.String name = null;
		int index = 0;
		WebElement ele = null;
		java.lang.String id = null;
		if (type == 1)
			switchToFrameById(id);
		else if (type == 2)
			switchToFrameByName(name);
		else if (type == 3)
			switchToFrameByWebElement(ele);
		else if (type == 4)
			switchToFrameByIndex(index);
		else {
			System.out.println("return to parentwindow itself");
			switchToParentWindow();
		}
		return type;

	}

	public static void switchToFrameByName(String name) {
		driver.switchTo().frame(name);
	}

	public static void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}

	public static void switchToFrameByWebElement(WebElement ele) {
		driver.switchTo().frame(ele);
	}

	public static void switchToFrameById(String id) {
		driver.switchTo().frame(id);
	}
	//method-16
	public static void initialiseSelect() {
	sel= new Select(WebElement);}
	//method-17
	public static void selectByIndex(int index) {
		sel.selectByIndex(index);
	}
	//method-18
	public static void deselectByIndex(int index) {
		sel.deselectByIndex(index);
	}
	//method-19
	public static void selectByValue(String value) {
		sel.selectByValue(value);
	}
	//method-20
	public static void deselectByValue(String value) {
		sel.deselectByValue(value);
	}
	//method-21
	public static void selectByVisibleText(String text) {
		sel.selectByVisibleText(text);
	}
	//method-22
	public static void deselectByVisibleText(String text) {
		sel.deselectByVisibleText(text);
	}
	//method-23
	public static void selectAll()
	{
		sel.deselectAll();
	}
	//method-24
	public static void windowByUrl(String url)
	{
		driver.switchTo().window(url);
	}
	//method-25
	public static void windowByTitle(String title)
	{
		driver.switchTo().window(title);
	}
	//method-26
	public static void windowByWindowsId(String WindowsId)
	{
		driver.switchTo().window(WindowsId);
	}
	//method-27
	public static void javaScriptExecutorSetUp()
	{
		 jse = (JavascriptExecutor) driver;
	}
	//method-28
	public static void setAttribute(String text,WebElement ele)
	{
		String executeScript = (String) jse.executeScript("arguments[0].setAttribute('value','text')", ele);
		System.out.println(executeScript);
	}
	//method-29
	public static void getAttribute(String text,WebElement ele)
	{
		String executeScript = (String) jse.executeScript("arguments[0].getAttribute('value','text')", ele);
		System.out.println(executeScript);
	}
	//method-30
	public static void clickUsingJavaScriptExecutor(WebElement ele)
	{
		jse.executeScript("arguments[0].click", ele);
	}
	//method-31
	public static void scrollDown(WebElement ele)
	{
		jse.executeScript("arguments[0].scrollIntoView(true)", ele);
	}
	//method-32
	public static void scrollUp(WebElement ele)
	{
		jse.executeScript("arguments[0].scrollIntoView(false)", ele);
	}
	//method-33
	public static void closeBrowser()
	{
		driver.close();
	}
	//method-34
	public static void quitBrowser()
	{
		driver.quit();
	}
	//method-35
	public static void pageSource()
	{
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);
	}
	//method-36
	public static void manage()
	{
		driver.manage().deleteAllCookies();
	}
	//method-37
	public static void refresh()
	{
		driver.navigate().refresh();
	}
	//method-38
	public static Point setSize(Point p)
	{
		Point p1 = new Point(500,500);
		driver.manage().window().setPosition(p1);
		return p;
	}
	//method-39
	public static void clear()
	{
		ele.clear();
	}
	//method-40
	public static void getOptions()
	{
	java.util.List<WebElement> list = sel.getOptions();
	System.out.println(list);
	}
	//method-41
	public static String getText(String text)
	{
		ele.getText();
		return text;
	}
	//method-41
	public static String getAttribute(String textContent)
	{
		ele.getAttribute(textContent);
		return textContent;
	}
	//method-42
	public static void mouseAction()
	{
		 a = new Actions(driver);
		a.moveToElement(ele).perform();
	}
	//method-43
	public static void dragDrop()
	{
		a.dragAndDrop(ele, ele1).perform();
	}
	//method-44
	public static void rightClick()
	{
		a.contextClick(ele).perform();
	}
	//method-45
	public static void dragDrop1()
	{
		a.clickAndHold(ele).moveToElement(ele1).release().perform();
	}
	//method-46
	public static void doubleClick()
	{
		a.doubleClick(ele).perform();
	}
	//method-47
	 public static  void handleSimpleAlert()
	{
		   al.accept();
	}
	 //method-48
	 public static  void handleConfirmAlert()
		{
			  int i = 0;
			  System.out.println("enter the way to handle to confirm alert");
			  System.out.println("**enter '0'/'1' to 'accept'/'dismiss'**");
			  int nextInt = s.nextInt();
			  System.out.println(nextInt);
			  if(i==0)
			  al.accept();
			  else
			  al.dismiss();
		}
	 //method-49
	 public static  void handlePromptAlert()
		{
			  int i = 0;
			  System.out.println("enter the text to handle prompt alert in the text box");
			  insertKeys(ele,String);
			  System.out.println("enter the way to handle to prompt alert");
			  System.out.println("**enter '0'/'1' to 'accept'/'dismiss'**");
			  if(i==0)
			  al.accept();
			  else
			  al.dismiss();
		}
	 //method-50
	 public static void copyPaste() throws AWTException
	 {
		 Robot rb = new Robot();
		 //copy
		 rb.keyPress(KeyEvent.VK_CONTROL);
		 rb.keyPress(KeyEvent.VK_C);
		 rb.keyRelease(KeyEvent.VK_C);
		 rb.keyRelease(KeyEvent.VK_CONTROL);
		 //paste
		 rb.keyPress(KeyEvent.VK_CONTROL);
		 rb.keyPress(KeyEvent.VK_V);
		 rb.keyRelease(KeyEvent.VK_V);
		 rb.keyRelease(KeyEvent.VK_CONTROL);
	}
	 
}
