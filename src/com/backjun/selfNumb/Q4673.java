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
				System.out.println(input);
			}
		}
	}
}
