package BabyTestSteps;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Driver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Functionality.babyfunction;
import PropertyFile.pro_1;
import PropertyFile.pro_2;
import Report.Report;

import com.gargoylesoftware.htmlunit.javascript.host.Document;
import com.opera.core.systems.OperaDriver;
import com.opera.core.systems.OperaProfile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class FaceBook {
	
//  public static WebDriver driver = new FirefoxDriver();
  public static WebDriver driver;
  public static String baseUrl;
  public static BufferedWriter bw;
  public static File f;
  public static String gray="gray";  
  public static String red="red";  
  public static String green="green"; 
  public static String Yellow="Yellow";
  public static String Orange="Orange";
  public static String  black="black";
  public static String blue="blue";
  public static DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
  public static Date date1 = new Date();
  public static String date23=dateFormat1.format(date1);
  public static pro_2 file = new pro_2();
  public static pro_1 obj = new pro_1(file.show());
  public static pro_1 fb = new pro_1(file.fb());

  
  public static String getTagValue(String sTag, Element eElement) {
      NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
      Node nValue = (Node) nlList.item(0);
      return nValue.getNodeValue();
   }
  
  public static void wait(int TD) 
  {	  try{
			Thread.sleep(TD);
			
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static Element testData(int i) throws ParserConfigurationException, SAXException, IOException
  {
	  File xmlFile = new File("src\\TestDataXML\\FBTestData.xml");
	  DocumentBuilderFactory dbFactory1 =  DocumentBuilderFactory.newInstance();
	  DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
	  org.w3c.dom.Document doc1 =  dBuilder1.parse(xmlFile);
	  doc1.getDocumentElement().normalize();
	  NodeList nList1 = doc1.getElementsByTagName("TestData");
//	  System.out.println("senthilkumar: "+nList1.getLength());
	  Node nNode1 = nList1.item(i);
	  Element eElement1 = (Element) nNode1;
	return eElement1;
  }
  
  
  public static void dummyTestSteps(int TD) throws ParserConfigurationException, SAXException, IOException, InterruptedException
  {
			Element testData1=testData(TD);
		    babyfunction.babyinput_id(obj.ReadProperty("usrename"), "User name", getTagValue("username", testData1));
		    babyfunction.babyinput_id(obj.ReadProperty("password"), "Password", getTagValue("password", testData1));
		    babyfunction.babyclick_id(obj.ReadProperty("login"), "Login", "Nil");
		    wait(10000);
		    
  }
  
  public static void fbLogin(int TD) throws ParserConfigurationException, SAXException, IOException, InterruptedException
  {
	        Element testData1=testData(TD);
		    babyfunction.babyinput_id(fb.ReadProperty("fbEmail"), "Enter FB User name", getTagValue("username", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbPassword"), "Enter FB Password", getTagValue("password", testData1));
		    babyfunction.babyclick_id(fb.ReadProperty("fbRemembermeCheckbox"), "Click rememberme Button", "Nil");
		    babyfunction.babyclick_id(fb.ReadProperty("fbLogin"), "Click Login Button", "Nil");
		    wait(10000);
		    //Error message Validation
		    babyfunction.babySave_xpath(fb.ReadProperty("fbloginErrorMessage"), "Invalid Error message validation", "The password you entered is incorrect. Please try again (make sure your caps lock is off).");
		    
  }
  
  public static void fbRegistration(int TD) throws ParserConfigurationException, SAXException, IOException, InterruptedException
  {
	        Element testData1=testData(TD);
		    babyfunction.babyinput_id(fb.ReadProperty("fbFirstname"), "Enter First name", getTagValue("FirstName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbLastName"), "Enter Last Name", getTagValue("LastName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbmailId"), "Enter Mail ID", getTagValue("mailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbReenterMailid"), "Enter Mail OID again", getTagValue("Reentermailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbnewPassword"), "Enter Confirm Password", getTagValue("Password", testData1));
		    
		    babyfunction.babyDropboxSelectXpath(fb.ReadProperty("fbMonthSelect"), "Drop down select Month", "Nil");
		    babyfunction.babyDropboxSelectXpath(fb.ReadProperty("fbDaySelect"), "Drop down select Month", "Nil");
		    babyfunction.babyDropboxSelectXpath(fb.ReadProperty("fbYearSelect"), "Drop down select Month", "Nil");
		    
		    babyfunction.babyclick_id(fb.ReadProperty("fbGender"), "Click gender option", "Nil");
		    babyfunction.babyclick_id(fb.ReadProperty("fbsignup"), "Click signup Button", "Nil");
		    wait(10000);
		    babyfunction.babySave_xpath(fb.ReadProperty("fbRegisterError"), "Invalid Error message validation", "There is an existing account associated with this email.");
		    
  }
  
  public static void fbRegistrationDropDown(int TD) throws ParserConfigurationException, SAXException, IOException, InterruptedException
  {
	        Element testData1=testData(TD);
		    babyfunction.babyinput_id(fb.ReadProperty("fbFirstname"), "Enter First name", getTagValue("FirstName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbLastName"), "Enter Last Name", getTagValue("LastName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbmailId"), "Enter Mail ID", getTagValue("mailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbReenterMailid"), "Enter Mail OID again", getTagValue("Reentermailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbnewPassword"), "Enter Confirm Password", getTagValue("Password", testData1));
		    
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbMonthSelectid"), "Drop down select Month", getTagValue("month", testData1));
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbDaySelectid"), "Drop down select day", getTagValue("day", testData1));
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbYearSelectid"), "Drop down select year", getTagValue("year", testData1));
		    
		    babyfunction.babyclick_id(fb.ReadProperty("fbGender"), "Click gender option", "Nil");
		    babyfunction.babyclick_id(fb.ReadProperty("fbsignup"), "Click signup Button", "Nil");
		    wait(10000);
		    babyfunction.babySave_xpath(fb.ReadProperty("fbRegisterError"), "Invalid Error message validation", "There is an existing account associated with this email.");
  }
  
  public static void fbRegistrationDropDownFail(int TD) throws ParserConfigurationException, SAXException, IOException, InterruptedException
  {
	        Element testData1=testData(TD);
		    babyfunction.babyinput_id(fb.ReadProperty("fbFirstname"), "Enter First name", getTagValue("FirstName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbLastName"), "Enter Last Name", getTagValue("LastName", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbmailId"), "Enter Mail ID", getTagValue("mailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbReenterMailid"), "Enter Mail OID again", getTagValue("Reentermailid", testData1));
		    babyfunction.babyinput_id(fb.ReadProperty("fbnewPassword"), "Enter Confirm Password", getTagValue("Password", testData1));
		    
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbMonthSelectid"), "Drop down select Month", getTagValue("month", testData1));
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbDaySelectid"), "Drop down select day", getTagValue("day", testData1));
		    babyfunction.babyDropSelect_ID(fb.ReadProperty("fbYearSelectid"), "Drop down select year", getTagValue("year", testData1));
		    
		    babyfunction.babyclick_id(fb.ReadProperty("fbGender"), "Click gender option", "Nil");
		    babyfunction.babyclick_id(fb.ReadProperty("fbsignup"), "Click signup Button", "Nil");
		    wait(10000);
		    babyfunction.babySave_xpath(fb.ReadProperty("fbRegisterError"), "Invalid Error message validation", "Fail-There is an existing account associated with this email.");
		    
  }
}
