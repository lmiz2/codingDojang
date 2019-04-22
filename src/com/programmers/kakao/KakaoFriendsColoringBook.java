package com.programmers.kakao;

import java.util.ArrayList;

public class KakaoFriendsColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] pic = {{0,1,1,0},{1,2,2,0},{1,0,0,1},{0,5,0,1},{0,6,0,3},{0,0,0,3},{2147483647,2147483647,0,2147483647},{2147483647,2147483647,2147483647,2147483647}};
		int[][] pict = {{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},{0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0}
						, {0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0}
						, {0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0}
						, {0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0},{0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0}
						, {0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},{0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0}
						, {0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0},{0,0,1,1,1,1,1,2,2,1,1,1,1,1,0,0}
						, {0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0}};
		Solution s = new Solution();
		s.solution(13, 16, pict);
	}

}

class Solution {
	int oneCnt = 0;
	int areaCnt = 0;
	int largestSize = 0;
	public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
//	      print(m,n,picture);
	      for(int i = 0; i < m; i++) {
	    	  for(int j = 0 ; j < n ; j ++) {
	    		  if(picture[i][j] != 0) {
		    		  deps(picture, i, j, picture[i][j]);
				      areaCnt++;  
		    	      if(oneCnt > largestSize) {
		    	    	  largestSize = oneCnt;
		    	      }
		    	      oneCnt = 0;
	    		  }
	    	  }		      
	      }
	      
	      int[] answer = new int[2];
	      numberOfArea = areaCnt;
	      maxSizeOfOneArea = largestSize;
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      System.out.println(answer[0]+", "+answer[1]);
	      return answer;
	  }
	  
	  public void deps(int[][] picture, int x, int y, int color) {
		  try {
			  if(picture[x][y] != color) {
				  return;
			  }else {
				  picture[x][y] = 0;
				  oneCnt++;
				  deps(picture, x, y+1, color);
				  deps(picture, x+1, y, color);
				  deps(picture, x, y-1, color);
				  deps(picture, x-1, y, color);
			  }
		  }catch(ArrayIndexOutOfBoundsException e) {
			  return;
		  }
	  }
	  
	  public void print(int m, int n ,int[][] pct) {
		  for(int i = 0; i < m; i++) {
			  for(int j = 0; j < n; j++) {
				  System.out.print(""+(pct[i][j] == 1 ? "@" : pct[i][j] == 2 ? "#": pct[i][j] == 3? "*": " ")+"");
			  }
			  System.out.println();
		  }
	  }
}