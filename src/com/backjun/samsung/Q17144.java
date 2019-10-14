package com.backjun.samsung;

import java.util.Scanner;

public class Q17144 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution_Q17144 s = new Solution_Q17144(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc);
		
	}

}
class Solution_Q17144{
	int r,c,t,sum;
	int[][] arr;
	int[][] nextSts;
	Pair[] airClears;
	Pair[] dirsToTop = {new Pair(0,-1),new Pair(-1,0),new Pair(0,1),new Pair(1,0)};
	Pair[] dirsToBot = {new Pair(0,-1),new Pair(1,0),new Pair(0,1),new Pair(-1,0)};
	
	public Solution_Q17144(int r, int c, int t, Scanner sc) {
		this.r = r;
		this.c = c;
		this.t = t;
		arr = new int[r][c];
		nextSts = new int[r][c];
		airClears = new Pair[2];
		int acIdx = 0;
		sum = 0;
		
		for(int i = 0 ; i < r; i++) {
			for(int j = 0 ; j < c ; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == -1) {
					airClears[acIdx++] = new Pair(i,j);
				}
			}
		}
		sol();
//		spread();
//		print(arr);
//		airCleaning();
//		print(arr);
	}
	
	public void print(int[][] arr) {
		for(int i = 0; i < r ; i++) {
			for(int j = 0 ; j < c; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void sol() {
		for(int i = 0 ; i < t; i++) {
			spread();
			airCleaning();
		}
		
		for(int i = 0; i < r ; i++) {
			for(int j = 0 ; j < c; j++) {
				if(arr[i][j] != -1) {
					sum += arr[i][j];
				}				
			}
		}
		System.out.println(sum);
	}
	public void spread() {
		for(int i = 0 ; i < r; i++) {
			for(int j = 0 ; j < c ; j++) {
				if(arr[i][j] <= 0) {
					continue;
				}else {
					int succCnt = 0;
					for(int d = 0 ; d < 4; d++) {
						int x = i+dirsToTop[d].a;
						int y = j+dirsToTop[d].b;
						if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length && arr[x][y] != -1) {
							nextSts[x][y] += arr[i][j]/5;
							succCnt++;
						}
					}
					nextSts[i][j] += arr[i][j] - ((arr[i][j]/5) * succCnt);
				}
			}
		}
		
		for(int i = 0; i < r ; i++) {
			for(int j = 0 ; j < c; j++) {
				if(arr[i][j] != -1) {
					arr[i][j] = nextSts[i][j];
					nextSts[i][j] = 0;
				}				
			}
		}
	}
	public void airCleaning() {
		vacuumTop(airClears[0].a, airClears[0].b);
		vacuumBot(airClears[1].a, airClears[1].b);
	}
	public void vacuumTop(int r, int c) {
			for(int d = 0; d < 4; d++) {
				int x = r+dirsToTop[d].a;
				int y = c+dirsToTop[d].b;
				if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length) {
					if( arr[x][y] != -1 && 
							(
							(d == 1 && y == 0)
							|| (d==2 && x == 0)
							|| (d==3 && y == arr[r].length-1 && x <= airClears[0].a)
							|| (d==0 && airClears[0].a == r)
							)
						) {

						if(airClears[0].a == r && airClears[0].b == c) {
							arr[x][y] = 0;
						}else {
							arr[r][c] = arr[x][y];
							
						}
						vacuumTop(x, y);
						break;
					}else if(arr[x][y] == -1) {
						arr[r][c] = 0;
					}
				}
			}
	}
	
	public void vacuumBot(int r, int c) {
		for(int d = 0; d < 4; d++) {
			int x = r+dirsToBot[d].a;
			int y = c+dirsToBot[d].b;
			if(x >= 0 && x < arr.length && y >= 0 && y < arr[x].length) {			
				if( arr[x][y] != -1 && (
						(d == 1 && y == 0)
						|| (d==2 && x == arr.length-1)
						|| (d==3 && y == arr[r].length-1 && x >= airClears[1].a)
						|| (d==0 && airClears[1].a == r)
						)
					) {

					if(airClears[1].a == r && airClears[1].b == c) {
						arr[x][y] = 0;
					}else {
						if(arr[x][y] != -1) {
							arr[r][c] = arr[x][y];
						}
					}
					vacuumBot(x, y);
					break;
				}else if ( arr[x][y] == -1) {
					arr[r][c] = 0;
				}
				
			}
		}
	}
	
	class Pair{
		int a,b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
}