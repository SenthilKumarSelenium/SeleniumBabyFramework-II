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

public class BabyTestSteps {
	
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
  public static String abc;
  public static DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
  public static Date date1 = new Date();
  public static String date23=dateFormat1.format(date1);
  public static pro_2 file = new pro_2();
  public static pro_1 obj = new pro_1(file.show());



  public static WebDriver browser() throws ParserConfigurationException, SAXException, IOException
  {
	  String browser=obj.ReadProperty("Browser");
	        if(browser.equals("Mozilla"))
	        {
	        	driver = new FirefoxDriver();
	        }
	        if(browser.equals("IE"))
	        {
	            System.setProperty("webdriver.ie.driver", "C:\\Users\\Sivakumar\\Downloads\\IEDriverServer.exe");
	            DesiredCapabilities capab = DesiredCapabilities.internetExplorer();
	            capab.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	            driver = new InternetExplorerDriver(capab); 
	        }
	        if(browser.equals("Chrome"))
	        {
        	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sivakumar\\Downloads\\chromedriver.exe");
	            DesiredCapabilities capab = DesiredCapabilities.chrome();
	            driver = new ChromeDriver(capab);
	        }
	        if(browser.equals("Safari"))
	        {
	        	 driver = new SafariDriver();
	        }
	        if(browser.equals("Opera"))
	        {
	        	DesiredCapabilities capabilities = DesiredCapabilities.opera();

	        	OperaProfile profile = new OperaProfile("C:\\Program Files");  // prepared profile
	        	capabilities.setCapability("opera.profile", profile);

	        	 driver = new OperaDriver(capabilities);
	        }
	        if(browser.equals("HTML Unit Driver"))
	        {
	        	driver = new HtmlUnitDriver();
	        }
	return driver;
  }
  
  public static String getTagValue(String sTag, Element eElement) {
      NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
      Node nValue = (Node) nlList.item(0);
      return nValue.getNodeValue();
   }
  
  public static Element testData(int i) throws ParserConfigurationException, SAXException, IOException
  {
	  File xmlFile = new File("src\\TestDataXML\\TestData.xml");
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
  
  public static String save(String url) throws ParserConfigurationException, SAXException, IOException
  {
	  System.out.println("mnsbdmnbcdbs,mbfm,bsdmnbmbm,sdnm,fn,m"+url);
	  abc=url;
	return url;
  }
    public static String start(int TD) throws IOException, ParserConfigurationException, SAXException
  {
	 driver=BabyTestSteps.browser();
	  try{
		  
	      baseUrl =obj.ReadProperty(abc);
	      driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
	      driver.manage().window().maximize();
	      driver.get(obj.ReadProperty(abc));
	      Report.heading();
		  Report.pass("application launches successfully","Nil",obj.ReadProperty(abc));
		  }catch(Exception e)
		  {
			  System.out.println("Error: "+e);
		  }
	return null;
  }
  
    public static void wait(int TD) 
    {	  try{
  			Thread.sleep(TD);
  			
  	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
    }
  
  public static void HDFCPLoginChildWindow(int TD) 
  {	  try{
			new HDFCPage();
			HDFCPage.ChildWindownavigation(TD);
			
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static void hdfcPMouseMove(int TD) 
  {	  try{
			new HDFCPage();
			HDFCPage.hdfcMouseMove(TD);
			
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static void fbLogin(int TD) 
  { try{
			new FaceBook();
			FaceBook.fbLogin(TD);
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static void fbRegistration(int TD) 
  { try{
			new FaceBook();
			FaceBook.fbRegistration(TD);
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static void fbRegistrationDrop(int TD) 
  { try{
			new FaceBook();
			FaceBook.fbRegistrationDropDown(TD);
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  public static void fbRegistrationDropFail(int TD) 
  { try{
			new FaceBook();
			FaceBook.fbRegistrationDropDownFail(TD);
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  
  public static void twitterLogin(int TD) 
  { try{
			new Twitter();
			Twitter.twitterLogin(TD);
	  }catch(Exception e) {  Report.fail("NIL","Error: "+e,"Nil"); }
  }
  
  

  public static String stop(int TD)
  {
	  try{
		    driver.quit();
		    bw.write("</table>");
		    bw.write("<hr>");
		    bw.write("<center><h2> Test Steps Status</h2></center>");
		    bw.write("<center><table border="+3+"");
		    Report.headingStatus();
		    Report.totalStatus();
		    
		    //Desktop.getDesktop().browse(f.toURI());
			  }catch(Exception e)
			  {
				  System.out.println("Error: "+e);
			  }
	return null;
  }
  
  
  public static void main(String ar[]) throws ParserConfigurationException, SAXException, IOException
  {
	  
  }
}
