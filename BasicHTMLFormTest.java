import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import javax.swing.*;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BasicHTMLFormTest
{

    static WebDriver chrome ;

    @BeforeAll
    public static void beforeEach(){
        System.setProperty("webdriver.chrome.driver","F:\\chromedriver_win32\\chromedriver.exe" );
        ChromeOptions options  = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        chrome = new ChromeDriver(options);


    }

    @Test
    public void testingUsernameField(){


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please write the username : 'Elon Musk' on the username field within 30s  " +
                        "and click on the Submit button to proceed with the test.",
                "testingUsernameField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.name("username")).sendKeys("Elon Musk");
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String usernameResult = chrome.findElement(By.id("_valueusername")).getText();
        assertNotNull(usernameResult);
        assertTrue(usernameResult.contains("Elon Musk"));



    }

    @Test
    public  void testingPasswordField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please write the password : '#_superman@0' on the password field within 30s  " +
                        "and click on the Submit button to proceed with the test.",
                "testingPasswordField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.name("password")).sendKeys("#_superman@0");
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String passwordResult = chrome.findElement(By.id("_valuepassword")).getText();
        assertNotNull(passwordResult);
        assertTrue(passwordResult.contains("#_superman@0"));
    }
    @Test
    public void testingCommentField() {
        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please write the text: 'I am a developer' in the comment field and click on the Submit button within 30 seconds to proceed with the test.", "Testing Comment Field", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.name("comments")).sendKeys("I am a developer");
        chrome.findElement(By.name("submitbutton")).click();

        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String commentFieldResult = chrome.findElement(By.id("_valuecomments")).getText();
        assertNotNull(commentFieldResult);
        assertTrue(commentFieldResult.contains("I am a developer"));
    }


    @Test
    public  void testingFirstRadioField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select first radio field within 30s  " +
                        "and click on the Submit button to proceed with the test.",
                "testingFirstRadioField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[1]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String firstRadioFieldResult = chrome.findElement(By.id("_valueradioval")).getText();
        assertNotNull(firstRadioFieldResult);

        assertEquals("rd1",firstRadioFieldResult);
    }

    @Test
    public  void testingSecondRadioField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select second radio field within 30s  " +
                        "and click on the Submit button to proceed with the test.",
                "testingSecondRadioField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[2]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String secondRadioFieldResult = chrome.findElement(By.id("_valueradioval")).getText();
        assertNotNull(secondRadioFieldResult);

        assertEquals("rd2",secondRadioFieldResult);
    }

    @Test
    public  void testingUploadFileField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select a pdf file with name 'STLC_NOTES.pdf' within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingUploadFileField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.name("filename")).sendKeys("C:\\Users\\pc\\Documents\\STLC_NOTES.pdf");
        chrome.findElement(By.name("submitbutton")).click();

        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String fileName = chrome.findElement(By.id("_filename")).getText();
        assertNotNull(fileName);
        assertTrue(fileName.contains("STLC_NOTES.pdf"));

    }
    @Test
    public  void testingThirdRadioField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");


        JOptionPane.showMessageDialog(null, "Please select third radio field within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingThirdRadioField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[6]/td/input[3]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String thirdRadioFieldResult = chrome.findElement(By.id("_valueradioval")).getText();
        assertNotNull(thirdRadioFieldResult);

        assertEquals("rd3",thirdRadioFieldResult);
    }
    @Test
    public  void testingFirstCheckBoxField()  {

        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select first checkbox fields within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingFirstCheckBoxField ", JOptionPane.INFORMATION_MESSAGE);


        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String firstCheckBoxResult = chrome.findElement(By.id("_valuecheckboxes0")).getText();
        assertNotNull(firstCheckBoxResult);
        assertTrue(firstCheckBoxResult.contains("cb1"));

    }
    @Test
    public  void testingSecondCheckBoxField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select second checkbox fields within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingSecondCheckBoxField ", JOptionPane.INFORMATION_MESSAGE);


        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String secondCheckBoxResult = chrome.findElement(By.id("_valuecheckboxes0")).getText();
        assertNotNull(secondCheckBoxResult);
        assertTrue(secondCheckBoxResult.contains("cb2"));

    }
    @Test
    public  void testingThirdCheckBoxField()  {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select third checkbox fields within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingThirdCheckBoxField ", JOptionPane.INFORMATION_MESSAGE);

        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[3]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        String thirdCheckBoxResult = chrome.findElement(By.id("_valuecheckboxes0")).getText();
        assertNotNull(thirdCheckBoxResult);
        assertTrue(thirdCheckBoxResult.contains("cb3"));

    }
    @Test
    public  void testingAllThreeCheckBoxField()  {

        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select all the checkbox field within 30s " +
                "and click on the Submit button to proceed with the test.",
                "testingAllThreeCheckBoxField ", JOptionPane.INFORMATION_MESSAGE);



        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[1]")).click();
        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[2]")).click();
        chrome.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[5]/td/input[3]")).click();
        chrome.findElement(By.name("submitbutton")).click();


        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String[] expectedResults = {"cb1", "cb2", "cb3"};
        String[] actualResults = new String[3];


        actualResults[0] = chrome.findElement(By.id("_valuecheckboxes0")).getText();
        actualResults[1] = chrome.findElement(By.id("_valuecheckboxes1")).getText();
        actualResults[2] = chrome.findElement(By.id("_valuecheckboxes2")).getText();

        assertArrayEquals(expectedResults, actualResults);
    }

    @Test
    public void testMultipleSelect() {

        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        // Select the second, third, and fourth options in the multiple select dropdown list
        Select dropdown = new Select(chrome.findElement(By.name("multipleselect[]")));
        dropdown.selectByValue("ms2");
        dropdown.selectByValue("ms3");
        dropdown.selectByValue("ms4");

        // Click the submit button
        chrome.findElement(By.name("submitbutton")).click();

        // Wait for the form processor page to load
        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        // Verify that the selected options are displayed in the form processor page
        String[] expectedValues = {"ms2", "ms3", "ms4"};
        String[] actualValues = new String[3];
        actualValues[0] = chrome.findElement(By.id("_valuemultipleselect0")).getText();
        actualValues[1] = chrome.findElement(By.id("_valuemultipleselect1")).getText();
        actualValues[2] = chrome.findElement(By.id("_valuemultipleselect2")).getText();
        assertArrayEquals(expectedValues, actualValues);
    }

    @Test
    public void testingDropdownList() {


        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "Please select third option : 'Drop Down Item 3'  within 30s " +
                        "and click on the Submit button to proceed with the test.",
                "testingDropdownList ", JOptionPane.INFORMATION_MESSAGE);



        Select dropdown = new Select(chrome.findElement(By.name("dropdown")));
        dropdown.selectByValue("dd3");


        chrome.findElement(By.name("submitbutton")).click();

        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));


        WebElement selectedOption = chrome.findElement(By.id("_valuedropdown"));
        String expectedValue = "dd3";
        String actualValue = selectedOption.getText();
        assertEquals(expectedValue, actualValue);
    }
    @Test
    public void testingTheWholeForm() {

        chrome.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        JOptionPane.showMessageDialog(null, "To test the whole form provide input values as specified - \n" +
                        "username = \"Elon Musk\"\n" +
                        "password = \"#_superman@0\"\n" +
                        "comments = \"I am a developer\"\n" +
                        "filePath = \"C:\\\\Users\\\\pc\\\\Documents\\\\STLC_NOTES.pdf\"\n"+
                         "expectedCheckboxes = {\"cb1\", \"cb2\", \"cb3\"}\n"+
                        "expectedDropdownValues = {\"dd1\", \"dd2\", \"dd3\"}\n"+
                         "expectedMultipleSelectValues = {\"ms1\", \"ms2\", \"ms3\"}"
        );




        String username = "Elon Musk";
        String password = "#_superman@0";
        String comments = "I am a developer";
        String filePath = "C:\\Users\\pc\\Documents\\STLC_NOTES.pdf";
        String[] expectedCheckboxes = {"cb1", "cb2", "cb3"};
        String[] expectedDropdownValues = {"dd1", "dd2", "dd3"};
        String[] expectedMultipleSelectValues = {"ms1", "ms2", "ms3"};

        chrome.findElement(By.name("username")).sendKeys(username);
        chrome.findElement(By.name("password")).sendKeys(password);
        chrome.findElement(By.name("comments")).sendKeys(comments);
        chrome.findElement(By.name("filename")).sendKeys(filePath);

        for (int i = 0; i < expectedCheckboxes.length; i++) {
            chrome.findElement(By.cssSelector("input[value='" + expectedCheckboxes[i] + "']")).click();
        }

        Select dropdown = new Select(chrome.findElement(By.name("dropdown")));
        for (int i = 0; i < expectedDropdownValues.length; i++) {
            dropdown.selectByValue(expectedDropdownValues[i]);
        }

        Select multipleSelect = new Select(chrome.findElement(By.name("multipleselect[]")));
        for (int i = 0; i < expectedMultipleSelectValues.length; i++) {
            multipleSelect.selectByValue(expectedMultipleSelectValues[i]);
        }

        chrome.findElement(By.name("submitbutton")).click();

        WebDriverWait wait = new WebDriverWait(chrome, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.urlToBe("https://testpages.herokuapp.com/styled/the_form_processor.php"));

        String[] actualCheckboxes = new String[3];
        actualCheckboxes[0] = chrome.findElement(By.id("_valuecheckboxes0")).getText();
        actualCheckboxes[1] = chrome.findElement(By.id("_valuecheckboxes1")).getText();
        actualCheckboxes[2] = chrome.findElement(By.id("_valuecheckboxes2")).getText();

        assertArrayEquals(expectedCheckboxes, actualCheckboxes);

        WebElement selectedOption = chrome.findElement(By.id("_valuedropdown"));
        String actualDropdownValue = selectedOption.getText();
        assertTrue(Arrays.asList(expectedDropdownValues).contains(actualDropdownValue));

        String[] actualMultipleSelectValues = new String[3];
        actualMultipleSelectValues[0] = chrome.findElement(By.id("_valuemultipleselect0")).getText();
        actualMultipleSelectValues[1] = chrome.findElement(By.id("_valuemultipleselect1")).getText();
        actualMultipleSelectValues[2] = chrome.findElement(By.id("_valuemultipleselect2")).getText();

        assertArrayEquals(expectedMultipleSelectValues, actualMultipleSelectValues);

    }
    @Test
    public void testingGoToFormPageRedirectLink() {

        chrome.get("https://testpages.herokuapp.com/styled/the_form_processor.php");

        JOptionPane.showMessageDialog(null, "Please click on the 'Go back to the form' green button " +
                        "and click on the Submit button to proceed with the test.",
                "testingGoToFormPageRedirectLink ", JOptionPane.INFORMATION_MESSAGE);

        WebElement submitButton = chrome.findElement(By.id("back_to_form"));
        submitButton.click();


        String expectedUrl = "https://testpages.herokuapp.com/styled/basic-html-form-test.html";
        String actualUrl = chrome.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }


    @AfterAll
    public static void afterEach(){
        chrome.close();
    }

}
