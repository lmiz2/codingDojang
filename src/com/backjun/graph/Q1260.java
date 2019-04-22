package com.backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 
 * @author lmiz2
 *
 * 1260번 DFS와 BFS문제
 * 
 * test case : 
 * 13 32 1
	3 10
	3 7
	6 1
	8 5
	8 11
	5 1
	9 11
	10 5
	12 3
	5 9
	6 8
	2 5
	4 7
	13 4
	4 3
	11 12
	3 11
	10 13
	12 4
	4 11
	4 10
	10 2
	9 3
	7 1
	11 2
	6 11
	12 10
	11 7
	6 4
	12 9
	8 13
	6 5
 */
public class Q1260 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Solution s = new Solution();
		String tmp;
		while((tmp=reader.readLine()) != null) {
			s.parseInput(tmp);
		}
		
	}

	
	
}
class Solution{
	LinkedList<Integer>[] adjcList;
	boolean[] check;
	Queue<Integer> bfsRoot;
	int lineCount = 0;
	int initVertex = 0;
	int initLines = 0;
	int startVertex = 0;
	int lineLimit = 0;
	

	public void parseInput(String input) {
		if(lineCount == 0 ) {
			StringTokenizer token = new StringTokenizer(input);
			while (token.hasMoreElements()) {
				initVertex = Integer.parseInt(token.nextElement().toString())+1;
				initLines = Integer.parseInt(token.nextElement().toString());
				startVertex = Integer.parseInt(token.nextElement().toString());
				lineLimit = initLines+1;
			}
			adjcList = new LinkedList[initVertex];
			bfsRoot = new LinkedList<>();
			check = new boolean[initVertex];
			for(int a = 0 ; a < initVertex; a++) {
				adjcList[a] = new LinkedList<>();
			}
		}else {
			StringTokenizer token = new StringTokenizer(input);
			Integer elem = Integer.parseInt(token.nextElement().toString());
			Integer elem2 = Integer.parseInt(token.nextElement().toString());
			if(!adjcList[elem].contains(elem2)) {
				adjcList[elem].add(elem2);
			}
			if(!adjcList[elem2].contains(elem)) {
				adjcList[elem2].add(elem);
			}
		}
		lineCount++;
		
		if(lineCount == lineLimit) {
			for(LinkedList<Integer> t : adjcList) {
				Collections.sort(t);					
			}
			dfs(startVertex);
			System.out.println();
			check = new boolean[initVertex];
			bfs(startVertex);
			
		}
	}
	
	public void dfs(int currNode) {
		if(check[currNode]) {
			return;
		}
		check[currNode] = true;
		System.out.print(currNode+" ");
		for( int a : adjcList[currNode]) {
			dfs(a);
		}
	}
	
	public void bfs(int currNode) {
		bfsRoot.add(currNode);
		check[currNode] = true;
		while(!bfsRoot.isEmpty()) {
			int thisNode = bfsRoot.poll();
			System.out.print(thisNode+" ");
			for(int a : adjcList[thisNode]) {
				if(!check[a]) {
					check[a] = true;
					bfsRoot.add(a);
				}
			}
		}
	}
}
