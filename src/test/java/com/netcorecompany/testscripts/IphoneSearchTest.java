package com.netcorecompany.testscripts;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.netcorecompany.commonutils.BaseClass;
import com.netcorecompany.objectRepository.FlipkartHomepagedisplay;
import com.opencsv.CSVWriter;
	public class IphoneSearchTest  extends BaseClass{
		@Test
		public void iphonesearchcriteriatestcase() throws Throwable
		{
			
			FlipkartHomepagedisplay fp=new FlipkartHomepagedisplay(driver);
			fp.getLoginPopup().click();
			fp.getSearchBOX().sendKeys("iphones less than 40000",Keys.ENTER);
			WebElement searchResult = fp.getContentVal();
			Assert.assertEquals(searchResult.isDisplayed(), true);
			List<WebElement> devicenameslist = fp.getIphonedevices();
			List<WebElement> pricevalueslist = fp.getIphonePrice();
			List<WebElement> ratingvaluelist = fp.getIphoneRatings();
			
			List<String> prices = new ArrayList<String>();
			for(WebElement e : pricevalueslist){
				prices.add(e.getText());
			}
			Collections.sort(prices);
			
			List<String> ratings = new ArrayList<String>();
			for(WebElement e : ratingvaluelist){
				ratings.add(e.getText());
			}
			Collections.sort(ratings);
			
			String[] header = {"Device Details", "Price", "Ratings"};
			List<String[]> list = new ArrayList<>();
			
			list.add(0,header);
			for(int i=0;i<devicenameslist.size();i++)
			{
				String[] row1 = {devicenameslist.get(i).getText(),prices.get(i),ratings.get(i)};
				list.add(i, row1);
			}
			CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/IPhonedetails.csv"));
			writecsv.writeAll(list);
			writecsv.close();
		}
	}



