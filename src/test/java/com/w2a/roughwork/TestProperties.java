package com.w2a.roughwork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println(System.getProperty("user.dir"));
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream("System.getProperty(\"user.dir\")"+"\\src\\test\\resources\\properties\\Config.properties");
		config.load(fis);
		
		Properties OR = new Properties();
		 fis = new FileInputStream("System.getProperty(\"user.dir\")"+"\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

	}

}
