package com.iie.common.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class DomainFileUtils {
	
	public static String fileName;
	
	/**
	 * 读文件，得到域名
	 */
	public static List<String> getDomains(String path) {
		List<String> resultList = new ArrayList<String>();
		FileInputStream inputStream = null;
		BufferedInputStream bins = null;
		Scanner sc = null;
		try {
			inputStream = new FileInputStream(path);
			bins = new BufferedInputStream(inputStream);
			sc = new Scanner(bins);
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				resultList.add(line.trim());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (inputStream != null) {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (sc != null) {
			sc.close();
		}
		return resultList;
	}
	/**
	 * 读取配置文件
	 * @param propertiesFile 配置文件的名字
	 * @return
	 */
	public String findFilePath(String propertiesFile) {
		String path = null;
		Properties prop = null;
		InputStream inputStream = null;
		try {
			prop = new Properties();
			inputStream = this.getClass().getClassLoader().getResourceAsStream(propertiesFile);
			prop.load(new InputStreamReader(inputStream, "utf-8"));
			path = prop.getProperty("filePath");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;
	}
	
}
