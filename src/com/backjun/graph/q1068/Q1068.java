package com.backjun.graph.q1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1068 {
	
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
	ArrayList<ArrayList<Integer>> trees;
	int lineCount = 0;
	int initWidth = 0;
	int initHeight = 0;
	int leafCnt = 0;
	

	public void parseInput(String input) {
		if(lineCount == 0 ) {
			trees = new ArrayList<>();
		}else{
			StringTokenizer token = new StringTokenizer(input);
			ArrayList<Integer> currTree = null;
			if(lineCount == 2) {
				delete(Integer.parseInt(token.nextToken()));
			}else {
				while (token.hasMoreElements()) {
					Integer elem = Integer.parseInt(token.nextElement().toString());
					if(elem == -1) {
						currTree = new ArrayList<>();
						trees.add(currTree);				
					}
					currTree.add(elem);
				}
			}
		}
		lineCount++;
	}
	
	public void delete(int seq) {
		int targetStartSeq = 0;
		int tmp = -1;
		int listIdx = 0;
		for(ArrayList<Integer> li : trees) {
			targetStartSeq = tmp+1;
			tmp += li.size();
			if(seq >= 0 && seq <= tmp) {
				break;
			}
			listIdx++;
		}
		ArrayList<Integer> targetList = trees.get(listIdx);
		int deleteOffset = seq - targetStartSeq;
		delLoop(targetList, deleteOffset);
		

		for(ArrayList<Integer> tmpList : trees) {
			for(int a : tmpList) {
			}
		}
		
		for(ArrayList<Integer> tmpList : trees) {
			countLoop(tmpList, 0);
		}
		
		System.out.println(leafCnt);
	}
	
	public boolean delLoop(ArrayList<Integer> targetList, int idx) {
		try {
			boolean isProcessed = false;
			for(int i = idx+1; i < targetList.size(); i++) {
				if(targetList.get(i) == idx) {
					isProcessed = true;
					if(delLoop(targetList, i)) {
						i--;
					}
				}else if (isProcessed) {
					break;
				}
			}
			targetList.remove(idx);
			return true;
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
	
	public int countLoop(ArrayList<Integer> targetList, int idx) {
		try {
			int childCnt= 0;
			boolean isProcessed = false;
			for(int i = idx+1; i < targetList.size(); i++) {
				if(targetList.get(i) == idx) {
					isProcessed = true;
					childCnt += countLoop(targetList, i);					
					
				}else if (isProcessed) {
					break;
				}
			}
			if(childCnt == 0 && targetList.size() >= 1) {
				leafCnt++;
			}
			return 1;
		}catch(IndexOutOfBoundsException e) {
			return 0;
		}
	}
	
}
