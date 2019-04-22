package com.backjun.samsungg;

import java.util.Scanner;

public class Q7087 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = sc.nextInt();
			selfAlphabetHash hash = new selfAlphabetHash();
			for(int i = 0 ; i < n; i ++ ) {
			 	hash.put(sc.next());
			}
			sb.append("#"+test_case+" "+hash.getAnswer()+"\n");
			
		}
		System.out.println(sb.toString());
	}

}
class selfAlphabetHash{
	String[] arr;
	final int start_index = (int)'A';
	final int end_index = (int)'Z';
	public selfAlphabetHash() {
		// TODO Auto-generated constructor stub
		arr = new String[end_index+2];
	}
	
	public void put(String in) {
		if(in != null) {
			arr[(int)in.charAt(0)] = in;
		}
	}
	
	public String[] getArr() {
		return arr;
	}
	
	public int getAnswer() {
		int cnt = 0;
		if(arr[start_index] == null) return cnt;
		else {
			int arridx = start_index;
			while(true) {
				if(arr[arridx++] == null) {
					break;
				}else {
					cnt++;	
				}
			}
			return cnt;
		}
	}
}