package com.SWExpertAcademy;

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
			long[][] vectorMax;
			boolean[] visited;
//			Queue<Pair> q = new LinkedList<Pair>();
			int n = sc.nextInt();
			vector = new long[n][n];
			vectorMax = new long[n][n];
			visited = new boolean[n];
			worms = new Pair[n];
			for(int i = 0 ; i < n ; i ++) {
				worms[i] = new Pair(sc.nextInt(),sc.nextInt());
			}
			
			
			for(int i = 0 ; i < n-1 ; i ++) {
				for(int j = i+1 ; j < n ; j ++) {
					long xd = worms[i].x-worms[j].x;
					
					long yd = worms[i].y-worms[j].y;
					
					long vectorT = xd+yd;
					vector[i][j] = vectorT;
					vector[j][i] = vectorT;
					vectorMax[i][j] = (xd*xd)+(yd*yd);
//					System.out.println(i+","+j+" : "+vectorT);
				}
			}

			Rec[] tmp = new Rec[(n*n-1)/2];
			int idx = 0;
			for(int i = 0; i < n-1; i++) {
				for(int j = i+1; j < n; j++) {
					if(i==j) continue;
					boolean[] vtd = new boolean[n];
					vtd[i] = true;
					vtd[j] = true;
					Rec tRec = new Rec(n);
					tRec.bestValue = 0;
					tRec.addWormPair(new Pair(i,j));
					dfs(i,j,n,vector,tRec,vtd,0);
					tmp[idx++] = tRec;
				}
			}
			Rec best = null;				
			for(int i = 0; i < idx; i++) {
				if(tmp[i] == null) break;
				if(best == null) {
					best = tmp[i];
					continue;
				}
				if(tmp[i].bestValue < best.bestValue) {						
					best = tmp[i];					
				}				
			}
			long rs = 0L;
			for(Pair p : best.wormPairs) {
//				System.out.println(p.x+", "+p.y);
				rs += vectorMax[p.x][p.y];
			}
			
			
						
			System.out.println(rs);
			
//			q.add(e)
			
			
		}
	}
	
	public static void dfs(int x, int y, int n, long[][] vectorMin, Rec rec, boolean[] visited, int deps) {
		Rec[] tmp = new Rec[(n*n-1)/2];
		int idx = 0;
		for(int i = 0; i < n-1 ; i++) {
			for(int j = i+1; j < n; j++) {
				if(i==j) continue;
				if(!visited[i] && !visited[j]) {
					visited[i] = true;
					visited[j] = true;
					rec.addWormPair(new Pair(i,j));
					dfs(i,j,n,vectorMin,rec,visited,deps+1);
				}
			}
		}
//		Rec best = null;
//		if(idx <= 0) {
//			Rec endPoint = new Rec(n);
//			return endPoint;
//		}else {
//			for(int i = 0; i < idx; i++) {
//				if(tmp[i] == null) break;
//				if(best == null) {
//					best = tmp[i];
//					continue;
//				}
//				if(tmp[i].bestValue < best.bestValue) {
//					best = tmp[i];
//				}
//			}
//		}
//		return best;
	}

}
class Pair{
	int x,y;
	
	public Pair(int x, int y) {
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
class Rec{
	Pair[] wormPairs;
	int idx;
	long bestValue;
	
	public Rec(int n) {
		// TODO Auto-generated constructor stub
		wormPairs = new Pair[n/2];
		idx = 0;
		bestValue = Long.MAX_VALUE;
	}
	
	public void addWormPair(Pair wormPair) {
		wormPairs[idx++] = wormPair;
	}
}
