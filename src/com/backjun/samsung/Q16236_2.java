package com.backjun.samsung;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Q16236_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution_Q16236_2 s = new Solution_Q16236_2(sc.nextInt(), sc);
	}

}
class Solution_Q16236_2{
	Pair[] dirs = {new Pair(0, 1),new Pair(-1, 0),new Pair(1, 0),new Pair(0, -1)};
	Pair babyShark;	
	int n;
	int[][] arr;
	boolean[][] visited;
	int size;
	int eatCnt;
	int totalTime;
	public Solution_Q16236_2(int n, Scanner sc) {
		this.n = n;
		arr = new int[n][n];
		visited = new boolean[n][n];
		size = 2;
		eatCnt = 0;
		totalTime = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0 ; j < arr[i].length ; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 9) {
					babyShark = new Pair(i,j);
					arr[i][j] = 0;
				}
			}
		}
		moveToEat();
		System.out.println(totalTime);
	}
	public void print() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(i != babyShark.x || j!= babyShark.y) {
					System.out.print(arr[i][j]+" ");
				}else {
					System.out.print("◆ ");
				}
			}
			System.out.println();
		}
		System.out.println(totalTime);
		System.out.println();
	}
	
	public void moveToEat() {
		Queue<Pair> queue = new LinkedList<Pair>();
		PriorityQueue<Pair> eatList = new PriorityQueue<Pair>();
		queue.add(babyShark);
		visited[babyShark.x][babyShark.y] = true;
		while(true){
//			print();
			while(!queue.isEmpty()) {
				Pair p = queue.poll();
				for(int i = 0 ; i < 4 ; i++) {
					int px = p.x+dirs[i].x;
					int py = p.y+dirs[i].y;
					if(px >= 0 && px < arr.length && py >= 0 && py < arr[px].length) {
						if(!visited[px][py]) {
							visited[px][py] = true;
							if(arr[px][py] == 0 || arr[px][py] == size) {
								queue.add(new Pair(px,py,p.deps+1));
							}else if (arr[px][py] < size) {
								eatList.add(new Pair(px,py,p.deps+1));
							}
						}
					}
				}
			}
			
			for(int i = 0 ; i < arr.length; i++) {
				for(int j = 0 ; j < arr[i].length ; j++) {
					visited[i][j] = false;
				}
			}
			if(!eatList.isEmpty()) {
				Pair eatObj = eatList.poll();
				arr[eatObj.x][eatObj.y] = 0;
				totalTime += eatObj.deps;
				eatCnt++;
				if(size == eatCnt) {
					size++;
					eatCnt = 0;
				}
				queue.clear();
				eatList.clear();
				this.babyShark = new Pair(eatObj.x,eatObj.y);
				queue.add(babyShark);
			}else {
				break;
			}
		}
		
	}	
	
	class Pair implements Comparable<Pair>{
		int x,y;
		int deps;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			this.deps = 0;
		}
		public Pair(int x, int y, int deps) {
			this(x,y);
			this.deps = deps;
		}
		
		public int compareTo(Pair p) {
			if(this.deps < p.deps) {
				return -1;
			}else if (this.deps == p.deps) {
				if(this.x < p.x) {
					return -1;
				}else if (this.x == p.x) {
					if(this.y < p.y)return -1;
					else return 1;
				}else return 1;
			}else return 1;
		}
		
	}
}