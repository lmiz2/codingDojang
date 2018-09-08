package com.programmers.kakao;

import java.util.HashMap;

public class KakaoFriendsColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pic = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		Solution s = new Solution();
		s.solution(6, 4, pic);
	}

}

class Solution {
	HashMap<Integer, HashMap<Integer,Integer>> areaSets;
	int areaCount = 0;
	int areaNumber = 1;
	
	public Solution() {
		// TODO Auto-generated constructor stub
		areaSets = new HashMap<>();
	}
	  public int[] solution(int m, int n, int[][] picture) {
		  print(m,n,picture);
		  int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      int topColor = -1;
	      int leftColor = -1;
//	      for(int x = 0; x < m; x++) {
//	    	  for(int y = 0; y < n; y++) {
//	    		  int color = picture[x][y];
//	    		  if(color == 0 && leftColor == -1) {
//	    			  continue;
//	    		  }
//	    		  if(color != 0) {
//		    		  if(!areaSets.containsKey(areaNumber)) {
//		    			  areaSets.put(areaNumber, new HashMap<Integer,Integer>());
//		    		  }
//		    		  areaSets.get(areaNumber).put(x,y);
//	    		  }
//	    	  }
//	      }
	      	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	  
	  public void widthdeps(int[][] picture, int deps) { //뎁스 : m 세로가로.
		  boolean flag = true;
		  int wPointer = 0;
    	  while(flag) {
    		  int color = picture[deps][wPointer];
    		  if(color == 0) {
    			  continue;
    		  }
    	  }
    		  
      }
	  	  
	  public void print(int m, int n ,int[][] pct) {
		  for(int i = 0; i < m; i++) {
			  for(int j = 0; j < n; j++) {
				  System.out.print(" "+pct[i][j]+" ");
			  }
			  System.out.println();
		  }
	  }
}
