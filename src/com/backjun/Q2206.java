package com.backjun;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q2206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQ2206 s = new SolutionQ2206();
		
	}

}

class SolutionQ2206{
	Pair[] DIRECTION_ARR = {new Pair(-1,0         )
								   ,new Pair(0,1  )
								   ,new Pair(1,0  )
								   ,new Pair(0,-1 )};
	final int NOT_VISITED = 0;
	final int HAS_PUNCH_VISITED = 1;
	final int NO_HAVE_PUNCH_VISITED = 2;
	Scanner sc ;
	int n,m;
	int[][] arr;
	Queue<Pair> nodes;
	int[][] visited3;
	int fTime = -1;
	
	int currN = 0;
	int currM = 0;
	boolean currPunchSts = false;
			
	public SolutionQ2206() {
		// TODO Auto-generated constructor stub
		nodes = new LinkedList<Pair>();
		sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		sc.nextLine();
		arr = new int[n][m];
		visited3 = new int[n][m];
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
		nodes.add(initData);
		visited3[0][0] = HAS_PUNCH_VISITED;
		while(!nodes.isEmpty()) {
			Pair tmpPair = nodes.poll();
			currN = tmpPair.n;
			currM = tmpPair.m;
			currPunchSts = tmpPair.isUsePunch;
			
			if(currN == n-1 && currM == m-1) {
				fTime = tmpPair.time+1;
				break;
			}
			
			for(int i = 0 ; i < 4; i ++) {
				Pair dir = DIRECTION_ARR[i];
				int toN = currN+dir.n;
				int toM = currM+dir.m;
				if(toN >= 0 && toN < n && toM >= 0 && toM < m ) {					
					if(arr[toN][toM] == 0) {
						if(!currPunchSts && visited3[toN][toM] != HAS_PUNCH_VISITED) {
							Pair toPair = new Pair(toN,toM);
							toPair.isUsePunch = currPunchSts;
							toPair.setTime(tmpPair.time+1);
							nodes.add(toPair);
							visited3[toN][toM] = HAS_PUNCH_VISITED;
							
						}else if (currPunchSts && visited3[toN][toM] == NOT_VISITED) {
							Pair toPair = new Pair(toN,toM);
							toPair.isUsePunch = currPunchSts;
							toPair.setTime(tmpPair.time+1);
							nodes.add(toPair);
							visited3[toN][toM] = NO_HAVE_PUNCH_VISITED;
						}
					}else if ( arr[toN][toM] == 1  && !currPunchSts) {
						if(visited3[toN][toM] == NOT_VISITED) {
							Pair toPair = new Pair(toN,toM);
							toPair.setTime(tmpPair.time+1);
							toPair.isUsePunch = true;
							nodes.add(toPair);
							visited3[toN][toM] = NO_HAVE_PUNCH_VISITED;
						}
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
	public void printArrCurr(int n, int m) {
		for(int i = 0 ; i < arr.length; i++) {
			for(int j = 0 ; j < arr[i].length; j++) {
				if(i == n && j == m) {
					System.out.print("#"+" ");
				}else {
					System.out.print(arr[i][j]+" ");
				}
				
			}
			System.out.println();
		}
	}


class Pair{
	boolean isUsePunch = false;
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
}
