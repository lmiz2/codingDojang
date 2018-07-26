package com.backjun.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
		ComputerQ3 computer = new ComputerQ3(Integer.parseInt(br.readLine()));
		computer.command();
		}catch(Exception e) {
			System.out.println("NO");
		}
		br.close();
	}

}

class ComputerQ3{
	Stack<Integer> st;
	StringBuffer result;
	int inputCount = 0;
	int pointer = 1;
	boolean isCanNot = false;
	ComputerQ3(int linecnt){
		inputCount = linecnt;
		result = new StringBuffer();
		st = new Stack<Integer>();
	}
	
	public void command(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int loopcnt = 0;
			while(true) {
				loopcnt++;
				try {
					int inputNum = (int)Integer.parseInt(br.readLine());
					if(!st.isEmpty()) {
						if(inputNum < st.peek().intValue()) {
							isCanNot = true;
						}
					}
					while(pointer <= inputNum) {
						st.push(pointer++);
						result.append("+\n");
					}
					st.pop();
					result.append("-");
					
				}catch(Exception e) {
					isCanNot = true;
					
				}finally {
					if(inputCount == loopcnt) {
						getRes();
						break;
					}
					result.append("\n");
				}
			}
		
		
	}
	
	public void getRes() {
		if(!isCanNot && st.size() == 0) {
			System.out.println(result.toString());
		}else {
			System.out.println("NO");
		}
	}
}