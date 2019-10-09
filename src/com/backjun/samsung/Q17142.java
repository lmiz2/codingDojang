package com.backjun.samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q17142 {
	/*
	 * 이 문제에서 배운것
	 * 1. 조합(Combination)을 사용하지않고 수열(Permutation)을 사용하여몇십 몇백배 느린 실행속도를 가지게 했다.
	 * 이와 같은 경우에는 조합을 사용하는게 수열보다 가늠할수 없을 정도로 효율적이다.(실행속도 차이로 인해 백준에서는 런타임 오류를 뱉었다.)
	 */

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution_Q17142 s = new Solution_Q17142(sc.nextInt(), sc.nextInt(), sc); 
		System.out.println(s.solute());
	}

}
class Solution_Q17142{
	Pair[] dirs = {new Pair(0,1),new Pair(-1,0),new Pair(0,-1),new Pair(1,0)};
	int BLANK = 0;
	int WALL = 1;
	int VIRUS_START_POINT = 2;
	
	int n,m;
	int[][] arr;
	Pair[] locs;
	boolean[][] visited;
	
	int[] rsArr;
	int[] cnArr;
	int minRecord = 99999999;
	
	public Solution_Q17142(int n, int m, Scanner sc) {
		this.n = n;
		this.m = m;
		arr = new int[n][n];
		locs = new Pair[n*n];
		visited = new boolean[n][n];
		int locsIdx = 0;
				
		
		for(int i = 0; i < n; i ++) {
			for(int j = 0; j < n; j ++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == VIRUS_START_POINT) {
					locs[locsIdx++] = new Pair(i,j);
				}
			}	
		}
		
		rsArr = new int[m];
		cnArr = new int[locsIdx];
		
		for(int i = 0; i < locs.length; i++) {
			if(locs[i] == null) break;
			cnArr[i] = i;
		}
		getComb(rsArr, cnArr.length, m, 0, 0, cnArr);
		
	}
	
	public int solute() {
//		printArr();
		boolean flg = false;
		if(minRecord == 99999999) {
			for(int i = 0; i < n ; i ++) {
				for(int j = 0; j < n ; j ++) {
					if(arr[i][j] == BLANK) flg = true;
				}
			}
			return flg? -1 : 0;		
		}
		return minRecord;
	}
		
	public void getComb(int[] rs, int nn, int r, int idx, int tgt, int[] cn) {
		if(r == 0) {
			//sol
			Queue<wrapPair> ques = new LinkedList<wrapPair>();
			int lsTime = 0;
			for(int i = 0; i < rsArr.length; i++) {
				ques.add(new wrapPair(locs[rsArr[i]], 0));
				visited[locs[rsArr[i]].a][locs[rsArr[i]].b] = true;
			}
			while(!ques.isEmpty()) {
				wrapPair wp = ques.poll();
				Pair currLoc = wp.a;
				if(arr[currLoc.a][currLoc.b] != VIRUS_START_POINT)lsTime = wp.b;
				for(int d = 0 ; d < dirs.length ; d++) {
					int a = currLoc.a+dirs[d].a;
					int b = currLoc.b+dirs[d].b;
					if(a >= 0 && a < n && b >= 0 && b < n) {
						if((!visited[a][b] && arr[a][b] == VIRUS_START_POINT)|| (!visited[a][b] && arr[a][b] != WALL && arr[a][b] != VIRUS_START_POINT)) {
							visited[a][b] = true;
							ques.add(new wrapPair(new Pair(a,b),wp.b+1));
						}
					}
				}
			}
			boolean isCom = true;
			for(int i = 0 ; i < n ; i++) {
				for(int j = 0 ; j < n ; j++) {
					if(arr[i][j] == BLANK && !visited[i][j]) isCom = false;
				}
			}
			if(isCom && minRecord > lsTime) minRecord = lsTime;
			
			visited = new boolean[n][n];
			return;
		}else if (tgt == nn) {
			return;
		}else {
			rsArr[idx] = tgt;
			getComb(rs, nn, r-1, idx+1, tgt+1, cn);
			getComb(rs, nn, r, idx, tgt+1,cn );
		}
	}
	
	class Pair{
		int a,b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	class wrapPair{
		Pair a;
		int b;
		public wrapPair(Pair a, int b) {
			this.a = a;
			this.b = b;
			
		}
	}
}