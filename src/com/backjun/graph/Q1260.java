package com.backjun.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

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
