package com.backjun.selfNumb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4673 {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int findTo = 1000000;
		Map<Integer,String> results = new HashMap<>();
		for(int input = 1; input <= findTo ; input ++) {// 4자리 수 동안.
			for(int j = 0; j < String.valueOf(input).length()*9 ; j++) {//네자리 수는 최대 36과 x를 더한 값이 이 네자리 수 이므로, 제너레이터는 네자리수에서 최대 36을 뺀 값일것. 고로 36번만 반복해서 찾아내면 됨.
				String tmp = String.valueOf(input - j);//이 수가 제너레이터 일지 아닐지 알아보기
				int sum = 0;
				List numbs = new ArrayList();// 제너레이트 수식화
				for(int s = 0; s < tmp.length(); s++) {// 각 자릿수를 분리해서 넣고, 마지막에 자신 수 를 넣음.
					numbs.add(tmp.charAt(s));					
				}
				numbs.add(input-j);
				for(Object a: numbs) {
					if(a instanceof Character) {
						sum += Character.getNumericValue((char)a);
					}else {
						sum += (Integer)a;
					}
				}
				
				if(input == sum) {
					results.put(input, tmp);
				}
			}
			if(results.get(input)==null) {
				System.out.println(input);
			}
		}
	}
}
