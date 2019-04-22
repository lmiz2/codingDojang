package com.backjun.samsungg;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7227 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			long bestVector = Long.MAX_VALUE;
			Pair[] worms;
			long[][] vector;
			boolean[][] visited;
//			Queue<Pair> q = new LinkedList<Pair>();
			int n = sc.nextInt();
			vector = new long[n][n];
			visited = new boolean[n][n];
			worms = new Pair[n];
			for(int i = 0 ; i < n ; i ++) {
				worms[i] = new Pair(sc.nextLong(),sc.nextLong());
			}
			
			
			for(int i = 0 ; i < n-1 ; i ++) {
				for(int j = i+1 ; j < n ; j ++) {
					long xd = worms[i].x-worms[j].x;
					xd *= xd;
					
					long yd = worms[i].y-worms[j].y;
					yd *= yd;
					
					long vectorT = xd+yd;
					vector[i][j] = vectorT;
					vector[j][i] = vectorT;
//					System.out.println(i+","+j+" : "+vectorT);
				}
			}
			
			for(int i = 0 ; i < n-1 ; i ++) {
//				for(int j = i+1 ; j < n ; j ++) {
//					
//				}
				
				visited[i][0] = true;
				long thisLargeTurn = dfs(i,0,n,vector,0,visited,0);
				if(bestVector > thisLargeTurn) {
					bestVector = thisLargeTurn;
//					System.out.println(thisLargeTurn);
				}
			}
			System.out.println(bestVector);
			
//			q.add(e)
			
			
		}
	}
	
	public static long dfs(int x, int y, int n, long[][] arr, long depValue, boolean[][] visited, int deps) {
		if(deps >= 2 )return depValue;
		long rtn = depValue+arr[x][y];
		Long best = null;
//		System.out.println(best);
		for(int i = 0; i < n ; i++) {
			if(!visited[x][i] && x != i) {
				visited[x][i] = true;
				long thisturnValue = dfs(x,i,n,arr,rtn,visited, deps);
				if(best == null) {
					best = thisturnValue;
				}else if(thisturnValue < best) {
					best = thisturnValue;
//					System.out.println(thisturnValue);
				}
			}
			
		}
		if(best == null) best = 0L;
		rtn = rtn+best;
		return rtn;
	}

}
class Pair{
	long x,y;
	
	public Pair(long x, long y) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pair s = (Pair)obj;
		return this.x == s.x && this.y == s.y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return (int)x^16+(int)y^16;
	}
}
