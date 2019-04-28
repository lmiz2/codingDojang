package com.backjun.samsungg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1211 {

	public static void main(String[] args){		
//		System.setIn(new FileInputStream("res/input.txt"));
		try {
		
			int mb = 1024*1024;
			Runtime runtime = Runtime.getRuntime();
			System.out.println("##MEMORY##");
			
			System.setIn(new FileInputStream("C:\\Users\\songhs\\Downloads\\input.txt"));
			Scanner sc = new Scanner(System.in);
			for(int ti = 1 ; ti <= 10; ti++) {
				SolutionQ1211 s = new SolutionQ1211(sc);
				System.out.println("#"+ti+" "+s.getAnswer().y);
				
				System.out.println("usedMemory : "+((runtime.totalMemory() -runtime.freeMemory()) /mb)+"MB");
	//			System.gc();
			}
			System.out.println("Max Memory : "+runtime.maxMemory()/mb);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	

}
class SolutionQ1211{
	final static Pair2[] dirs = new Pair2[] {new Pair2(0,-1) ,new Pair2(0,1) ,new Pair2(1,0)};
	Pair2 goal = null;
	int[][] map;
	Pair2 rtnAns;
	Pair2 starts[];
	Pair2 anss[];
	int startsIdx = 0;
	public SolutionQ1211(Scanner sc) throws Exception {
		map = new int[100][100];
		int qcnt = sc.nextInt();
		starts = new Pair2[50]; 
		anss = new Pair2[50];	
		

		for(int i = 0; i < 100 ; i++) {
			for(int j = 0 ; j < 100 ; j++) {
				int in = sc.nextInt();
				map[i][j] = in;
				if(i == 0 && in != 0) {
					starts[startsIdx++] = new Pair2(i,j);
				}
				
			}
		}
		while(--startsIdx >= 0) {
			anss[startsIdx] = whileDoit(starts[startsIdx]);
		}
		int best = -1;
		for(int i = 0; i < 50 ; i++) {
			Pair2 p = anss[i];
			if(p == null) break;
			if(best == -1) best = i;
			else {
				if(anss[best].deps > p.deps) {
					best = i;
				}
			}
			
		}
		rtnAns = starts[best];
		
		
	}
	public Pair2 getAnswer() {
		return rtnAns;
	}
	
	public Pair2 whileDoit(Pair2 curr) {
		Pair2 currNode = new Pair2(curr.x,curr.y);
		currNode.deps = curr.deps;
		int beforeUse = -1;
		while(currNode.x != 99) {
			for(int i = 0; i < 3 ; i++) {
				if(currNode.x+dirs[i].x >= 0 && currNode.x+dirs[i].x < 100 && currNode.y+dirs[i].y >= 0 && currNode.y+dirs[i].y < 100) {
					if(map[currNode.x+dirs[i].x][currNode.y+dirs[i].y] == 1) {
						if( i != 2 ) {
							if( i == beforeUse || 2 == beforeUse) {
								currNode.x = currNode.x+dirs[i].x;
								currNode.y = currNode.y+dirs[i].y;
								currNode.deps += 1;
								beforeUse = i;
								break;	
							}
						} else {
							currNode.x = currNode.x+dirs[i].x;
							currNode.y = currNode.y+dirs[i].y;
							currNode.deps += 1;
							beforeUse = i;
							break;
						}
					}
					
				}
			}
		}
		return currNode;
	}
	
}
class Pair2{
	
	int x,y;
	int deps;
	public Pair2(int x, int y) {
		// TODO Auto-generated constructor stub
		this.x=x;
		this.y=y;
		deps = 0;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pair2 t = (Pair2)obj;
		return this.x == t.x && this.y == t.y;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return x^32+y^32;
	}
}
