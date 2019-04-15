package com.backjun.samsung;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionQ13460 s = new SolutionQ13460();
	}

}

class SolutionQ13460 {
	final static int BALL_RED = 10; // R
	final static int BALL_BLUE = 11; // B
	final static int MAZE_WALL = 12; // #
	final static int MAZE_HOLE = 13; // O
	final static int MAZE_BLANK = 14; // .
	
	int n,m;
	int[][] maze;
	Pair red,blue,hole;
	Queue<DoublePair> processor;
	Queue<DoublePair> visited;
	DoublePair currSts;
	int goalDeps = -1;
	
	public SolutionQ13460() {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		maze = new int[n][m];
		processor = new LinkedList<DoublePair>();
		visited = new LinkedList<DoublePair>();
		
		
		sc.nextLine();
		for(int ii = 0 ; ii < n ; ii++) {
			String tmp = sc.nextLine();
			for(int i = 0 ; i < m ; i ++) {
				char at = tmp.charAt(i);
				if(at == '.') {
					maze[ii][i] = MAZE_BLANK;
				} else if (at == '#') {
					maze[ii][i] = MAZE_WALL;
				} else if (at == 'R') {
					maze[ii][i] = MAZE_BLANK;//BALL_RED;
					red = new Pair(ii,i);
				} else if (at == 'B') {
					maze[ii][i] = MAZE_BLANK;//BALL_BLUE;
					blue = new Pair(ii,i);
				} else {
					maze[ii][i] = MAZE_BLANK;
					hole = new Pair(ii,i);
				}
			}
		}
		doit();
		System.out.println(goalDeps);
		
	}
	
	StringBuffer printArr() {
		StringBuffer sb = new StringBuffer();
		Pair red = currSts.x;
		Pair blue = currSts.y;
		for(int i = 0 ; i < n ; i ++) {
			for(int j = 0 ; j < m ; j ++) {
				if(i==red.x && j == red.y) {
					sb.append("R");
					continue;
				}else if(i==blue.x && j == blue.y) {
					sb.append("B");
					continue;
				}else if (i==hole.x && j == hole.y) {
					sb.append("O");
					continue;
				}
				if(maze[i][j] == MAZE_BLANK) {
					sb.append(".");
				}else if (maze[i][j] == MAZE_WALL) {
					sb.append("#");
				}
				
			}
			sb.append("\n");
		}
		return sb;
	}
	
	void doit(){
		DoublePair first = new DoublePair(red, blue);
		processor.add(first);
		visited.add(first);
		while (!processor.isEmpty()) {
			DoublePair tmpSts = processor.poll();
			currSts = tmpSts;
//			StringBuffer sb = printArr();			
			
			
			DoublePair[] nexts = new DoublePair[4];
			nexts[0] = toleft(tmpSts);
			nexts[1] = totop(tmpSts);
			nexts[2] = toright(tmpSts);
			nexts[3] = tobottom(tmpSts);
			
			for(int i = 0 ; i < 4; i ++) {
//				if(nexts[i].x.equals(hole)) {
//					goalDeps = nexts[i].deps;
//					return;
//				}
				if(nexts[i] == null) {
					continue;
				}
//				nexts[i].appendstr(sb);
//				nexts[i].redTracking.append(nexts[i].deps+"\n");
				if(nexts[i].x == null && nexts[i].y ==null) {
					if(nexts[i].deps > 10) {
						goalDeps = -1;
					}else {
						goalDeps = nexts[i].deps;
					}					
//					System.out.println(nexts[i].redTracking.toString());
					return;
				}
				if (!visited.contains(nexts[i])) {
//					nexts[i].deps += 1;
					processor.add(nexts[i]);
					visited.add(nexts[i]);
				}
			}
			
		}
	}
	
	
	
	DoublePair toleft(DoublePair in) {
		boolean redSuccess = false;
		boolean blueSuccess = false;
		Pair redball = new Pair(in.x.x,in.x.y);
		Pair blueball = new Pair(in.y.x, in.y.y);
		int redMove = 0;
		int blueMove = 0;
		while (true) {
			if(redball.x > 0 && redball.x < n-1 && redball.y > 0 && redball.y < m - 1
			 && blueball.x > 0 && blueball.x < n-1 && blueball.y > 0 && blueball.y < m - 1 ) {
				Pair movedRed = new Pair(redball.x, redball.y-1);
				Pair movedBlue = new Pair(blueball.x, blueball.y-1);
				
				if(redball.y-1 != 0 && maze[redball.x][redball.y - 1] == MAZE_BLANK && !movedRed.equals(blueball) ) {
					redMove++;
					redball.y -= 1;
				}else {
					movedRed = redball;
				}
				
				if(blueball.y-1 != 0 && maze[blueball.x][blueball.y - 1] == MAZE_BLANK && !movedBlue.equals(movedRed)) {
					blueMove++;
					blueball.y -= 1;
				} else {
					movedBlue = blueball;
				}

				if(redMove == 0 && blueMove == 0) {
					break;
				}
				if(blueMove != 0) {
					blueMove = 0;
					blueball = movedBlue;
				}
				if(redMove != 0) {
					redMove = 0;
					redball = movedRed;					
				}
				if(redball.equals(hole)) {
					redSuccess = true;
					redball = blueball;
				}
				if(blueball.equals(hole)) {
					blueSuccess = true;
				}
				
			} else {
				break;
			}
		}
		DoublePair rtnDP = new DoublePair(redball, blueball);
		rtnDP.deps = in.deps+1;
//		rtnDP.appendstr(in.redTracking);
		if (blueSuccess) {
			rtnDP = null;
			return rtnDP;
		}
		if(redSuccess && !blueSuccess) {
			rtnDP.x = null;
			rtnDP.y = null;
		}		
		return rtnDP;
	}
	
	DoublePair toright(DoublePair in) {
		boolean redSuccess = false;
		boolean blueSuccess = false;
		Pair redball = new Pair(in.x.x,in.x.y);
		Pair blueball = new Pair(in.y.x, in.y.y);
		int redMove = 0;
		int blueMove = 0;
		while (true) {
			if(redball.x > 0 && redball.x < n -1 && redball.y > 0 && redball.y < m - 1
					 &&blueball.x > 0 && blueball.x < n -1 && blueball.y > 0 && blueball.y < m - 1) {
				Pair movedRed = new Pair(redball.x, redball.y+1);
				Pair movedBlue = new Pair(blueball.x, blueball.y+1);
				if(redball.y+1 < m-1 && maze[redball.x][redball.y + 1] == MAZE_BLANK && !movedRed.equals(blueball) ) {
					redMove++;
					redball.y += 1;
				}else {
					movedRed = redball;
				}
				
				if(blueball.y+1 < m-1 && maze[blueball.x][blueball.y + 1] == MAZE_BLANK && !movedBlue.equals(movedRed)) {
					blueMove++;
					blueball.y += 1;
				} else {
					movedBlue = blueball;
				}

				if(redMove == 0 && blueMove == 0) {
					break;
				}
				if(blueMove != 0) {
					blueMove = 0;
					blueball = movedBlue;
				}
				if(redMove != 0) {
					redMove = 0;
					redball = movedRed;					
				}
				if(redball.equals(hole)) {
					redSuccess = true;
					redball = blueball;
				}
				if(blueball.equals(hole)) {
					blueSuccess = true;
				}
			} else {
				break;
			}
		}
		DoublePair rtnDP = new DoublePair(redball, blueball);
		rtnDP.deps = in.deps+1;
//		rtnDP.appendstr(in.redTracking);
		if (blueSuccess) {
			rtnDP = null;
			return rtnDP;
		}
		if(redSuccess && !blueSuccess) {
			rtnDP.x = null;
			rtnDP.y = null;
		}
		return rtnDP;
	}

	DoublePair totop(DoublePair in) {
		boolean redSuccess = false;
		boolean blueSuccess = false;
		Pair redball = new Pair(in.x.x,in.x.y);
		Pair blueball = new Pair(in.y.x, in.y.y);
		int redMove = 0;
		int blueMove = 0;
		while (true) {
			if(redball.x > 0 && redball.x < n -1 && redball.y > 0 && redball.y < m - 1 
					 &&blueball.x > 0 && blueball.x < n -1 && blueball.y > 0 && blueball.y < m - 1 ) {
				Pair movedRed = new Pair(redball.x-1, redball.y);
				Pair movedBlue = new Pair(blueball.x-1, blueball.y);
				if(redball.x-1 > 0 && maze[redball.x-1][redball.y] == MAZE_BLANK && !movedRed.equals(blueball) ) {
					redMove++;
					redball.x -= 1;
				}else {
					movedRed = redball;
				}
				
				if(blueball.x-1 > 0 && maze[blueball.x-1][blueball.y] == MAZE_BLANK && !movedBlue.equals(movedRed)) {
					blueMove++;
					blueball.x -= 1;
				} else {
					movedBlue = blueball;
				}

				if(redMove == 0 && blueMove == 0) {
					break;
				}
				if(blueMove != 0) {
					blueMove = 0;
					blueball = movedBlue;
				}
				if(redMove != 0) {
					redMove = 0;
					redball = movedRed;					
				}
				if(redball.equals(hole)) {
					redSuccess = true;
					redball = blueball;
				}
				if(blueball.equals(hole)) {
					blueSuccess = true;
				}
			} else {
				break;
			}
		}		
		DoublePair rtnDP = new DoublePair(redball, blueball);
		rtnDP.deps = in.deps+1;
//		rtnDP.appendstr(in.redTracking);
		if (blueSuccess) {
			rtnDP = null;
			return rtnDP;
		}
		if(redSuccess && !blueSuccess) {
			rtnDP.x = null;
			rtnDP.y = null;
		}
		return rtnDP;
	}
	
	DoublePair tobottom(DoublePair in) {
		boolean redSuccess = false;
		boolean blueSuccess = false;
		Pair redball = new Pair(in.x.x,in.x.y);
		Pair blueball = new Pair(in.y.x, in.y.y);
		int redMove = 0;
		int blueMove = 0;		
		
		while (true) {
			if(redball.x > 0 && redball.x < n -1 && redball.y > 0 && redball.y < m -1
					 &&blueball.x > 0 && blueball.x < n -1 && blueball.y > 0 && blueball.y < m - 1) {
				Pair movedRed = new Pair(redball.x+1, redball.y);
				Pair movedBlue = new Pair(blueball.x+1, blueball.y);
				if(redball.x+1 < n-1 && maze[redball.x+1][redball.y] == MAZE_BLANK && !movedRed.equals(blueball) ) {
					redMove++;
					redball.x += 1;
				}else {
					movedRed = redball;
				}
				
				if(blueball.x+1 < n-1 && maze[blueball.x+1][blueball.y] == MAZE_BLANK && !movedBlue.equals(movedRed)) {
					blueMove++;
					blueball.x += 1;
				} else {
					movedBlue = blueball;
				}

				if(redMove == 0 && blueMove == 0) {
					break;
				}
				if(blueMove != 0) {
					blueMove = 0;
					blueball = movedBlue;
				}
				if(redMove != 0) {
					redMove = 0;
					redball = movedRed;					
				}
				if(redball.equals(hole)) {
					redSuccess = true;
					redball = blueball;
				}
				if(blueball.equals(hole)) {
					blueSuccess = true;
				}
			} else {
				break;
			}
		}		
		DoublePair rtnDP = new DoublePair(redball, blueball);
		rtnDP.deps = in.deps+1;
//		rtnDP.appendstr(in.redTracking);
		if (blueSuccess) {
			rtnDP = null;
			return rtnDP;
		}
		if(redSuccess && !blueSuccess) {
			rtnDP.x = null;
			rtnDP.y = null;
		}
		return rtnDP;
	}

	
	class DoublePair{
//		StringBuffer redTracking;
		Pair x,y;
		int deps = 0;
		public DoublePair(Pair x, Pair y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
//			 redTracking = new StringBuffer();
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			DoublePair d = (DoublePair)obj;
			return this.x.equals(d.x) && this.y.equals(d.y);
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return x.x^16+x.y^16+y.x^16+y.y^16;
		}
		
//		public void appendstr(StringBuffer str) {
//			redTracking.append(str.toString());
//		}
	}
	class Pair {
		
		int x = 0;
		int y = 0;
		int deps = 0;
		
		public Pair(int x, int y) {
			// TODO Auto-generated constructor stub
			this.x = x;
			this.y = y;
			deps = 0;
		}
		
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Pair in = (Pair) obj;
			return this.x == in.x && this.y == in.y;
		}
		
		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return this.x^32+this.y^32;
		}
	}
	
}