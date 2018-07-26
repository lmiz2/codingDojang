package com.backjun.q1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStack st = new MyStack();
		Scanner sc = new Scanner(System.in);
		while(true) {
			st.parser(sc.nextLine());
		}
	}

}

class MyStack {
	int[] inner = null;
	int pointer = 0;
	int cmdCnt = 0;
	StringBuffer rs;
	
	public void parser(String command) throws ArrayIndexOutOfBoundsException{
		// TODO Auto-generated constructor stub
		
		int result = 0;
		if(inner == null) {
			inner = new int[Integer.parseInt(command)+1];
			cmdCnt = Integer.parseInt(command);
			rs = new StringBuffer();
		}else {
			switch(command) {
			case "empty":
				rs.append(empty()+"\n");
				break;
			case "pop":
				rs.append(pop()+"\n");
				break;
			case "size":
				rs.append(size()+"\n");
				break;
			case "top":
				rs.append(top()+"\n");
				break;
			default :
				int idx = command.indexOf(" ");
				if(idx != -1) {
					if(command.substring(0, idx).equals("push")) {
						push(Integer.parseInt(command.substring(idx+1)));
					}
				}
				
			}
			cmdCnt--;

			if(cmdCnt == 0) {
				System.out.println(rs);
				System.exit(0);
			}
		}		
	}
	
	private void push(int data) {
		inner[pointer++] = data;
	}
	
	private int pop() {
		if(pointer == 0) {
			return -1;
		}
		int result = inner[--pointer];
		inner[pointer] = 0;
		return result;
	}
	
	public int size() {
		return this.pointer;
	}
	
	private int empty() {
		int result = 0;
		result = inner == null ? 1 : (pointer == 0 ? 1 : 0);
		return result;
	}
	
	private int top() {
		if(pointer == 0) {
			return -1;
		}
		return inner[pointer-1];
	}
}