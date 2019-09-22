package com.SWExpertAcademy;

import java.util.Scanner;

class Q7854
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			System.out.println("#"+test_case + " "+sol(sc.nextInt()));

		}
		sc.close();
	}
	public static int sol(int q) {
		String tmp = String.valueOf(q);
		int rs = 0;
		StringBuffer thn = new StringBuffer();
		int threeNumbs = 0;
		for(int i = 0; i < tmp.length(); i++) {
			switch(i) {
			case 0 :
				if(tmp.length() != 1) rs += 3;
				thn.append(tmp.charAt(i));
				break;
			case 1 :
				if(tmp.length() != 2) rs += 4;
				thn.append(tmp.charAt(i));
				break;
			case 2 : 
				thn.append(tmp.charAt(i));
				break;
			default :
				rs += 5;
				break;				
			}
		}
		threeNumbs = Integer.parseInt(thn.toString());
		int[] arr ;
		if(thn.length() == 1) {
			arr = new int[3];
			arr[0] = 1;
			arr[1] = 2;
			arr[2] = 5;
		}else if (thn.length() == 2) {
			arr = new int[4];
			arr[0] = 10;
			arr[1] = 20;
			arr[2] = 25;
			arr[3] = 50;
		}else {
			arr = new int[5];
			arr[0] = 100;
			arr[1] = 125;
			arr[2] = 200;
			arr[3] = 250;
			arr[4] = 500;
		}
		for(int i = 0; i < arr.length ; i++) {
			if(threeNumbs >= arr[i]) rs += 1;
		}
		return rs;
	}
}