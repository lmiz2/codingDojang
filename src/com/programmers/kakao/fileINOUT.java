package com.programmers.kakao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fileINOUT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File fe = new File("C:\\WorkShop\\log.txt");
		BufferedReader br = new BufferedReader(new FileReader(fe));
		String t = null;
		while((t=br.readLine())!=null)
		System.out.println(t);
		
	}

}
