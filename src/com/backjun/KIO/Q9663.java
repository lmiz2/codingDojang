package com.backjun.KIO;

import java.util.Scanner;

public class Q9663 {
	int totalCnt = 0;
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ComNQ4 c = new ComNQ4();
//		c.compute(Integer.parseInt(br.readLine()));
//		
//
//	}
	
	
	static int path[] = new int[16];
	static int n;
	static int ans;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		for(int i=0; i<n; i++){
			path[0] = i;
			nQueen(i,0);
		}
		System.out.println(ans);
	}
	private static void nQueen(int x, int y) {
		for(int i=0;i<y;i++){
	        if(path[i]==x || Math.abs(x-path[i])==y-i)	        	
	        	 return;
	    }
	    if(y==n-1){
	        ans++;
	        return;
	    }
	    for(int i=0;i<n;i++){
	        path[y+1]=i;
	        nQueen(i,y+1);
	    }
	}

	
}
//
//class ComNQ4{
////	double stTime = 0;	
//	int totalCount = 0;
//	int size = 0;
//	int deps = 0;
//	HashSet<Integer> qY;
//	HashSet<Integer> qld;
//	HashSet<Integer> qlu;
//	
//	public void newQueen(int x, int y) {
//		qY.add(y);
//		qld.add(x+y);
//		qlu.add(x-y);
//	}
//	
//	public void popQueen(int x, int y) {
//		qY.remove(y);
//		qld.remove(x+y);
//		qlu.remove(x-y);
//	}
//	
//	public void compute(int size) {
//		qY = new HashSet<Integer>();
//		qld = new HashSet<Integer>();
//		qlu = new HashSet<Integer>();
//		this.size = size;
////		long start = System.currentTimeMillis();
//		for(int y = 0; y < this.size ; y++) {
//			newQueen(0,y);
//			queen(0,deps+1);
//			popQueen(0, y);
//		}
////		long end = System.currentTimeMillis();
////		stTime += (end - start)/1000.0;
//		System.out.println(totalCount);
////		System.out.println("total exe Time : "+stTime);
//	}
//	
//	public void queen(int xt, int deps) {
//		if(deps == size) {
//			totalCount++;
//			return;
//		}
//		else {
//			
//			for(int x = xt+1; x < size; x++) {
//				for(int y = 0; y < size ; y++) {
//					if(!qY.contains(y)) {
//						if(!qld.contains(x+y) && !qlu.contains(x-y)) {
//							newQueen(x, y);
//							queen(x,deps+1);
//							popQueen(x, y);
//						}
//					}
//				}
//			}
//		}
//	}
//	
//
//} //시간초과 코드




//
//package com.backjun.KIO;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.HashSet;
//import java.util.Stack;
//
//public class Q9663 {
//	int totalCnt = 0;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		ComNQ4 c = new ComNQ4();
//		c.compute(Integer.parseInt(br.readLine()));
//		
//
//	}
//	
//}
//
//class ComNQ4{
//	double stTime = 0;
//	double ioTime = 0;
//	double ldt = 0;
//	double lut = 0;
//	double yt = 0;
//	
//	int totalCount = 0;
//	int size = 0;
//	int deps = 0;
//	HashSet<Integer> qY;
//	HashSet<Integer> qld;
//	HashSet<Integer> qlu;
//	Stack<Queen> ql ;
//	
//	public void newQueen(int x, int y) {
//		qY.add(y);
//		qld.add(x+y);
//		qlu.add(x-y);
//	}
//	
//	public void popQueen(int x, int y) {
//		qY.remove(y);
//		qld.remove(x+y);
//		qlu.remove(x-y);
//	}
//	
//	public void compute(int size) {
//		this.ql = new Stack<Queen>();
//		qY = new HashSet<Integer>();
//		qld = new HashSet<Integer>();
//		qlu = new HashSet<Integer>();
//		this.size = size;
//		long start = System.currentTimeMillis();
//		for(int x = 0; x < this.size; x++) {
//			for(int y = 0; y < this.size ; y++) {
//				newQueen(x,y);
//				queen(x,deps+1);
//				ql.pop();
//
//			}
//		}
//		long end = System.currentTimeMillis();
//		stTime += (end - start)/1000.0;
//		System.out.println(totalCount);
//		System.out.println("total exe Time : "+stTime);
//		System.out.println("total ld Time : "+ldt);
//		System.out.println("total lu Time : "+lut);
//		System.out.println("total yt Time : "+yt);
//	}
//	
//	public void queen(int xt, int deps) {
//		if(deps == size) {
//			totalCount++;
//			return;
//		}
//		else {
//			
//			for(int x = xt+1; x < size; x++) {
//					for(int y = 0; y < size ; y++) {
//						if(!isInY(y)) {
//								if(!isInld(x,y) && !isInlu(x,y)) {
//									ql.push(new Queen(x, y));
//									queen(x,deps+1);
//									ql.pop();
//								}
//						}
//					}
//			}
//		}
//	}
//	
//	
//	public boolean isInY(int y) {
//		long start = System.currentTimeMillis();
//		for (Queen tmpq: ql) {
//			if(tmpq.getLocationY() == y) {
//
//				long end = System.currentTimeMillis();
//				yt += (end - start)/1000.0;
//				return true;
//				
//			}
//		}
//
//		long end = System.currentTimeMillis();
//		yt += (end - start)/1000.0;
//		return false;
//		
//	}
//	
//	public boolean isInld(int x, int y) {
//		long start = System.currentTimeMillis();
//		int ld = x-y;
//		for (Queen tmpq: ql) {
//			if(tmpq.getLeftdownToRightup() == ld) {long end = System.currentTimeMillis();
//			ldt += (end - start)/1000.0;
//				return true;
//			}
//		}
//		long end = System.currentTimeMillis();
//		ldt += (end - start)/1000.0;
//		return false;
//	}
//	
//	public boolean isInlu(int x, int y) {
//		long start = System.currentTimeMillis();
//		int lu = x+y;
//		for (Queen tmpq: ql) {
//			if(tmpq.getLeftupToRightdown() == lu) {
//				long end = System.currentTimeMillis();
//				lut += (end - start)/1000.0;
//				return true;
//			}
//		}
//		long end = System.currentTimeMillis();
//		lut += (end - start)/1000.0;
//		return false;
//	}
//	
//	public int[] getAbsXs() {
//		return null;
//			
//		}
//	
//	public int[] getAbsYs() {
//		return null;
//		
//	}
//}
//
//class Queen{
//	int locationX = 0;
//	int locationY = 0;
//	int leftupToRightdown = 0;
//	int leftdownToRightup = 0;
//	
//	Queen(int x, int y){
//		locationX = x;
//		locationY = y;
//		leftupToRightdown = x+y;
//		leftdownToRightup = x-y;
//	}
//	
//	public int getLeftupToRightdown() {
//		return leftupToRightdown;
//	}
//
//	public void setLeftupToRightdown(int leftupToRightdown) {
//		this.leftupToRightdown = leftupToRightdown;
//	}
//
//	public int getLeftdownToRightup() {
//		return leftdownToRightup;
//	}
//
//	public void setLeftdownToRightup(int leftdownToRightup) {
//		this.leftdownToRightup = leftdownToRightup;
//	}
//
//	public int getLocationX() {
//		return locationX;
//	}
//	public void setLocationX(int locationX) {
//		this.locationX = locationX;
//	}
//	public int getLocationY() {
//		return locationY;
//	}
//	public void setLocationY(int locationY) {
//		this.locationY = locationY;
//	}
//	
//	@Override
//	public String toString() {
//		return "Queen X:"+locationX+" Y:"+locationY+" ld:"+leftdownToRightup +" lu:"+leftupToRightdown;
//	}
//} //시간초과 코드
//
//

