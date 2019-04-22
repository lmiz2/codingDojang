package com.backjun.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q3 {

	public static void main(String[] args) throws IOException{			
		ComputerQ3 computer = new ComputerQ3();		
		try {			
			computer.command();			
		}catch(Exception e) {
			System.out.println("NO");
		}
	}

}

class ComputerQ3{
	Stack<Integer> st;
	StringBuffer result;
	int inputCount = 0;
	int pointer = 1;
	boolean isCanNot = false;
	ComputerQ3(){
		result = new StringBuffer();
		st = new Stack<Integer>();
	}
	
	public void command(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer tmp = new StringBuffer();
		String in = "";
		try {
			while((in = br.readLine())!= null) {
				System.out.println(in);
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(tmp.toString()+" this");
		StringTokenizer token = new StringTokenizer(tmp.toString());
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		
		int loopcnt = 0;
			while(true) {
				loopcnt++;
				try {
					int inputNum = Integer.parseInt(token.nextToken());
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