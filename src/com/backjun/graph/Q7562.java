package com.backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Q7562 init = new Q7562();
		Solution s = init.new Solution();
		String tmp;
		while((tmp=reader.readLine()) != null) {
			s.parseInput(tmp);
		}
		
	}
	class Solution{
		Queue<Pair> q;
		int[][] geoMap;
		boolean[][] check;
		int lineCount = -1;
		int initWidth = 0;
		int initHeight = 0;
		int dx[] = {-2,-1,1,2,2,1,-1,-2};
		int dy[] = {1,2,2,1,-1,-2,-2,-1};
		Pair knight;
		Pair destination;
		int dep = 0;

		public void parseInput(String input) {
			StringTokenizer token = new StringTokenizer(input);		
			if(lineCount == 0 ) {
				q = new LinkedList<>();
				Integer elem = Integer.parseInt(token.nextElement().toString());
				initWidth = elem;
				initHeight = elem;
				geoMap = new int[initHeight][initWidth];
				check = new boolean[initHeight][initWidth];
			}else if(lineCount == 1){
				while (token.hasMoreElements()) {				
					knight = new Pair();
					knight.x = Integer.parseInt(token.nextElement().toString());
					knight.y = Integer.parseInt(token.nextElement().toString());
				}			
			}else if(lineCount ==2) {
				while (token.hasMoreElements()) {
					destination = new Pair();
					destination.x = Integer.parseInt(token.nextElement().toString());
					destination.y = Integer.parseInt(token.nextElement().toString());
				}
				System.out.println(solution(knight.x, knight.y));
				lineCount = -1;
			}
			lineCount++;
		}
		
		public int solution(int x, int y) {
//			if(x== destination.x && y == destination.y) {
//				return null;
//			}
			q.add(new Pair(x,y,check,0));
			while(!q.isEmpty()) {
				Pair front = q.poll();
				if(front.x == destination.x && front.y == destination.y) {
					return front.step;
				}
				for(int i = 0; i < dx.length; i++) {
					if(
						front.x+dx[i] < initWidth 
						&& front.y+dy[i] < initHeight 
						&& front.x+dx[i] >= 0 
						&& front.y+dy[i] >= 0 
						&& !check[front.x+dx[i]][front.y+dy[i]]
					   ) {
						q.add(new Pair(front.x+dx[i],front.y+dy[i],check,front.step+1));	
						
					}
				}
			}
			return -1;
		}
		class Pair{
			
			public int x = 0;
			public int y = 0;
			int step = 0;
			Pair(){
				
			}
			
			Pair(int x, int y, boolean chk[][], int step){
				this.x = x;
				this.y = y;
				chk[x][y] = true;
				this.step = step;
				
			}
		}
	}

}


