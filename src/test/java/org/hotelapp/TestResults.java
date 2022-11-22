package org.hotelapp;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestResults {
	public static void main(String[] args) {
		Result r = JUnitCore.runClasses(HotelApp.class);
		System.out.println("-------Test Result--------");
		System.out.println("Run Count===>"+r.getRunCount());
		System.out.println("Failure count===>"+r.getFailureCount());
		System.out.println("Ignore count===>"+r.getIgnoreCount());
		System.out.println("Run Time===>"+r.getRunTime());
		System.out.println("Successful===>"+r.wasSuccessful());
	}

}
