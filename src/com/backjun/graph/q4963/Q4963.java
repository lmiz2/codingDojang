package com.backjun.graph.q4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4963 {
	static int[][] geoMap;
	static boolean isWnH = true;
	static int lineCounter = 0;
	static int colCounter = 0;
	static int numberOfIsland = 0;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String tmp;
		while((tmp=reader.readLine()) != null) {
			parseInput(tmp);	
		}
		
	}

	public static void parseInput(String input) {
		StringTokenizer token = new StringTokenizer(input);
		if(isWnH) {
			int w = Integer.parseInt(token.nextElement().toString());
			int h = Integer.parseInt(token.nextElement().toString());
			geoMap = new int[w][h];			
			isWnH = false;
		}else {
			while (token.hasMoreElements()) {
				Integer elem = Integer.parseInt(token.nextElement().toString());
//				System.out.println(elem);
				geoMap[colCounter][lineCounter] = elem;
				colCounter++;
			}
			colCounter = 0;
			lineCounter++;
			if(geoMap[0].length == lineCounter) {
				for(int w = 0 ; w < geoMap.length; w++) {
					for(int h = 0; h < geoMap[0].length; h++) {
						solution(w, h, 0);
					}
				}
				System.out.println(numberOfIsland);
				numberOfIsland = 0;
				isWnH = true;
				lineCounter = 0;				
			}
		}
	}
	
	public static void solution(int w, int h, int deps) {
		try {
			if(geoMap[w][h] == 1) {
				if(deps == 0 ) {
					numberOfIsland++;
				}
				geoMap[w][h] = 0;
				solution(w-1,h-1,deps+1);
				solution(w-1,h,deps+1);
				solution(w-1,h+1,deps+1);
				solution(w,h+1,deps+1);
				solution(w+1,h+1,deps+1);
				solution(w+1,h,deps+1);
				solution(w+1,h-1,deps+1);
				solution(w,h-1,deps+1);
			}else {
				return;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			return;
		}
		
	}
}
