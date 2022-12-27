package me.karter;

import me.karter.utils.RandomNames;
import me.karter.utils.RandomUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {
    public static int WaitTime = 500;
    public static String URL = "https://signup.live.com/";
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        // Starting driver
        System.setProperty("webdriver.gecko.driver", "D:\\GLASS20\\Desktop\\geckodriver.exe");
        driver = new FirefoxDriver();

        // Set windows size
        driver.manage().window().setSize(new Dimension(600, 580));

        driver.manage().deleteAllCookies();

        driver();

        driver.manage().deleteAllCookies();
    }

    public static void driver() throws InterruptedException {
        // Connecting to live.com
        driver.get(URL);

        // Test
//        String title = driver.getTitle();
//        System.out.printf(title);
//
//        Thread.sleep(WaitTime);

        // In China The Next
        try{
            WebElement iSignupAction = driver.findElement(By.id("iSignupAction"));
            if(iSignupAction != null){
                iSignupAction.click();
                Thread.sleep(WaitTime);
            }
        }catch (Throwable e){
        }


        WebElement liveSwitch = driver.findElement(By.id("liveSwitch"));
        liveSwitch.click();

        Thread.sleep(WaitTime);

        // Random User Information
        String Email = "NK" + RandomUtil.getRandomString(10,5);
        String Password = RandomUtil.getRandomString(5,3) ;
        String FirstName = RandomNames.GenerateName();
        String LastName = RandomNames.GenerateName();

        // Input email
        WebElement email_text = driver.findElement(By.id("MemberName"));
        email_text.click();
        email_text.clear();
        email_text.sendKeys(Email);

        Thread.sleep(WaitTime);

        // The Next
        WebElement iSignupAction2 = driver.findElement(By.id("iSignupAction"));
        iSignupAction2.click();

        Thread.sleep(WaitTime);

        // Check MemberNameError
        try {
            WebElement MemberNameError = driver.findElement(By.id("MemberNameError"));
            System.out.println("MemberNameError");
            return;
        }catch (Throwable e) {
        }

        // Input Password
        while(true) {
            try {
                WebElement Password_text = driver.findElement(By.id("PasswordInput"));
                Password_text.click();
                Password_text.clear();
                Password_text.sendKeys(Password);
                break;
            }catch (Throwable e){
            }
        }

        Thread.sleep(WaitTime);
        // The Next
        WebElement iSignupAction3 = driver.findElement(By.id("iSignupAction"));
        iSignupAction3.click();

        Thread.sleep(WaitTime);

        // Input FirstName
        WebElement FirstName_text = driver.findElement(By.id("FirstName"));
        FirstName_text.click();
        FirstName_text.clear();
        FirstName_text.sendKeys(FirstName);

        Thread.sleep(WaitTime);

        // Input LastName
        WebElement LastName_text = driver.findElement(By.id("LastName"));
        LastName_text.click();
        LastName_text.clear();
        LastName_text.sendKeys(LastName);

        Thread.sleep(WaitTime);

        // The Next
        WebElement iSignupAction4 = driver.findElement(By.id("iSignupAction"));
        iSignupAction4.click();

        while(true) {
            try {
                // Use us
                Select Country_text = new Select(driver.findElement(By.id("Country")));
                Country_text.selectByValue("US");

                Thread.sleep(WaitTime);

                // Input Month
                Select BirthMonth_text = new Select(driver.findElement(By.id("BirthMonth")));
                BirthMonth_text.selectByValue(String.valueOf(RandomUtil.nextInt(1,12)));

                Thread.sleep(WaitTime);

                // Input day
                Select BirthDay_text = new Select(driver.findElement(By.id("BirthDay")));
                BirthDay_text.selectByValue(String.valueOf(RandomUtil.nextInt(1,25)));

                Thread.sleep(WaitTime);

                // Input year
                WebElement BirthYear_text = driver.findElement(By.id("BirthYear"));
                BirthYear_text.click();
                BirthYear_text.clear();
                BirthYear_text.sendKeys("2000");

                Thread.sleep(WaitTime);
                break;
            }catch (Throwable e){
            }
        }

        // The Next
        WebElement iSignupAction5 = driver.findElement(By.id("iSignupAction"));
        iSignupAction5.click();
    }
}