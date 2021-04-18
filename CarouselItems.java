package com.devlabs.serviceNow.testcases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CarouselItems {
	static WebDriver driver;
	static String prodName;
	static ArrayList<String> list = new ArrayList<String>();

	public static ArrayList<String> RequiredLists(String path1) {
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class=\"sc-fvhGYg kHEClt\"]//h3[contains(text(), '"+path1+"')]/parent::div/parent::div/following-sibling::div//*[@class=\"puv25r-2 cwZEwU\"]/img"));
		for (int i = 1; i < list1.size(); i++) {

			prodName = list1.get(i).getAttribute("alt");
			list.add(prodName);
		}
		Collections.sort(list);
		return list;
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.get("https://www.noon.com/uae-en/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String path ="Recommended For You";

		System.out.println("----------------------TOP RequiredLists-------------------------");
		ArrayList<String> s1 = RequiredLists(path);
		
		for (String s : s1) {
			System.out.println(s);
		}
		

		System.out.println("----------------------TOP PICKS IN ELECTRONICS-------------------------");
		ArrayList<String> s2 = RequiredLists("Top picks in electronics");
		
		for (String s : s2) {
			System.out.println(s);
		}
		
		System.out.println("----------------------LIMITED TIME OFFERS-------------------------");
		ArrayList<String> s3 = RequiredLists("Limited time offers");
		
		for (String s : s3) {
			System.out.println(s);
		}


	}

}
