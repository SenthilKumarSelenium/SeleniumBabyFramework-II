package Functionality;
 
import java.awt.Robot;
import java.io.IOException;
import java.net.URLDecoder;
 
import javax.xml.parsers.ParserConfigurationException;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;
 
import BabyTestSteps.BabyTestSteps;
import Report.Report;
 
 
public class babyfunction extends BabyTestSteps{
               
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void babyclick_id(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using name///////////////////////        
                public static void babyclick_name(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.name(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.name(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                Thread.sleep(2000);
                                } catch (InterruptedException e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using xpath///////////////////////        
                public static void babyclick_xpath(String objects,String description, String testData)
                {
                                try{
//                                //System.out.println("sen");
                                int count=driver.findElements(By.xpath(objects)).size();
//                                //System.out.println("senn`"+count);
                                if(count==1)
                                {
                                                //System.out.println("kumar");
                                                driver.findElement(By.xpath(objects)).click();
                                                Report.pass( description,  objects, testData);
                                }else
                                {
                                                Report.fail(description+" Object not available",  objects, testData);
                                }
                                }
                                catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Click by using LinkText///////////////////////  
                public static void babyclick_LinkText(String objects, String description,
                                                String testData){
                                try {
                                int count = driver.findElements(By.linkText(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.linkText(objects)).click();
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                               
                                                Thread.sleep(2000);
                                }catch (InterruptedException e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
 
/////////////////////////////////////////Click by using ID///////////////////////               
                public static void babyinput_id(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.id(objects)).sendKeys(testData);;
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
/////////////////////////////////////////Input by using name///////////////////////      
public static void babyinput_name(String objects, String description,
                                String testData){
                try {
                int count = driver.findElements(By.name(objects)).size();
                if (count == 1) {
                                driver.findElement(By.name(objects)).sendKeys(testData);;
                                Report.pass(description, objects, testData);
                } else {
                                Report.fail(description+" Object not available", objects, testData);
                }
               
                                Thread.sleep(2000);
                } catch (Exception e) {
                                Report.fail("Error: "+e, "Nil", "Nil");
                }
}

/////////////////////////////////////////Drop Down Selection Through Xpath(No test data)///////////////////////  

                public static void babyDropboxSelectXpath(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                String dropText =  driver.findElement(By.xpath(objects)).getText();
                                                String[] drop=objects.split("/option");
                                                new Select(driver.findElement(By.xpath(drop[0]))).selectByVisibleText(dropText);
                                               
                                                Report.pass(description, objects, dropText);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }

               
/////////////////////////////////////////Input by using xpath///////////////////////                  
                public static void babyinput_xpath(String objects, String description,
                                                String testData){
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                driver.findElement(By.xpath(objects)).sendKeys(testData);;
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
                
                
/*/////////////////////////////////////////Input by using xpath///////////////////////      
                public static void babyinputBack_xpath(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                                for(int i=0;i<=10;i++)
                                                                {
                                                                driver.findElement(By.xpath(objects)).sendKeys(Keys.BACK_SPACE);
                                                                }
                                                                driver.findElement(By.xpath(objects)).clear();
                                                               
                                                driver.findElement(By.xpath(objects)).sendKeys(testData);
                                                Report.pass(description, objects, testData);
                                } else {
                                                Report.fail(description+" Object not available", objects, testData);
                                }
               
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }*/
               
               
/////////////////////////////////////////Save Text by using xpath///////////////////////             
                public static void babySave_xpath(String objects, String description,
                                                String testData)  {
                                try {
                                String runtimeText="";;
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                runtimeText=driver.findElement(By.xpath(objects)).getText();
                                                //System.out.println("pppppppppppppppppppppp"+runtimeText.trim());
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
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
/*                public static String babySave_xpathReturn(String objects, String description,
                                                String testData) throws IOException, ParserConfigurationException,
                                                SAXException {
                                String runtimeText="";;
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                                runtimeText=driver.findElement(By.xpath(objects)).getText();
                                                //System.out.println("Save Text"+runtimeText.trim());
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                try {
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                                return runtimeText;
}*/
                
                ////////String Compare/////////////////////   
               
                public static void stringCompare(String error1, String error2,String objects, String description,
                                                String testData)  {
                                try {
                                if (error1.trim().equals(error2.trim())) {
                                                Report.pass("Expected error message is available: " + error2, objects ,testData);
                                } else {
                                                Report.fail("Expected error message is not available: " + error2, objects ,testData);
                                }
                               
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
               
/////////////////////////////////////////Save Text by using id///////////////////////     
                public static void babySave_id(String objects, String description,
                                                String testData)  {
                                try {
                                String runtimeText = "";
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                runtimeText = driver.findElement(By.id(objects)).getText();
                                                //System.out.println("pppppppppppppppppppppp" + runtimeText.trim());
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
                               
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
/////////////////////////////////////////Save Text by using name///////////////////////             
                public static void babySave_name(String objects, String description,
                                                String testData) {
                                try{
                                String runtimeText = "";
                                int count = driver.findElements(By.name(objects)).size();
                                if (count == 1) {
                                                runtimeText = driver.findElement(By.name(objects)).getText();
                                                //System.out.println("pppppppppppppppppppppp" + runtimeText.trim());
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
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
                
                ////////Drop Down Select/////////////////////   
               
                public static void babyDropSelect_ID(String objects, String description,
                                                String testData) {
                                try{
                                String runtimeText = "";
                                int count = driver.findElements(By.id(objects)).size();
                                if (count == 1) {
                                                new Select(driver.findElement(By.id(objects))).selectByVisibleText(testData);        
                                                Report.pass("Dro down selected successfully " + testData, objects,
                                                        testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                Thread.sleep(5000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
              
                ////////Mouse Moving verification/////////////////////   
               
                public static void babyMouseMove_Xpath(String objects, String description,
                                                String testData)  {
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                if (count == 1) {
                                               
                                                  WebElement MainMenu;
                          //WebElement SubMenu;
                          MainMenu = driver.findElement(By.xpath(objects));
                          //SubMenu = driver.findElement(By.xpath("//span/span[contains(.,'PAGs, PAs & Accounts')]"));
                          Actions builder = new Actions(driver);  
                           // Move cursor to the Main Menu Element  
                          builder.moveToElement(MainMenu).perform();
                          // Waiting For the Submenu to Display          
                          
                                                                Report.pass("Mouse moving success ", objects, testData);
                                               
                                }else{
                                                Report.fail(description + " Object not available", objects,              testData);
                                }
                                Thread.sleep(3000);}catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
               
                
                ////////Child Window navigation/////////////////////   
                
                public static void babyNavigateChildWIndow(String objects, String description,
                                                String testData) {
                                try{
                                //boolean blnExpectedWindowFound=false;
                                Thread.sleep(5000);
                                for (String handle : driver.getWindowHandles()) {
                                                driver.switchTo().window(handle);
                                                Thread.sleep(3000);
                                                String strCurrentUrl = driver.getCurrentUrl();
                                                //Decoding the URL
                                                String strDecodedUrl=URLDecoder.decode(strCurrentUrl, "US-ASCII");
                                                if ((strDecodedUrl.toUpperCase()).indexOf(testData.toUpperCase())!=-1){
                                                                //blnExpectedWindowFound=true;
                                                                try {
                                                                                ((JavascriptExecutor) driver).executeScript("window.focus();");
                                                                                driver.manage().window().maximize();
                                                                                Report.pass("Child window navigation Success", objects, testData);
                                                                } catch (Exception ex){
                                                                                Report.fail("Child window not available: "+testData, objects, testData);
                                                                }
                                                                break;
                                                }
                                } 
                                Thread.sleep(3000);}catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
               
              
                
                ////////Object available validation/////////////////////   
               
                public static void babyObjectXpathYes(String objects, String description,
                                                String testData) {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                //System.out.println("KKK:"+count);
                                if (count == 1) {
                                                Report.pass(description + " Object available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                               
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
                
                
          ////////Object not available validation/////////////////////      
                
                public static void babyObjectXpathNO(String objects, String description,
                                                String testData)  {
                                try {
                                int count = driver.findElements(By.xpath(objects)).size();
                                //System.out.println("KKK:"+count);
                                if (count == 0) {
                                                Report.pass(description + " Object not available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object available", objects,
                                                                                testData);
                                }
                               
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
                
                
   /*             public static void babyDataMatch(String objects, String description,String testData) {
                try{
                                String splitt[]=objects.split("!");
     int rowcount1 = driver.findElements(By.xpath(splitt[0])).size();
     int rowcount2 = driver.findElements(By.xpath(splitt[1])).size();
                if(rowcount1==rowcount2)
                {
                                Report.pass("Expected data count is available both-- list box count is: "+rowcount1+" and Table view count is: "+rowcount2,description,testData);
                               
                }else
                {
                                Report.fail("Expected data count is not available both-- list box count is: "+rowcount1+" and Table view count is: "+rowcount2,description,testData);
                }
                   }catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
                */
                
///Browser back validation///////////////////                
                public static void babyBrowserback_xpath(String objects, String description,
                                                String testData)  {
                                try{
                                int count = driver.findElements(By.xpath(objects)).size();
                                //System.out.println("KKK:"+count);
                                if (count == 1) {
                                                Thread.sleep(3000);
                                                driver.navigate().back();
                                                Report.pass(description + " Object available", objects,
                                                                                testData);
                                } else {
                                                Report.fail(description + " Object not available", objects,
                                                                                testData);
                                }
                                                Thread.sleep(2000);
                                } catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
}
               
   
              
              ///Page Scroll Down///////////////////             
                 
                public static void babyScrollDownEnd() {
                                try{
                                Robot robot=new Robot();
                                robot.keyPress(java.awt.event.KeyEvent.VK_END);
                                robot.keyRelease(java.awt.event.KeyEvent.VK_END);
                                Thread.sleep(3000);}
                                catch (Exception e) {
                                                Report.fail("Error: "+e, "Nil", "Nil");
                                }
                }
               
}