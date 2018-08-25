package com.programmers.kakao;

public class KakaoFriendsColoringBook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pic = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
		Solution s = new Solution();
		s.solution(6, 4, pic);
	}

}

class Solution {
	  public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      
	      print(m,n,picture);
	      
	      int[] answer = new int[2];
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
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