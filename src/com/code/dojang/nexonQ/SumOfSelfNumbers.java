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
 * @�����            : GS ITM ���ϻ�� �ڹٱ���
 * @FileName        : question1.java 
 * @Project         : codingDojang 
 * @Date            : 2018. 7. 3. 
 * @�ۼ���            : ������
 * @���α׷� ����                :
 *	� �ڿ��� n�� ���� ��, d(n)�� n�� �� �ڸ��� ���ڵ�� n �ڽ��� ���� ���ڶ�� ��������.
	���� ���
	d(91) = 9 + 1 + 91 = 101	
	�� ��, n�� d(n)�� ���׷�����(generator)��� �Ѵ�. ���� ������ 91�� 101�� ���׷������̴�.	
	� ���ڵ��� �ϳ� �̻��� ���׷����͸� ������ �ִµ�, 101�� ���׷����ʹ� 91 �� �ƴ϶� 100�� �ִ�. �׷��� �ݴ��, ���׷����Ͱ� ���� ���ڵ鵵 ������, �̷� ���ڸ� �ε��� ������ Kaprekar�� ���� �ѹ�(self-number)�� �̸� �ٿ���. ���� ��� 1,3,5,7,9,20,31 �� ���� �ѹ� ���̴�.	
	1 �̻��̰� 5000 ���� ���� ��� ���� �ѹ����� ���� ���϶�.
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
		for(int input = 1; input <= findTo ; input ++) {// 4�ڸ� �� ����.
			for(int j = 0; j < String.valueOf(input).length()*9 ; j++) {//���ڸ� ���� �ִ� 36�� x�� ���� ���� �� ���ڸ� �� �̹Ƿ�, ���ʷ����ʹ� ���ڸ������� �ִ� 36�� �� ���ϰ�. ��� 36���� �ݺ��ؼ� ã�Ƴ��� ��.
				String tmp = String.valueOf(input - j);//�� ���� ���ʷ����� ���� �ƴ��� �˾ƺ���
				int sum = 0;
				List numbs = new ArrayList();// ���ʷ���Ʈ ����ȭ
				for(int s = 0; s < tmp.length(); s++) {// �� �ڸ����� �и��ؼ� �ְ�, �������� �ڽ� �� �� ����.
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
		System.out.println("����-�ѹ� �� :"+selfnumberSum);
	}

}

/**
 * 
 * 5000 -> x + max9 + max9 + max9 + max9 = x + max 36
 * 500 -> x + max9 + max9 + max9 = x + max 27
 * 50 -> x + max9 + max9 = x + max 18
 */
