package com.backjun.graph;

/**
 * 
 * @author lmiz2
 * Q1707
 * 이분 그래프 판별하기
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1707 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		s.parseInput();
		
	}

	static class Solution{
		LinkedList<Integer>[] adList;
		int[] color;
		boolean[] check;
		int tCaseCnt = 0;
		int ttvertex = 0;
		int lineCnt = 0;
		Scanner sc;
		
		Solution(){
			sc = new Scanner(System.in);
		}
	
		public void parseInput() {
			tCaseCnt = sc.nextInt();
			for(int r = 0 ; r < tCaseCnt; r++) {				
				ttvertex = sc.nextInt()+1;
				lineCnt = sc.nextInt();
//				arr = new int[ttvertex][ttvertex];
				adList = new LinkedList[ttvertex];
				check = new boolean[ttvertex];
				color = new int[ttvertex];
				for(int i = 0; i < lineCnt; i++) {
//					arr[sc.nextInt()][sc.nextInt()] = 1;
					int input = sc.nextInt();
					int input2 = sc.nextInt();
					if(adList[input] == null) {
						adList[input] = new LinkedList<Integer>();
					}
					if(adList[input2] == null) {
						adList[input2] = new LinkedList<Integer>();
					}
					adList[input].add(input2);
					adList[input2].add(input);
				}
//				for(int i = 1 ; i < ttvertex; i++) {
//					dfs(i,1);
//				}
				boolean flag = true;
				for(int i = 1; i<ttvertex ; i++) {
					for(int j : adList[i]) {
						if(color[i] == color[j]) {
							flag = false;
						}
					}
				}
				if(flag) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
//				for(int x = 1 ; x < arr[0].length ; x++) {
//					for(int y = 1; y < arr.length ; y++) {
//						System.out.print(arr[x][y]);
//					}
//					System.out.println();
//				}
				
			}
			
		}
		
		public boolean dfs(int thisNode, int c) {
			boolean rs = true;
//			System.out.println(thisNode+"chk "+color[thisNode]+" ("+c+")");		
			if(check[thisNode]) {
//				System.out.println("chk"+thisNode);
				if(color[thisNode] == c) {
					return false;
				}				
				return rs;
			}
			check[thisNode] = true;
//			System.out.print(thisNode+"("+c+") ");
			color[thisNode] = 3-c;
			if(adList[thisNode] != null) {
				for(int i = 0 ; i < adList[thisNode].size(); i++) {
					int nextVertex = adList[thisNode].get(i); 
					if(color[nextVertex] == 0) {
						rs = dfs(nextVertex,color[thisNode]);						
					}
				}
			}
			return rs;
		}
	}

}
