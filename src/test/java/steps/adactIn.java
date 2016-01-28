package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

/**
 * Created by wamika on 1/23/16.
 */
public class adactIn {

    public WebDriver driver;
//    private WebDriverWait wait = new WebDriverWait(driver, 10);

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        String baseUrl = "http://www.adactin.com/";
        driver.get(baseUrl + "/HotelApp/index.php");
    }

    @Given("^I want to make a hotel booking through AdactIn$")
    public void login() throws Throwable {
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("wamikasingh");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("abcd1234");
        WebElement login = driver.findElement(By.id("login"));
        login.click();
//        WebElement username_show =  wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("username_show"))));
        Thread.sleep(8000);
        WebElement username_show = driver.findElement(By.id("username_show"));
    }



    @And("^I try to search a hotel$")
    public void searchAHotel() throws Throwable {

        WebElement hotelLocation = driver.findElement(By.id("location"));
        new Select(hotelLocation).selectByVisibleText("London");
        WebElement hotelName = driver.findElement(By.id("hotels"));
        new Select(hotelName).selectByVisibleText("Hotel Sunshine");
        WebElement hotelRoomType = driver.findElement(By.id("room_type"));
        new Select(hotelRoomType).selectByVisibleText("Super Deluxe");
        WebElement submit = driver.findElement(By.id("Submit"));
        submit.click();

    }

    @When("^I select the hotel$")
    public void selectHotel() throws Throwable {
        assertEquals("AdactIn.com - Select Hotel", driver.getTitle());
        assertEquals("Hotel Sunshine", driver.findElement(By.id("hotel_name_0")).getAttribute("value"));
        assertEquals("London", driver.findElement(By.id("location_0")).getAttribute("value"));
        driver.findElement(By.id("radiobutton_0")).click();
        driver.findElement(By.id("continue")).click();
    }

    @And("^fill in my details$")
    public void fillInDetails() throws Throwable {
        WebElement firstName = driver.findElement(By.id("first_name"));
        firstName.clear();
        firstName.sendKeys("Wamika");
        WebElement lastName = driver.findElement(By.id("last_name"));
        lastName.clear();
        lastName.sendKeys("Singh");
        WebElement address = driver.findElement(By.id("address"));
        address.clear();
        address.sendKeys("ACR Mansion, 3rd block Koramangala");
        WebElement ccNum = driver.findElement(By.id("cc_num"));
        ccNum.clear();
        ccNum.sendKeys("1234567812345678");
        WebElement ccType = driver.findElement(By.id("cc_type"));
        new Select(ccType).selectByVisibleText("American Express");
        WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
        new Select(ccExpMonth).selectByVisibleText("December");
        WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
        new Select(ccExpYear).selectByVisibleText("2022");
        WebElement cvv = driver.findElement(By.id("cc_cvv"));
        cvv.clear();
        cvv.sendKeys("123");
        WebElement bookHotel = driver.findElement(By.id("book_now"));
        bookHotel.click();
        WebElement waitMessage = driver.findElement(By.id("process_span"));
        assertEquals("Please wait! We are processing your Hotel Booking...", waitMessage.getText());
        Thread.sleep(8000);

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("process_span")));
    }

    @Then("^I see a hotel booking confirmation$")
    public void verifyHotelBookingConfirmation() throws Throwable {
        assertEquals("AdactIn.com - Hotel Booking Confirmation", driver.getTitle());

    }

    @And("^I logout$")
    public void logout() throws Throwable {
        WebElement logout = driver.findElement(By.id("logout"));
        logout.click();
        assertEquals("You have successfully logged out. Click here to login again", driver.findElement(By.cssSelector("td.reg_success")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}
