package com.backjun.samsung;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q17143 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution_Q17143 s = new Solution_Q17143(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc);
	}	
	
}
class Solution_Q17143{
	Pair TO_TOP = new Pair(-1,0);
	Pair TO_RIGHT = new Pair(0,1);
	Pair TO_BOTTOM = new Pair(1,0);
	Pair TO_LEFT = new Pair(0,-1);
	int r,c,m;
	Queue<Shark>[][] sea;
	int man = -1;
	int catchWeightSum = 0;
	public Solution_Q17143(int r, int c, int m, Scanner sc) {
		this.r = r;
		this.c = c;
		this.m = m;
		sea = new LinkedList[r][c];
		for(int i = 0 ; i < sea.length; i++) {
			for(int j = 0 ; j < sea[i].length ; j++) {
				sea[i][j] = new LinkedList<Shark>();
			}
		}
		
		for(int i = 0 ; i < m; i ++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Shark t = 
					new Shark(
							sc.nextInt()
							, sc.nextInt()
							, sc.nextInt());
			sea[x-1][y-1].add(t);
		}
		try {
			
			sol();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.catchWeightSum);
	}
	
	public void sol() throws Exception {
		while (man < c-1) {
			man++;
			
			for(int i = 0; i < sea.length; i++) {
				if(!sea[i][man].isEmpty()) {					
					Shark t = sea[i][man].poll();
					catchWeightSum += t.size;
					break;
				}
			}
			
			
			for(int i = 0 ; i < sea.length; i++) {
				for(int j = 0 ; j < sea[i].length; j++) {
					if(sea[i][j].isEmpty()) continue;
					Shark t = sea[i][j].peek();
					if(t.moveCnt == man) {
						t = sea[i][j].poll();
						Pair l = t.getMovedLoc(i, j);
						sea[l.x][l.y].add(t);	
					}
				}
			}
			
			for(int i = 0 ; i < sea.length; i++) {
				for(int j = 0 ; j < sea[i].length; j++) {
					if(sea[i][j].isEmpty()) continue;
					Shark t = sea[i][j].poll();
					while(!sea[i][j].isEmpty()) {
						Shark e = sea[i][j].poll();
						if(t.size < e.size) t = e;
					}
					sea[i][j].add(t);
				}
			}
			
		}
	}	
	
	class Shark{
		Pair direction;
		int size, speed;
		int moveCnt = 0;
		public Shark(int s, int d, int z ) {
			this.speed = s;
			if(d == 1) this.direction = TO_TOP;
			else if(d == 2) this.direction = TO_BOTTOM;
			else if(d == 3) this.direction = TO_RIGHT;
			else if(d == 4) this.direction = TO_LEFT;
			this.size = z;
		}
		
		public void toggleDir() {
			if(this.direction == TO_TOP) this.direction = TO_BOTTOM;
			else if(this.direction == TO_BOTTOM) this.direction = TO_TOP;
			else if(this.direction == TO_LEFT) this.direction = TO_RIGHT;
			else if(this.direction == TO_RIGHT) this.direction = TO_LEFT;
		}
		
		public Pair getMovedLoc(int r, int c) {
			moveCnt++;
			int distance = this.speed;
			int x = r;
			int y = c;
			while(distance > 0) {
				if(direction == TO_TOP) {
					if(x+TO_TOP.x >= 0 && x+TO_TOP.x < sea.length ) { 
						x = x+TO_TOP.x;
						distance--;
					}else {
						direction = TO_BOTTOM;
					}
				}else if (direction == TO_BOTTOM) {
					if(x+TO_BOTTOM.x >= 0 && x+TO_BOTTOM.x < sea.length ) {
						x = x+TO_BOTTOM.x;
						distance--;
					}else {
						direction = TO_TOP;
					}
				}else if (direction == TO_LEFT) {
					if(y+TO_LEFT.y >= 0 && y+TO_LEFT.y < sea[x].length) { 
						y = y+TO_LEFT.y;
						distance--;
					}else {
						direction = TO_RIGHT;
					}
				}else if (direction == TO_RIGHT) {
					if(y+TO_RIGHT.y >= 0 && y+TO_RIGHT.y < sea[x].length) { 
						y = y+TO_RIGHT.y;
						distance--;
					}else {
						direction = TO_LEFT;
					}
				}
			}
			
			return new Pair(x,y);
		}
		
	}
	class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public void setSpeed(int m) {
			if(this.x != 0 && this.y == 0) {
				this.x = this.x * m;
			}else if(this.x == 0 && this.y != 0) {
				this.y = this.y * m;
			}
		}
	}
}