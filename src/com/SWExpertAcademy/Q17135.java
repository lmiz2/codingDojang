package com.backjun.samsungg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q17135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQ17135 s = new SolutionQ17135();
	}

}

class SolutionQ17135{
	int n,m;
	int d;
	int totalKill;
	int[][] field;
	int[][] tField;
	Pair[] dirs;
	int toploc;
	
	
	public SolutionQ17135() {
		dirs = new Pair[]{new Pair(0,-1),new Pair(-1,0),new Pair(0,1),new Pair(1,0)};
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		d = sc.nextInt();
		field = new int[n][m];
		totalKill = 0;
		toploc = n+1;
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j++) {
				field[i][j] = sc.nextInt();
				if(field[i][j] == 1 && toploc > i) {
					toploc = i;
				}
			}
		}
		
		for(int a = 0; a < m-2 ; a++) {
			for(int b = a+1; b < m-1; b++) {
				for(int c = b+1; c < m ; c++ ) {		

					int kill = perCaseDoit(new Archer[] {new Archer(new Pair(n,a)),new Archer(new Pair(n,b)),new Archer(new Pair(n,c))});
					
//				System.out.println();
//					System.out.println(a+","+b+","+c+"!!"+kill);
					if(kill >= totalKill) {
						totalKill = kill;
					}
				}
			}
		}
		System.out.println(totalKill);
		
	}
	
	public int perCaseDoit(Archer[] archers) {
//		Archer[] archers = new Archer[3];
//		archers[0] = new Archer(new Pair(n,0));
//		archers[1] = new Archer(new Pair(n,1));
//		archers[2] = new Archer(new Pair(n,2));
		int bestKill = 0;
		int thisToploc = toploc;
//		tField = field.clone();
		tField = new int[n][m];
		for(int i = 0 ; i < n ; i ++) {
			for( int j = 0 ; j < m ; j ++) {
				tField[i][j]=field[i][j];
			}
		}
		
		while(thisToploc++ < n) { // 1턴마다, 적들 한칸씩 내려감.
			Set<Pair> thisTTgt = new HashSet<>();
			for(int i = 0; i < 3 ; i ++) {
				Pair tgt = perArcherDoit(archers[i]);
				if (tgt != null)
				thisTTgt.add(tgt);
			}
			
			for(Pair a: thisTTgt) {
				if(a != null && tField[a.x][a.y] != 0) {
					tField[a.x][a.y]= 0; 
					bestKill++;
				}
			}
			
			// prt
//			for(int i = 0 ; i < n ; i ++) {
//				for( int j = 0 ; j < m ; j ++) {
//					System.out.print(tField[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println(bestKill);
//			System.out.println();
			//prt end
			
			//적 전진
			for(int i = n-1; i >= -1 ; i --) {
				for(int j = 0; j < m ; j++) {
					if(i >= n-1) {
						tField[i][j] = 0;
					}else if(i < 0){
						tField[i+1][j] = 0;
					} else {
						tField[i+1][j] = tField[i][j];
					}
				}
			}
			
			
		}
		return bestKill;
		
	}
	
	public Pair perArcherDoit(Archer ac) {
		Queue<Pair> shotDistance = new LinkedList<Pair>();
		boolean[][] shotDistanceVS = new boolean[n][m];
		Archer tmpAc = new Archer(ac.currLoc);
		Pair currLoc = null;
		
		Pair tmp = new Pair(tmpAc.currLoc.x, tmpAc.currLoc.y);
		tmp.x -= 1;
		tmp.deps =1;
		
		shotDistance.add(tmp);
		shotDistanceVS[tmp.x][tmp.y] = true;
		while(!shotDistance.isEmpty()) {
			currLoc = shotDistance.poll();

			if(tField[currLoc.x][currLoc.y] == 1 && currLoc.deps <= d) {
				return new Pair(currLoc.x,currLoc.y);
			}
			
			for(int i = 0 ; i < 4 ; i ++) {
				Pair dir = dirs[i];
				if(currLoc.x+dir.x >=0 && currLoc.x+dir.x  < n 
				&& currLoc.y+dir.y >= 0 && currLoc.y+dir.y < m) {
					if(!shotDistanceVS[currLoc.x+dir.x][currLoc.y+dir.y]) {
						Pair p = new Pair(currLoc.x+dir.x,currLoc.y+dir.y);
						p.deps = currLoc.deps +1;
						shotDistance.add(p);
						shotDistanceVS[currLoc.x+dir.x][currLoc.y+dir.y] = true;
					}
				}
			}
		}
		
		return null;
	}
	
	class Pair implements Comparable<Pair>{
		int x,y;
		int deps;
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			deps = 0;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return x^32+y^32;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Pair p = (Pair)obj;
			return this.x == p.x && this.y == p.y;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			if(this.y > o.y) {
				return 1;
			}else if (this.y < o.y) {
				return -1;
			}else {
				if(this.x < o.x) {
					return -1;
				}else {
					return 1;
				}
			}
		}
	}
	
	class Archer{
		Pair currLoc;
		public Archer(Pair loc) {
			// TODO Auto-generated constructor stub
			currLoc = loc;
		}
	}
}