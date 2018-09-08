package com.programmers.kakao;

<<<<<<< HEAD
import java.util.HashMap;
=======
import java.util.ArrayList;
>>>>>>> fe29b7c0c4758311ef961ef965bcb9197c5afbc8

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
<<<<<<< HEAD
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
=======
	int oneCnt = 0;
	int areaCnt = 0;
	int largestSize = 0;
	public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
>>>>>>> fe29b7c0c4758311ef961ef965bcb9197c5afbc8
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
	      
<<<<<<< HEAD
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
	      	      
=======
	      
>>>>>>> fe29b7c0c4758311ef961ef965bcb9197c5afbc8
	      int[] answer = new int[2];
	      numberOfArea = areaCnt;
	      maxSizeOfOneArea = largestSize;
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      System.out.println(answer[0]+", "+answer[1]);
	      return answer;
	  }
	  
<<<<<<< HEAD
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
	  	  
=======
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
	  
>>>>>>> fe29b7c0c4758311ef961ef965bcb9197c5afbc8
	  public void print(int m, int n ,int[][] pct) {
		  for(int i = 0; i < m; i++) {
			  for(int j = 0; j < n; j++) {
				  System.out.print(""+(pct[i][j] == 1 ? "@" : pct[i][j] == 2 ? "#": pct[i][j] == 3? "*": " ")+"");
			  }
			  System.out.println();
		  }
	  }
}
