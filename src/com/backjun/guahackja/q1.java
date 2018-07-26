package com.backjun.guahackja;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Computer cpt = new Computer();
		cpt.parser("5 3");
		cpt.parser("3 3");
	}

}

class Computer{
	int answer = 0;
	String[][] map = null;
	int mapSize = 0;
	Box box = null;
	boolean isMapCreated = false;
	int totalBoxMoveCnt = 0;
	
	public void parser(String command) {
		Pattern p = Pattern.compile("[0-9]+");
		StringBuffer comCtrl = new StringBuffer(command);
		Matcher m = p.matcher(comCtrl.toString());
		int count = 0;
		int tmp = 0;
		while(m.find()) {
			count++;
			int num = Integer.parseInt(m.group());
			if(!isMapCreated && count == 1) {				
				map = new String[num][num];
				mapSize = num;
			}else if (!isMapCreated && count == 2) {
				box = new Box(num);
				isMapCreated = true;
			}else if (isMapCreated && count == 1) {
				tmp = Integer.parseInt(m.group());
			}else if (isMapCreated && count == 2) {
				box.settingLocate(tmp, Integer.parseInt(m.group()), mapSize);
			}
			totalBoxMoveCnt = tmp;
		}
		
		//문자열 처리 추가하기. 현재 숫자 커맨드 들만 받을 수 있음.
		Pattern charPatt = Pattern.compile("[0-9]+");
		
	}
	
	public int getAnswer () {
		return this.answer;
	}
	
	public void printCage() {
		//2차원 배열 print
	}
}

class Mouse{
	int x = 0;
	int y = 0;
	int mapleft = 0;
	int mapbottom = 0;
	int maptop = 0;
	int mapright = 0;
	Box box = null;
	String[][] map = null;
	Mouse(String[][] map, int mapSize, Box box){
		maptop = mapSize;
		mapright = mapSize;
		this.box = box;
		this.map = map;
	}
	
	public boolean init(int x,int y) {
		if(map[x][y].equals("r")) {
			return false;
		}else {
			this.x = x;
			this.y = y;
			return true;
		}
	}
	
	//쥐가 map 밖으로 나갈수 없도록 move 메소드 만들기.
	public boolean moveToLeft(String whiteORred) {
		if(x-1 < mapleft || whiteORred.equals("r")) {
			return false;
		}else {
			x--;
			return true;
		}
	}
	
	public boolean moveToRight(String whiteORred) {
		if(x+1 < mapright || whiteORred.equals("r")) {
			return false;
		}else {
			x--;
			return true;
		}
	}
	
	public boolean moveToTop(String whiteORred) { 
		if(y+1 >= maptop || whiteORred.equals("r")) {
			return false;
		}else {
			y++;
			return true;
		}
	}
	
	public boolean moveToBottom(String whiteORred) {
		if(y-1 < mapbottom || whiteORred.equals("r")) {
			return false;
		}else {
			y--;
			return true;
		}
	}
}

class Box {
	int left = 0;
	int right = 0;
	int top = 0;
	int bottom = 0;
	int size = 0;
	StringBuffer moveHistory = null;
	
	Box(int size){
		this.size = size;
		moveHistory = new StringBuffer();
	}
	
	public boolean mouseMoveThenBox(int x, int y, String direction) {
		switch(direction) {
		case "L":
			if(x-1 < left) {
				moveToLeft();
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return true;
			}else {
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return false;
			}
		case "R":
			if(x+1 >= right) {
				moveToRight();
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return true;
			}else {
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return false;
			}
		case "U":
			if(y+1 >= top) {
				moveToTop();
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return true;
			}else {
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return false;
			}
		case "D":
			if(y-1 < bottom) {
				moveToBottom();
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return true;
			}else {
				System.out.println(left +" "+ right + ", "+top + " "+bottom+"  BoxMoveHistory : "+moveHistory.toString());
				return false;
			}
		default:
		}
		return false;
	}
	
	public void settingLocate(int r, int c, int mapSize) {
		left = r-1;
		top = mapSize - c + 1;
		right = left + size;
		bottom = top - size;
		
		System.out.println(left +" "+ right + ", "+top + " "+bottom);
	}
	
	public int moveToLeft() {
		moveHistory.append("L");
		right--;
		return --left;
	}
	
	public int moveToRight() {
		moveHistory.append("R");
		left++;
		return ++right;
	}
	
	public int moveToTop() {
		moveHistory.append("U");
		bottom++;
		return ++top;
	}
	
	public int moveToBottom() {
		moveHistory.append("D");
		top--;
		return --bottom;
	}
	
	public String getMoveHistory() {
		return moveHistory.toString();
	}
}