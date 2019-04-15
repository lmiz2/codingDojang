package com.backjun.samsung;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Q16236 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 한글
		int arrsize = 0;
		Scanner sc = new Scanner(System.in);
		arrsize = sc.nextInt();
		solutionQ16236 obj = new solutionQ16236(arrsize);
		for(int i = 0 ; i < arrsize * arrsize ; i ++) {
			obj.setInt(i, sc.nextInt());
		}
		obj.isDebugging = false;
		obj.doit();
	}
}

class solutionQ16236{
	Pair[] dir = {
			new Pair(-1,0  ,0) //��
			,new Pair(0,-1  ,0) //��		
			,new Pair(0,1  ,0) // ����
			,new Pair(1,0  ,0) // �Ʒ�
			};
	int babySize = 2;
	int sizeCnt = 0;
	Pair currLoc;
	int size = 0;
	int[][] arr;
	int move = 0;
	int thisTurnMove = 0;
	boolean isDebugging = false;
	Queue<Pair> times;
	PriorityQueue<Pair> eatables;
	Set<Pair> visited;
	
	public solutionQ16236(int a) {
		// TODO Auto-generated constructor stub
		this.size = a;
		arr = new int[size][];
		for(int i = 0 ; i < arr.length; i ++) {
			arr[i] = new int[size];
		}
		times = new LinkedList<Pair>();
		visited = new HashSet<Pair>();
		eatables = new PriorityQueue<Pair>();
	}
	
	public void setInt(int i, int a) {
		arr[i/size][i%size] = a;
		if(a == 9) {
			currLoc = new Pair(i/size,i%size,0);
			arr[i/size][i%size] = 0;
		}
	}
	
	public void doit() {
		babyMove();
		System.out.println(move+"");
	}
	public void babyMove() {

		do {
		
			times.add(currLoc);
			visited.add(currLoc);
			thisTurnMove = 0;
			while (!times.isEmpty()) {
				Pair tgt = times.poll();
				currLoc = tgt;				
				
				if(arr[tgt.x][tgt.y] < babySize && arr[tgt.x][tgt.y] != 0) {//������ ������
					tgt.forDistance = tgt.dep - move;
					eatables.add(tgt);
//					debugln("add"+tgt.x+","+tgt.y+", eatabels size "+eatables.size());
					continue;
					
				}// ������ ������ �� ��
				tgt.setDep(tgt.dep+1);
				for(int i = 0; i < 4 ; i ++) {
					Pair tmp = tgt.plus(dir[i]);
					//�湮�� ���� �ƴϰ�, ���Ʒ��¿� ���� ������,
					if(tmp.x >= 0 && tmp.x < size && tmp.y >= 0 && tmp.y < size && !visited.contains(tmp)) {
						//����Ⱑ ���� ���ų� ����̸�
						if((arr[tmp.x][tmp.y] <= babySize  && arr[tmp.x][tmp.y] <= 6)|| arr[tmp.x][tmp.y]==0 ||arr[tmp.x][tmp.y] == 9) {
							times.add(tmp);
							visited.add(tmp);
						}
					}
				}
			}// end while (!times.isEmpty()) 
			
			if(!eatables.isEmpty()) { //�����Ÿ��� ������� ���� �� ���� ����
				Pair eatableFish = eatables.poll();
				debugln("eatables.poll : "+eatableFish.x+","+eatableFish.y);
				
				visited.clear();
				times.clear();
				eatables.clear();
				if(++sizeCnt == babySize) {
					babySize++;
					sizeCnt = 0;
				}
				arr[eatableFish.x][eatableFish.y] = 0;
				thisTurnMove = eatableFish.dep - move;
				move = eatableFish.dep;
								
				currLoc = eatableFish;
				
				debugln(babySize+" : "+thisTurnMove);
				printArr();
				debugln();
				
			}else {
				break;
			}
		}while (true);
	}
	
	public void printArr() {
		for(int i = 0; i < arr.length ; i++) {
			for(int j = 0; j < arr.length ; j++) {
				if(currLoc.x == i && currLoc.y == j) {
					debug("�� ");
					continue;
				}
				debug(arr[i][j]+" ");
			}
			debugln();
		}
	}
	
	public void debugln(String msg) {
		if(isDebugging)
			System.out.println(msg);
	}
	
	public void debug(String msg) {
		
		if(isDebugging)
			System.out.print(msg);
	}
	
	public void debugln() {
		if(isDebugging)
			System.out.println();
	}
	
}

class Pair implements Comparable<Pair>{
	int x;
	int y;
	int dep;
	int forDistance;
	public Pair(int x, int y, int d) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		dep = d;
		forDistance = 0;
	}
	
	public Pair plus(Pair p) {
		Pair a = new Pair(p.x,p.y,p.dep);
		a.x = this.x+p.x;
		a.y = this.y+p.y;
		a.dep = this.dep+p.dep;
		return a;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Pair a = (Pair)obj;
		if(a.x == this.x && a.y == this.y) {
			return true;
		}
		return false;
	}
	
	public void setDep(int d) {
		dep = d;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		return this.x^32+this.y^32;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		if(this.forDistance < o.forDistance) {
			return -1;
		}else if (this.forDistance == o.forDistance) {
			if(this.x < o.x) {
				return -1;
			}else if (this.x == o.x ) {
				if(this.y < o.y) {
					return -1;
				} else if (this.y == o.y) {
					return 0;
				}else {
					return 1;
				}
			} else {
				return 1;
			}
		}else {
			return 1;
		}

	}

}