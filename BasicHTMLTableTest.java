import org.junit.Test;
import org.junit.Before;


import org.junit.jupiter.api.AfterAll;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BasicHTMLTableTest {
    private static WebDriver chrome;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        chrome = new ChromeDriver();
        js = (JavascriptExecutor) chrome;
        vars = new HashMap<String, Object>();
    }


    @Test
    public void testingDynamicTableCaptionUpdate() {

        try {
            chrome.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
            chrome.manage().window().setSize(new Dimension(2000, 2000));

            JOptionPane.showMessageDialog(null, "Testing the caption field with text : 'name'",
                    "testingDynamicTableCaptionUpdate ", JOptionPane.INFORMATION_MESSAGE);

            chrome.findElement(By.name("caption")).sendKeys("name");

            // Click the Refresh button
            chrome.findElement(By.id("refreshtable")).click();

            WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

            String captionName = chrome.findElement(By.tagName("caption")).getText();



            // Verify that the table data has been updated
            assertTrue(captionName.contains("name"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testingDynamicTableIDUpdate() {

        try {
            chrome.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
            chrome.manage().window().setSize(new Dimension(2000, 2000));

            JOptionPane.showMessageDialog(null, "Testing the Id field with text : 'tableid' " ,
                    "testingDynamicTableIDUpdate ", JOptionPane.INFORMATION_MESSAGE);

            chrome.findElement(By.id("tableid")).sendKeys("TableName");


            chrome.findElement(By.id("refreshtable")).click();

            WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

            String idName = chrome.findElement(By.cssSelector("#dynamictablefghfgh")).getText();

            // table data updated or not
            assertTrue(idName.contains("TableName"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testingIsDataOnTableUpdatedOnModifyingTableDataInJSONFormat (){
        try {
            chrome.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
            chrome.manage().window().setSize(new Dimension(2000, 2000));

            JOptionPane.showMessageDialog(null, "Testing the name and age column fields with updated name and age data ",
                    "testingIsDataOnTableUpdatedOnModifyingTableDataInJSONFormat ", JOptionPane.INFORMATION_MESSAGE);


            WebElement jsonDataInput = chrome.findElement(By.id("jsondata"));
            jsonDataInput.clear();
            jsonDataInput.sendKeys("[{\"name\" : \"Bob\", \"age\" : 20}, {\"name\": \"George\", \"age\" : 42}]");


            chrome.findElement(By.id("refreshtable")).click();


            WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")));


            assertEquals("Bob", chrome.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")).getText());

            jsonDataInput.clear();
            jsonDataInput.sendKeys("[{\"name\" : \"Kokushibu\", \"age\" : 200}, {\"name\": \"Akaza\", \"age\" : 170},{\"name\": \"Douma\", \"age\" : 140}]");

            chrome.findElement(By.id("refreshtable")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")));

            assertEquals("Kokushibu", chrome.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(1)")).getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @AfterAll
    public static void afterEach(){
        chrome.close();
    }
}
