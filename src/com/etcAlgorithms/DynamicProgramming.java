package com.etcAlgorithms;

public class DynamicProgramming {
	int[][] arr;
	public DynamicProgramming(int maxA, int maxB) {
		// TODO Auto-generated constructor stub
		arr = new int[maxA+1][maxB+1];
	}
	public static void main(String[] args) {
		// f(a,b) = f(a-1, b) + f(a, b-1)
		// f(0,0) = 1 
		// f(n,0) = 1
		// f(0,n) = 1
		
		// f(10,12) = ??
		int a = 10;
		int b = 12;
		DynamicProgramming p = new DynamicProgramming(a,b);
		
		long beforeTime = System.currentTimeMillis(); 
		
		System.out.println("f("+a+", "+b+") = "+p.ff(a,b));
		
		long afterTime = System.currentTimeMillis();
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("실행시간(ms) : "+secDiffTime);

	}
	
	public int ff(int a, int b) {
		System.out.println("f("+a+", "+b+")");
		if( a == 0 || b == 0) return 1;
		
		/*
		 *  dynamic 사용시
		 *  f(2, 2) = 646646
		 *  실행시간(ms) : 4
		 */
		if(arr[a][b] != 0) return arr[a][b];
		arr[a][b] = ff(a-1, b) + ff(a,b-1);
		return arr[a][b];
		
		/*
		 * dynamic 미사용시
		 * f(2, 2) = 646646
		 * 실행시간(ms) : 6395
		 */		
//		return ff(a-1, b) + ff(a,b-1);
	}// dynamic programming 기법을 사용하자 약 1500배 빠른 실행 속도를 얻을 수 있었다.

}
