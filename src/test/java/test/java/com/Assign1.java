package test.java.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.Cell;

public class Assign1 {
	public static void main(String[] args) throws IOException, InterruptedException {
		//launching the driver and initialising the file(read)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sethu\\eclipse-workspace\\FaceBook\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		File f = new File("C:\\Users\\sethu\\eclipse-workspace\\FaceBook\\InputSheet\\Junit1_excel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Sheet2");
		//inspecting the elements
		WebElement fName=driver.findElement(By.id("firstName"));
        WebElement lName=driver.findElement(By.id("lastName"));
        WebElement email=driver.findElement(By.id("userEmail"));
        WebElement gender= driver.findElement(By.id("gender-radio-1"));
        WebElement dob= driver.findElement(By.id("dateOfBirthInput"));
        WebElement hobbies = driver.findElement(By.xpath("//label[text()='Sports']"));
        WebElement mobile=driver.findElement(By.id("userNumber"));
        WebElement address=driver.findElement(By.id("currentAddress"));
        WebElement submitBtn=driver.findElement(By.id("submit"));
        //import data from excel
        int numberOfRows = s.getPhysicalNumberOfRows();
		Row row = s.getRow(1);
		int numberOfCells = row.getPhysicalNumberOfCells();
        for(int i=0;i<numberOfRows;i++)
        {Thread.sleep(3000);
        	fName.sendKeys(s.getRow(i).getCell(0).getStringCellValue());
            lName.sendKeys(s.getRow(i).getCell(1).getStringCellValue());
            email.sendKeys(s.getRow(i).getCell(2).getStringCellValue());
            //mobile.sendKeys(s.getRow(i).getCell(4).getStringCellValue());
            address.sendKeys(s.getRow(i).getCell(8).getStringCellValue());
            Thread.sleep(2000);
            //gender.click();
            //hobbies.click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click()", gender);
            Thread.sleep(5000);
           js.executeScript("arguments[0].click()", hobbies);
            Thread.sleep(5000);
         //  submitBtn.click();
            js.executeScript("arguments[0].click()", submitBtn);
        }
		
		
		
		
		
		
		
		
		
		
		
		
		
		//question 1 to 3
		/*Sheet s = w.getSheet("Sheet1");
		int numberOfRows = s.getPhysicalNumberOfRows();
		System.out.println("the no of rows is "+numberOfRows);
		Row row = s.getRow(1);
		//System.out.println(row);
		int numberOfCells = row.getPhysicalNumberOfCells();
		System.out.println("the no of columns is "+numberOfCells);
		for(int i =0;i<numberOfRows;i++)
		{
			for(int j=0;j<numberOfCells;j++)
			{
				Row r=s.getRow(i);
				Cell c= r.getCell(j);
				System.out.println(c);
				
			}
		}
		Row createRow = s.createRow(11);
		createRow.createCell(0).setCellValue("KKKKK");
		createRow.createCell(1).setCellValue("SAP-ABAP");
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\sethu\\\\eclipse-workspace\\\\FaceBook\\\\InputSheet\\\\Junit1_excel.xlsx");
		w.write(fos);
		w.close();*/
		//question-4
				/*Sheet s = w.getSheet("Sheet2");
				int numberOfRows = s.getPhysicalNumberOfRows();
				Row row = s.getRow(1);
				int numberOfCells = row.getPhysicalNumberOfCells();
				for(int i =0;i<numberOfRows;i++)
				{
					for(int j=0;j<numberOfCells;j++)
					{
						Row r=s.getRow(i);
						Cell c= r.getCell(j);
						System.out.println(c);
						
					}
				}*/
		/*//question-5
		Sheet s = w.createSheet("AdactInfo");
		XSSFRow row1 = (XSSFRow) s.createRow(0);
		row1.createCell(0).setCellValue("Username");
		row1.createCell(1).setCellValue("Password");
		row1.createCell(2).setCellValue("Locations");
		row1.createCell(3).setCellValue("Hotels");
		row1.createCell(4).setCellValue("RoomType");
		row1.createCell(5).setCellValue("no of Rooms");
		row1.createCell(6).setCellValue("check-in-date");
		row1.createCell(7).setCellValue("check-out-date");
		row1.createCell(8).setCellValue("adults per room");
		row1.createCell(9).setCellValue("children per room");
		row1.createCell(10).setCellValue("First name");
		row1.createCell(11).setCellValue("Last Name");
		row1.createCell(12).setCellValue("Billing Address");
		row1.createCell(13).setCellValue("credit card no");
		row1.createCell(14).setCellValue("credit card type");
		row1.createCell(15).setCellValue("select month");
		row1.createCell(16).setCellValue("select year");
		row1.createCell(17).setCellValue("cvv no");
		XSSFRow row2 = (XSSFRow) s.createRow(1);
		row2.createCell(0).setCellValue("dharanisekar2106");
		row2.createCell(1).setCellValue("test@1234");
		row2.createCell(2).setCellValue("Sydney");
		row2.createCell(3).setCellValue("Hotel Creek");
		row2.createCell(4).setCellValue("Deluxe");
		row2.createCell(5).setCellValue("1-One");
		row2.createCell(6).setCellValue("16/04/2021");
		row2.createCell(7).setCellValue("16/04/2021");
		row2.createCell(8).setCellValue("1-One");
		row2.createCell(9).setCellValue("1-One");
		row2.createCell(10).setCellValue("Dharani");
		row2.createCell(11).setCellValue("Surya");
		row2.createCell(12).setCellValue("Chennai");
		row2.createCell(13).setCellValue("1234567890123450");
		row2.createCell(14).setCellValue("VISA");
		row2.createCell(15).setCellValue("June");
		row2.createCell(16).setCellValue("2021");
		row2.createCell(17).setCellValue("123");
		FileOutputStream fos = new FileOutputStream("C:\\\\Users\\\\sethu\\\\eclipse-workspace\\\\FaceBook\\\\InputSheet\\\\Junit1_excel.xlsx");
		w.write(fos);
		w.close();
		System.out.println("Data written done");*/
				
}}
