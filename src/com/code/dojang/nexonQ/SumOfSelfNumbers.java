package com.code.dojang.nexonQ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @과목명            : GS ITM 인턴사원 자바교육
 * @FileName        : question1.java 
 * @Project         : codingDojang 
 * @Date            : 2018. 7. 3. 
 * @작성자            : 송현석
 * @프로그램 설명                :
 *	어떤 자연수 n이 있을 때, d(n)을 n의 각 자릿수 숫자들과 n 자신을 더한 숫자라고 정의하자.
	예를 들어
	d(91) = 9 + 1 + 91 = 101	
	이 때, n을 d(n)의 제네레이터(generator)라고 한다. 위의 예에서 91은 101의 제네레이터이다.	
	어떤 숫자들은 하나 이상의 제네레이터를 가지고 있는데, 101의 제네레이터는 91 뿐 아니라 100도 있다. 그런데 반대로, 제네레이터가 없는 숫자들도 있으며, 이런 숫자를 인도의 수학자 Kaprekar가 셀프 넘버(self-number)라 이름 붙였다. 예를 들어 1,3,5,7,9,20,31 은 셀프 넘버 들이다.	
	1 이상이고 5000 보다 작은 모든 셀프 넘버들의 합을 구하라.
	101 - 91, 100,
	91 = 9 + 1 + 91 
	100 = 1 + 0 + 0 + 100 
 */
public class SumOfSelfNumbers {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int findTo = 10000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		findTo = Integer.parseInt(br.readLine());
		Map<Integer,String> results = new HashMap<>();
		int selfnumberSum = 0;
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
				selfnumberSum += input;
			}
		}
		System.out.println("셀프-넘버 합 :"+selfnumberSum);
	}

}

/**
 * 
 * 5000 -> x + max9 + max9 + max9 + max9 = x + max 36
 * 500 -> x + max9 + max9 + max9 = x + max 27
 * 50 -> x + max9 + max9 = x + max 18
 */
