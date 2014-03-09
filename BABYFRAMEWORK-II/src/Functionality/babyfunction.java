package Functionality;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.xml.sax.SAXException;

import BabyTestSteps.BabyTestSteps;
import Report.Report;


public class babyfunction extends BabyTestSteps{
	
/////////////////////////////////////////Click by using ID///////////////////////	
	public static void babyclick_id(String objects, String description,
			String testData) throws IOException, ParserConfigurationException, SAXException {
		int count = driver.findElements(By.id(objects)).size();
		if (count == 1) {
			driver.findElement(By.id(objects)).click();
			Report.pass(description, objects, testData);
		} else {
			Report.fail(description+" Object not available", objects, testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/////////////////////////////////////////Click by using name///////////////////////	
	public static void babyclick_name(String objects, String description,
			String testData) throws IOException, ParserConfigurationException, SAXException {
		int count = driver.findElements(By.name(objects)).size();
		if (count == 1) {
			driver.findElement(By.name(objects)).click();
			Report.pass(description, objects, testData);
		} else {
			Report.fail(description+" Object not available", objects, testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
/////////////////////////////////////////Click by using xpath///////////////////////	
	public static void babyclick_xpath(String objects,String description, String testData) throws IOException, ParserConfigurationException, SAXException
	{
		
		System.out.println("sen");
		int count=driver.findElements(By.xpath(objects)).size();
		System.out.println("senn`"+count);
		if(count==1)
		{
			System.out.println("kumar");
			driver.findElement(By.xpath(objects)).click();
			Report.pass( description,  objects, testData);
		}else
		{
			Report.fail(description+" Object not available",  objects, testData);
		}
	}
/////////////////////////////////////////Click by using LinkText///////////////////////	
	public static void babyclick_LinkText(String objects, String description,
			String testData) throws IOException, ParserConfigurationException, SAXException {
		int count = driver.findElements(By.linkText(objects)).size();
		if (count == 1) {
			driver.findElement(By.linkText(objects)).click();
			Report.pass(description, objects, testData);
		} else {
			Report.fail(description+" Object not available", objects, testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////Click by using ID///////////////////////	
	public static void babyinput_id(String objects, String description,
			String testData) throws IOException, ParserConfigurationException, SAXException {
		int count = driver.findElements(By.id(objects)).size();
		if (count == 1) {
			driver.findElement(By.id(objects)).sendKeys(testData);;
			Report.pass(description, objects, testData);
		} else {
			Report.fail(description+" Object not available", objects, testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
/////////////////////////////////////////Input by using name///////////////////////	
public static void babyinput_name(String objects, String description,
		String testData) throws IOException, ParserConfigurationException, SAXException {
	int count = driver.findElements(By.name(objects)).size();
	if (count == 1) {
		driver.findElement(By.name(objects)).sendKeys(testData);;
		Report.pass(description, objects, testData);
	} else {
		Report.fail(description+" Object not available", objects, testData);
	}
	try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
/////////////////////////////////////////Input by using xpath///////////////////////	
	public static void babyinput_xpath(String objects, String description,
			String testData) throws IOException, ParserConfigurationException, SAXException {
		int count = driver.findElements(By.xpath(objects)).size();
		if (count == 1) {
			driver.findElement(By.xpath(objects)).sendKeys(testData);;
			Report.pass(description, objects, testData);
		} else {
			Report.fail(description+" Object not available", objects, testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

/////////////////////////////////////////Save Text by using xpath///////////////////////	
	public static void babySave_xpath(String objects, String description,
			String testData) throws IOException, ParserConfigurationException,
			SAXException {
		String runtimeText="";;
		int count = driver.findElements(By.xpath(objects)).size();
		if (count == 1) {
			runtimeText=driver.findElement(By.xpath(objects)).getText();
			System.out.println("pppppppppppppppppppppp"+runtimeText.trim());
			if(runtimeText.trim().equals(testData))
			{
				Report.pass("Expected text is available: "+testData, objects, testData);
			}else
			{
				Report.fail("Expected text is not available: "+testData, objects,testData);
			}
			//Report.pass(description, objects, testData);
		} else {
			Report.fail(description + " Object not available", objects,
					testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
	
/////////////////////////////////////////Save Text by using id///////////////////////	
	public static void babySave_id(String objects, String description,
			String testData) throws IOException, ParserConfigurationException,
			SAXException {
		String runtimeText = "";
		;
		int count = driver.findElements(By.id(objects)).size();
		if (count == 1) {
			runtimeText = driver.findElement(By.id(objects)).getText();
			System.out.println("pppppppppppppppppppppp" + runtimeText.trim());
			if (runtimeText.trim().equals(testData)) {
				Report.pass("Expected text is available: " + testData, objects,
						testData);
			} else {
				Report.fail("Expected text is not available: " + testData,
						objects, testData);
			}
			// Report.pass(description, objects, testData);
		} else {
			Report.fail(description + " Object not available", objects,
					testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
/////////////////////////////////////////Save Text by using name///////////////////////	
	public static void babySave_name(String objects, String description,
			String testData) throws IOException, ParserConfigurationException,
			SAXException {
		String runtimeText = "";
		;
		int count = driver.findElements(By.name(objects)).size();
		if (count == 1) {
			runtimeText = driver.findElement(By.name(objects)).getText();
			System.out.println("pppppppppppppppppppppp" + runtimeText.trim());
			if (runtimeText.trim().equals(testData)) {
				Report.pass("Expected text is available: " + testData, objects,
						testData);
			} else {
				Report.fail("Expected text is not available: " + testData,
						objects, testData);
			}
			// Report.pass(description, objects, testData);
		} else {
			Report.fail(description + " Object not available", objects,
					testData);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
