package com.backjun.samsung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import com.dataStructure.SelfLinkedList.LInkedList;

public class Q16235 {

	public static void main(String[] args) {
		SolutionQ16235 s = new SolutionQ16235();
		s.doit();

	}

}

class SolutionQ16235{
	Scanner sc ;
	int n ,m ,k;// N = 밭의크기, M = 나무 수, K = K년 후 나무 갯수
	int[][] arr; // 현재양분데이터
	int[][] foodForYear; // 매년 추가될 양분데이터
	ArrayList<Integer>[][] trees;
	int x,y,z;
	Pair[] dirs = {new Pair(-1,-1),new Pair(-1,0),new Pair(-1,+1),new Pair(0,-1),
				   new Pair(0,+1),new Pair(+1,-1),new Pair(+1,+1),new Pair(+1,0)};

	public SolutionQ16235() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		this.n = sc.nextInt();
		this.m = sc.nextInt();
		this.k = sc.nextInt();
		arr = new int[n][n];
		foodForYear = new int[n][n];
		trees = new ArrayList[n][n];
		for(int r = 0 ; r < n ; r++) {
			for(int c = 0; c < n; c++) {
				arr[r][c] = 5;
				foodForYear[r][c] = sc.nextInt();
			}
		}

		for(int i = 0; i < n ; i ++) {
			for(int j = 0; j < n ; j ++) {
				trees[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0 ; i < m ; i ++) {
			x=sc.nextInt();
			y=sc.nextInt();
			z=sc.nextInt();
			trees[x-1][y-1].add(z);
		}

	}

	public void doit() {
		while(k-- > 0) { // K년 반복
//			System.out.println(k);

			//1. Spring & Summer Sequences
			for(int i = 0; i < n; i ++) {
				for (int j = 0 ; j < n ; j ++) {
					if(!trees[i][j].isEmpty()) {//[i][j] 타일에 나무가 있으면 실행
						Collections.sort(trees[i][j]);
						int[] deadTree = new int[trees[i][j].size()];
						int deadTreeIdx = 0;
						int[] survived = new int[trees[i][j].size()];
						int survivedIdx = 0;
						int totalFoodInSummer = 0;
						for( int tree : trees[i][j] ) {
							if(arr[i][j] >= tree) { // i,j 타일의 양분이 트리 하나보다 많거나 같으면
								arr[i][j] -= tree;
								tree++;
								survived[survivedIdx++] = tree;
							} else { // 나무쥬금
								deadTree[deadTreeIdx++] = tree;
							}
						}
						trees[i][j].clear(); // 여름 시작
						while(survivedIdx > 0) {
							int tmptree = survived[--survivedIdx];
							trees[i][j].add(tmptree);
						}
						while(deadTreeIdx > 0) {
							arr[i][j] += deadTree[--deadTreeIdx]/2;
						}
						//여름 끝
					}
				}
			}

			for(int i = 0 ; i < n ; i ++) {
				for(int j = 0 ; j < n ; j++) {
					arr[i][j] += foodForYear[i][j];
					for(int tmpTree : trees[i][j]) {
						if(tmpTree%5 == 0) {// 가을 시작
							for(int di = 0; di < 8 ; di++) {
								if(i+dirs[di].x >= 0 && j+dirs[di].y >= 0
								 && i+dirs[di].x < n && j+dirs[di].y < n) {
									trees[i+dirs[di].x][j+dirs[di].y].add(1);//나이가 1인나무 생김
								}
							}
						}//가을 끝
					}
				}
			}

			int survivorCnt = 0;
			for(int i = 0 ; i < n ; i ++) {
				for(int j = 0 ; j < n ; j ++) {
					survivorCnt += trees[i][j].size();
				}
			}
		}

		//answer
		int survivorCnt = 0;
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < n ; j ++) {
				survivorCnt += trees[i][j].size();
			}
		}
		System.out.println(survivorCnt);
	}

	class Pair{
		int x = 0;
		int y = 0;
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
		}
	}
}
