package com.backjun.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1427 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer instr = new StringBuffer();
		instr.append(br.readLine());
		for(int j = 0; j < instr.length(); j++) {
			for(int i = j; i < instr.length(); i ++) {
				if(Character.getNumericValue(instr.charAt(j))<Character.getNumericValue(instr.charAt(i))) {
					swap(instr,j,i);
				}else if(Character.getNumericValue(instr.charAt(j))==Character.getNumericValue(instr.charAt(i))) {
					char tmp = instr.charAt(i);
					instr.deleteCharAt(i);
					instr.insert(j, tmp);
				}
			}
		}
		System.out.println(instr.toString());
	}
	
	public static void swap(StringBuffer str, int i, int j) {
		char tmp = str.charAt(i);
		str.setCharAt(i, str.charAt(j));
		str.setCharAt(j, tmp);
	}

}
