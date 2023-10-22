package com.osa.genericUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class contains java methods
 * 
 * @author mayur
 */
public class JAVAUtility {
	/**
	 * This mathod returns the Random integer values
	 * 
	 * @return
	 */
	public int getRandomNum() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}

	public String getSystemDate() {
		Date date = new Date();
		return date.toString();
	}

	/**
	 * This method used to return the date in required format
	 * 
	 * @return
	 */
	public String getSystemDateInRequredFormat() {
		Date dateTime = new Date();
		String[] d = dateTime.toString().split(" ");

		String day = d[0];
		String month = d[1];
		String date = d[2];
		String year = d[5];

		String finalFormat = day + " " + month + " " + date + " " + year;
		return finalFormat;
	}

}
