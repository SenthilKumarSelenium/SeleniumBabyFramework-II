package BabyExecute;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import BabyTestSteps.BabyTestSteps;
import PropertyFile.pro_1;
import PropertyFile.pro_2;
import PropertyFile.pro_1;
import PropertyFile.pro_2;
import Report.Report;
import XML.XMLMETHOD;

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class BabyRun extends BabyTestSteps {
	
	public static void main(String ar[]) throws IOException
	{
		try{

		   	Class noparams[] = {};
			Class cls = Class.forName("BabyTestSteps.BabyTestSteps");
			Object obj = cls.newInstance();
			
			    File xmlFile = new File("src\\ModuleXML\\Modules.xml");
		        DocumentBuilderFactory dbFactory1 =  DocumentBuilderFactory.newInstance();
		        DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
		        Document doc1 = dBuilder1.parse(xmlFile);
		        doc1.getDocumentElement().normalize();
		        NodeList nList1 = doc1.getElementsByTagName("Module");
		        System.out.println("senthilkumar: "+nList1.getLength());
		        for(int iii=0;iii<=nList1.getLength()-1;iii++)
		        {
		        Node nNode1 = nList1.item(iii);
			        if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
			        Element eElement1 = (Element) nNode1;
			        String testCaseActive1=new XMLMETHOD().getTagValue("Active", eElement1);
			        System.out.println("oopop"+testCaseActive1);
			        String modulename=new XMLMETHOD().getTagValue("ModuleName", eElement1);  
			        System.out.println("oopop"+modulename);
			                if(testCaseActive1.equalsIgnoreCase("YES"))
			                {
			                	System.out.println("kkkkkkkk"+modulename);
								    xmlFile = new File("src\\TestCaseXML\\"+modulename+".xml");
							        DocumentBuilderFactory dbFactory =  DocumentBuilderFactory.newInstance();
							        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
							        Document doc = dBuilder.parse(xmlFile);
							        doc.getDocumentElement().normalize();
							        NodeList nList = doc.getElementsByTagName("TC");
							        System.out.println("senthilkumar: "+nList.getLength());
							        for(int i=0;i<=nList.getLength()-1;i++)
							        {
							        Node nNode = nList.item(i);
								        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								        Element eElement = (Element) nNode;
								        String testCaseActive=new XMLMETHOD().getTagValue("Active", eElement);
										        if(testCaseActive.equalsIgnoreCase("YES"))
										        {
										        String url=new XMLMETHOD().getTagValue("TestSteps", eElement);
										        String TestCaseID=new XMLMETHOD().getTagValue("TestCaseID", eElement);
										        
										        String spli1[]=url.split(",");
										      //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@REPOPRT@@@@@@@@@@@@@@@@@@@@@@@@@//
								      			  new File("Reports\\"+date23).mkdir();
								      			  f = new File("Reports\\"+date23+"\\"+modulename+""+TestCaseID+".htm");
								      		      bw = new BufferedWriter(new FileWriter(f));
								      		      bw.write("<html>");
								      		      bw.write("<body  bgcolor ="+"#d4d4d4"+">");
								      		      bw.write("<center><h2>Module Name: "+modulename+" ---- Test Case ID: "+TestCaseID+"</h2></center>");
								      		      bw.write("<hr>");
								      		      //bw.write("<center><h2>Test Case ID: "+TestCaseID+"</h2></center>");
								      		      bw.write("<table border="+5+" ");
								      		      bw.write("<hr>");
								      		   //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@REPOPRT@@@@@@@@@@@@@@@@@@@@@@@@@//
										        System.out.println("PSKKKKKKK"+spli1[0]);
										        System.out.println("PSKKKKKKK"+spli1[1]);
										        //System.out.println("PSKKKKKKK"+spli1[2]);
										        
											        for(int ii=0;ii<=spli1.length-1;ii++)
											        {
													Method method = cls.getDeclaredMethod(spli1[ii], noparams);
													method.invoke(obj, null); 
											        	System.out.println("kumarsenthil: "+spli1[ii]);
											        }
											        Report.valueReset();
										        }
								         }
								    }
			                }
			        }
		        }
		}catch(Exception e)
		{
			System.out.println("error: "+e);
		}
  }

}
