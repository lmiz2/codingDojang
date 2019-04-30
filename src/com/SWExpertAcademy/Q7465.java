package com.SWExpertAcademy;

import java.util.Scanner;

public class Q7465 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		StringBuffer sb = new StringBuffer();
		for(int caseCnt = 1; caseCnt <= t ; caseCnt++) {

			boolean[][] rel;
			int n,m;
			int cnt = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			rel = new boolean[n][n];
			for(int i = 0 ; i < m; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				rel[x][y] = true;
				rel[y][x] = true;
			}
			for(int i = 0 ; i < n ; i++) {
				rel[i][i] = true;
			}
			
			for(int i = 0 ; i < n; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(rel[i][j]) {
						dfs(i,j,n,rel);
						cnt++;
					}
				}
			}
			
			sb.append("#"+caseCnt+" "+cnt+"\n");
			
		}
		System.out.println(sb.toString());

	}
	
	public static void dfs(int x, int y , int n, boolean[][] arr) {
		arr[x][y] = false;
		arr[y][x] = false;
		for(int i = 0; i < n; i++) {
			if(arr[y][i]) {
				dfs(y,i,n,arr);
			}
		}
	}


}
