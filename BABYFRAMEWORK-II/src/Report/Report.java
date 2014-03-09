package Report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.http.conn.params.ConnManagerParams;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import XML.XMLMETHOD;
import BabyTestSteps.BabyTestSteps;
import Functionality.babyfunction;

public class Report extends BabyTestSteps{
	  static int i=0;
	  static int ii=0;
	  static int j=0;
	  static int a=0;
	  
	  public static void valueReset() throws IOException
	    {
		  ii=ii-ii;
		  System.out.println("pskk"+ii);
		  i=i-i;
		  System.out.println("pskk"+ii);
		  j=j-j;
		  System.out.println("pskk"+j);
		  a=a-a;
		  System.out.println("pskk"+a);
	    }
	  
	  public static void headingStatus() throws IOException
	    {
	  	  
	  	 
	  	  bw.write("<tr>");
	  	  bw.write("<th width="+50+" bgcolor ="+green+"><center>PASS</center></th>");
	  	  bw.write("<th width="+50+" bgcolor="+red+"><center>FAIL</center></th>");
	  	  bw.write("<th width="+150+" bgcolor="+Orange+"><center>Total Steps</center></th>");
	  	  bw.write("</tr>"); 
	    }
	    
	  public static void totalStatus() throws IOException
	    {
	  	  bw.write("<tr>");
	  	  bw.write("<td width="+50+"><font><center>"+i+"</center></font></td>");
	  	  bw.write("<td width="+50+"><font><center>"+j+"</center></font></td>");
	  	  a=i+j;
	  	  bw.write("<td width="+50+"><font><center>"+a+"</center></font></td>");
	  	  bw.write("</tr>"); 
	  	  bw.write("</body>");
		  bw.write("</html>");
		  bw.close();
	    }
	    

	 
	public static void heading() throws IOException
    {
  	  
  	 
  	  bw.write("<tr>");
  	  bw.write("<th width="+50+" bgcolor ="+gray+"><center>S.No</center></th>");
  	  bw.write("<th width="+75+" bgcolor ="+gray+"><center>Status</center></th>");
  	  bw.write("<th width="+500+" bgcolor="+gray+"><center>Test Steps</center></th>");
  	  bw.write("<th width="+250+" bgcolor="+gray+"><center>Selenium Objects</center></th>");
  	  bw.write("<th width="+200+" bgcolor="+gray+"><center>Test data</center></th>");
  	  bw.write("<th width="+150+" bgcolor ="+gray+"><center>Date/Time</center></th>");
  	  bw.write("</tr>"); 
    }
    
    public static void pass(String description, String boj, String TC) throws IOException
    {
  	  i=i+1;
  	  ii=ii+1;
	  System.out.println("sen"+i);
	  
  	  bw.write("<tr>");
  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
  	  bw.write("<td border="+2+" width="+50+"><font color="+green+"><b><center>Pass</center></b></font></td>");
  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
  	  bw.write("<td border="+2+" width="+300+">"+boj+"</td>");
  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
  	  DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
  	  Date date = new Date();
  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
  	  System.out.println(dateFormat.format(date));
  	  bw.write("</tr>"); 
  	System.out.println("kjashjkfdh");

    }
    
	  public static void fail(String description, String objects,String TC) throws IOException, ParserConfigurationException, SAXException
	    {
		  
		    String browser=obj.ReadProperty("Browser");
	        if(!browser.equals("HTML Unit Driver"))
	        {
	    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	     	 Date date = new Date();
	    	
	    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
	     	 Date date1 = new Date();
	     	//new File("FailReport\\").mkdir();
	    	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(scrFile, new File("Reports//"+date23+"//"+dateFormat1.format(date1)+"screenshot.png"));
	    	
		      j=j+1;
		      ii=ii+1;
		      System.out.println("sen"+j);
		  	  bw.write("<tr>");
		  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
		  	  bw.write("<td border="+2+" width="+50+">" +
		  	  		"<a href="+dateFormat1.format(date1)+"screenshot.png"+"><font color="+red+"><b><center>Fail</center></font></a></td>");
		  	  
		  	
		  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
		  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
		  	 
		  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
		  	  bw.write("</tr>"); 
	        }else
	        {
		    	 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		     	 Date date = new Date();
		    	
		    	 DateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
		     	 Date date1 = new Date();
		     	//new File("FailReport\\").mkdir();
		    	
			      j=j+1;
			      ii=ii+1;
			      System.out.println("sen"+j);
			  	  bw.write("<tr>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+black+"><b><center>"+ii+"</center></b></font></td>");
			  	  bw.write("<td border="+2+" width="+50+"><font color="+red+"><b><center>Fail</center></font></a></td>");
			  	  
			  	
			  	  bw.write("<td border="+2+" width="+300+">"+description+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+objects+"</td>");
			  	  bw.write("<td border="+2+" width="+300+">"+TC+"</td>");
			  	 
			  	  bw.write("<td width="+150+"><font color="+black+">"+dateFormat.format(date)+"</font></td>");
			  	  bw.write("</tr>"); 
	        }
	  
	  
}

}
