package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class testclass {
	public static AndroidDriver driver;
	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.UDID, "cf27ceaa7d31"); //Give Device ID of your mobile phone
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9 PPR1.180610.011");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi");
		caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
		caps.setCapability("appPackage", "com.threefiveeight.adda");
		caps.setCapability("appActivity", ".login.LoginActivity");
		caps.setCapability("automationName", "Appium");
		caps.setCapability("ignoreHiddenApiPolicyError", true);
		caps.setCapability("unicodeKeyboard", true);
		caps.setCapability("resetKeyboard", false);
		caps.setCapability("ignoreUnimportantViews", true);
		caps.setCapability("disableAndroidWatchers", true);
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
		Thread.sleep(2000);
		
	}
	@Test (priority=1)
	public void openapp() throws InterruptedException {
		//System.out.println("Test Passed");
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_switch_email_mobile")).click(); //swith to login with emailid
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/et_email_id")).sendKeys("test90923@gmail.com");  //enter email id
		driver.findElement(By.id("com.threefiveeight.adda:id/et_password")).sendKeys("adda1234"); //enter password
		Thread.sleep(2000);
		driver.findElement(By.id("com.threefiveeight.adda:id/tv_login")).click(); //click login

		Thread.sleep(6000);
		//try catch to handle if already logged in popup appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/tvOk")).isDisplayed())
			{driver.findElement(By.id("com.threefiveeight.adda:id/tvOk")).click(); 

			Thread.sleep(6000);
			}
		}
		catch (Exception e)
		{
			//System.out.println(e);
			System.out.println("Already logged in popup not displayed");
		}

		//try catch to handle if confirm number screen appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/confirm_action")).isDisplayed())
			{ 
				driver.findElement(By.id("com.threefiveeight.adda:id/confirm_action")).click();
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("Confirm mobile number not displayed");

		}

		//Try catch to handle if rating screen appears
		try{
			if(driver.findElement(By.id("com.threefiveeight.adda:id/iv_cancel")).isDisplayed())
			{driver.findElement(By.id("com.threefiveeight.adda:id/iv_cancel")).click();
			}
		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("Rating screen not displayed");
		}

		Thread.sleep(2000);




		//Try catch to handle app tour

		try{	
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/app_bar")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/fl_discover_pager")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/tv_label_discover")).click();
			Thread.sleep(2000);

		}
		catch(Exception e)
		{
			//System.out.println(e);
			System.out.println("App tour not displayed");
		}
		Thread.sleep(2000);	
	}
	//Book facility
		@Test (priority=2)
		public static void bookFacility() throws InterruptedException
		{ 
			driver.findElement(By.id("com.threefiveeight.adda:id/iv_add_shortcuts")).click();
			Thread.sleep(1000);
			String visibleText="Book Facility";
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+visibleText+"\").instance(0)").click();
			Thread.sleep(1000);
			String Facilityscreen="Facilities";
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Facilityscreen+"\").instance(0)").click();
			
			  String bookedFacility="Hour";
			  driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+bookedFacility+"\").instance(0)").click();
			  
			  Thread.sleep(2000); 
			  driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Select Date\").instance(0)").click();
			 LocalDate localDate =java.time.LocalDate.now();   //Getting current date
			int Day = localDate.getDayOfMonth()+1;              //Extract day out of date
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Day+"\")").click(); //Selecting from calendar day
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

			driver.findElement(By.id("com.threefiveeight.adda:id/from_time_tv")).click();
			driver.findElement(By.id("android:id/toggle_mode")).click();
			driver.findElement(By.id("android:id/input_hour")).click();
			driver.findElement(By.id("android:id/input_hour")).clear();
			driver.findElement(By.id("android:id/input_hour")).sendKeys("01");
			driver.findElement(By.id("android:id/input_minute")).click();
			driver.findElement(By.id("android:id/input_minute")).clear();
			driver.findElement(By.id("android:id/input_minute")).sendKeys("30");
			driver.findElement(By.id("android:id/am_pm_spinner")).click();
			Thread.sleep(2000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"AM\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

			driver.findElement(By.id("com.threefiveeight.adda:id/to_time_tv")).click();
			driver.findElement(By.id("android:id/toggle_mode")).click();
			driver.findElement(By.id("android:id/input_hour")).click();
			driver.findElement(By.id("android:id/input_hour")).clear();
			driver.findElement(By.id("android:id/input_hour")).sendKeys("02");
			driver.findElement(By.id("android:id/input_minute")).click();
			driver.findElement(By.id("android:id/input_minute")).clear();
			driver.findElement(By.id("android:id/input_minute")).sendKeys("30");
			driver.findElement(By.id("android:id/am_pm_spinner")).click();
			Thread.sleep(2000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"AM\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();

			driver.findElement(By.id("com.threefiveeight.adda:id/et_notes")).sendKeys("Test");

			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"BOOK\")").click();

			Thread.sleep(2000);
			//driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();
			driver.findElement(By.id("android:id/button1")).click();

			Thread.sleep(3000);
			driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageButton\")").click(); //Click on back icon

			Thread.sleep(2000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Booking History\")").click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/btn_cancel")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.threefiveeight.adda:id/dialog_positive_button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Facilities']/android.widget.TextView")).click();
			
			String DateText="Date";
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+DateText+"\").instance(0)").click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/pick_date_tv1")).click();
			Thread.sleep(1000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Day+"\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();
			driver.findElement(By.id("com.threefiveeight.adda:id/pick_date_tv2")).click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Day+"\")").click();
			Thread.sleep(1000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/book")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
			Thread.sleep(1000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Booking History\")").click();			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/btn_cancel")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/dialog_positive_button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Facilities']/android.widget.TextView")).click();
			
			String SlotText="Slot";
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+SlotText+"\").instance(0)").click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/pick_date_tv1")).click();
			Thread.sleep(1000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\""+Day+"\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"OK\")").click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/book")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
			Thread.sleep(1000);
			driver.findElementByAndroidUIAutomator("new UiSelector().textContains(\"Booking History\")").click();			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/btn_cancel")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("com.threefiveeight.adda:id/dialog_positive_button")).click();
			Thread.sleep(1000);
		}

	@AfterTest
	public void teardown() {
		
	}

}
