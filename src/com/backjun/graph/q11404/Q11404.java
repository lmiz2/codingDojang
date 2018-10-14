package com.backjun.graph.q11404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11404 {
	
	public static final int CANT_GO = 9999999;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		String tmp;
		while((tmp=reader.readLine()) != null) {
			s.parseInput(tmp);
		}
	}
}

class Solution{
	int[][] geoMap;	
	int lineCount = 0;
	int initWidth = 0;
	int initHeight = 0;

	public void parseInput(String input) {
		StringTokenizer token = new StringTokenizer(input);
		if(token.hasMoreTokens()) {
			if(lineCount == 0) {
				initWidth = Integer.parseInt(token.nextToken());
			}else if( lineCount == 1 ){
				initHeight = Integer.parseInt(token.nextToken());
				geoMap = new int[initWidth][initWidth];
				for(int i = 0 ; i < initWidth; i++) {
					for(int j = 0 ; j < initWidth; j++) {
						geoMap[i][j] = Q11404.CANT_GO;
					}
				}
			}else {
				while (token.hasMoreElements()) {
					int a = Integer.parseInt(token.nextToken())-1;
					int b = Integer.parseInt(token.nextToken())-1;
					int v = Integer.parseInt(token.nextToken());
					if(geoMap[a][b] > v) {
						geoMap[a][b] = v;
					} else {
					}
				}
			}
			
		}
		lineCount++;
		if(lineCount >= initHeight+2) {
			solution();
		}
	}
	
	public void printResult() {
		for(int[] w : geoMap) {
			for(int h: w) {
				if(h == Q11404.CANT_GO) {
					h = 0;
				}
				System.out.print(h+" ");
			}
			System.out.println();
		}
	}
	
	public void solution() {
		for(int tmp = 0 ; tmp < geoMap.length; tmp++) {
			for(int s = 0; s <geoMap.length; s++) {
				for(int e = 0; e < geoMap.length; e++) {
					if(s==e) {
						continue;
					}
					if(geoMap[s][e] > geoMap[s][tmp]+geoMap[tmp][e]) {
						geoMap[s][e] = geoMap[s][tmp]+geoMap[tmp][e];
					}
				}
			}
		}
		printResult();
	}
}
