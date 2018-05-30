package com.expotek.confidencetreev1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Conf {

	private static File confFile = new File("ConfidenceTree.conf");//This file config is added at build

	public static String get(String conf) {
		try {
			FileReader fileReader = new FileReader(confFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			String fileConf;
			while ((line = bufferedReader.readLine()) != null) {
				line=line.trim();
				fileConf = line.substring(0,line.indexOf(":"));
				if (fileConf.matches(conf)) {
					String value = line.substring(line.indexOf(":"),line.length());
					System.out.println("Found conf - " + fileConf + ". Value is - " + value);
					return value;
				}
			}
			fileReader.close();
			} catch (IOException e) {
				System.out.println("Check your conf file. Must be only one conf file in the jar's directory and each conf life must contain a colon as in KEY:VALUE");
				e.printStackTrace();
			}
			System.out.println("No conf found in conf file for - " + conf + ". Check your conf file");
			return null;
	
	}

}
