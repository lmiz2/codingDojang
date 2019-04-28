package com.SWExpertAcademy;

import java.util.Scanner;

public class Q7102 {

	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		StringBuffer sb = new StringBuffer();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n==m) {
				sb.append("#"+test_case+" "+(n+1)+"\n");
			}else {
				int gap = Math.abs(n-m);
				int best,worst;
				if(n > m) {
					best = n+1;
					worst = m+1;
				}
				else {
					best = m+1;
					worst = n+1;
				}
				sb.append("#"+test_case+" ");
				int tmpCnt = best - gap;
				for(int i = 0; i <= gap; i++) {
					sb.append(tmpCnt++);
					if(i == gap) sb.append("\n");
					else sb.append(" ");
				}
			}
		}
		System.out.println(sb.toString());
	}
}
