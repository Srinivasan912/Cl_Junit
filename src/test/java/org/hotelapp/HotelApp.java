package org.hotelapp;

import org.hotelapppage.BookHotel;
import org.hotelapppage.BookingConfirm;
import org.hotelapppage.LoginPage;
import org.hotelapppage.SearchHotelPage;
import org.hotelapppage.SelectHotelPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.utility.BaseClass;

public class HotelApp extends BaseClass {
	@BeforeClass
	public static void beforeClass() {
		launchBrowser("chrome");
		maximize();
		implicitwait(10);
		System.out.println("Successfully Browser Launch");
	}
	
	//Login Page
	@Test
	public void testA() {
		urlLaunch("http://adactinhotelapp.com/");
		LoginPage l = new LoginPage();
		sendkeys(l.getTxtUser(),"TestCase00001");
		String atUser = getAttribute(l.getTxtUser());
		Assert.assertEquals("Verify UserName", "TestCase00001", atUser);
		sendkeys(l.getTxtpass(), "password");
		String atPass = getAttribute(l.getTxtpass());
		Assert.assertEquals("Verify PassWord", "password", atPass);
		click(l.getBtnLogin());
		System.out.println("Successfully Login ");
	}
	
	//Search Hotel Page
	@Test
	public void testB() throws InterruptedException {
		//urlLaunch("http://adactinhotelapp.com/SearchHotel.php");
		Thread.sleep(3000);
		Assert.assertTrue("Verify Search Hotel url",currentUrl().contains("SearchHotel"));
		SearchHotelPage s = new SearchHotelPage();
		selectByIndex(s.getDrdLocation(), 2);
		selectByIndex(s.getDrdhotels(), 3);
		selectByIndex(s.getDrdRoomtype(), 2);
		selectByIndex(s.getDrdRoomnos(), 1);
		selectByIndex(s.getDrdAdultroom(), 3);
		selectByIndex(s.getDrdChildroom(), 3);
		click(s.getBtnSearch());
		System.out.println("Successfully Search hotel");
	}
	
	//Select Hotel page
	@Test
	public void testC() throws InterruptedException {
		//urlLaunch(""http://adactinhotelapp.com/SelectHotel.php);
		Thread.sleep(3000);
		Assert.assertTrue("Verify Select Hotel url",currentUrl().contains("SelectHotel"));
		SelectHotelPage sl = new SelectHotelPage();
		click(sl.getRadSelect());
		click(sl.getBtnContinue());
		System.out.println("Successfully Select hotel");
	}
	
	//Book hotel Page
	@Test
	public void testD() throws InterruptedException {
		//urlLaunch("http://adactinhotelapp.com/BookHotel.php");
		Thread.sleep(3000);
		Assert.assertTrue("Verify Book Hotel url",currentUrl().contains("BookHotel"));
		BookHotel b=new BookHotel();
		sendkeys(b.getTxtFirstName(), "Srinivasan");
		String atFName = getAttribute(b.getTxtFirstName());
		Assert.assertEquals("Verify First Name", "Srinivasan", atFName);
		sendkeys(b.getTxtLastName(), "Rajendran");
		String atLName = getAttribute(b.getTxtLastName());
		Assert.assertEquals("Verify Last Name", "Rajendran", atLName);
		sendkeys(b.getTxtAddress(), "Chennai");
		String atAddress = getAttribute(b.getTxtAddress());
		Assert.assertEquals("Verify Address", "Chennai", atAddress);
		sendkeys(b.getTxtCardNo(), "9999888877776666");
		String atCard = getAttribute(b.getTxtCardNo());
		Assert.assertEquals("Verify Card Number", "9999888877776666", atCard);
		selectByIndex(b.getDrdCardType(), 3);
		selectByIndex(b.getDrdExpiryMonth(), 6);
		selectByIndex(b.getDrdExpiryYear(), 11);
		sendkeys(b.getTxtCvvNo(), "987");
		String atCvv = getAttribute(b.getTxtCvvNo());
		Assert.assertEquals("Verify CVV", "987", atCvv);
		click(b.getBtnBookNow());
		System.out.println("Successfully Hotel Booked");
		
	}
	
	//Booking Confirm
	@Test
	public void testE() throws InterruptedException {
		//urlLaunch("http://adactinhotelapp.com/BookingConfirm.php");
		Thread.sleep(3000);
		BookingConfirm bl = new BookingConfirm();
		String order_no = getAttribute(bl.getTxtOrderNumber());
		System.out.println("Order Number========>"+order_no);
		System.out.println("SuccessFully Booked and Print Order Number");
	}
	
	@AfterClass
	public static void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		BookingConfirm b2= new BookingConfirm();
		click(b2.getBtnLogOut());
		System.out.println("Logout SuccessFully..........");
		System.out.println("");
		quit();
	}
}
