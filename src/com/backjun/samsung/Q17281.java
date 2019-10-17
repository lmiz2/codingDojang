package com.backjun.samsung;

import java.util.Arrays;
import java.util.Scanner;

public class Q17281 {
	/*
	 *	이 문제에서 배운 점 
	 * 1. 순열을 사용할때, 총 경우의 수가 n! 인지(의도한 수가 맞는지) 확인해야한다. 시간초과의 원인. 
	 * 2. for문으로 a<<1 을 여러번 하는것보다  a<<1 a<<2 a<<3 이런식으로 하나씩 하드코딩하는게 훠얼씬 빠르다.
	 */
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
		this.rsArr = new int[9];
		this.rsArr[3] = 1;
		this.ground = 0;
		this.outCnt = 0;
		this.score = 0;
		this.currIning = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		permu(pArr, pArr.length+1, 0, rsArr);
		System.out.println(bestScore);
		
	}
	
	public void playball(int[] perm) {
		int i = 0;
		while(currIning < arr.length) {			
			if(!hit(arr[currIning][perm[i]-1])) {
				outCnt = 0;
				this.ground = 0;
				currIning++;
			}
			i++;
			i = i%(perm.length);
		}
		
		if(bestScore < score) {
			bestScore = score;
		}

		this.ground = 0;
		this.outCnt = 0;
		this.score = 0;
		this.currIning = 0;
	}
	
//	public boolean hit(int n) {
//			if(n > 0 && n <= 4) {
//				for(int i = 0 ; i < n; i++) {
//					ground = ground << 1;
//					if(i == 0) {
//						ground = 1|ground;
//					}					
//					if((ground &(1<<3)) > 0) {
//						score++;
//						ground = ground&~(1<<3);
//					}
//				}				
//			}else {
//				if(n == 0) {
//					outCnt++;
//					if(outCnt == 3) {
//						return false;
//					}
//				}
//			}
//			return true;		
//	}
	
	public boolean hit(int n) {
		if(n == 0) {
			outCnt++;
			if(outCnt == 3) {
				return false;
			}
			return true;
		}
		ground = ground << 1;
		ground = 1|ground;
		if(n > 1)ground = ground << n-1;
		if((ground &(1<<3)) > 0) {
			score++;
			ground = ground&~(1<<3);
		}
		if((ground &(1<<4)) > 0) {
			score++;
			ground = ground&~(1<<4);
		}
		if((ground &(1<<5)) > 0) {
			score++;
			ground = ground&~(1<<5);
		}
		if((ground &(1<<6)) > 0) {
			score++;
			ground = ground&~(1<<6);
		}
		if((ground &(1<<7)) > 0) {
			score++;
			ground = ground&~(1<<7);
		}
		
		return true;		
	}
	
	
	public void permu(int[] nArr, int r, int deps, int[] rsArr) {
		if(deps == r) {
			playball(rsArr);
//			System.out.println(Arrays.toString(rsArr));
//			bestScore++;
			return;
		}
		if(deps == 3) deps++;
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