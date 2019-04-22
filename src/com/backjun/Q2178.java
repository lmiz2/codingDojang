package com.backjun;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q2178 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQ2178 s = new SolutionQ2178();
		
//		s.printArr();
	}

}

class SolutionQ2178{
	static Pair[] DIRECTION_ARR = {new Pair(-1,0)
								   ,new Pair(0,1)
								   ,new Pair(1,0)
								   ,new Pair(0,-1)};
	Scanner sc ;
	int n,m;
	int[][] arr;
	Queue<Pair> nodes;
	Set<Pair> visited;
	int fTime = 0;
	
	int currN = 0;
	int currM = 0;
			
	public SolutionQ2178() {
		// TODO Auto-generated constructor stub
		nodes = new LinkedList<Pair>();
		visited = new HashSet<Pair>();
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new int[n][m];
		String[] argss = new String[n];
		for(int idx = 0; idx < n; idx++) {
			argss[idx] = sc.nextLine();
			
		}

		for(int j = 0 ; j < argss.length; j++) {			
			for(int i = 0 ; i < argss[j].length(); i++) {
				arr[j][i] = Character.getNumericValue(argss[j].charAt(i));
			}
		}
		
		doit();
		System.out.print(fTime);
		
	}
	
	public void doit() {
		Pair initData = new Pair(0,0);
//		initData.setTime(1);
		nodes.add(initData);
		while(!nodes.isEmpty()) {
			Pair tmpPair = nodes.poll();
			currN = tmpPair.n;
			currM = tmpPair.m;
			
			if(currN == n-1 && currM == m-1) {
//				System.out.println(tmpPair.time);
				fTime = tmpPair.time+1;
				break;
			}
			
			for(int i = 0 ; i < 4; i ++) {
				Pair dir = DIRECTION_ARR[i];
				int toN = currN+dir.n;
				int toM = currM+dir.m;
//				System.out.println(toN+" "+toM);
				if(toN >= 0 && toN < n && toM >= 0 && toM < m ) {
					Pair toPair = new Pair(toN,toM);
					if(arr[toN][toM] == 1 && !visited.contains(toPair)) {
						toPair.setTime(tmpPair.time+1);
						nodes.add(toPair);
						visited.add(toPair);
//						System.out.println("add:"+toPair.n+" , "+toPair.m+" t:"+toPair.time);
					}
				}
			}
		}
	}
	
	public void printArr() {
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

class Pair{
	
	int n,m;
	int time;
	public Pair(int n, int m) {
		// TODO Auto-generated constructor stub
		this.n= n;
		this.m = m;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pair p = (Pair)obj;
		return (p.m == this.m)&&(p.n == this.n);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.m^32+this.n^32;
	}
}