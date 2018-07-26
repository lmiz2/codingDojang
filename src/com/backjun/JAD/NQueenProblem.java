package com.backjun.JAD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String in = br.readLine();
			if(in.equals("exit")) {
				break;
			}
			ComNQ3 cp = new ComNQ3();
			cp.compute(Integer.parseInt(in));
		}
	}
}

class ComputerNQueen{
	int totalWayCount = 0;
	List<int[]> Dtiles;
	
	public void start(int size) {
		int deps = 0;
		Dtiles = new ArrayList<int[]>();
		for(int i = 0; i < size; i++) {//x좌표
			for(int j = 0; j < size ; j++) {//y좌표
				nQueen(i,j,size,deps+1);
			}
		}
		System.out.println(totalWayCount);
	}
	
	public void nQueen(int x, int y, int range, int deps) {
		
		if(deps==range) {
			totalWayCount++;
			return;
		}
		
		for(int rx = 0; rx < range ; rx++) {
			for(int ry = 0; ry < range ; ry++) {
				int dX = Math.abs(x - rx);
				int dY = Math.abs(y - ry);//차
				if(dX > 0 && dY > 0 && dX != dY) {
					//현재 퀸의 Range 밖 == 놓을 수 있는 tile
				}
			}
		}
		
	}
	
}

class ComNQ2{
	
	int totalCount = 0;
	int size = 0;
	public void compute(int size) {
		this.size = size;
		queen(0,0,0,0,1);
	}
	
	public void queen(int x, int y, int w, int z, int deps) {
		System.out.println("queen"+deps);
		if(deps == size) {
			totalCount++;
			return;
		}
		int luRd = size + (x-y);
		int ldRu = x+y+1;
		for(int i = 0 ; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if( x != i && y != j && w != luRd && z != ldRu) {
					queen(i,j,luRd,ldRu,deps+1);
				}
			}
		}
		if(deps == 1) {
			System.out.println(totalCount);
		}
	}
}

class ComNQ3{
	
	int totalCount = 0;
	int size = 0;
	public void compute(int size) {
		this.size = size;
		queen();
	}
	
	public void queen(int ...x) {
		if(x.length == 4) {
			totalCount++;
			return;
		}
//		int luRd = size + (x-y);
//		int ldRu = x+y+1;
//		for(int i = 0 ; i < size; i++) {
//			for(int j = 0; j < size; j++) {
//				if( x != i && y != j && w != luRd && z != ldRu) {
//					queen(i,j,luRd,ldRu,deps+1);
//				}
//			}
//		}
		switch(x.length) {
		case 0 :
			for(int i = 0; i < size ; i++) {// 가로
				queen(i);
			}
			break;
		case 1 :
			for(int i = 0; i < size ; i++) {// 세로
				queen(x[0],i);
			}
			break;
		case 2 :
			int luRd = size + (x[0]-x[1]);
			for(int i = 0; i < size*2-1 ; i++) {//대각선1
				if(i == luRd) {
					queen(x[0],x[1],i);
				}
			}
			break;
		case 3 :
			for(int i = 0; i < size*2-1 ; i++) {//대각선2
				int ldRu = x[0]+x[1]+1;
				if(i == ldRu) {
					queen(x[0],x[1],x[2],i);
				}
			}
			break;
		default : 
			break;
		}
		
		if(x.length == 0) {
			System.out.println(totalCount);
		}
	}
}


class ComNQ4{
	
	int totalCount = 0;
	int size = 0;
	public void compute(int size) {
		this.size = size;
		queen();
	}
	
	public void queen(int x) {
		
	}
}
