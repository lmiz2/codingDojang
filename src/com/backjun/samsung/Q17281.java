package com.backjun.samsung;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q17281 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Solution_Q17281 s = new Solution_Q17281(sc.nextInt(), sc);
	}

}
class Solution_Q17281{
	int n;
	int[][] arr;
	int bestScore;
	
	int ground;	
	Queue<Boolean> grounds;
	int outCnt;
	int score;
	int currIning;
	int[] pArr;
	int[] rsArr;
	
	public Solution_Q17281(int n, Scanner sc) {
		this.n = n;
		this.bestScore = 0;
		this.arr = new int[n][9];
		this.pArr = new int[]{2,3,4,5,6,7,8,9};
		this.rsArr = new int[8];
		this.ground = 0;
//		this.grounds = new LinkedList<>();
		this.outCnt = 0;
		this.score = 0;
		this.currIning = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		permu(pArr, pArr.length, 0, rsArr);
		System.out.println(bestScore);
		
	}
	
	public void playball(int[] perm) {
		int i = 0;
		while(currIning < arr.length) {
			if(i == 3) {
				if(!hit(arr[currIning][0])) {
					outCnt = 0;
//					grounds.clear();
					this.ground = 0;
					currIning++;
				}	
			}else if(i < 3){
				if(!hit(arr[currIning][perm[i]-1])) {
					outCnt = 0;
//					grounds.clear();
					this.ground = 0;
					currIning++;
				}
			}else {
				if(!hit(arr[currIning][perm[i-1]-1])) {
					outCnt = 0;
//					grounds.clear();
					this.ground = 0;
					currIning++;
				}
			}
			i++;
			i = i%(perm.length+1);
		}
		
		if(bestScore < score) {
			bestScore = score;
//			System.out.println(Arrays.toString(perm)+", "+score);
		}

		this.ground = 0;
//		grounds.clear();
		this.outCnt = 0;
		this.score = 0;
		this.currIning = 0;
	}
	
	public boolean hit(int n) {
			if(n > 0 && n <= 4) {
				for(int i = 0 ; i < n; i++) {
					ground = ground << 1;
					if(i == 0) {
						ground = 1|ground;
					}					
					if((ground &(1<<3)) > 0) {
						score++;
						ground = ground&~(1<<3);
					}
				}				
			}else {
				if(n == 0) {
					outCnt++;
					if(outCnt == 3) {
						return false;
					}
				}
			}
			return true;		
	}
	
//	public boolean hit(int n) {
//		if(n == 0) {
//			outCnt++;
//			if(outCnt == 3) {
//				return false;
//			}
//		}else {
//			if(n==4) {
//				score++;
//				while(!grounds.isEmpty()){
//					if(grounds.poll()) score++;
//				}
//			}else {
//				grounds.add(true);
//				for(int i = 0 ; i < n-1; i++) {
//					grounds.add(false);
//				}
//				while(grounds.size()>=4) {
//					if(grounds.poll()) score++;
//				}
//			}
//		}
//		
//		return true;
//	}
	
	public void permu(int[] nArr, int r, int deps, int[] rsArr) {
		if(deps == r) {
			playball(rsArr);
//			System.out.println(Arrays.toString(rsArr));
//			bestScore++;
			
			return;
		}
		for(int i = 0 ; i < nArr.length ; i++) {
			if(nArr[i] == -1) {
				continue;
			}
//			if(deps == 3) {
//				rsArr[deps] = 1;
//				permu(nArr,r,deps+1,rsArr);
//			}else {
				int tmp = nArr[i];
				nArr[i] = -1;
				rsArr[deps] = tmp;
				permu(nArr,r,deps+1,rsArr);
				nArr[i] = tmp;
//			}
		}
	}
	
}