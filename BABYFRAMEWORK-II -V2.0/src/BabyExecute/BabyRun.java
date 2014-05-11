package BabyExecute;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
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

import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.SeleneseTestCase;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverBackedSelenium;
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
	
	  public static pro_2 file = new pro_2();
	  public static pro_1 objj = new pro_1(file.show());
	  
	public static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();
		Node nValue = (Node) nlList.item(0);
		return nValue.getNodeValue();
	}

	public static void main(String ar[]) {
		try {

			Class noparams[] = {};
			Class cls = Class.forName("BabyTestSteps.BabyTestSteps");
			Object obj = cls.newInstance();

			File xmlFile = new File("src\\ModuleXML\\Modules.xml");
			DocumentBuilderFactory dbFactory1 = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder1 = dbFactory1.newDocumentBuilder();
			Document doc1 = dBuilder1.parse(xmlFile);
			doc1.getDocumentElement().normalize();
			NodeList nList1 = doc1.getElementsByTagName("Module");
			
			for (int iii = 0; iii <= nList1.getLength() - 1; iii++) {
				Node nNode1 = nList1.item(iii);
				if (nNode1.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement1 = (Element) nNode1;
					String testCaseActive1 = getTagValue("Active", eElement1);
					
					String modulename = getTagValue("ModuleName", eElement1);
					
					if (testCaseActive1.equalsIgnoreCase("YES")) {
						String url = getTagValue("url", eElement1);
						new BabyTestSteps().save(url);
						new File("Reports\\" + date23).mkdir();
						// new
						// File("Reports\\"+date23+"\\SummaryReport\\").mkdir();
						Date date2 = new Date();
						String date233=dateFormat1.format(date2);
						File ff = new File("Reports\\" + date23 + "\\"
								+ modulename +date233+ "_Module Summary_.htm");
						BufferedWriter bww = new BufferedWriter(new FileWriter(
								ff));
						
						/*FileChannel ic = new FileInputStream("C:\\Users\\Sivakumar\\Desktop\\123.jpg").getChannel();
						FileChannel oc = new FileOutputStream("Reports\\" + date23 + "\\123.jpg").getChannel();
						ic.transferTo(0, ic.size(), oc);*/
						
						bww.write("<html>");
						bww.write("<body bgcolor =" + "#d4d4d4" + ">");
						bww.write("<center><h3>SUMMARY REPORT</h3></center>");
						bww.write("<hr>");
						
						bww.write("<center><table border=" + 5 + " >");
						/*String path="123.jpg";
						//bww.write("<img src="+path+">");
						bww.write("<th width=" + 250
								+ " ><center><img src="+path+"></center></th>");
						bww.write("<th width=" + 250 + " ><center><img src="+path+"></center></th>");
						bww.write("</center></table border=" + 5 + " >");*/
						
						
						bww.write("<center><table border=" + 5 + " >");
						bww.write("<th width=" + 250
								+ " ><center>Module Name:</center></th>");
						bww.write("<th width=" + 250 + " ><center>"
								+ modulename + "</center></th>");
		/*				String path="C:\\Users\\Sivakumar\\Desktop\\123.jpg";
						bww.write("<img src="+path+">");*/
						bww.write("</center></table border=" + 5 + " >");
						bww.write("<center><table border=" + 5 + " >");
						bww.write("<th width=" + 250
								+ " ><center>Browser Name:</center></th>");
						pro_2 file = new pro_2();
						pro_1 objj = new pro_1(file.show());
						String browser = objj.ReadProperty("Browser");
						bww.write("<th width=" + 250 + " ><center>" + browser
								+ "</center></th>");
						// bw.write("</tr>");
						bww.write("</center></table border=" + 5 + " >");
						// bww.write("<center><h2>Summary Report_Module Name: "+modulename+"</h2></center>");
						bww.write("<hr>");
						// bw.write("<center><h2>Test Case ID: "+TestCaseID+"</h2></center>");
						bww.write("<center><table border=" + 5 + " >");
						bww.write("<tr>");
						bww.write("<th width="
								+ 250
								+ " bgcolor ="
								+ gray
								+ "><center>Execution Report PASS/FAIL</center></th>");
						bww.write("<th width=" + 250 + " bgcolor =" + gray
								+ "><center>TestCase Name</center></th>");
						bww.write("<th width=" + 250 + " bgcolor =" + gray
								+ "><center>TestData Set</center></th>");
						/*bww.write("<th width=" + 250 + " bgcolor =" + gray
								+ "><center>URL</center></th>");*/
						bww.write("<th width=" + 250 + " bgcolor =" + gray
								+ "><center>Date/Time</center></th>");
						bww.write("</tr>");

						
						xmlFile = new File("src\\TestCaseXML\\" + modulename
								+ ".xml");
						DocumentBuilderFactory dbFactory = DocumentBuilderFactory
								.newInstance();
						DocumentBuilder dBuilder = dbFactory
								.newDocumentBuilder();
						Document doc = dBuilder.parse(xmlFile);
						doc.getDocumentElement().normalize();
						NodeList nList = doc.getElementsByTagName("TC");
//						System.out
//								.println("senthilkumar: " + nList.getLength());
						for (int i = 0; i <= nList.getLength() - 1; i++) {
							Node nNode = nList.item(i);
							if (nNode.getNodeType() == Node.ELEMENT_NODE) {
								Element eElement = (Element) nNode;
								String testCaseActive = getTagValue("Active",
										eElement);
								if (testCaseActive.equalsIgnoreCase("YES")) {
									String url1 = getTagValue("TestSteps",
											eElement);
									String TestCaseID = getTagValue(
											"TestCaseID", eElement);
									String TestCaseSet = getTagValue("TCSET",
											eElement);

									String spli1[] = url1.split(",");
									// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@REPOPRT@@@@@@@@@@@@@@@@@@@@@@@@@//
									Date date3 = new Date();
									
									
									String date234=dateFormat1.format(date3);
									f = new File("Reports\\" + date23 + "\\"
											+ TestCaseID+date234 + ".htm");
									bw = new BufferedWriter(new FileWriter(f));
									bw.write("<html>");
									bw.write("<body  bgcolor =" + "#d4d4d4"
											+ ">");

									bw.write("<center><h3>EXECUTION REPORT</h3></center>");
									bw.write("<hr>");
									bw.write("<center><table border=" + 5
											+ " >");
									// bw.write("<tr>");
									bw.write("<th width="
											+ 250
											+ " ><center>Module Name:</center></th>");
									bw.write("<th width=" + 250 + " ><center>"
											+ modulename + "</center></th>");
									bw.write("</center></table border=" + 5
											+ " >");
									bw.write("<center><table border=" + 5
											+ " >");
									bw.write("<th width="
											+ 250
											+ " ><center>TestCase ID:</center></th>");
									bw.write("<th width=" + 250 + " ><center>"
											+ TestCaseID + "</center></th>");
									// bw.write("</tr>");
									bw.write("</center></table border=" + 5
											+ " >");

									// /
									// bw.write("<center><h2>Module Name: "+modulename+" ---- Test Case ID: "+TestCaseID+"</h2></center>");
									bw.write("<hr>");
									// bw.write("<center><h2>Test Case ID: "+TestCaseID+"</h2></center>");
									bw.write("<table border=" + 5 + " ");
									bw.write("<hr>");
									// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@REPOPRT@@@@@@@@@@@@@@@@@@@@@@@@@//
//									System.out.println("PSKKKKKKK" + spli1[0]);
//									System.out.println("PSKKKKKKK" + spli1[1]);
									// System.out.println("PSKKKKKKK"+spli1[2]);

									int jj = Integer.parseInt(TestCaseSet);
									for (int ii = 0; ii <= spli1.length - 1; ii++) {
										System.out.println("Test Step name: "+ spli1[ii]);
										Method method = cls.getDeclaredMethod(
												spli1[ii], int.class);
										method.invoke(obj, jj);
//										System.out.println("Method Name is: "
//												+ spli1[ii]);
									}

								
									bww.write("<tr>");
									int count = new Report().count();
									if (count > 0) {
										// bww.write("<td width="+50+" bgcolor ="+red+"><font><center>FAIL</center></font></td>");
										bww.write("<td border="
												+ 2
												+ " width="
												+ 50
												+ ">"
												+ "<a href="
												+ ""
												+ TestCaseID+date234
												+ ".htm"
												+ "><font color="
												+ red
												+ "><b><center>FAIL Report</center></font></a></td>");

										bww.write("<td width=" + 50
												+ "><font><center>"
												+ TestCaseID
												+ "</center></font></td>");
										bww.write("<td width=" + 50
												+ "><font><center>"
												+ TestCaseSet
												+ "</center></font></td>");
										/*bww.write("<td width=" + 50
												+ "><font><center>"
												+ objj.ReadProperty(url)
												+ "</center></font></td>");*/
										DateFormat dateFormat1 = new SimpleDateFormat(
												"yyyy/MM/dd HH:mm:ss");
										Date date = new Date();
										bww.write("<td width=" + 150
												+ "><font color=" + black + ">"
												+ dateFormat1.format(date)
												+ "</font></td>");
										
									} else {
										
										bww.write("<td border="
												+ 2
												+ " width="
												+ 50
												+ ">"
												+ "<a href="
												+ ""
												+ TestCaseID+date234
												+ ".htm"
												+ "><font color="
												+ green
												+ "><b><center>PASS Report</center></font></a></td>");

										// bww.write("<td width="+50+" bgcolor ="+green+"><font><center>PASS</center></font></td>");
										bww.write("<td width=" + 50
												+ "><font><center>"
												+ TestCaseID
												+ "</center></font></td>");
										bww.write("<td width=" + 50
												+ "><font><center>"
												+ TestCaseSet
												+ "</center></font></td>");
										DateFormat dateFormat2 = new SimpleDateFormat(
												"yyyy/MM/dd HH:mm:ss");
										Date date = new Date();
										bww.write("<td width=" + 150
												+ "><font color=" + black + ">"
												+ dateFormat2.format(date)
												+ "</font></td>");
									}
									
								

									Report.valueReset();
								}
								if (i == nList.getLength() - 1) {
									
									bww.write("</tr>");
									bww.write("</table>");
									bww.write("</body>");
									bww.write("</html>");
									bww.close();
									Desktop.getDesktop().browse(ff.toURI());
								}
							}
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println("error: " + e);
		}
	}

}
