package com.backjun.samsung;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Q17140 {
	/**
	 *  이 문제에서 배운 것
	 *  1. PriorityQueue 에서 원소를 꺼낼때, for(원소 o : PriorityQueue) 형식으로 사용하니, Comparable 기준이 적용이 되지 않았다.
	 *  2. 입력값(r,c)이 초기의 배열보다 훨씬 커서 IndexOut이 날 수 있다는 사실을 알지 못했다. 	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][3];
		int r = sc.nextInt();
		int c = sc.nextInt();
		int k = sc.nextInt();
		for(int i = 0; i < 3; i ++) {
			for(int j = 0; j < 3; j ++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Solution_Q17140 s = new Solution_Q17140(r, c, k, arr);
	}	
}
class Solution_Q17140{
	int r,c,k;
	int[][] arr;
	int[][] ctrlArr;	
			
	public Solution_Q17140(int r, int c, int k, int[][] arr) {
		this.r = r;
		this.c = c;
		this.k = k;
		this.arr = arr;
		this.ctrlArr = new int[3][3];
		int cnt = 0;
		while(!loop(k,cnt++));
	}
	public boolean loop(int ans, int cnt) {
		if(r-1 < arr.length && c-1 < arr[0].length) {
			if(ans == arr[r-1][c-1]) {
				System.out.println(cnt);
				return true;
			}else if(cnt > 100) {
				System.out.println("-1");
				return true;
			}
			
		}else if(cnt > 100) {
			System.out.println("-1");
			return true;
		}
		if(arr.length >= arr[0].length) {
			arr = calR(arr);			
		}else {
			arr = calC(arr);			
		}
		
		return false;
	}
	
	public int[][] calR(int[][] arr) { // row갯수가 col 갯수보다 크거나 같을때
		int maxRowLength = 0;
		for(int i = 0 ; i < arr.length; i++) {
			int[] map = new int[100+1];
			for(int j = 0 ; j < arr[i].length; j++) {
				map[arr[i][j]]++;
			}
			PriorityQueue<Pair> q = new PriorityQueue<>();
			//Pair.a : 숫자
			//Pair.b : 숫자의갯수
			
			for(int m = 1; m < map.length ; m++) {
				if(map[m] == 0) {
					continue;
				}
				q.add(new Pair(m,map[m]));
			}
						
			if(q.size()*2 > arr[i].length) {
				if(q.size()*2 < maxRowLength) {
					arr[i] = new int[maxRowLength];
				}else {
					arr[i] = new int[q.size()*2];
				}				
			}else {
				if(q.size()*2 < maxRowLength) {
					arr[i] = new int[maxRowLength];
				}else {
					arr[i] = new int[arr[i].length];
				}
			}
			
			int tmpIdx = 0;
//			for(Pair p : q) {
			while(!q.isEmpty()) {
				Pair p = q.poll();
				arr[i][tmpIdx++] = p.a;
				arr[i][tmpIdx++] = p.b;
				if(tmpIdx >= 100) break;
			}
			
			if(maxRowLength < arr[i].length) {
				if(arr[i].length > 100) maxRowLength = 100;
				else maxRowLength = arr[i].length;
			}
			
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length < maxRowLength) {
				int[] tmp = arr[i];
				arr[i] = new int[maxRowLength];
				int tmpIdx = 0;
				for(int a : tmp) {
					arr[i][tmpIdx++] = a; 
				}
			}
		}
		return arr;
		
	}
		
	public int[][] calC(int[][] arr) {// row갯수가 col갯수보다 작을때
//		int maxColLength = 0;
		PriorityQueue<Pair>[] ques = new PriorityQueue[arr[0].length];
		int quesIdx = 0; 
		int maxQSize = 0;
		
		for(int i = 0 ; i < arr[0].length; i++) {
			int[] map = new int[100+1];
			for(int j = 0 ; j < arr.length; j++) {
				map[arr[j][i]]++;
			}
			PriorityQueue<Pair> q = new PriorityQueue<>();
			//Pair.a : 숫자
			//Pair.b : 숫자의갯수
			
			for(int m = 1; m < map.length ; m++) {
				if(map[m] == 0) {
					continue;
				}
				q.add(new Pair(m,map[m]));
			}
			if(maxQSize < q.size()) maxQSize = q.size();
			ques[quesIdx++] = q;
		}
		if(arr.length < maxQSize*2) {
			if(maxQSize > 100) arr = new int[100][arr[0].length];
			else arr = new int[maxQSize*2][arr[0].length];
		}
		
		for(int qi = 0 ; qi < ques.length; qi++) {
			int i1 = 0;
			int i2 = 1;
//			for(Pair p : ques[qi]) {
			while(!ques[qi].isEmpty() || i2 <= arr.length) {			
				Pair p = ques[qi].poll();
				if(p != null) {
					arr[i1][qi] = p.a;
					arr[i2][qi] = p.b;					
				}else {
					arr[i1][qi] = 0;
					arr[i2][qi] = 0;					
				}
				i1 = i1+2;
				i2 = i2+2;
				if(i1 >= 100) break;
			}
		}
		
		return arr;
	}

	
	class Pair implements Comparable<Pair>{
		int a;//숫자
		int b;//갯수
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(this.b < o.b) {
				return -1;
			}else if (this.b == o.b){
				if(this.a < o.a) return -1;
				else if(this.a > o.a) return 1;
			}else {
				return 1;
			}
			return 0;
		}
	}
}

