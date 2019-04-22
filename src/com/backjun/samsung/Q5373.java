package com.backjun.samsung;

import java.util.Scanner;

public class Q5373 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int testCaseCnt = sc.nextInt();
		
		for(int i = 0 ; i < testCaseCnt ; i ++) {
			Cube cb = new Cube();
			int cmdCnt = sc.nextInt();
			for(int j = 0 ; j < cmdCnt; j ++) {
				String s = sc.next();
//				System.out.println(s);
				cb.rotate(s.charAt(0), s.charAt(1));
			}
			cb.printUp();
			
		}
	}

}

class Cube { 
	char[][] up;
	char[][] down;
	char[][] front;
	char[][] back;
	char[][] left;
	char[][] right;
	
	Cube() {
		up = new char[3][3];
		down = new char[3][3];
		front = new char[3][3];
		back = new char[3][3];
		left = new char[3][3];
		right = new char[3][3];
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				up[i][j] = 'w';
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				down[i][j] = 'y';
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				front[i][j] = 'r';
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				back[i][j] = 'o';
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				left[i][j] = 'g';
			}
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				right[i][j] = 'b';
			}
		}
	}
	
	public void rotate(char where, char direct) {

//		System.out.println(where+" : "+direct);
		switch(where) {
		case 'U' :
			if(direct == '-') {
				char tmp1 = up[0][0];
				char tmp2 = up[0][1];
				char tmp3 = up[0][2];
				
				up[0][0]  = up[0][2];
				up[0][1]  = up[1][2];
				up[0][2]  = up[2][2];
				
				up[0][2] = up[2][2];
				up[1][2] = up[2][1];
				up[2][2] = up[2][0];
				
				up[2][2] = up[2][0];
				up[2][1] = up[1][0];
				up[2][0] = up[0][0];
				
				up[2][0] = tmp1;
				up[1][0] = tmp2;
				up[0][0] = tmp3;				
						
				char[] tmps = {left[0][0],left[0][1],left[0][2]};
				tmp1 = left[0][0];
				
				for(int i = 0; i < 3 ; i++) {
					left[0][i] = back[0][i];
					back[0][i] = right[0][i];
					right[0][i] = front[0][i];
					front[0][i] = tmps[i];
				}
			} else {
				char tmp1 = up[0][0];
				char tmp2 = up[0][1];
//				char tmp3 = up[0][2];

				up[0][1] = up[1][0];
				up[0][0] = up[2][0];
				
				up[1][0] = up[2][1];
				up[2][0] = up[2][2];
				
				up[2][1] = up[1][2];
				up[2][2] = up[0][2];
				
				up[1][2] = tmp2;
				up[0][2] = tmp1;
				
				char[] tmps = {left[0][0],left[0][1],left[0][2]};
				tmp1 = left[0][0];
				
				for(int i = 0; i < 3 ; i++) {
					left[0][i] = front[0][i];
					front[0][i] = right[0][i];
					right[0][i] = back[0][i];
					back[0][i] = tmps[i];
				}
			}
			break;
		case 'D' :
			if(direct == '-') {
				char tmp1 = down[0][0];
				char tmp2 = down[0][1];
				char tmp3 = down[0][2];
				
				down[0][0]  = down[0][2];
				down[0][1]  = down[1][2];
				down[0][2]  = down[2][2];
				
				down[0][2] = down[2][2];
				down[1][2] = down[2][1];
				down[2][2] = down[2][0];
				
				down[2][2] = down[2][0];
				down[2][1] = down[1][0];
				down[2][0] = down[0][0];
				
				down[2][0] = tmp1;
				down[1][0] = tmp2;
				down[0][0] = tmp3;				
				
				char[] tmps = {left[2][0],left[2][1],left[2][2]};
				
				for(int i = 0; i < 3 ; i++) {
					left[2][i] = front[2][i];
					front[2][i] = right[2][i];
					right[2][i] = back[2][i];
					back[2][i] = tmps[i];
				}
			} else {
				char tmp1 = down[0][0];
				char tmp2 = down[0][1];
//				char tmp3 = down[0][2];

				down[0][1] = down[1][0];
				down[0][0] = down[2][0];
				
				down[1][0] = down[2][1];
				down[2][0] = down[2][2];
				
				down[2][1] = down[1][2];
				down[2][2] = down[0][2];
				
				down[1][2] = tmp2;
				down[0][2] = tmp1;
				
				char[] tmps = {left[2][0],left[2][1],left[2][2]};
				
				for(int i = 0; i < 3 ; i++) {
					left[2][i] = back[2][i];
					back[2][i] = right[2][i];
					right[2][i] = front[2][i];
					front[2][i] = tmps[i];
				}
			}
			break;
		case 'F':
			if(direct == '-') {
				char tmp1 = front[0][0];
				char tmp2 = front[0][1];
				char tmp3 = front[0][2];
				
				front[0][0]  = front[0][2];
				front[0][1]  = front[1][2];
				front[0][2]  = front[2][2];
				
				front[0][2] = front[2][2];
				front[1][2] = front[2][1];
				front[2][2] = front[2][0];
				
				front[2][2] = front[2][0];
				front[2][1] = front[1][0];
				front[2][0] = front[0][0];
				
				front[2][0] = tmp1;
				front[1][0] = tmp2;
				front[0][0] = tmp3;				
						
				char[] tmps = {left[0][2],left[1][2],left[2][2]};
				
				for(int i = 0, j = 2; i < 3 ; i++, j--) {
					left[i][2] = up[2][j];
					up[2][j] = right[j][0];
					right[j][0] = down[0][i];
					down[0][i] = tmps[i];
				}
			} else {
				char tmp1 = front[0][0];
				char tmp2 = front[0][1];
//				char tmp3 = front[0][2];

				front[0][1] = front[1][0];
				front[0][0] = front[2][0];
				
				front[1][0] = front[2][1];
				front[2][0] = front[2][2];
				
				front[2][1] = front[1][2];
				front[2][2] = front[0][2];
				
				front[1][2] = tmp2;
				front[0][2] = tmp1;
				
				char[] tmps = {left[0][2],left[1][2],left[2][2]};
				
				
				for(int i = 0 , j = 2; i < 3 ; i++, j--) {
					left[i][2] = down[0][i];
					down[0][i] = right[j][0]; // d00 - r20 , d02 - r 00
					right[j][0] = up[2][j];
					up[2][j] = tmps[i];					
				}
			}
			break;
		case 'B' :
			if(direct == '-') {
				char tmp1 = back[0][0];
				char tmp2 = back[0][1];
				char tmp3 = back[0][2];
				
				back[0][0]  = back[0][2];
				back[0][1]  = back[1][2];
				back[0][2]  = back[2][2];
				
				back[0][2] = back[2][2];
				back[1][2] = back[2][1];
				back[2][2] = back[2][0];
				
				back[2][2] = back[2][0];
				back[2][1] = back[1][0];
				back[2][0] = back[0][0];
				
				back[2][0] = tmp1;
				back[1][0] = tmp2;
				back[0][0] = tmp3;				
				
				char[] tmps = {left[0][0],left[1][0],left[2][0]};
				
				for(int i = 0 , j = 2; i < 3 ; i++,j--) {
					left[i][0] = down[2][i];
					down[2][i] = right[i][2];
					right[i][2] = up[0][i];
					up[0][i] = tmps[i];
				}
			} else {
				char tmp1 = back[0][0];
				char tmp2 = back[0][1];
//				char tmp3 = back[0][2];

				back[0][1] = back[1][0];
				back[0][0] = back[2][0];
				
				back[1][0] = back[2][1];
				back[2][0] = back[2][2];
				
				back[2][1] = back[1][2];
				back[2][2] = back[0][2];
				
				back[1][2] = tmp2;
				back[0][2] = tmp1;
				
				char[] tmps = {left[0][0],left[1][0],left[2][0]};
				for(int i = 0 , j = 2; i < 3 ; i++,j--) {
					left[i][0] = up[0][i];
					up[0][i] = right[i][2];
					right[i][2] = down[2][i];
					down[2][i] = tmps[i];
				}
			}
			break;
		case 'L':
			if(direct == '-') {
				char tmp1 = left[0][0];
				char tmp2 = left[0][1];
				char tmp3 = left[0][2];
				
				left[0][0]  = left[0][2];
				left[0][1]  = left[1][2];
				left[0][2]  = left[2][2];
				
				left[0][2] = left[2][2];
				left[1][2] = left[2][1];
				left[2][2] = left[2][0];
				
				left[2][2] = left[2][0];
				left[2][1] = left[1][0];
				left[2][0] = left[0][0];
				
				left[2][0] = tmp1;
				left[1][0] = tmp2;
				left[0][0] = tmp3;				
				
				char[] tmps = {front[0][0],front[1][0],front[2][0]};
				
				for(int i = 0, j = 2; i < 3 ; i++,j--) {
					front[i][0] = down[i][0];
					down[i][0] = back[j][2];
					back[j][2] = up[i][0];
					up[i][0] = tmps[i];
					
				}
			} else {
				char tmp1 = left[0][0];
				char tmp2 = left[0][1];
//				char tmp3 = left[0][2];

				left[0][1] = left[1][0];
				left[0][0] = left[2][0];
				
				left[1][0] = left[2][1];
				left[2][0] = left[2][2];
				
				left[2][1] = left[1][2];
				left[2][2] = left[0][2];
				
				left[1][2] = tmp2;
				left[0][2] = tmp1;
				
				char[] tmps = {front[0][0],front[1][0],front[2][0]};

				for(int i = 0, j = 2; i < 3 ; i++,j--) {
					front[i][0] = up[i][0];
					up[i][0] = back[j][2];
					back[j][2] = down[i][0];
					down[i][0] = tmps[i];
					
				}
			}
			break;
		case 'R' :
			if(direct == '-') {
				char tmp1 = right[0][0];
				char tmp2 = right[0][1];
				char tmp3 = right[0][2];
				
				right[0][0]  = right[0][2];
				right[0][1]  = right[1][2];
				right[0][2]  = right[2][2];
				
				right[0][2] = right[2][2];
				right[1][2] = right[2][1];
				right[2][2] = right[2][0];
				
				right[2][2] = right[2][0];
				right[2][1] = right[1][0];
				right[2][0] = right[0][0];
				
				right[2][0] = tmp1;
				right[1][0] = tmp2;
				right[0][0] = tmp3;				
						
				char[] tmps = {front[0][2],front[1][2],front[2][2]};
				
				for(int i = 0, j = 2; i < 3 ; i++,j--) {
					front[i][2] = up[i][2];
					up[i][2] = back[j][0];
					back[j][0] = down[i][2];
					down[i][2] = tmps[i];					
				}
			} else {
				char tmp1 = right[0][0];
				char tmp2 = right[0][1];
//				char tmp3 = right[0][2];

				right[0][1] = right[1][0];
				right[0][0] = right[2][0];
				
				right[1][0] = right[2][1];
				right[2][0] = right[2][2];
				
				right[2][1] = right[1][2];
				right[2][2] = right[0][2];
				
				right[1][2] = tmp2;
				right[0][2] = tmp1;
				
				char[] tmps = {front[0][2],front[1][2],front[2][2]};
				
				for(int i = 0, j = 2; i < 3 ; i++,j--) {
					front[i][2] = down[i][2];
					down[i][2] = back[j][0];
					back[j][0] = up[i][2];
					up[i][2] = tmps[i];					
				}
			}
			break;
		}
	}
	
	public void printUp() {
		for(int i = 0 ; i < 3 ; i ++) {
			for(int j = 0 ; j < 3 ; j ++) {
				System.out.print(up[i][j]);				
			}
			System.out.println();
		}
	}
}
