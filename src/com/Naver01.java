package com;

import java.util.ArrayList;
import java.util.Collections;

public class Naver01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String[] rs = {};
//		Stack<String> s = new Stack<>();
//		s.push("aas");
//		s.push("bds");
//		s.push("ccc");
////		rs[1] = "123";
//		String tmp = s.pop();
//		String[] record = new String[5];
//		record[0] = "RECIV asdasd";
//		for(int i = 0 ; i < s.size() ; i++) {
//			System.out.println(s.get(i).charAt(0));
//			s.removeAllElements();
//		}
//		System.out.println(record[0].split(" ")[0]);
//		System.out.println(record[0].split(" ")[1]);
		ArrayList<Long> arr = new ArrayList<>();
		arr.add(1000L);
		arr.add(10000L);
		arr.add(100L);
		Collections.sort(arr);
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		inserts(1,2);
		System.out.println(arr.contains(100L));
	}
	public static void inserts(long e, long rs) {
		if( rs > 10000000) {
			return;
		}
		System.out.println(rs);
		inserts(e+1,rs*e);
	}
	
	
	

}
